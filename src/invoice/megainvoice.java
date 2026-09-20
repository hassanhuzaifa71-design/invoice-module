package invoice;

import java.util.ArrayList;
 public class megainvoice {

    private int invoice_num;
    private String date;
    private customer customer;
    private ArrayList<invoiceitem> items;

    //constructor
    public megainvoice(int invoice_num, String date, customer customer) {
        this.invoice_num = invoice_num;
        this.date = date;
        this.customer = customer;
        items = new ArrayList<>();
    }

    public void addItem(invoiceitem item) {
        items.add(item);
    }

    public double calculateGrandTotal() {

        double grandTotal = 0;

        for (invoiceitem item : items) {
            grandTotal += item.calculateTotal();
        }

        return grandTotal;
    }

    public void printInvoice() {

        System.out.println("\n========== FINAL INVOICE ==========");

        System.out.println("Invoice Number : " + invoice_num);
        System.out.println("Date : " + date);

        System.out.println("\nCustomer Details:");
        customer.display();

        System.out.println("\nItems Details:");

        for (invoiceitem item : items) {
            item.display();
            System.out.println("---------------------");
        }

        System.out.println("Grand Total : " + calculateGrandTotal());
    }
}