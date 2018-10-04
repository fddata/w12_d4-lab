package vendingMachine;

import products.Product;

import java.util.ArrayList;

public class Drawer {

    private DrawerCode drawerCode;
    private ArrayList<Product> products;
    private int capacity;



    public Drawer(DrawerCode drawerCode) {
        this.drawerCode = drawerCode;
        this.products = new ArrayList<>();
        this.capacity = 5;
    }


    public int getNumberOfProducts(){
        return this.products.size();
    }

    public void addProductToDrawer(Product product){
        if (this.getNumberOfProducts() < this.capacity){
        this.products.add(product);
    }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPriceOfProduct(){
        return this.products.get(0).getPrice();
    }
}
