//Ciaran Clerkin K00191500
//Declan Cordial K00184439
public class Node {

    int vertex;
    int distance;
    int vertex2;

    public Node(int a,int b,int c) {
        vertex = a;
	vertex2 = b;
	distance = c;
    }//end of node
    public int from(){
        return vertex;
    }//end of from
    public int to(){
        return vertex2;
    }//end of to
    public int weight(){
        return distance;
    }//end of weight
}//end of class