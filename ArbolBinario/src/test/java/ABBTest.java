import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ABBTest {

    @Test
    public void recorridoInordenTest(){
        ABB raiz= new ABB(25);
        raiz.setLeftChild(new ABB(14, new ABB(12, null,null,null), new ABB(20, null, null, null), null));
        raiz.setRightChild(new ABB(30,new ABB(27),new ABB(32,new ABB(31),null,null),null));
        assertEquals(raiz.inorder(), "12 14 20 25 27 30 31 32");
    }

    @Test
    public void InsertTest(){
        ABB raiz= new ABB(50);
        raiz.insert(20);
        raiz.insert(12);
        raiz.insert(30);
        raiz.insert(60);
        assertEquals(raiz.inorder(), "12 20 30 50 60");
    }

    @Test
    public void SearchTest(){
        ABB raiz= new ABB(50);
        raiz.insert(20);
        raiz.insert(12);
        raiz.insert(30);
        raiz.insert(60);
        assertTrue(raiz.Search(12));
        assertFalse(raiz.Search(2));
    }

    @Test
    public void MaximumTest(){
        ABB raiz= new ABB(50);
        raiz.insert(20);
        raiz.insert(12);
        raiz.insert(30);
        raiz.insert(60);
        raiz.insert(70);
        assertEquals(raiz.maximum(), 70);

        ABB raiz2= new ABB(20);
        assertEquals(raiz2.maximum(), 20);
    }

    @Test
    public void MinimumTest(){
        ABB raiz= new ABB(50);
        raiz.insert(20);
        raiz.insert(12);
        raiz.insert(30);
        raiz.insert(60);
        raiz.insert(70);
        assertEquals(raiz.minimum(), 12);

        ABB raiz2= new ABB(20);
        raiz2.insert(25);
        raiz2.insert(24);
        assertEquals(raiz2.minimum(), 20);
    }

    @Test
    public void MinimumABBTest(){
        ABB raiz= new ABB(50);
        raiz.insert(20);
        raiz.insert(12);
        raiz.insert(30);
        raiz.insert(60);
        raiz.insert(70);
        assertEquals(raiz.minimumABB(), raiz.getLeftChild().getLeftChild());

        ABB raiz2= new ABB(20);
        raiz2.insert(25);
        raiz2.insert(24);
        assertEquals(raiz2.minimumABB(), raiz2);
    }

    @Test
    public void SearchABBTest(){
        ABB raiz= new ABB(50);
        raiz.insert(20);
        raiz.insert(12);
        raiz.insert(30);
        raiz.insert(60);
        raiz.insert(70);
        assertEquals(raiz.SearchABB(70), raiz.getRightChild().getRightChild());
    }

    @Test
    public void SuccessorWInorderTest(){
        ABB raiz= new ABB(50);
        raiz.insert(20);
        raiz.insert(12);
        raiz.insert(30);
        raiz.insert(60);
        raiz.insert(70);
        assertEquals(raiz.successorWInorder(30),50 );
        assertEquals(raiz.successorWInorder(70),-1);
    }

    @Test
    public void SuccessorWInorderABBTest(){
        ABB raiz= new ABB(50);
        raiz.insert(20);
        raiz.insert(12);
        raiz.insert(30);
        raiz.insert(60);
        raiz.insert(70);
        assertEquals(raiz.successorWInorderABB(30),raiz);
        assertEquals(raiz.successorWInorderABB(20),raiz.getLeftChild().getRightChild());
        assertEquals(raiz.successorWInorderABB(70), null);
    }

    @Test
    public void SuccessorTest(){
        ABB raiz= new ABB(50);
        raiz.insert(20);
        raiz.insert(12);
        raiz.insert(30);
        raiz.insert(60);
        raiz.insert(70);
        assertEquals(raiz.successor(30),raiz);
        assertEquals(raiz.successor(20),raiz.getLeftChild().getRightChild());
        assertEquals(raiz.successor(70), null);
    }



}
