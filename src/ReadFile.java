
package readfile;
import java.util.*;
import java.io.*;
import java.awt.*;

public class ReadFile{

    public static void main(String[] args) throws FileNotFoundException {


	int Connections, i =0;
	char GraphType;
	int Nodex, Nodey, NodeWeight;
	//System.out.print("test");
        //Scanner scan = new Scanner(new File("Points.txt"));
        
        String workingDir = System.getProperty("user.dir");
        System.out.println(workingDir);
        //Scanner scan = new Scanner(new File(workingDir+"\\src\\ReadFile\\point.txt"));
        Scanner scan = new Scanner(new File("point.txt"));
        GraphType = scan.next().charAt(0);
        Connections = scan.nextInt();
        int[] nodex = new int[Connections];
        int[] nodey = new int[Connections];
        int[] nodeweight = new int[Connections];
        
        while(scan.hasNextInt()){
            
            Nodex = scan.nextInt();
            nodex[i] = Nodex;
         
            Nodey = scan.nextInt();
            nodey[i] = Nodey;
           
            NodeWeight = scan.nextInt();
            nodeweight[i] = NodeWeight;
            i++;
        }
    
        System.out.println(GraphType);
        System.out.println(Connections);
        for(int j=0; j<Connections;j++){
        System.out.println(nodex[j]+" "+nodey[j]+" "+nodeweight[j]);
        }  
    }
}
