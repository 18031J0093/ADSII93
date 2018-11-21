
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
 
 class Vertex implements Comparable<Vertex> 
 {
	private String name;
	private List<Edge> adjacenciesList;
	private boolean visited;
	private Vertex predecessor;
	private int distance = Integer.MAX_VALUE;
 
	public Vertex(String name) {
		this.name = name;
		this.adjacenciesList = new ArrayList<>();
	}
 
	public void addNeighbour(Edge edge) {
		this.adjacenciesList.add(edge);
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public List<Edge> getAdjacenciesList() {
		return adjacenciesList;
	}
 
	public void setAdjacenciesList(List<Edge> adjacenciesList) {
		this.adjacenciesList = adjacenciesList;
	}
 
	public boolean isVisited() {
		return visited;
	}
 
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
 
	public Vertex getPredecessor() {
		return predecessor;
	}
 
	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}
 
	public int getDistance() {
		return distance;
	}
 
	public void setDistance(int distance) {
		this.distance = distance;
	}
 
	@Override
	public String toString() {
		return this.name;
	}
 
	@Override
	public int compareTo(Vertex otherVertex) {
		return Integer.compare(this.distance, otherVertex.getDistance());
	}
}
 class Edge {
	private int weight;
	private Vertex startVertex;
	private Vertex targetVertex;
	
	public Edge(int weight, Vertex startVertex, Vertex targetVertex) {
		this.weight = weight;
		this.startVertex = startVertex;
		this.targetVertex = targetVertex;
	}
 
	public int getWeight() {
		return weight;
	}
 
	public void setWeight(int weight) {
		this.weight = weight;
	}
 
	public Vertex getStartVertex() {
		return startVertex;
	}
 
	public void setStartVertex(Vertex startVertex) {
		this.startVertex = startVertex;
	}
 
	public Vertex getTargetVertex() {
		return targetVertex;
	}
 
	public void setTargetVertex(Vertex targetVertex) {
		this.targetVertex = targetVertex;
	}
}

 
class DijkstraShortestPath 
{ 
	public void computeShortestPaths(Vertex sourceVertex)
	{
		sourceVertex.setDistance(0);
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(sourceVertex);
		sourceVertex.setVisited(true);
 
		while( !priorityQueue.isEmpty() ){
            // Getting the minimum distance vertex from priority queue
			Vertex actualVertex = priorityQueue.poll();
			for(Edge edge : actualVertex.getAdjacenciesList()){
				Vertex v = edge.getTargetVertex();
				if(!v.isVisited())
				{
					int newDistance = actualVertex.getDistance() + edge.getWeight();
 
					if( newDistance < v.getDistance() ){
						priorityQueue.remove(v);
						v.setDistance(newDistance);
						v.setPredecessor(actualVertex);
						priorityQueue.add(v);
					}
				}
			}
			actualVertex.setVisited(true);
		}
	}
 
	public List<Vertex> getShortestPathTo(Vertex targetVertex){
		List<Vertex> path = new ArrayList<>();
 
		for(Vertex vertex=targetVertex;vertex!=null;vertex=vertex.getPredecessor()){
			path.add(vertex);
		}
 
		Collections.reverse(path);
		return path;
	}
}

public class DijkstraMain 
{
	public static Vertex getVertex(Vertex v[], String vName) {
		for (int i = 0; i < v.length; i++)
			if (vName.equals(v[i].getName()))
				return v[i];
		return null;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.nextLine();
		String ss[] = s1.split(" ");
		String s2 = scn.nextLine();
		String s3[] = s2.split(" ");
		Vertex v[] = new Vertex[Integer.parseInt(ss[0])];
		for (int i = 0; i < s3.length; i++) {
			v[i] = new Vertex(s3[i]);
		}
		for (int j = 0; j < Integer.parseInt(ss[1]); j++) {
			String s5 = scn.nextLine();
			String s6[] = s5.split(" ");
			Vertex v1 = getVertex(v, s6[0]);
			Vertex v2 = getVertex(v, s6[1]);
			v1.addNeighbour(new Edge(Integer.parseInt(s6[2]), v1, v2));
			v2.addNeighbour(new Edge(Integer.parseInt(s6[2]), v2, v1));
		}
		int c = Integer.parseInt(scn.nextLine());
		int count = 0;
		while (count < c) {
			String s7 = scn.nextLine();
			String s8[] = s7.split(" ");
			DijkstraShortestPath shortestPath = new  DijkstraShortestPath();
			for (int i = 0; i < s3.length; i++) {
				v[i].setDistance(Integer.MAX_VALUE);
				v[i].setVisited(false);
			}
			Vertex v1 = getVertex(v, s8[0]);
			Vertex v2 = getVertex(v, s8[1]);
			// System.out.println(v1);
			shortestPath.computeShortestPaths(v1);
			System.out.println(v2.getDistance());
			count++;
		}

	}

}


		/*DijkstraShortestPath shortestPath = new DijkstraShortestPath();
		shortestPath.computeShortestPaths(v[0]);
		System.out.println("======================================");
		System.out.println("Calculating minimum distance");
		System.out.println("======================================");
		System.out.println("Minimum distance from A to B: "+vertexB.getDistance());
		System.out.println("Minimum distance from A to C: "+vertexC.getDistance());
		System.out.println("Minimum distance from A to D: "+vertexD.getDistance());
		System.out.println("Minimum distance from A to E: "+vertexE.getDistance());
		
		System.out.println("=====================	=================");
		System.out.println("Calculating Paths");
		System.out.println("======================================");
		
		System.out.println("Shortest Path from A to B: "+shortestPath.getShortestPathTo(vertexB));
		System.out.println("Shortest Path from A to C: "+shortestPath.getShortestPathTo(vertexC));
		System.out.println("Shortest Path from A to D: "+shortestPath.getShortestPathTo(vertexD));
		System.out.println("Shortest Path from A to E: "+shortestPath.getShortestPathTo(vertexE));*/	

	
