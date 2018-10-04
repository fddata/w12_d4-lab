package vendingMachine;

import coinHolders.CoinHolder;
import coins.Coin;
import drawers.Drawer;
import drawers.DrawerCode;
import products.Product;

import java.util.ArrayList;

public class VendingMachine {

    private CoinHolder inputCoins;
    private CoinHolder bankCoins;
    private ArrayList<Drawer> drawers;

    public VendingMachine(CoinHolder inputCoins, CoinHolder bankCoins) {
        this.inputCoins = inputCoins;
        this.bankCoins = bankCoins;
        this.drawers = new ArrayList<>();
    }

    public void addDrawer(Drawer drawer){
        this.drawers.add(drawer);
    }

    public int countDrawers(){
        return this.drawers.size();
    }


    public int getPriceFromDrawer(Drawer drawer){
        int selectedDrawerIndex = this.drawers.indexOf(drawer);
        return this.drawers.get(selectedDrawerIndex).getPriceOfProduct();
    }

    public int getValueOfInputCoins(){
       return this.inputCoins.getTotalValue();
    }

    public boolean checkSufficientFunds(Drawer drawer){
       return this.getValueOfInputCoins() >= this.getPriceFromDrawer(drawer);
    }



    public String vendFromDrawer(Drawer drawer){
       if (this.checkSufficientFunds(drawer)){
           int selectedDrawerIndex = this.drawers.indexOf(drawer);
           this.drawers.get(selectedDrawerIndex).dispenseProduct();
           this.inputCoins.transferCoins(this.bankCoins);
           return "Please take the product. ENJOYYYYY!";
       }
       else{
           int difference = (this.getPriceFromDrawer(drawer) - this.getValueOfInputCoins());
           return "Please insert " + difference + " pence.";
       }

    }

    public int getValueOfBankCoins() {
        return this.bankCoins.getTotalValue();
    }
}
