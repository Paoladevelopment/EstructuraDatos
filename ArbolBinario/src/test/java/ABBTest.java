import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ABBTest {

    @Test
    public void recorridoInordenTest(){
        ABB raiz= new ABB(25);
        raiz.setLeftChild(new ABB(14, new ABB(12, null,null,null), new ABB(20, null, null, null), null));
        raiz.setRightChild(new ABB(30,new ABB(27),new ABB(32,new ABB(31),null,null),null));
        assertEquals(raiz.inorder(), "12 14 20 25 27 30 31 32");
    }
}
