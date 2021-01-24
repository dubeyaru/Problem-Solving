/**
https://leetcode.com/problems/evaluate-division/
 */

class Solution {
    Map<String, Map<String, Double>> map;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        getGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);
            if (!hasVertex(u)) {
                result[i] = -1.0;
            } else if (!hasVertex(v)) {
                result[i] = -1.0;
            } else if (hasEdge(u, v)) {
                result[i] = map.get(u).get(v);
            } else if (dfs(u, v)) {
                result[i] = map.get(u).get(v);
            } else {
                result[i] = -1.0;
            }
        }
        return result;
    }
    
    private boolean dfs(String u, String v) {
        dfsHelper(u, v, u, 1.0, new HashSet<String>());
        return hasEdge(u, v);
    }
    
    private void dfsHelper(String src, String dest, String curr, double cost, Set<String> visited) {
        visited.add(curr);
        if (dest.equals(curr)) {
            map.get(src).put(dest, cost);
            return;
        }
        Set<String> keys = new HashSet<>(map.get(curr).keySet());
        for (String v : keys) {
            if (v.equals(src) || v.equals(curr) || visited.contains(v)) {
                continue;
            }
            dfsHelper(src, dest, v, cost * map.get(curr).get(v), visited);
        }
    }
    
    private boolean hasVertex(String u) {
        return map.containsKey(u);
    }
    
    private boolean hasEdge(String u, String v) {
        if (map.containsKey(u)) {
            return map.get(u).containsKey(v);
        }
        return false;
    }
    
    private void getGraph(List<List<String>> equations, double[] values) {
        map = new HashMap<String, Map<String, Double>>();
        for (int i = 0; i < equations.size(); i++) {
            addEdge(equations.get(i).get(0), equations.get(i).get(1), values[i]);
            addEdge(equations.get(i).get(1), equations.get(i).get(0), 1 / values[i]);
        }
    }
    
    private void addEdge(String u, String v, double cost) {
        if (!map.containsKey(u)) {
            map.put(u, new HashMap<String, Double>());
        }
        map.get(u).put(v, cost);
    }
}
