public class AnyNode {

    private Object value;
    private AnyNode previous;
    private AnyNode next;

    public AnyNode(Object value) {
        this.value = value;
    }

    public <Any> Any getValue() {
        return (Any)value;
    }

    public void setPrevious(AnyNode node) {
        previous = node;
    }

    public AnyNode getPrevious() {
        return previous;
    }

    public void setNext(AnyNode node) {
        next = node;
    }

    public AnyNode getNext() {
        return next;
    }
}
