package products;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SweetTest {

    Sweet sweet;

    @Before
    public void setUp() throws Exception {
        sweet = new Sweet("MarsBar");
    }

    @Test
    public void canGetPrice() {
        assertEquals(65, sweet.getPrice(), 0);
    }

    @Test
    public void canGetName() {
        assertEquals("MarsBar", sweet.getName());
    }
}