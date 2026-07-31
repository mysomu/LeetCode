class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();

        // Add all students to the queue
        for (int student : students) {
            queue.offer(student);
        }

        int sandwichIndex = 0;
        int rotations = 0;

        while (!queue.isEmpty()) {

            // Front student likes the current sandwich
            if (queue.peek() == sandwiches[sandwichIndex]) {
                queue.poll();
                sandwichIndex++;
                rotations = 0; // Reset because a student got a sandwich
            } else {
                // Move front student to the back
                queue.offer(queue.poll());
                rotations++;
            }

            // Everyone has been rotated once without taking the sandwich
            if (rotations == queue.size()) {
                return queue.size();
            }
        }
        return 0;
    }
}