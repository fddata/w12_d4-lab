package coinHolders;

import coins.Coin;
import coins.CoinValue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoinHolderTest {

    CoinHolder coinHolder;
    CoinHolder targetHolder;
    Coin onepence;
    Coin twopence;
    Coin fiftypence;
    Coin twentypence;

    @Before
    public void setUp() throws Exception {
        coinHolder = new CoinHolder();
        targetHolder = new CoinHolder();
        onepence = new Coin(CoinValue.ONEPENCE);
        twopence = new Coin(CoinValue.TWOPENCE);
        fiftypence = new Coin(CoinValue.FIFTYPENCE);
        twentypence = new Coin(CoinValue.TWENTYPENCE);
    }

    @Test
    public void addCoinToAmount() {
        coinHolder.addCoinToAmount(fiftypence);
        assertEquals(1, coinHolder.getNumberOfCoins());
    }

    @Test
    public void cannotAddInvalidCoins() {
        coinHolder.addCoinToAmount(onepence);
        assertEquals(0, coinHolder.getNumberOfCoins());
        coinHolder.addCoinToAmount(twopence);
        assertEquals(0, coinHolder.getNumberOfCoins());
    }

    @Test
    public void canGetTotalAmountValue() {
        coinHolder.addCoinToAmount(fiftypence);
        coinHolder.addCoinToAmount(twentypence);
        assertEquals(70, coinHolder.getTotalValue());
    }


    @Test
    public void canTransferCoins() {
        coinHolder.addCoinToAmount(fiftypence);
        coinHolder.addCoinToAmount(twentypence);
        coinHolder.transferCoins(targetHolder);
        assertEquals(0, coinHolder.getNumberOfCoins());
        assertEquals(2, targetHolder.getNumberOfCoins());
        assertEquals(70, targetHolder.getTotalValue());
    }
}