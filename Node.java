public  class Node {
    private int data;
    private Node left;
    private Node right;
    
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public void setLeft(Node left) {
        this.left = left;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    
    public Node getLeft() {
        return this.left;
    }
    public Node getRight() {
        return this.right;
    }
    
    public void printData() {
        System.out.println(this.data);
    }
    public int getData() {
        return data;
    }
}