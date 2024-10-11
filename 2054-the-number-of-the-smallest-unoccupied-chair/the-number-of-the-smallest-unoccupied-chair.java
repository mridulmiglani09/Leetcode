class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] marked = times[targetFriend];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        for (int i = 0; i <= marked[0]; i++) {
            pq.add(i);  // Add available chairs
        }

        int j = 0;  // Used to traverse through the times array
        for (int i = 0; i <= times[times.length - 1][1]; i++) {
            if (hm.containsKey(i)) {
                ArrayList<Integer> chairs = hm.get(i);
                for (int chair : chairs) {
                    pq.add(chair);  // Return the chairs to the available pool
                }
                hm.remove(i);  // Remove the chairs as they are now free
            }
            while (j < times.length && i == times[j][0]) {
                // If the current friend is the target friend, return the smallest available chair
                if (Arrays.equals(times[j], marked)) {
                    return pq.peek();  // Return the smallest available chair
                }

                // Assign the smallest available chair to the current friend
                int chair = pq.poll(); 

                // Record when the current friend will leave and free the chair
                int leaveTime = times[j][1];
                if (hm.containsKey(leaveTime)) {
                    hm.get(leaveTime).add(chair);  // Add chair to the list of chairs freed at this time
                } else {
                    ArrayList<Integer> newList = new ArrayList<>();
                    newList.add(chair);
                    hm.put(leaveTime, newList);  // Create a new list if none exists for that leave time
                }

                j++;  // Move to the next friend
            }
        }
        return -1;  // Should not reach here as target friend will always be processed
    }
}