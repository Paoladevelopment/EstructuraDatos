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

    public ABB(int value, ABB father){
        this.value= value;
        this.father= father;
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


    //métodos
    public String inorder(){
        String left= "";
        String raiz= "";
        String right= "";
        if(this.getLeftChild() != null) {
            left= this.LeftChild.inorder() + " ";
        }
        raiz+= this.getValue();
        if(this.getRightChild() != null){
            right= " " + this.RightChild.inorder();
        }
        return left + raiz + right;

    }

    //se insertan numeros al arbol binario de búsqueda.
    public void insert(int number){
        if(this.getValue() <= number){
            if(this.getRightChild() ==null){
                this.setRightChild(new ABB(number, this));
            }else{
                this.getRightChild().insert(number);
            }
        } else{
            if(this.getLeftChild() ==null){
                this.setLeftChild(new ABB(number, this));
            }else{
                this.getLeftChild().insert(number);
            }
        }
    }
    //Retorna si cierto elemento se encuentra o no en el árbol de búsqueda binaria
    public boolean Search(int number){

        if(this.getValue() == number){
            return true;
        }else {
            if (this.getValue() < number) {
                if (this.getRightChild() != null) {
                    return this.getRightChild().Search(number);
                }
            } else {
                if (this.getLeftChild() != null) {
                    return this.getLeftChild().Search(number);
                }
            }
        }
        return false;
    }

    //Retorna el arbol siendo raíz del valor buscado
    public ABB SearchABB(int number) throws NullPointerException{

        if(this.getValue() == number){
            return this;
        }else {
            if (this.getValue() < number) {
                if (this.getRightChild() != null) {
                    return this.getRightChild().SearchABB(number);
                }else{
                    throw new NullPointerException();
                }
            } else {
                if (this.getLeftChild() != null) {
                    return this.getLeftChild().SearchABB(number);
                }else{
                    throw new NullPointerException();
                }
            }
        }
    }

    //Retorna el número más grande de nuestro ABB
    public int maximum() throws UnsupportedOperationException{
        ABB actualTree= this;
        while (actualTree.getRightChild() !=null){
            actualTree= actualTree.getRightChild();
        }
        return  actualTree.getValue();
    }
    //Retorna el número más pequeño de nuestro ABB
    public int minimum() throws UnsupportedOperationException{
        ABB actualTree= this;
        while (actualTree.getLeftChild() !=null){
            actualTree= actualTree.getLeftChild();
        }
        return  actualTree.getValue();
    }

    public ABB minimumABB(){
        ABB actualTree= this;
        while (actualTree.getLeftChild() !=null){
            actualTree= actualTree.getLeftChild();
        }
        return  actualTree;
    }

    public int successorWInorder(int num){
        String[] treeSearchArray= this.inorder().split(" ");
        for (int i= 0; i< treeSearchArray.length; i++){
            if (Integer.parseInt(treeSearchArray[i]) > num){
                return Integer.parseInt(treeSearchArray[i]);
            }
        }
        return -1;
    }

    public ABB successorWInorderABB(int num){
        String[] treeSearchArray= this.inorder().split(" ");


        for (int i= 0; i< treeSearchArray.length; i++){
            if (Integer.parseInt(treeSearchArray[i]) > num){
                return this.SearchABB(Integer.parseInt(treeSearchArray[i]));
            }
        }
        return null;
    }

    //ahora un método para obtener el sucesor pero usando la siguiente estrategia:
    //1) si el nodo al que se va a buscar el sucesor tiene hijo derecho, el sucesor es el minimo del hijo derecho
    //2) si no tiene hijo derecho, es el ancestro cuyo hijo izquierdo es ancestro del nodo actual. Entonces vamos intercambiando el nodo actual por el padre de este hasta que sea hijo izquierdo.
    public ABB successor(int num){
        ABB currentNode= this.SearchABB(num);
        if(currentNode.getRightChild() !=null){
            return currentNode.getRightChild().minimumABB();
        }else {
            ABB fatherOfCurrentNode= currentNode.getFather();
            while (fatherOfCurrentNode !=null && currentNode == fatherOfCurrentNode.getRightChild()){
                currentNode= fatherOfCurrentNode;
                fatherOfCurrentNode= currentNode.getFather();
            }
            return  fatherOfCurrentNode;
        }
    }
}
