/**
https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 */

class Solution {
    Map<Integer, ArrayList<Integer>> row;
    Map<Integer, ArrayList<Integer>> column;
    ArrayList<Set<Integer>> graph;
    
    public int removeStones(int[][] stones) {
      getGraph(stones);
      boolean[] visited = new boolean[stones.length];
      int countComponents = 0;
      for (int u = 0; u < stones.length; u++) {
    	  if (!visited[u]) {
              dfs (visited, u);
    		  countComponents++;
    	  }
      }
      return stones.length - countComponents;
    }

    private void getGraph(int[][] stones) {
      row = new HashMap<Integer, ArrayList<Integer>>();
      column = new HashMap<Integer, ArrayList<Integer>>();
      graph = new ArrayList<Set<Integer>>();
      
      for (int i = 0; i < stones.length; i++) {
    	  graph.add(i, new HashSet<Integer>());
    	  if (!row.containsKey(stones[i][0])) {
    		  row.put(stones[i][0], new ArrayList<Integer>());
    	  } else {
    		  for (Integer each : row.get(stones[i][0])) {
    			  graph.get(each).add(i);
    			  graph.get(i).add(each);
    		  }
    	  }
    	  row.get(stones[i][0]).add(i);
    	  if (!column.containsKey(stones[i][1])) {
    		  column.put(stones[i][1], new ArrayList<Integer>());
    	  } else {
    		  for (Integer each : column.get(stones[i][1])) {
    			  graph.get(each).add(i);
    			  graph.get(i).add(each);
    		  }
    	  }
    	  column.get(stones[i][1]).add(i);
      }
    }
    
    private void dfs (boolean[] visited, int u) {
    	visited[u] = true;
    	for (Integer each : graph.get(u)) {
        if (!visited[each]) {
    		dfs(visited, each);
    	  }
    	}
    }
}
