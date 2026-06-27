WITH RECURSIVE SpaceSplit AS (
    -- Step 1: Split the text by spaces only
    SELECT 
        content_id,
        content_text AS original_text,
        1 AS word_position,
        IF(INSTR(content_text, ' ') = 0, content_text, SUBSTRING_INDEX(content_text, ' ', 1)) AS current_word,
        IF(INSTR(content_text, ' ') = 0, '', SUBSTRING(content_text, INSTR(content_text, ' ') + 1)) AS remaining_text
    FROM user_content

    UNION ALL

    SELECT 
        content_id,
        original_text,
        word_position + 1,
        IF(INSTR(remaining_text, ' ') = 0, remaining_text, SUBSTRING_INDEX(remaining_text, ' ', 1)) AS current_word,
        IF(INSTR(remaining_text, ' ') = 0, '', SUBSTRING(remaining_text, INSTR(remaining_text, ' ') + 1)) AS remaining_text
    FROM SpaceSplit
    WHERE remaining_text <> ''
),
ProcessedWords AS (
    -- Step 2: Apply conditional capitalization based on the token structure
    SELECT 
        content_id,
        original_text,
        word_position,
        CASE 
            -- Check if the word is a clean single-hyphenated word (e.g., word1-word2)
            WHEN current_word REGEXP '^[a-zA-Z]+-[a-zA-Z]+$' THEN 
                CONCAT(
                    UPPER(SUBSTRING(SUBSTRING_INDEX(current_word, '-', 1), 1, 1)),
                    LOWER(SUBSTRING(SUBSTRING_INDEX(current_word, '-', 1), 2)),
                    '-',
                    UPPER(SUBSTRING(SUBSTRING_INDEX(current_word, '-', -1), 1, 1)),
                    LOWER(SUBSTRING(SUBSTRING_INDEX(current_word, '-', -1), 2))
                )
            -- Otherwise, capitalize ONLY the first character of the token and lowercase the rest
            ELSE 
                CONCAT(
                    UPPER(SUBSTRING(current_word, 1, 1)),
                    LOWER(SUBSTRING(current_word, 2))
                )
        END AS transformed_word
    FROM SpaceSplit
)
-- Step 3: Re-aggregate the tokens back together using a space separator
SELECT 
    content_id,
    original_text,
    GROUP_CONCAT(transformed_word ORDER BY word_position SEPARATOR ' ') AS converted_text
FROM ProcessedWords
GROUP BY content_id, original_text
ORDER BY content_id;