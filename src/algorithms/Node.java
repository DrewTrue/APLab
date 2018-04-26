package algorithms;

public class Node {
    private int key;
    private int counter;
    private Node left;
    private Node right;

    private final static int DEFAULT_VALUE = 0;

    /*public Node(){
        this(DEFAULT_VALUE);
    }*/

    public Node(int key){
        this.key = key;
        this.counter = DEFAULT_VALUE;
    }

    public int getKey(){
        return key;
    }

    public void setKey(int key){
        this.key = key;
    }

    public int getCounter(){
        return counter;
    }

    public void setCounter(int counter){
        this.counter = counter;
    }

    public Node getLeftSide(){
        return left;
    }

    public void setLeftSide(Node left){
        this.left = left;
    }

    public Node getRightSide(){
        return right;
    }

    public void setRightSide(Node right){
        this.right = right;
    }

    public String toString() {
        return key + "[" + counter + "]" + " --> ";
    }
}
