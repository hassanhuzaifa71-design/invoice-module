package invoice;

public class product extends invoice {

    private int product_id;
    private String product_name;
    private int stock;
    private double wholesale_price;

    //constructor
    public product(int invoice_id, int product_id, String product_name, int stock, double wholesale_price) {
        super(invoice_id);
        this.product_id = product_id;
        this.product_name = product_name;
        this.stock = stock;
        this.wholesale_price = wholesale_price;
    }

    //function
    public String getName() {
        return product_name;
    }

    public double getPrice() {
        return wholesale_price;
    }

    // Method Overriding
    @Override
    public void display() {
        System.out.println("Product ID : " + product_id);
        System.out.println("Product Name : " + product_name);
        System.out.println("Stock : " + stock);
        System.out.println("Wholesale Price : " + wholesale_price);
    }
}