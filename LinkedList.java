package algorithms.java;

public class LinkedList {
    private Node root;
    private  int size;

    private Node last;
    public void add(int value){
        Node node = new Node(value);
        if (root == null) {
            root = node;
            last = root;
            size = 1;
            return;
        }else {
            last.next = node;
            node.previous = last.next;
            last = node;
            size++;

        }

       /* Node currentNode = root;
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(value);
        last = currentNode.next;
        size++;

        */
    }
    public void addAt(int value, int index){
        if (index < 0 || index > size)
            return;
        if (index == 0){
            Node newNode = new Node(value);
            newNode.next = root;
            last = root;
            root = newNode;
            size++;
            return;
        }
        Node currentNode = getNode(index - 1);
        Node newNode = new Node(value,currentNode.next);
        currentNode.next = newNode;
        size++;


    }

    public int getSize(){
        return size;
    }
    public void addRemove(int value, int index){
        if (index == 0){
            Node newNode = new Node(value);
            newNode.next = root;
            root = newNode;
            size++;
            removeAt(index+1);
            return;
        }

        Node currentNode = getNode(index);
        Node newNode = new Node(value);
        currentNode.value = newNode.value;

        //size++;
        //removeAt(index+1);

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
    public void revers() {
        if (size > 1){
            last = root;
            Node currentNode = root.next;
            root.next = null;
            while (currentNode != null){
                Node next = currentNode.next;
                currentNode.next = root;
                root = currentNode;
                currentNode = next;
            }
        }

        /*int indexI = 0;
        int indexJ = size-1;
        int i = getValue(indexI);
        int length = size;
        int j = getValue(indexJ);
        Node currentNodeI = getNode(indexI);
        Node currentNodeJ = getNode(indexJ);
        Node currentNode = root;
        Node lastNode = last;

        if (size > 1){
            while (indexI < 2) {
                    Node next = currentNode.next;
                    Node previous = lastNode.previous;
                    Node temp = currentNode;
                    currentNode = lastNode;
                    lastNode = temp;
                    currentNode = next;
                    lastNode = previous;
        */


        //addRemove(i, indexJ);
        //addRemove(j, indexI);
        //currentNodeJ = temp;
        //indexI++;
        //indexJ--;


                /*if (indexI == 0) {
                    Node newNode = new Node(currentNodeJ.value);
                    newNode.next = root;
                    root = newNode;
                    size++;
                    removeAt(indexI + 1);
                    return;
                }

                 */
                /*Node currentNode1 = getNode(indexJ);
                Node currentNode2 = getNode(indexI);
                Node newNode1 = new Node(currentNodeI.value);
                Node newNode2 = new Node(currentNodeJ.value);
                //Node temp = currentNode1;
                currentNode1.value = newNode1.value;
                currentNode2.value = newNode2.value;

                 */

                /*Node temp = new Node(currentNodeJ.value);
                Node newNode = new Node(currentNodeI.value);
                currentNodeJ.value = newNode.value;
                currentNodeI.value = temp.value;

                 */
        /*

            }

        }
        else System.out.println("size is minimal");

    */
    }
    private class Node{
        int value;
        Node next;
        Node previous;

        Node(){}
        Node(int _value){
            this.value = _value;
        }

        Node(int _value, Node _next){
            this.value = _value;
            this.next = _next;
        }
        Node(int _value, Node _next, Node _previous){
            this.value = _value;
            this.next = _next;
            this.previous = _previous;
        }
    }
}
