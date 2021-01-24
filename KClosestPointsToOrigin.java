/**
https://leetcode.com/problems/k-closest-points-to-origin/
 */

 class Solution {
    class Pair implements Comparable<Pair> {
        int x;
        int y;
        int dist;
        
        public Pair(int i, int j, int dis) {
            x = i;
            y = j;
            dist = dis;
        }
        
        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(pair.dist, this.dist);
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for (int i = 0; i < points.length; i++) {
            int distance = points[i][0] * points[i][0];
            distance += (points[i][1] * points[i][1]);
            if (pq.size() == K) {
                if (pq.peek().dist > distance) {
                    pq.poll();
                    pq.add(new Pair(points[i][0], points[i][1], distance));
                }
            } else {
                pq.add(new Pair(points[i][0], points[i][1], distance));
            }
        }
        int[][] result = new int[K][2];
        int i = 0;
        while(!pq.isEmpty()) {
            result[i][0] = pq.peek().x;
            result[i][1] = pq.peek().y;
            i++;
            pq.poll();
        }
        return result;
    }
}