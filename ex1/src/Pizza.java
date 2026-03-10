public class Pizza {
    private String flavor;
    private String size;
    private float price;

    public Pizza (String flavor, String size, float price ){
        this.flavor = flavor;
        this.size = size;
        this.price = price;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return size;
    }

    public float getPrice() {
        return price;
    }
}
