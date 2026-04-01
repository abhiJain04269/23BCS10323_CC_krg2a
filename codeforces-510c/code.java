import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[26];

        for (int i = 0; i < n - 1; i++) {
            String s1 = names[i];
            String s2 = names[i + 1];

            int len = Math.min(s1.length(), s2.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    int u = s1.charAt(j) - 'a';
                    int v = s2.charAt(j) - 'a';

                    adj.get(u).add(v);
                    indegree[v]++;
                    found = true;
                    break;
                }
            }

            if (!found && s1.length() > s2.length()) {
                System.out.println("Impossible");
                return;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        StringBuilder result = new StringBuilder();

        while (!q.isEmpty()) {
            int node = q.poll();
            result.append((char)(node + 'a'));

            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        if (result.length() < 26) {
            System.out.println("Impossible");
        } else {
            System.out.println(result.toString());
        }
    }
}
