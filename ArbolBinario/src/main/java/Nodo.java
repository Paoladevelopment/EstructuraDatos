public class Nodo {
    private int value;
    private Nodo LeftChild;
    private Nodo RightChild;

    public Nodo(int value) {
        this.value = value;
        this.LeftChild= null;
        this.RightChild= null;
    }

    //Getter and Setter

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Nodo getLeftChild() {
        return LeftChild;
    }

    public void setLeftChild(Nodo leftChild) {
        LeftChild = leftChild;
    }

    public Nodo getRightChild() {
        return RightChild;
    }

    public void setRightChild(Nodo rightChild) {
        RightChild = rightChild;
    }
}
