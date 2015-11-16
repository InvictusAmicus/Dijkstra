import java.util.*;
import java.io.*;
import java.awt.*;


public class DeclanCiaranDijkstra {


    //distance between paths
    static int distance[];
    //Tree Structure Path
    static int TSP[][];
    static char GraphType;
    static int Connections;



    public static void main(String[]args)throws FileNotFoundException{
    	readFile();
        for(int j=0; j<Connections;j++){
        	System.out.println(TSP[j][0]+" "+TSP[j][1]+" "+distance[j]);
        }


// ----------Do algorithm

         LinkedList<Node> list = new LinkedList<Node>();

		        Node[] nodeArray = new Node[Connections];
		        for(int k = 0; k < Connections; k++)
		        {
					nodeArray[k] = new Node(TSP[k][0],TSP[k][1],distance[k]);

					list.add(nodeArray[k]);
				}

				System.out.println(list);

    }


    static void readFile()throws FileNotFoundException{
        int i =0;
	int NodeX, NodeY, NodeWeight;
	//System.out.print("test");
        //Scanner scan = new Scanner(new File("Points.txt"));

        String workingDir = System.getProperty("user.dir");
        System.out.println(workingDir);
        //Scanner scan = new Scanner(new File(workingDir+"\\src\\ReadFile\\DensePoints.txt"));
        Scanner scan = new Scanner(new File("Points.txt"));
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
	} // end of readfile

} // end of class
