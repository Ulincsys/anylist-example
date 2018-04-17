public class AnyList {

    private AnyNode head = null;
    private AnyNode tail = null;

    public AnyList() {
    }

    public void add(Object value) {
        AnyNode currentNode = new AnyNode(value);

        if(head == null) {
            head = currentNode;
            tail = currentNode;
        } else {
            currentNode.setPrevious(tail.getPrevious());
            tail = currentNode;
        }
    }

    public <Any> Any getFirst() {
        return (Any)head.getValue();
    }

    public <Any> Any getLast() {
        return (Any)tail.getValue();
    }
}
