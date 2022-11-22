public class Nodo {
    //atributo que guarda el valor.
    private int value;
    //atributo que enlaza el siguiente nodo
    private Nodo next;

    public Nodo(int value) {
        this.value = value;
        this.next= null;
    }

    //Getters and Setters

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
}
