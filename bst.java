import java.util.*;

public class bst {
    public static void main(String[] args) {
        Node root = new Node(5);
        Node test = new Node(4);
        
        insertNode(root, test);
        insertNode(root, new Node(16));
        insertNode(root, new Node(8));
        insertNode(root, new Node(1));
        insertNode(root, new Node(7));
        insertNode(root, new Node(9));
        insertNode(root, new Node(25));
        insertNode(root, new Node(2));
        printTreeInOrder(root);
        
        root = removeItem(root, new Node(16));
        
        printTreeInOrder(root);
    }
    
    public static void insertNode(Node root, Node insert) {
        
        while (root != null) {
            if (root.getData() > insert.getData()) {
                if (root.getLeft() == null) {
                    root.setLeft(insert);
                    break;
                } else {
                    root = root.getLeft();
                }
            } else if (root.getData() < insert.getData()) {
                if (root.getRight() == null) {
                    root.setRight(insert);
                    break;
                } else {
                    root = root.getRight();
                }
            }
        }
        
    }
    
    // Remove item from root and return new head pointer
    public static Node removeItem(Node root, Node remove) {
        // Traverse to the Node.Node
        Node prev = root;
        Node curr = root;
        while (curr != null) {
            //System.out.println();
            if (curr.getData() > remove.getData()) {
                prev = curr;
                curr = curr.getLeft();
            } else if (curr.getData() < remove.getData()) {
                prev = curr;
                curr = curr.getRight();
            } else if (curr.getData() == remove.getData()) {
                if (curr.getLeft() == null && curr.getRight() == null) {
                    System.out.println("Leaf node removal");
                    if (prev.getLeft() != null && (prev.getLeft().getData() == curr.getData())) {
                        prev.setLeft(null);
                    } else if (prev.getRight() != null && (prev.getRight().getData() == curr.getData())) {
                        prev.setRight(null);
                    }
                } else if ((curr.getLeft() == null && curr.getRight() != null) ||
                            (curr.getLeft() != null && curr.getRight() == null)) {
                    System.out.println("Single Child Node removal.");
                    if (remove.getData() < root.getData()) {
                        if (curr.getLeft() != null) {
                            prev.setLeft(curr.getLeft());
                        } else {
                            prev.setLeft(curr.getRight());
                        }
                    } else if (remove.getData() > root.getData()) {
                        if (curr.getLeft() != null) {
                            prev.setRight(curr.getLeft());
                        } else {
                            prev.setRight(curr.getRight());
                        }
                    }
                } else {
                    System.out.println("Double child node removal.");
                    if (remove.getData() < prev.getData()) {
                        prev.setLeft(curr.getLeft());
                        insertNode(root, curr.getRight());
                    } else if (remove.getData() > prev.getData()) {
                        prev.setRight(curr.getLeft());
                        insertNode(root, curr.getRight());
                    }
                }

                break;
            }
        }
        
        return root;
        
        // Third handle case where two children
    }
    
    public static void printTreePreOrder(Node root) {
        if (root != null) {
            System.out.println(root.getData());
            printTreePreOrder(root.getLeft());
            printTreePreOrder(root.getRight());
        }
    }
    
    public static void printTreePostOrder(Node root) {
        if (root != null) {
            System.out.println(root.getData());
            printTreePostOrder(root.getRight());
            printTreePostOrder(root.getLeft());
        }
    }
    
    public static void printTreeInOrder(Node root) {
        ArrayList<Node> myList = new ArrayList<>();
        if (root != null) {
            myList.add(root);
            
            while (myList.size() > 0) {
                Node temp = myList.remove(0);
                System.out.println(temp.getData());
                if (temp.getLeft() != null) {
                    myList.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    myList.add(temp.getRight());
                }
            }

        }
    }
    /*
    public static void printTreePretty(Node root) {
        ArrayList<Node> myList = new ArrayList<>();
        myList.add(root);
        
        int height = getHeight(root);
        
        while (myList.size() > 0) {
            (int i = 0; i < height; i++) {
                System.out.print("   ");
            }
            height--;
        
            Node temp = myList.remove(0);
            System.out.println();
        }
    }
    */
    
    public static int getHeight(Node root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
        }
    }
}