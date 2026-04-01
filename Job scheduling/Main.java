import java.util.*;

class Job {
    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class Main {

    public static int[] JobScheduling(Job[] arr, int n) {

        Arrays.sort(arr, (a, b) -> a.deadline - b.deadline);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(arr[i].profit);

            if (pq.size() > arr[i].deadline) {
                pq.poll();
            }
        }

        int totalProfit = 0;
        while (!pq.isEmpty()) {
            totalProfit += pq.poll();
        }

        return new int[]{pq.size(), totalProfit};
    }

    public static void main(String[] args) {

        Job[] arr = {
            new Job(1, 4, 20),
            new Job(2, 1, 10),
            new Job(3, 1, 40),
            new Job(4, 1, 30)
        };

        int[] result = JobScheduling(arr, arr.length);

        System.out.println(result[0] + " " + result[1]);
    }
}