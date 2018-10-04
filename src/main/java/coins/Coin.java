package coins;

public class Coin {

    private CoinValue coinValue;

    public Coin(CoinValue coinValue) {
        this.coinValue = coinValue;
    }

    public int getValue() {
        return coinValue.getValue();
    }
}
