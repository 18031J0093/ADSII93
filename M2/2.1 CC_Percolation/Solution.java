
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

 class Graph1 {
	int V;
	int E;
	String b[];
     Bag<Integer>[] adj;
     CC1 cc;
     
     @SuppressWarnings("unchecked")
	public Graph1(int V)
     {
    	 this.V=V;
    	 
    	 adj=(Bag<Integer>[])new Bag[V+1];
    	 for(int v=1;v<=V;v++)
    		 adj[v]=new Bag<Integer>();
     }
 int V()
{
	return V;
}
int E()
{
	return E;
}
Iterable<Integer> adj(int v)
{
	return adj[v];
}
public Graph1(BufferedReader in) throws IOException
{
this(Integer.parseInt(in.readLine()));
String z=in.readLine();
if(z==null)
{
	 System.out.println("false");
	 System.exit(0);;
}
while(z!=null)
{
	if(z.equals(""))
	{
		
		return;
	}
	//System.out.println(z);
	String r[]=z.split(" ");
	int v=Integer.parseInt(r[0]);
	int w=Integer.parseInt(r[1]);
	addEddge(v,w);
	z=in.readLine();
}
}
void addEddge(int v,int w)
{
	//System.out.println(E);
	E++;
	adj[v].add(w);
	adj[w].add(v);
}
}
 
 class CC1 {
	 boolean[] marked;
	 int[] id;
	 int[] size;
	 int count;
	 public CC1(Graph1 g)
	 {
	 	marked= new boolean[g.V()+1];
	 	id=new int[g.V()+1];
	 	size=new int[g.V()+1];
	 	for(int v=1;v<=g.V();v++)
	 	{
	 		if(!marked[v])
	 		{
	 			//System.out.println(v);
	 			dfs(g,v);
	 			count++;
	 		//System.out.println(count);
	 		}
	 	}
	 }
	 void dfs(Graph1 g,int v)
	 {
	 	marked[v]=true;
	 	id[v]=count;
	 	//System.out.println(id[v]);
	 	for(int w:g.adj(v))
	 	{
	 		//System.out.println(w);
	 		if(!marked[w])
	 		{
	 			dfs(g,w);
	 		}
	 	}
	 }
	 public int id(int v) {
	     validatevertex(v);
	     return id[v];
	 }
	 public int count() {
	     return count;
	 }
	 public int size(int v) {
	     validatevertex(v);
	     return size[id[v]];
	 }

	 boolean connected(int v,int w)
	 {
	 	//System.out.println(v+"cc"+w);
	 	validatevertex(v);
	 	validatevertex(w);
	 	return id[v]==id[w];
	 }
	 void validatevertex(int v)
	 {
	 	int V=marked.length;
	 	if(v<0||v>=V)
	 		throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
	 }
	 void display()
	 {
	 	//System.out.println(count);
	 	if(count==1)
	 	{
	 		System.out.println("true");
	 	}
	 	else
	 		System.out.println("false");
	 }
	 }


public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      Graph1 g=new Graph1(br);
      
      CC1 c=new CC1(g);
	 c.display();
	}

}
