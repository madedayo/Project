import java.util.ArrayList;
import java.util.Arrays;




public class MSTPrims {

	graph graph;
	int[] valueArray;
	int[] parentArray;
	boolean isInFringe[];	
	public void getMST()
	{
		Vertex startingVertex=graph.adjLists[0];		
		
		valueArray[0]=0;
		isInFringe[0]=false;
                while(isFringeEmpty()==false)	
		{
			Neighbour nbr=startingVertex.adjList;
		while(nbr!=null)
		{
			if((isInFringe[nbr.vertexNum]==true) && valueArray[nbr.vertexNum]>=nbr.weight){
			valueArray[nbr.vertexNum]=nbr.weight;
			parentArray[nbr.vertexNum]=getIndexForName(startingVertex.name);
			}
			nbr=nbr.next;
		}
		
		int indexOfMinumumValueInFringe=getindexOfMinumumValueInFringe();
		printEdge(indexOfMinumumValueInFringe);//printing the edge.. fore example - from A --> B
		isInFringe[indexOfMinumumValueInFringe]=false;
		startingVertex=graph.adjLists[indexOfMinumumValueInFringe];
	}
		
		
	}
	
	
	public int getIndexForName(String vertexName)
	{
		for(int i=0;i<graph.adjLists.length;i++)
		{
			if(graph.adjLists[i].name.equals(vertexName))return i;
		}
		return -1;
	}
	
	
	public int getindexOfMinumumValueInFringe()
	{
		int minimumValue=Integer.MAX_VALUE;
		int index_minimumValue=-99;
		for(int i=0;i<valueArray.length;i++)
		{
			
			if((valueArray[i]<minimumValue) && (isInFringe[i]==true))
			{
				minimumValue=valueArray[i];
				index_minimumValue=i;
			}
			
		}
		return index_minimumValue;
	}
	public boolean isFringeEmpty()
	{
		for(int i=0;i<isInFringe.length;i++)
		{
			if(isInFringe[i]==true)return false;
		}
		return true;
	}
	
	public void printEdge(int indexOfMinumumValueInFringe)
	{
		String startOfEdge=graph.adjLists[(parentArray[indexOfMinumumValueInFringe])].name;
		String endOfEdge=graph.adjLists[indexOfMinumumValueInFringe].name;
		System.out.println(startOfEdge+"  --> "+endOfEdge);
	}
	
	
		public static void main(String[] args) throws Exception {
		

		String path="G:\\advance java\\JavaApplication2\\src\\javaapplication2\\input.txt";
		MSTPrims minimumSpanningTreePrims=new MSTPrims();
		minimumSpanningTreePrims.graph=new graph(path);
		int noOfVertex=minimumSpanningTreePrims.graph.adjLists.length;
		minimumSpanningTreePrims.valueArray=new int[noOfVertex];
		minimumSpanningTreePrims.parentArray=new int[noOfVertex];
		minimumSpanningTreePrims.isInFringe=new boolean[noOfVertex];
		Arrays.fill(minimumSpanningTreePrims.isInFringe, true);
		Arrays.fill(minimumSpanningTreePrims.valueArray, Integer.MAX_VALUE);
		Arrays.fill(minimumSpanningTreePrims.parentArray, -99);
		
		minimumSpanningTreePrims.getMST();
		
	}
	
	
}
