/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

// @lc code=start
class Solution {
    List<List<Integer>>[] graph(int n , int[][] p){
        List<List<Integer>> g[] = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
          g[i] =new ArrayList<>();
        }
        for(int i=0;i<p.length;i++){
          g[p[i][0]].add(List.of(p[i][1] , p[i][2]));
        }
        return g;
    }

    public int findCheapestPrice(int n, int[][] f, int src, int dst, int k) {
        List<List<Integer>> g[] = graph (n , f);
        int[] dis = new int[n];
        Queue<List<Integer>> q= new LinkedList<>();
        q.offer(List.of(0 , src , 0));
        Arrays.fill(dis , Integer.MAX_VALUE);
        dis[src] =0;
        while(!q.isEmpty()){
            List<Integer> fn = q.poll();
            int s = fn.get(0);
            int v = fn.get(1);
            int c = fn.get(2);
            if(s > k){
                continue;
            }
            for(List<Integer> ng : g[v]){
                int nv = ng.get(0);
                int cv = ng.get(1);
                if(s <=k && c + cv  < dis[nv]){
                    dis[nv] = c + cv;
                    q.offer(List.of(s +1 , nv , dis[nv]));
                }
            }
        }
        if(dis[dst] == Integer.MAX_VALUE){
            return -1;
        } 
        return dis[dst];
    }
}
// @lc code=end

