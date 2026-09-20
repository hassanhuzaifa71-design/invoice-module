package invoice;

 public class invoiceitem extends invoice {

    private product product;
    private int quantity;
    private double selling_price;

    //constructor
    public invoiceitem(int invoice_id, product product , int quantity, double selling_price) {
        super(invoice_id);
        this.product = product;
        this.quantity = quantity;
        this.selling_price = selling_price;
    }

    public double calculateTotal() {
        return quantity * selling_price;
    }

    public product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    // Method Overriding
    @Override
    public void display() {
        System.out.println("Product : " + product.getName());
        System.out.println("Quantity : " + quantity);
        System.out.println("Selling Price : " + selling_price);
        System.out.println("Total : " + calculateTotal());
    }
}
