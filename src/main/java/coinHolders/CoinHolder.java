package coinHolders;

import coins.Coin;

import java.util.ArrayList;

public class CoinHolder {

    private ArrayList<Coin> coins;

    public CoinHolder() {
        this.coins = new ArrayList<>();
    }

    public void addCoinToAmount(Coin coin){
        if(coin.getValue() >= 5){
        this.coins.add(coin);
        }
    }

    public int getNumberOfCoins() {
        return this.coins.size();
    }

    public int getTotalValue() {
        int total = 0;
        for(Coin coin: this.coins){
            total += coin.getValue();
        }
        return total;
    }


    public void transferCoins(CoinHolder targetHolder){
        for(Coin coin: this.coins){
            targetHolder.addCoinToAmount(coin);
        }
        this.coins.clear();
    }
}
