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
        inputCoins.addCoinToAmount(fiftypence);
        assertEquals(50, vendingMachine.getValueOfInputCoins());
    }

    @Test
    public void checkSufficientFundsFalse() {
        inputCoins.addCoinToAmount(fiftypence);
        assertEquals(false, vendingMachine.checkSufficientFunds(drawer));
    }

    @Test
    public void checkSufficientFundsTrue() {
        inputCoins.addCoinToAmount(fiftypence);
        inputCoins.addCoinToAmount(fiftypence);
        assertEquals(true, vendingMachine.checkSufficientFunds(drawer));
    }

    @Test
    public void canVendFromDrawer() {
        inputCoins.addCoinToAmount(fiftypence);
        inputCoins.addCoinToAmount(fiftypence);
        vendingMachine.vendFromDrawer(drawer);
        assertEquals(0, drawer.getNumberOfProducts());
        assertEquals(0, vendingMachine.getValueOfInputCoins());
        assertEquals(100, vendingMachine.getValueOfBankCoins());
    }
}