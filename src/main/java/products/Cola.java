package products;

public class Cola extends Product {

    private String type;

    public Cola(String name, String type) {
        super(name, 100);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
