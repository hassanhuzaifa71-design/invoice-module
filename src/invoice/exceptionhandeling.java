package invoice;

public class exceptionhandeling {

    // BASE EXCEPTION
    public static class InvoiceException extends RuntimeException {
        public InvoiceException(String message) {
            super(message);
        }
    }

    // STOCK EXCEPTION
    public static class InvalidStockException extends InvoiceException {
        public InvalidStockException(String message) {
            super(message);
        }
    }

    // PRICE EXCEPTION
    public static class InvalidPriceException extends InvoiceException {
        public InvalidPriceException(String message) {
            super(message);
        }
    }

    // QUANTITY EXCEPTION
    public static class InvalidQuantityException extends InvoiceException {
        public InvalidQuantityException(String message) {
            super(message);
        }
    }
}
