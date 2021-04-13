public class Sales {
    private String sellerIdentification;
    private double value;

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setSellerIdentification(String sellerIdentification) {
        this.sellerIdentification = sellerIdentification;
    }

    public String getSellerIdentification() {
        return sellerIdentification;
    }
}
