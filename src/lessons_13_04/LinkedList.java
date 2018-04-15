package lessons_13_04;

public class LinkedList<T>  {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int sizeLinkedList;


    public LinkedList(){
        this.lastNode = new Node<T>(null,  firstNode, null);
        this.firstNode = new Node<T>(null, null,lastNode);
    }

    public void addLast(T element){
        Node<T> prev = lastNode;
        prev.setCurrentElement(element);
        lastNode = new Node<T>( null, prev , null );
        prev.setNextElement(lastNode);
        sizeLinkedList++;
    }
    public void addFirst(T element){
        Node<T> first = firstNode;
        first.setCurrentElement(element);
        firstNode = new Node<T>(null, null, first);
        first.setPrevElement(firstNode);
        sizeLinkedList++;
    }


    public int size(){
        return sizeLinkedList;
    }
    public T getElementByIndex(int index){
        Node<T> returnElement = firstNode.getNextElement();
        for(int i = 0; i < index; i++){
            returnElement = getNextElement(returnElement);
        }
        return returnElement.getCurrentElement();
    }
    private Node<T> getNextElement(Node<T> current){
        return current.getNextElement();
    }
}
