import java.util.*;
import java.io.*;
import java.awt.*;

public class DeclanCiaranDijkstra {
    readFile();
    //distance between paths
    int distance[];
    //Tree Structure Path
    int TSP[][];
    char GraphType;
    public static void main(String[]args){
    	readFile();
    }
    
    
    void readFile(){
        int Connections, i =0;
	int NodeX, NodeY, NodeWeight;
	//System.out.print("test");
        //Scanner scan = new Scanner(new File("Points.txt"));
        
        String workingDir = System.getProperty("user.dir");
        System.out.println(workingDir);
        //Scanner scan = new Scanner(new File(workingDir+"\\src\\ReadFile\\point.txt"));
        Scanner scan = new Scanner(new File("point.txt"));
        GraphType = scan.next().charAt(0);
        Connections = scan.nextInt();
        //int[] nodex = new int[Connections];
        //int[] nodey = new int[Connections];
        int[] nodeweight = new int[Connections];
        TSP[][] = new TSP[Connections][2];
        distance[] = new distance[Connections];
        while(scan.hasNextInt()){
            
            NodeX = scan.nextInt();
            //nodex[i] = Nodex;
            NodeY = scan.nextInt();
            //nodey[i] = Nodey;
           
            TSP[i][0] = NodeX;
            TSP[i][1] = NodeY
            NodeWeight = scan.nextInt();
            distance[i] = NodeWeight;
            i++;
        }
    
        System.out.println(GraphType);
        System.out.println(Connections);
        for(int j=0; j<Connections;j++){
        System.out.println(nodeX[j]+" "+nodeY[j]+" "+distance[j]);
        }  
        
    }
    
}
