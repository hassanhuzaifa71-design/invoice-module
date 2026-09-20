package invoice;

 public class customer extends invoice {

    private int customer_id;
    private String customer_name;
    private String phone;
    private String address;

    //constructer
    public customer(int invoice_id, int customer_id,
                    String customer_name, String phone, String address) {
        super(invoice_id);
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.phone = phone;
        this.address = address;
    }

    // Method Overriding
    @Override
    public void display() {
        System.out.println("Customer ID : " + customer_id);
        System.out.println("Customer Name : " + customer_name);
        System.out.println("Phone : " + phone);
        System.out.println("Address : " + address);
    }
    public String getCustomer_name(){
        return customer_name;
    }
}