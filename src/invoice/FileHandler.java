package invoice;

import java.io.*;

public class FileHandler {

    // SAVE INVOICE
    public static void saveInvoice(megainvoice mega) {

        try {

            ObjectOutputStream w1 =
                    new ObjectOutputStream(
                            new FileOutputStream("invoice.txt")
                    );

            w1.writeObject(mega);

            w1.close();

            System.out.println("Invoice Saved");

        }

        catch (Exception e) {

            System.out.println(e);

        }

    }

    // READ INVOICE
    public static megainvoice readInvoice() {

        try {

            ObjectInputStream r1 =
                    new ObjectInputStream(
                            new FileInputStream("invoice.txt")
                    );

            megainvoice mega =
                    (megainvoice) r1.readObject();

            r1.close();

            return mega;

        }

        catch (Exception e) {

            System.out.println(e);

        }

        return null;

    }

}
