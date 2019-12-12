import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class graph {

	Vertex[] adjLists;

	//constructor
	public graph(String file) throws FileNotFoundException
	{


		Scanner sc=new Scanner(new File(file));

		String graphType=sc.next();
		boolean undirected=true;
		
		adjLists=new Vertex[sc.nextInt()];


		for(int v=0;v<adjLists.length;v++)
		{
			adjLists[v]=new Vertex(sc.next(),null);
		}
		
		while(sc.hasNext())
		{
			
			int v1=indexForName(sc.next());
			int v2=indexForName(sc.next());
			int weight=Integer.parseInt(sc.next());
			adjLists[v1].adjList=new Neighbour(v2, adjLists[v1].adjList,weight); 
			if(undirected==true)
			{
				adjLists[v2].adjList=new Neighbour(v1, adjLists[v2].adjList,weight); 
			}	
		}
	}

	int indexForName(String name)
	{
		for(int v=0;v<adjLists.length;v++)
		{
			if(adjLists[v].name.equals(name))
			{
				return v;
			}
		}
		return -1;	
	}

	public void print()
	{
		System.out.println();
		for(int v=0;v<adjLists.length;v++)
		{
			System.out.println(adjLists[v].name);
			for(Neighbour nbr=adjLists[v].adjList;nbr!=null;nbr=nbr.next )
			{
				System.out.println("==>"+adjLists[nbr.vertexNum].name+"("+ nbr.weight +")");
			}
			System.out.println("\n");
		}


	}
	//Place the graph.txt on your Desktop and use the following path
	//Path ->   C:\Users\Gunjan\Desktop\input.txt
	public static void main(String[] args) throws FileNotFoundException
	{
	String file="G:\\advance java\\JavaApplication2\\src\\javaapplication2\\input.txt";	
            
		graph graph=new graph(file);
		graph.print();

	}

}
