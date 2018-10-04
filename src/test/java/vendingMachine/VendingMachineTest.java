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
    Drawer emptyDrawer;
    Cola cola;
    VendingMachine vendingMachine;
    CoinHolder inputCoins;
    CoinHolder bankCoins;
    CoinHolder returnCoins;
    Coin onepence;
    Coin twopence;
    Coin fiftypence;
    Coin twentypence;
    Coin onepound;


    @Before
    public void setUp() throws Exception {
        drawer = new Drawer(DrawerCode.A1);
        cola = new Cola("IrnBru", "Regular");
        drawer.addProductToDrawer(cola);
        emptyDrawer = new Drawer(DrawerCode.A2);
        onepence = new Coin(CoinValue.ONEPENCE);
        twopence = new Coin(CoinValue.TWOPENCE);
        fiftypence = new Coin(CoinValue.FIFTYPENCE);
        twentypence = new Coin(CoinValue.TWENTYPENCE);
        onepound = new Coin(CoinValue.ONEPOUND);
        inputCoins = new CoinHolder();
        returnCoins = new CoinHolder();
        bankCoins = new CoinHolder();
        vendingMachine = new VendingMachine(inputCoins, bankCoins, returnCoins);
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

    @Test
    public void cannotVendFromEmptyDrawerWithSufficentFunds() {
        inputCoins.addCoinToAmount(fiftypence);
        inputCoins.addCoinToAmount(fiftypence);
        vendingMachine.vendFromDrawer(emptyDrawer);
//        assertEquals(0, drawer.getNumberOfProducts());
        assertEquals(100, vendingMachine.getValueOfInputCoins());
        assertEquals(0, vendingMachine.getValueOfBankCoins());
    }


    @Test
    public void checkSufficentFundsMessage() {
        inputCoins.addCoinToAmount(onepound);
        assertEquals("Please take the product. ENJOYYYYY!", vendingMachine.vendFromDrawer(drawer));
    }

    @Test
    public void checkOutOfStockMessage() {
        assertEquals("Product out of stock", vendingMachine.vendFromDrawer(emptyDrawer));
    }

    @Test
    public void checkInsufficentFundsMessage() {
        inputCoins.addCoinToAmount(twentypence);
        assertEquals("Please insert 80 pence.", vendingMachine.vendFromDrawer(drawer));
    }

    @Test
    public void canReturnCoins() {
        inputCoins.addCoinToAmount(onepound);
        inputCoins.addCoinToAmount(fiftypence);
        inputCoins.addCoinToAmount(twentypence);
        vendingMachine.returnChange();
        assertEquals(3, returnCoins.getNumberOfCoins());
        assertEquals(170, returnCoins.getTotalValue());
        assertEquals(0, inputCoins.getNumberOfCoins());
        assertEquals(0, inputCoins.getTotalValue());
    }

    @Test
    public void checkProductIsInStockTrue() {
        assertEquals(true, vendingMachine.checkProductIsInStock(drawer));
    }

    @Test
    public void checkProductIsInStockFalse() {

        assertEquals(false, vendingMachine.checkProductIsInStock(emptyDrawer));
    }
}