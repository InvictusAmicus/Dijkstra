/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readfile;

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
    }
    
    
    static void readFile()throws FileNotFoundException{
        int i =0;
	int NodeX, NodeY, NodeWeight;
	//System.out.print("test");
        //Scanner scan = new Scanner(new File("Points.txt"));
        
        String workingDir = System.getProperty("user.dir");
        System.out.println(workingDir);
        //Scanner scan = new Scanner(new File(workingDir+"\\src\\ReadFile\\DensePoints.txt"));
        Scanner scan = new Scanner(new File("point.txt"));
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
        //for(int j=0; j<Connections;j++){
        //System.out.println(TSP[j][0]+" "+TSP[j][1]+" "+distance[j]);
        //}  
        
    }
    
}