import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListaTest {
    @Test
    public void creacionListaTest(){
        Lista objListaSimple= new Lista();
        assertEquals(objListaSimple.getHead(), null);
        assertEquals(objListaSimple.getSize(), 0);
    }

    @Test
    public void addTest(){
        Lista objListaSimple= new Lista();
        objListaSimple.add(10);
        objListaSimple.add(56);
        objListaSimple.add(5);
        objListaSimple.add(16);

        assertEquals(objListaSimple.getHead().getValue(), 10);
        assertEquals(objListaSimple.getHead().getNext().getValue(), 56);
        assertEquals(objListaSimple.getHead().getNext().getNext().getValue(), 5);
        assertEquals(objListaSimple.getHead().getNext().getNext().getNext().getValue(), 16);
        assertEquals(objListaSimple.getSize(), 4);
    }

    @Test
    public void insertByReferenceTest(){
        Lista objListaSimple= new Lista();
        objListaSimple.add(10);
        objListaSimple.add(56);
        objListaSimple.add(5);
        objListaSimple.add(16);
        objListaSimple.insertByReference(5,65);
        assertEquals(objListaSimple.getHead().getNext().getNext().getNext().getValue(), 65);
        assertEquals(objListaSimple.getHead().getNext().getNext().getNext().getNext().getValue(), 16);
        objListaSimple.insertByReference(16,20);
        assertEquals(objListaSimple.getHead().getNext().getNext().getNext().getNext().getValue(), 16);
        assertEquals(objListaSimple.getHead().getNext().getNext().getNext().getNext().getNext().getValue(), 20);
        assertEquals(objListaSimple.getSize(), 6);
    }

    @Test
    public void removeTest(){
        Lista objListaSimple= new Lista();
        objListaSimple.add(10);
        objListaSimple.add(56);
        objListaSimple.add(5);
        objListaSimple.add(16);
        objListaSimple.Remove(16);
        assertEquals(objListaSimple.getHead().getNext().getNext().getNext().getValue(), 0);
        assertEquals(objListaSimple.getSize(),3);
        objListaSimple.Remove(10);
        assertEquals(objListaSimple.getHead().getValue(),56);
        assertEquals(objListaSimple.getHead().getNext().getValue(),5);
        assertEquals(objListaSimple.getSize(),2);
    }

    @Test
    public void searchTest(){
        Lista objListaSimple= new Lista();
        objListaSimple.add(10);
        objListaSimple.add(56);
        objListaSimple.add(5);
        objListaSimple.add(16);
        assertTrue(objListaSimple.search(10));
        assertTrue(objListaSimple.search(56));
        assertTrue(objListaSimple.search(5));
        assertTrue(objListaSimple.search(16));
        assertFalse(objListaSimple.search(2));
    }

    @Test
    public void isEmptyTest(){
        Lista objListaSimple= new Lista();
        assertTrue(objListaSimple.isEmpty());
    }
}
