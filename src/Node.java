public class Node {

    private int vertex;
    private int distance;
    private int vertex2;

    public Node(int a,int b,int c) {
        vertex = a;
	vertex2 = b;
	distance = c;
    }
    public int from(){
        return vertex;
    }
    public int to(){
        return vertex2;
    }
    public int weight(){
        return distance;
    }
}