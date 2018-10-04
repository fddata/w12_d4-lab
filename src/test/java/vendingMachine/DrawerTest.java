package vendingMachine;

import org.junit.Before;
import org.junit.Test;
import products.Cola;

import static org.junit.Assert.*;

public class DrawerTest {

    Drawer drawer;
    Cola cola;

    @Before
    public void setUp() throws Exception {
        drawer = new Drawer(DrawerCode.A1);
        cola = new Cola("IrnBru", "Regular");
    }

    @Test
    public void drawerStartsEmpty() {
        assertEquals(0, drawer.getNumberOfProducts());
    }

    @Test
    public void addProductToDrawer() {
        drawer.addProductToDrawer(cola);
        assertEquals(1, drawer.getNumberOfProducts());
    }

    @Test
    public void canGetCapacity() {
        assertEquals(5, drawer.getCapacity());
    }


    @Test
    public void cannotFillPastCapacity() {
        drawer.addProductToDrawer(cola);
        drawer.addProductToDrawer(cola);
        drawer.addProductToDrawer(cola);
        drawer.addProductToDrawer(cola);
        drawer.addProductToDrawer(cola);
        drawer.addProductToDrawer(cola);
        assertEquals(5, drawer.getNumberOfProducts());
    }

    @Test
    public void canGetPriceOfProduct() {
        drawer.addProductToDrawer(cola);
        assertEquals(100, drawer.getPriceOfProduct());
    }
}