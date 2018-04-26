package algorithms;

public class BinaryTree {
    private Node root;
    private int counter;
    private Node previous;

    private final static int DEFAULT_VALUE = 1;

    public BinaryTree() {
        this.root = null;
        this.counter = DEFAULT_VALUE;
        this.previous = null;
    }

    public Node getRoot() {
        return root;
    }

    public void addNode(int key) {
        Node node = new Node(key);

        if (root == null) {
            root = node;
        } else {
            Node currentNode = root;
            Node parent;

            while (true) {
                parent = currentNode;

                if (key < currentNode.getKey()) {
                    currentNode = currentNode.getLeftSide();

                    if (currentNode == null) {
                        parent.setLeftSide(node);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRightSide();

                    if (currentNode == null) {
                        parent.setRightSide(node);
                        return;
                    }
                }
            }
        }
    }

    public boolean  removeNode(int key){
        Node currentNode = root;
        Node parent = root;

        boolean isItLeftSide = true;

        while(currentNode.getKey() != key){
            parent = currentNode;

            if(key < currentNode.getKey()){
                isItLeftSide = true;
                currentNode = currentNode.getLeftSide();
            } else {
                isItLeftSide = false;
                currentNode = currentNode.getRightSide();
            }
            if(currentNode == null){
                return false;
            }
        }

        if(currentNode.getLeftSide() == null && currentNode.getRightSide() == null){
            if(currentNode == root){
                root = null;
            } else if (isItLeftSide){
                parent.setLeftSide(null);
            } else {
                parent.setRightSide(null);
            }
        } else if (currentNode.getRightSide() == null){
            if(currentNode == root){
                root = currentNode.getLeftSide();
            } else if(isItLeftSide) {
                parent.setLeftSide(currentNode.getLeftSide());
            } else {
                parent.setRightSide(currentNode.getLeftSide());
            }
        } else if (currentNode.getLeftSide() == null){
            if(currentNode == root){
                root = currentNode.getRightSide();
            } else if (isItLeftSide){
                parent.setLeftSide(currentNode.getRightSide());
            }else{
                parent.setRightSide(currentNode.getRightSide());
            }
        } else {
            Node replacement = getReplacementNode(currentNode);

            if(currentNode == root){
                root = replacement;
            } else if(isItLeftSide){
                parent.setLeftSide(replacement);
            } else {
                parent.setRightSide(replacement);
            }
            replacement.setLeftSide(currentNode.getLeftSide());
        }
        return true;
    }

    public Node getReplacementNode(Node replaceNode){
        Node replacementParent = replaceNode;
        Node replacement = replaceNode;
        Node currentNode = replaceNode.getRightSide();

        while(currentNode != null){
            replacementParent = replacement;
            replacement = currentNode;
            currentNode = currentNode.getLeftSide();
        }

        if( replacement != replaceNode.getRightSide()){
            replacementParent.setLeftSide(replacement.getRightSide());
            replacement.setRightSide(replaceNode.getRightSide());
        }

        return replacement;
    }

    public void inOrderTraverse(Node currentNode) {
        if (currentNode != null) {
            inOrderTraverse(currentNode.getLeftSide());
            System.out.println(currentNode);
            inOrderTraverse(currentNode.getRightSide());
        }
    }

    public void inOrderTraverseChanged(Node currentNode) {
        if (currentNode != null) {
            inOrderTraverseChanged(currentNode.getLeftSide());

            if(previous != null && currentNode.getKey() == previous.getKey()){
                counter++;
                currentNode.setCounter(counter);
            } else {
                counter = DEFAULT_VALUE;
                currentNode.setCounter(counter);
            }

            System.out.print(currentNode + " ");

            previous = currentNode;

            inOrderTraverseChanged(currentNode.getRightSide());
        }
    }

    public void preOrderTraverse(Node currentNode) {
        if (currentNode != null) {
            System.out.println(currentNode);
            preOrderTraverse(currentNode.getLeftSide());
            preOrderTraverse(currentNode.getRightSide());
        }
    }

    public void postOrderTraverse(Node currentNode) {
        if (currentNode != null) {
            postOrderTraverse(currentNode.getLeftSide());
            postOrderTraverse(currentNode.getRightSide());
            System.out.println(currentNode);
        }
    }

    public Node findNode(int key) {
        Node currentNode = root;

        while (currentNode.getKey() != key) {
            if (key < currentNode.getKey()) {
                currentNode = currentNode.getLeftSide();
            } else {
                currentNode = currentNode.getRightSide();
            }

            if (currentNode == null) {
                return null;
            }
        }

        return currentNode;
    }

    public String recoveringPathToNode(int key) {
        Node currentNode = root;
        StringBuilder path = new StringBuilder(currentNode.toString());

        while (currentNode.getKey() != key) {
            if (key < currentNode.getKey()) {
                currentNode = currentNode.getLeftSide();
            } else {
                currentNode = currentNode.getRightSide();
            }

            if (currentNode == null) {
                return null;
            }

            path.append(currentNode);
        }

        return path.toString();
    }
}
