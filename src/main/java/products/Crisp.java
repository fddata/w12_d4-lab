package products;

public class Crisp extends Product{

    private String flavour;

    public Crisp(String name, String flavour) {
        super(name, 50);
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }
}
