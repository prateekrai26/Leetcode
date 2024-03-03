class Solution {
    static boolean valid(int x , int y , int n  , int m){
        if(x>=0  && y>=0 && x<n && y<m) return true;
        return false;
    }
    public int minimumEffortPath(int[][] mt) {
     int n = mt.length;
	 int m = mt[0].length;
     int[][] dis = new int[n][m];
	 Arrays.stream(dis).forEach(x -> Arrays.fill(x,Integer.MAX_VALUE));
     Queue<List<Integer>> pq= new PriorityQueue<>((x,y)-> x.get(2)-y.get(2));
	 pq.offer(List.of(0, 0 , 0));
	 dis[0][0]= 0;
	 int[] a= {1,-1, 0 , 0 };
	 int[] b= { 0 , 0 , 1, -1};
	 while(!pq.isEmpty()){
		 List<Integer> f = pq.poll();
		 int x = f.get(0);
		 int y = f.get(1);
		 int w = f.get(2);
         if(x==n-1 && y==m-1){
             return w;
         }
         for(int i=0;i<4;i++){
			 int ni = x + a[i];
			 int nj = y + b[i];
             if(valid(ni,  nj , n , m )  ){
             int diff= Math.max(dis[x][y] , Math.abs(mt[ni][nj] - mt[x][y]));
			   if(diff < dis[ni][nj]){
				 dis[ni][nj] = diff;
				 pq.offer(List.of(ni , nj , diff));
			   }
             }
		 }
	  }
     return  dis[n-1][m-1];
    }
}