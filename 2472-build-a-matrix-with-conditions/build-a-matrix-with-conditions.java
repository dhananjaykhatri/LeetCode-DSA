class Solution {
    private static List<Integer> fillPositions(int k, int[][] conditions) {
        int[] deg = new int[k + 1];
        List<Integer>[] adj = new List[k + 1];
        for (int i = 0; i <= k; i++) adj[i] = new ArrayList<>();
        
        for (int[] condition : conditions) {
            adj[condition[0]].add(condition[1]);
            deg[condition[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (deg[i] == 0) q.add(i);
        }
        
        List<Integer> orderOfNums = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            orderOfNums.add(node);
            for (int adjNode : adj[node]) {
                deg[adjNode]--;
                if (deg[adjNode] == 0) q.add(adjNode);
            }
        }
        
        if (orderOfNums.size() != k) return new ArrayList<>();
        return orderOfNums;
    }

    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowNumOrder = fillPositions(k, rowConditions);
        List<Integer> colNumOrder = fillPositions(k, colConditions);

        if (rowNumOrder.isEmpty() || colNumOrder.isEmpty()) return new int[0][0];

        int[][] res = new int[k][k];
        int[] rowPos = new int[k + 1], colPos = new int[k + 1];
        Arrays.fill(rowPos, -1);
        Arrays.fill(colPos, -1);

        for (int i = 0; i < k; i++) {
            rowPos[rowNumOrder.get(i)] = i;
            colPos[colNumOrder.get(i)] = i;
        }

        for (int i = 1; i <= k; i++) {
            res[rowPos[i]][colPos[i]] = i;
        }

        return res;
    }
}