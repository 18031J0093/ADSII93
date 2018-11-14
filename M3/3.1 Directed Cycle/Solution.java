
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution 
{
	private int V;   
    private Bag<Integer> adj[]; 

    Solution(int v) 
    { 
        V = v; 
        adj = new Bag[v]; 
        for (int i=0; i<v; ++i) 
        {
            adj[i] = new Bag<Integer>(); 
        }
    } 
	void addEdge(int v,int w) 
    { 
        adj[v].add(w); 
    } 
	private boolean DFS(int s)
    {
    	boolean visited[] = new boolean[V];
    	int i=0;
    	while(i<V)
    	{
    		if(DFSrec(s, visited))
    		{
    			return true;
    		}
    		i++;
    	}
    	return false;
    }
    private boolean DFSrec(int s, boolean visited[])
    {
    	visited[s] = true;
    	
    		Iterator<Integer>  i = adj[s].iterator();
    		while(i.hasNext())
    		{
    			int n = i.next();
    			if(!visited[n])
    			{
    				DFSrec(n, visited);
    				return true;
    			}
    		}
    		return false;
    	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int v = Integer.parseInt(sc.nextLine());
		int w = Integer.parseInt(sc.nextLine());
		Solution s = new Solution(w);
		while(sc.hasNext())
		{
			String s1 = sc.nextLine();
			String s2[] = s1.split(" ");
			s.addEdge(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]));
		}
		
		if(s.DFS(0))
		{
		System.out.println("Cycle doesn't exists.");
		}
		else
		{
		System.out.println("Cycle exists.");
		}
	}

}
