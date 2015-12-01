import java.util.*;
import java.io.*;
import java.awt.*;



public class DeclanCiaranDijkstra {

    static double[] distTo;
    static Node[] edgeTo;
    //distance between paths
    static int distance[];
    //Tree Structure Path
    static int TSP[][];
    static char GraphType;
    static int Connections;
    Bag<Node>[] adj;
    static IndexMinPQ<Double> pq;


    public static void main(String[]args)throws FileNotFoundException{
    	
        
        
        
        readFile();
        for(int j=0; j<Connections;j++){
        	System.out.println(TSP[j][0]+" "+TSP[j][1]+" "+distance[j]);
        }
        //EdgeWeightedDigraph G; 
        //    G = new EdgeWeightedDigraph(new In("point.txt"));
       /*
        adj = (Bag<DirectedEdge>[]) new Bag[Connections];
        for(int i = 0;i<Connections;i++){
        
        adj[i] = new Bag<DirectedEdge>();}
        int s = TSP[0][0];
        System.out.println(adj[0]);


// ----------Do algorithm

         LinkedList<Node> list = new LinkedList<Node>();
         int count = 0;
        */
        Node[] nodeArray = new Node[Connections];
        for(int k = 0; k < Connections; k++){
	    nodeArray[k] = new Node(TSP[k][0],TSP[k][1],distance[k]);
                                        
	    //list.add(nodeArray[k]);
            //count++;
	}

				//System.out.println(list);
                                //System.out.println("count is "+count);
                                //System.out.println("connections is "+Connections);
        
        //*/                 
        //Start algorithm
        distTo = new double[Connections];
        edgeTo = new Node[Connections];
        for (int v = 0; v < Connections; v++){
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        //distTo[TSP[0][0]] = 0.0;
        distTo[TSP[0][0]-1] = 0.0;
        System.out.print("Test "+distTo[TSP[0][0]-1]);
        
        pq = new IndexMinPQ<Double>(Connections);
        pq.insert(TSP[0][0], distTo[TSP[0][0]]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
           // for (Node e : nodeArray[v]){
           //     relax(e);
           // }    
        }
        
        assert check(nodeArray, TSP[0][0]);
        
        for (int t = 0; t < Connections; t++) {
            if (hasPathTo(t)) {
                System.out.printf("%d to %d (%.2f)  ", TSP[0][0], t, distTo(t));
                if (hasPathTo(t)) {
                    for (Node e : pathTo(t)) {
                        System.out.print(e + "   ");
                    }
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", TSP[0][0], t);
            }
        }
        
        
        
    }


    static void readFile()throws FileNotFoundException{
        int i =0;
	int NodeX, NodeY, NodeWeight;
	//System.out.print("test");
        //Scanner scan = new Scanner(new File("Points.txt"));

        String workingDir = System.getProperty("user.dir");
        //System.out.println(workingDir);
        Scanner scan = new Scanner(new File(workingDir+"\\src\\ReadFile\\Points.txt"));
        //Scanner scan = new Scanner(new File("Points.txt"));
        //Scanner scan = new Scanner(new In("Points.txt"));
        GraphType = scan.next().charAt(0);
        Connections = scan.nextInt();
        //int[] nodex = new int[Connections];
        //int[] nodey = new int[Connections];
        int[] nodeweight = new int[Connections];
        TSP = new int[Connections][2];
        distance = new int[Connections];
        while(scan.hasNextInt()){

            NodeX = scan.nextInt();
            //nodex[i] = Nodex;
            NodeY = scan.nextInt();
            //nodey[i] = Nodey;

            TSP[i][0] = NodeX;
            TSP[i][1] = NodeY;
            NodeWeight = scan.nextInt();
            distance[i] = NodeWeight;
            i++;

		}

        System.out.println(GraphType);
        System.out.println(Connections);
       // for(int j=0; j<Connections;j++){
       // System.out.println(TSP[j][0]+" "+TSP[j][1]+" "+distance[j]);
        //return new Node();
		//}
		// ---------Sort arrays
		int[] check = new int[3];
		for(int e = 0; e < Connections; e++)
		{
			for(int f = 1; f < Connections; f++)
			{
				if(TSP[f][0] < TSP[f-1][0])
				{
					check[0] = TSP[f][0];
					check[1] = TSP[f][1];
					check[2] = distance[f];

					TSP[f][0] = TSP[f-1][0];
					TSP[f][1] = TSP[f-1][1];
					distance[f] = distance[f-1];

					TSP[f-1][0] = check[0];
					TSP[f-1][1] = check[1];
					distance[f-1] = check[2];

				} // end of if
                                
			} // end of for
		}
            scan.close();
            //EdgeWeightedDigraph G; 
            //G = new EdgeWeightedDigraph(new In("point.txt"));
            //int s = TSP[0][0];
            //System.out.println("G = "+G);
	} // end of readfile
    public static double distTo(int x){
        return distTo[x];
    }
    public static boolean hasPathTo(int x){
        return distTo[x]<Double.POSITIVE_INFINITY;
    }
    
    public static Iterable<Node> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Node> path = new Stack<Node>();
        for (Node e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
    
    public static void relax(Node e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) pq.change(w, distTo[w]);
            else                pq.insert(w, distTo[w]);
        }
    }
    
    public Iterable<Node> adj(int v) {
        return adj[v];
    }

} // end of class