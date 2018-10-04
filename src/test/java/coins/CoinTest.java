package coins;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoinTest {

    Coin fiftypence;

    @Before
    public void setUp()  {
        fiftypence = new Coin(CoinValue.FIFTYPENCE);
    }

    @Test
    public void canGetCoinValue() {
        assertEquals(50, fiftypence.getValue());
    }
}