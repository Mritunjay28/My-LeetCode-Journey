class Solution {

    class Node<T> {
        T value;
        Node<T> prev, next;

        Node(T value) {
            this.value = value;
        }
    }

    class DoublyLinkedList<T> {
        Node<T> head, tail;

        public Node<T> add(T value) {
            Node<T> node = new Node<>(value);

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }

            return node;
        }

        public void delete(Node<T> node) {
            if (node == null)
                return;

            if (node == head)
                head = node.next;
            if (node == tail)
                tail = node.prev;

            if (node.prev != null)
                node.prev.next = node.next;
            if (node.next != null)
                node.next.prev = node.prev;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        PriorityQueue<int[]> left = new PriorityQueue<>(
                (a, b) -> {
                    return a[0] - b[0];
                });

        PriorityQueue<int[]> right = new PriorityQueue<>(
                (a, b) -> {
                    return a[0] - b[0];
                });

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (directions.charAt(i) == 'L') {
                left.add(new int[] { positions[i], healths[i] });
            } else
                right.add(new int[] { positions[i], healths[i] });
        }

        DoublyLinkedList<int[]> list = new DoublyLinkedList<>();
        while (!right.isEmpty()) {
            list.add(right.poll());
        }

        while (!left.isEmpty()) {
            int[] temp = left.poll();
            int idx = temp[0], h = temp[1];
           
            Node<int[]> curr = list.tail;
            while (curr != null && h>0) {
                
                int[] arr = curr.value;

                if (arr[0] < idx) {
                    if (arr[1] == h) {
                        list.delete(curr);
                        h=0;
                         break;
                    } else if (arr[1] > h) {
                        arr[1]--;
                        h=0;
                         break;
                    } else {
                        h--;
                        Node<int[]> toDelete = curr;
                        curr = curr.prev; 
                        list.delete(toDelete);
                        continue;
                    }
                   
                }
                curr = curr.prev;
            }

            if (h>0)
                map.put(idx, h);
        }

        Node<int[]> curr = list.head;
        while (curr != null) {
            int[] arr = curr.value;
            map.put(arr[0], arr[1]);
            curr = curr.next;
        }

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int val = positions[i];
            if (map.containsKey(val))
                arr.add(map.get(val));
        }

        return arr;

    }
}

/*

2-15 , 3-10 ,5-10, 6-12
rrll

basically if a robot have opposite then only they collide 

r - 2-15,3-10,5-9
l - 4-10,6-12


*/