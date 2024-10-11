class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        List<int[]> arrivals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arrivals.add(new int[] { times[i][0], i });
        }

        arrivals.sort((a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            availableChairs.add(i);
        }

        PriorityQueue<int[]> leavingQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int[] arrival : arrivals) {
            int arrivalTime = arrival[0];
            int peopleIndex = arrival[1];

            while (!leavingQueue.isEmpty() && leavingQueue.peek()[0] <= arrivalTime) {
                availableChairs.add(leavingQueue.poll()[1]);
            }

            int chair = availableChairs.poll();

            if (peopleIndex == targetFriend) {
                return chair;
            }

            leavingQueue.add(new int[] { times[peopleIndex][1], chair });
        }

        return -1;

    }
}