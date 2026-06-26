-- Gaps and Islands ways 
-- used to solve consecutive dates,ids,streak

WITH cte AS (
    SELECT *,
           id - ROW_NUMBER() OVER (ORDER BY id) AS grp
    FROM Stadium
    WHERE people >= 100
)

SELECT id,
       visit_date,
       people
FROM cte
WHERE grp IN (
    SELECT grp
    FROM cte
    GROUP BY grp
    HAVING COUNT(*) >= 3
)
ORDER BY visit_date;


/*
Suppose we have

id	people
1	120
2	150
3	180
4	20
5	140
6	170
7	160

We only care about

people >=100

So filter first.

id
1
2
3
5
6
7

Now we have two islands.

1 2 3

5 6 7
But how does SQL know they are consecutive?

This is the beautiful trick.

Assign row numbers.

ROW_NUMBER() OVER(ORDER BY id)

Result

id	row_number
1	1
2	2
3	3
5	4
6	5
7	6

Now compute

id - row_number

id	rn	id-rn
1	1	0
2	2	0
3	3	0
5	4	1
6	5	1
7	6	1

Notice something?

Every consecutive group has the same difference.

That's the magic.

Why does this work?

Think.

For consecutive ids

id: 5 6 7 8

Row numbers are

rn: 1 2 3 4

Difference

4
4
4
4

Constant.

Now imagine a gap.

id

5
6
8

Row numbers

1
2
3

Difference

4
4
5

Boom.

Difference changes.

A new island starts.

Now solve Stadium

Step 1

Filter

WHERE people>=100

Step 2

Assign row number

ROW_NUMBER() OVER(ORDER BY id)

Step 3

Create group

id - row_number AS grp

Now every consecutive sequence has same grp.

Step 4

Group by grp

GROUP BY grp

Count rows.

If

COUNT(*)>=3

Keep it.

Step 5

Join back to get original rows.

*/