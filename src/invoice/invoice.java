package invoice;

abstract class invoice {
    protected int invoice_id;

    public invoice(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    // Abstract method (Polymorphism)
    public abstract void display();

}