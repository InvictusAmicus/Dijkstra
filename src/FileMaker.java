//Ciaran Clerkin K00191500
//Declan Cordial K00184439
import java.util.Random;
import java.io.*;
public class FileMaker {

	public static void main(String[]args)throws FileNotFoundException {
                //assigns name for a file and creates file or overwrites file
		String filename = "point.txt";
		PrintWriter pw = new PrintWriter(filename);
		int n = 1000, x = 0, y = 0, z = 0;
		//adds the stream letter first
                pw.println("A");
		pw.println(n);
		Random RNG = new Random();
		RNG.setSeed(System.nanoTime());

		int[] node1 = new int[n];
		int[] node2 = new int[n];
		int[] distance = new int[n];
		int count;
		boolean ignore = false;

		for(count = 0; count < n;) {
			ignore = false;
			x = RNG.nextInt(1000)+1;
			y = RNG.nextInt(1000)+1;
			z = RNG.nextInt(1000)+1;

			System.out.println(x + "\t" + y + "\t" + z);

			if(x == y) {
				ignore = true;
			}//end of for

			for(int j = 0; j < n; j++) {
				if(x == node1[j])
				{
					for(int l = 0; l < n; l++) {
						if(y == node2[l]) {
							ignore = true;
						}//end of if
					}//end of for
				}//end of if

			}//end of for
			if(!ignore) {
				node1[count] = x;
				node2[count] = y;
				distance[count] = z;
				count++;
			}//end of if

		}//end of for

		for(int i = 0; i<n; i++) {
			pw.println(node1[i] + " " + node2[i]+ " " + distance[i] + " ");
		}//end of for

		pw.close();

	} // end of main

}//end of class