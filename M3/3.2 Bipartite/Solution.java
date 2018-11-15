import java.util.*; 
import java.lang.*; 
import java.io.*;
class Graph 
{ 
   public int V; 
	int [][]matrix; 
   public  LinkedList<Integer> adj[]; 
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v];
        matrix=new int[v][v];
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
    void addEdge(int v, int w) 
    { 
        adj[v].add(w); 
        if (v != w) {
	            if (!hasEdge(v, w)) {
	                matrix[v][w] = 1;
	                matrix[w][v] = 1;
	            }
	        } else {
	            return;
	        }
    } 
    public boolean hasEdge(int v,int w) {
    	if(matrix[v][w]==1) {
    		return true;
    	}
    	else
    		return false;
    }
    void DFSUtil(int v,boolean visited[]) 
    { 
         
        visited[v] = true; 
        System.out.print(v+" ");  
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 
  
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    void DFS(int v) 
    { 
        
        boolean visited[] = new boolean[V]; 
        DFSUtil(v, visited); 
    } 
    public void output()
	    {
	    	int count=0;
	    	
	    	for(int i=0;i<V;i++)
	    	{
	    		for(int j=0;j<V;j++)
	    		{
	    			if(matrix[i][j]==0) {
	    					count++;	
	    			}
	    		}
	    	}
	    	if(count!=matrix.length)
	    	{
	    		int i=0; 
	    	for(i=0;i<V-1;i++)
	    	{
	    		int j=0;
	    		for(;j<V;j++)
	    		{
	    			System.out.print(matrix[i][j]+" ");
	    		}
	    		
	    		System.out.println();
	    	}
	    	int k=0;
	    	for(k=0;k<V-1;k++)
 		{
 			System.out.print(matrix[i][k]+" ");
 		}
 		System.out.print(matrix[i][k]);
	    	}
	    	else
	    		System.out.println("No edges");
	    }
}
 public class Solution 
 { 
     boolean isBipartite(int G[][],int src) 
     {
         int colorArr[] = new int[G.length]; 
         for (int i=0; i<G.length; ++i) 
             colorArr[i] = -1; 
         colorArr[src] = 1; 
         LinkedList<Integer>q = new LinkedList<Integer>(); 
         q.add(src); 
    
         while (q.size() != 0) 
         { 
             int u = q.poll(); 
   
             if (G[u][u] == 1) 
                 return false;  
   
             for (int v=0; v<G.length; ++v) 
             { 
               
                 if (G[u][v]==1 && colorArr[v]==-1) 
                 { 
                     
                     colorArr[v] = 1-colorArr[u]; 
                     q.add(v); 
                 } 
   
                 else if (G[u][v]==1 && colorArr[v]==colorArr[u]) 
                     return false; 
             } 
         } 
         return true; 
     } 
     public static void main (String[] args) 
     { 
    	 Scanner scn=new Scanner(System.in);
    	 int n=Integer.parseInt(scn.nextLine());
    	 int m=Integer.parseInt(scn.nextLine());
    	Solution b = new Solution();
    	 Graph gp=new Graph(n);
    	 while(scn.hasNext()) {
    		 String s1=scn.nextLine();
    		 String s2[]=s1.split(" ");
    		 gp.addEdge(Integer.parseInt(s2[0]),Integer.parseInt(s2[1])); 
    	 } 
         if (b.isBipartite(gp.matrix, 0)) 
        	 System.out.println("Graph is bipartite"); 
         else
        	 System.out.println("Graph is not a bipartite"); 
     } 
 } 

