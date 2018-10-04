package vendingMachine;

import coinHolders.CoinHolder;
import coins.Coin;
import coins.CoinValue;
import drawers.Drawer;
import drawers.DrawerCode;
import org.junit.Before;
import org.junit.Test;
import products.Cola;

import static org.junit.Assert.*;

public class VendingMachineTest {

    Drawer drawer;
    Cola cola;
    VendingMachine vendingMachine;
    CoinHolder inputCoins;
    CoinHolder bankCoins;
    Coin onepence;
    Coin twopence;
    Coin fiftypence;
    Coin twentypence;


    @Before
    public void setUp() throws Exception {
        drawer = new Drawer(DrawerCode.A1);
        cola = new Cola("IrnBru", "Regular");
        drawer.addProductToDrawer(cola);
        onepence = new Coin(CoinValue.ONEPENCE);
        twopence = new Coin(CoinValue.TWOPENCE);
        fiftypence = new Coin(CoinValue.FIFTYPENCE);
        twentypence = new Coin(CoinValue.TWENTYPENCE);
        inputCoins = new CoinHolder();
        inputCoins.addCoinToAmount(fiftypence);
        bankCoins = new CoinHolder();
        vendingMachine = new VendingMachine(inputCoins, bankCoins);
        vendingMachine.addDrawer(drawer);

    }


    @Test
    public void canAddDrawer() {
        vendingMachine.addDrawer(drawer);
//        includes the one added to the constructor once addDrawer method was proved.
        assertEquals(2, vendingMachine.countDrawers());
    }

    @Test
    public void getPriceFromDrawer() {
        assertEquals(100,vendingMachine.getPriceFromDrawer(drawer));
    }

    @Test
    public void canGetInputCoinValue() {
        assertEquals(50, vendingMachine.getValueOfInputCoins());
    }
}