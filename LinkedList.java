package algorithms.java;

public class LinkedList {
    private Node root;
    private  int size;
    public void add(int value){
        if (root == null) {
            root = new Node(value);
            size = 1;
            return;
        }
        Node currentNode = root;
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(value);
        size++;
    }
    public void addAt(int value, int index){
        if (index < 0 || index > size)
            return;
        if (index == 0){
            Node newNode = new Node(value);
            newNode.next = root;
            root = newNode;
            size++;
            return;
        }
        Node currentNode = getNode(index - 1);
        Node newNode = new Node(value,currentNode.next);
        currentNode.next = newNode;
        size++;


    }
    public void print(){
        Node currentNode = root;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
    }
    public boolean remove(int value){
        if (root == null)
            return false;
        if (root.value == value){
            root = root.next;
            size--;
            return true;

        }

        Node currentNode = root;
        while (currentNode.next != null){
            if (currentNode.next.value == value){
                currentNode.next = currentNode.next.next;
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }
    public void removeAt(int index){
        if (index < 0 || index >= size)
            return;
        if (index == 0){
            root = root.next;
            size--;
            return;
        }
        Node currentNode = getNode(index - 1);
        currentNode.next = currentNode.next.next;
        size--;
    }
    public int getValue(int index){
        if (index < 0 || index >= size)
            throw  new IndexOutOfBoundsException();
        Node currentNode = root;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }
    public Node getNode(int index){
        if (index < 0 || index >= size)
            return null;
        if (index == 0){
            return root;
        }
        Node currentNode = root;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
    private class Node{
        int value;
        Node next;
        Node(){}
        Node(int _value){
            this.value = _value;
        }

        Node(int _value, Node _next){
            this.value = _value;
            this.next = _next;
        }
    }
}
