public class ABB {
    private int value;
    private ABB LeftChild;
    private ABB RightChild;

    private ABB father;

    public ABB(int value) {
        this.value = value;
        this.LeftChild= null;
        this.RightChild= null;
        this.father= null;
    }

    //constructor completo

    public ABB(int value, ABB leftChild, ABB rightChild, ABB father) {
        this.value = value;
        this.LeftChild = leftChild;
        this.RightChild = rightChild;
        this.father = father;
    }


    //Getter and Setter

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ABB getLeftChild() {
        return LeftChild;
    }

    public void setLeftChild(ABB leftChild) {
        LeftChild = leftChild;
    }

    public ABB getRightChild() {
        return RightChild;
    }

    public void setRightChild(ABB rightChild) {
        RightChild = rightChild;
    }

    public ABB getFather() {
        return father;
    }

    public void setFather(ABB father) {
        this.father = father;
    }
}
