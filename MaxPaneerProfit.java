import java.util.*;

public class MaxPaneerProfit {
    static class Edge {
        int from, to;

        Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] val = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            val[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            edges.add(new Edge(from, 0));
        }

        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int to = sc.nextInt();
            edges.get(i).to = to;
        }

        System.out.println(findMaxProfit(n, val, edges));
    }

    public static int findMaxProfit(int n, int[] val, List<Edge> edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            adjList.get(edge.from).add(edge.to);
        }

        int[] maxReachable = new int[n + 1];
        Arrays.fill(maxReachable, Integer.MIN_VALUE);

        for (int i = 1; i <= n; i++) {
            if (maxReachable[i] == Integer.MIN_VALUE) {
                dfs(i, val, adjList, maxReachable);
            }
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int neighbor : adjList.get(i)) {
                int profit = maxReachable[neighbor] - val[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    private static void dfs(int city, int[] val, List<List<Integer>> adjList, int[] maxReachable) {
        maxReachable[city] = val[city];
        for (int neighbor : adjList.get(city)) {
            if (maxReachable[neighbor] == Integer.MIN_VALUE) {
                dfs(neighbor, val, adjList, maxReachable);
            }
            maxReachable[city] = Math.max(maxReachable[city], maxReachable[neighbor]);
        }
    }
}
