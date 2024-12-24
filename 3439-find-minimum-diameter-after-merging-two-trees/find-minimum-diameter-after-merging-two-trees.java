class Solution {
    int maxDiameter;
    
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int size1 = edges1.length + 1;
        int size2 = edges2.length + 1;
        ArrayList<Integer>[] tree1 = new ArrayList[size1];
        ArrayList<Integer>[] tree2 = new ArrayList[size2];

        for (int i = 0; i < size1; i++) tree1[i] = new ArrayList<>();
        for (int i = 0; i < size2; i++) tree2[i] = new ArrayList<>();
        
        for (int[] edge : edges1) {
            tree1[edge[0]].add(edge[1]);
            tree1[edge[1]].add(edge[0]);
        }
        for (int[] edge : edges2) {
            tree2[edge[0]].add(edge[1]);
            tree2[edge[1]].add(edge[0]);
        }
        
        maxDiameter = -1;
        boolean[] visitedTree1 = new boolean[size1];
        computeDiameter(0, tree1, visitedTree1);
        int diameter1 = maxDiameter;

        maxDiameter = -1;
        boolean[] visitedTree2 = new boolean[size2];
        computeDiameter(0, tree2, visitedTree2);
        int diameter2 = maxDiameter;

        int candidateDiameter = (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1;
        return Math.max(candidateDiameter, Math.max(diameter1, diameter2));
    }

    private int computeDiameter(int node, ArrayList<Integer>[] tree, boolean[] visited) {
        visited[node] = true;
        int maxChildHeight = -1, secondMaxChildHeight = -1;

        for (int child : tree[node]) {
            if (!visited[child]) {
                int childHeight = computeDiameter(child, tree, visited);
                if (childHeight > maxChildHeight) {
                    secondMaxChildHeight = maxChildHeight;
                    maxChildHeight = childHeight;
                } else if (childHeight > secondMaxChildHeight) {
                    secondMaxChildHeight = childHeight;
                }
            }
        }
        
        if (maxChildHeight + secondMaxChildHeight + 2 > maxDiameter) {
            maxDiameter = maxChildHeight + secondMaxChildHeight + 2;
        }
        
        return maxChildHeight + 1;
    }
}