//Ciaran Clerkin K00191500
//Declan Cordial K00184439
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

        readFile();//cals readfile() method below
        for(int j=0; j<Connections;j++){
                //prints vertex1, vertex2 and the distance
        	System.out.println(TSP[j][0]+" "+TSP[j][1]+" "+distance[j]);
        }//end of for

        Node[] nodeArray = new Node[Connections];
        for(int k = 0; k < Connections; k++){
            //assigns nodes to the node array
	    nodeArray[k] = new Node(TSP[k][0],TSP[k][1],distance[k]);
	}//end of for

        //Start algorithm
        distTo = new double[Connections];
        edgeTo = new Node[Connections];
        for (int v = 0; v < Connections; v++){
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[TSP[0][0]] = 0.0;

        pq = new IndexMinPQ<Double>(Connections);
        pq.insert(TSP[0][0], distTo[TSP[0][0]]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for(int q = 0; q<Connections;q++){
                relax(nodeArray[q]);
            }//end of for
        }//end of while

                        PrintWriter pw = new PrintWriter("output.txt");
        for (int t = 0; t < Connections; t++) {
            if (hasPathTo(t)) {
                System.out.printf("%d to %d (%.2f)  ", TSP[0][0], t, distTo(t));
                if (hasPathTo(t)) {
                    for (Node e : pathTo(t)) {
                        //prints out the vertex1 to vertex2 along with the distance
                        System.out.print(e.vertex + "->"+e.vertex2 +" : "+e.distance+"   ");
                        pw.print(e.vertex + "->"+e.vertex2 +" : "+e.distance+"   ");

                    }//end of for
                }//end of if
                System.out.println();
                pw.println();
            }//end of if
        }//end of for
    }//end of main


    static void readFile()throws FileNotFoundException{
        int i =0;
	int NodeX, NodeY, NodeWeight;
        //Scanner scan = new Scanner(new File("Points.txt"));

        String workingDir = System.getProperty("user.dir");
        //System.out.println(workingDir);
        Scanner scan = new Scanner(new File(workingDir+"\\src\\ReadFile\\1000Point.txt"));
        //Scanner scan = new Scanner(new File("Points.txt"));
        //Scanner scan = new Scanner(new In("Points.txt"));
        GraphType = scan.next().charAt(0);
        Connections = scan.nextInt();

        int[] nodeweight = new int[Connections];
        TSP = new int[Connections][2];
        distance = new int[Connections];
        while(scan.hasNextInt()){

            NodeX = scan.nextInt();
            NodeY = scan.nextInt();

            TSP[i][0] = NodeX;
            TSP[i][1] = NodeY;
            NodeWeight = scan.nextInt();
            distance[i] = NodeWeight;
            i++;

	}
        //prints out the type of graph and the number of connections
        System.out.println(GraphType);
        System.out.println(Connections);

        //sorts the array
	int[] check = new int[3];
	for(int e = 0; e < Connections; e++){
	    for(int f = 1; f < Connections; f++){
		if(TSP[f][0] < TSP[f-1][0]){
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
	}//end of for
        scan.close();

    } // end of readfile

    public static double distTo(int x){
        return distTo[x];
    }//end of distTo
    public static boolean hasPathTo(int x){
        return distTo[x]<Double.POSITIVE_INFINITY;
    }//end of hasPathTo

    public static Iterable<Node> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Node> path = new Stack<Node>();
        for (Node e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }//end of path

    public static void relax(Node e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) pq.change(w, distTo[w]);
            else                pq.insert(w, distTo[w]);
        }//end of if
    }//end of relax

    public Iterable<Node> adj(int v) {
        return adj[v];
    }//end of adj
} // end of class