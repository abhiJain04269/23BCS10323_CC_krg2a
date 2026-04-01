import java.util.*;

class Solution {

    class Tuple {
        int node, cost, stops;

        Tuple(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

       
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] f : flights) {
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.offer(new Tuple(src, 0, 0));

        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        
        while (!pq.isEmpty()) {
            Tuple curr = pq.poll();

            int node = curr.node;
            int cost = curr.cost;
            int stops = curr.stops;

           
            if (node == dst) return cost;

            
            if (stops > k) continue;

            for (int[] nei : adj.get(node)) {
                int next = nei[0];
                int price = nei[1];

                if (cost + price < dist[next] || stops <= k) {
                    dist[next] = cost + price;
                    pq.offer(new Tuple(next, cost + price, stops + 1));
                }
            }
        }

        return -1;
    }
}
