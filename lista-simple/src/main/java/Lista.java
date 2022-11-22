public class Lista {
    private Nodo head;
    private int size;

    public Lista(){
        this.head= null;
        this.size=0;
    }

    //métodos sobre la lista

    //Agrega el valor al final de la lista.
    public void add(int value){
        if(this.head==null){
            Nodo head= new Nodo(value);
            this.setHead(head);
            this.size++;
        }else{
            Nodo ActualNode= this.head;
            while (ActualNode.getNext() != null){
                ActualNode= ActualNode.getNext();
            }
            ActualNode.setNext(new Nodo(value));
            this.size++;
        }
    }
    //Inserta el valor después del valor de referencia en la lista.
    //Se implementará sin usar search
    public void insertByReference(int ref, int value) throws NullPointerException{
        //Empezamos con el nodo inicial
        Nodo ActualNode= this.getHead();
        //Acá vamos recorriendo cada nodo hasta que lleguemos al que tiene el valor de referencia o al final de la lista
        while (ActualNode.getValue() != ref && ActualNode.getNext() != null){
            ActualNode= ActualNode.getNext();
        }
        //Tenemos que verificar si el valor del nodo actual coincide con el de referencia
        if (ActualNode.getValue()==ref){
            if (ActualNode.getNext() !=null){
                int nextValue= ActualNode.getNext().getValue();
                ActualNode.getNext().setValue(value);
                ActualNode.getNext().setNext(new Nodo(nextValue));
                this.size++;
            }else{
                ActualNode.setNext(new Nodo(value));
                this.size++;
            }

        }else {
            throw new NullPointerException();
        }
    }
    //Elimina el nodo con el valor que coincida con la referencia.
    public void Remove(int value) throws NullPointerException{
        Nodo ActualNode= this.head;
        while (ActualNode.getNext() !=null){
            if (ActualNode.getValue()== value){
                ActualNode.setValue(ActualNode.getNext().getValue());
                ActualNode.setNext(ActualNode.getNext().getNext());
                this.size--;
                break;
            }else {
                ActualNode= ActualNode.getNext();
            }
        }
        if(ActualNode.getValue()== value){
            ActualNode.setValue(0);
            this.size--;
        }
    }
    //Actualiza el valor de nodo con el valor que coincida con la referencia.
    public void Editar(int ref) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    //retorna true si la lista está vacía, false en caso contrario.
    public boolean isEmpty() {
        return this.head==null;
    }

    //retorna true si el elemento existe en la lista, false caso contrario.
    public boolean search(int value){
        //Se empieza con la cabeza y se recorren los nodos hasta llegar al último.
        //Se verifica si ese nodo contiene el valor que se anda buscando.
        Nodo ActualNode= this.head;
        while (ActualNode.getNext() !=null){
            if (ActualNode.getValue()==value){
                return true;
            }else {
                ActualNode= ActualNode.getNext();
            }
        }
        if (ActualNode.getValue()==value){
            return true;
        }else {
            return false;
        }
    }

    //elimina la lista
    public void delete() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    //imprime en pantalla los elementos de la lista.
    public String listing() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    //Getters

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }



    public static void main(String[] args) {
        Lista objLista= new Lista();
        objLista.setHead(new Nodo(10));
        objLista.getHead().setNext(new Nodo(20));
        System.out.println(objLista.getHead().getNext().getNext());
    }
}
