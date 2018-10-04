package products;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrispTest {

    Crisp crisp;

    @Before
    public void setUp() throws Exception {
        crisp = new Crisp("Real McCoys", "Salt and Vinegar");
    }

    @Test
    public void canGetFlavour() {
        assertEquals("Salt and Vinegar", crisp.getFlavour());
    }

    @Test
    public void canGetPrice() {
        assertEquals(50, crisp.getPrice());
    }


    @Test
    public void canGetName() {
        assertEquals("Real McCoys", crisp.getName());
    }
}