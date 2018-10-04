package products;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColaTest {

    Cola cola;

    @Before
    public void setUp() throws Exception {
        cola = new Cola("Coca Cola", "Diet");
    }

    @Test
    public void getType() {
        assertEquals("Diet", cola.getType());
    }

    @Test
    public void getPrice() {
        assertEquals(100, cola.getPrice());
    }

    @Test
    public void canGetName() {
        assertEquals("Coca Cola", cola.getName());
    }
}