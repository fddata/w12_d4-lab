package coins;

public enum CoinValue {

    ONEPENCE(1),
    TWOPENCE(2),
    FIVEPENCE(5),
    TWENTYPENCE(20),
    FIFTYPENCE(50),
    ONEPOUND(100),
    TWOPOUND(200);

    private final int value;

    CoinValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
