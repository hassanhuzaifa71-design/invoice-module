package invoice;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class InvoiceGUI extends JFrame {

    // ===== CUSTOMER FIELDS =====
    JTextField nameField;
    JTextField phoneField;
    JTextField addressField;

    // ===== PRODUCT FIELDS =====
    JTextField productNameField;
    JTextField priceField;
    JTextField qtyField;

    // ===== BUTTONS =====
    JButton addCustomerBtn;
    JButton addProductBtn;
    JButton generateBtn;
    JButton clearBtn;
    JButton saveBtn;
    JButton readBtn;

    // ===== INVOICE AREA =====
    JTextArea invoiceArea;

    public InvoiceGUI() {

        // ===== FRAME SETTINGS =====
        setTitle("Invoice System");
        setSize(550, 850);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // =====================================================
        // CUSTOMER SECTION
        // =====================================================

        JLabel customerTitle = new JLabel("CUSTOMER DETAILS");
        customerTitle.setBounds(180, 20, 200, 30);
        add(customerTitle);

        // NAME
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 70, 120, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(170, 70, 200, 25);
        add(nameField);

        // PHONE
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 110, 120, 25);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(170, 110, 200, 25);
        add(phoneField);

        // ADDRESS
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 150, 120, 25);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(170, 150, 200, 25);
        add(addressField);

        // =====================================================
        // PRODUCT SECTION
        // =====================================================

        JLabel productTitle = new JLabel("PRODUCT DETAILS");
        productTitle.setBounds(180, 210, 200, 30);
        add(productTitle);

        // PRODUCT NAME
        JLabel productLabel = new JLabel("Product Name:");
        productLabel.setBounds(30, 260, 120, 25);
        add(productLabel);

        productNameField = new JTextField();
        productNameField.setBounds(170, 260, 200, 25);
        add(productNameField);

        // PRICE
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(30, 300, 120, 25);
        add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(170, 300, 200, 25);
        add(priceField);

        // QUANTITY
        JLabel qtyLabel = new JLabel("Quantity:");
        qtyLabel.setBounds(30, 340, 120, 25);
        add(qtyLabel);

        qtyField = new JTextField();
        qtyField.setBounds(170, 340, 200, 25);
        add(qtyField);

        // =====================================================
        // BUTTONS
        // =====================================================

        addCustomerBtn = new JButton("Add Customer");
        addCustomerBtn.setBounds(30, 400, 140, 30);
        add(addCustomerBtn);

        addProductBtn = new JButton("Add Product");
        addProductBtn.setBounds(190, 400, 140, 30);
        add(addProductBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(350, 400, 100, 30);
        add(clearBtn);

        generateBtn = new JButton("Generate Invoice");
        generateBtn.setBounds(140, 450, 220, 35);
        add(generateBtn);

        // SAVE BUTTON
        saveBtn = new JButton("Save File");
        saveBtn.setBounds(140, 500, 220, 35);
        add(saveBtn);

        // READ BUTTON
        readBtn = new JButton("Read File");
        readBtn.setBounds(140, 550, 220, 35);
        add(readBtn);

        // =====================================================
        // INVOICE AREA
        // =====================================================

        invoiceArea = new JTextArea();
        invoiceArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(invoiceArea);
        scrollPane.setBounds(30, 620, 470, 150);

        add(scrollPane);

        // =====================================================
        // BUTTON EVENTS
        // =====================================================

        addCustomerBtn.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Customer Added Successfully"
            );

        });

        addProductBtn.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Product Added Successfully"
            );

        });

        // =====================================================
        // GENERATE INVOICE
        // =====================================================

        generateBtn.addActionListener(e -> {

            try {

                String customerName = nameField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();

                String productName = productNameField.getText();

                double price =
                        Double.parseDouble(priceField.getText());

                int quantity =
                        Integer.parseInt(qtyField.getText());

                double total = price * quantity;

                String invoiceText = "";

                invoiceText += "====================================\n";
                invoiceText += "           INVOICE SYSTEM           \n";
                invoiceText += "====================================\n\n";

                invoiceText += "CUSTOMER DETAILS\n";
                invoiceText += "------------------------------------\n";

                invoiceText += "Name    : " + customerName + "\n";
                invoiceText += "Phone   : " + phone + "\n";
                invoiceText += "Address : " + address + "\n\n";

                invoiceText += "PRODUCT DETAILS\n";
                invoiceText += "------------------------------------\n";

                invoiceText += "Product  : " + productName + "\n";
                invoiceText += "Price    : " + price + "\n";
                invoiceText += "Quantity : " + quantity + "\n\n";

                invoiceText += "------------------------------------\n";
                invoiceText += "TOTAL BILL : " + total + "\n";
                invoiceText += "====================================\n";

                invoiceArea.setText(invoiceText);

            }

            catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Price and Quantity must be numbers"
                );

            }

            catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Error: " + ex.getMessage()
                );

            }

        });

        // =====================================================
        // SAVE FILE
        // =====================================================

        saveBtn.addActionListener(e -> {

            try {

                ObjectOutputStream w1 =
                        new ObjectOutputStream(
                                new FileOutputStream("invoice.txt")
                        );

                w1.writeObject(invoiceArea.getText());

                w1.close();

                JOptionPane.showMessageDialog(
                        this,
                        "Invoice Saved Successfully"
                );

            }

            catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Error : " + ex.getMessage()
                );

            }

        });

        // =====================================================
        // READ FILE
        // =====================================================

        readBtn.addActionListener(e -> {

            try {

                ObjectInputStream r1 =
                        new ObjectInputStream(
                                new FileInputStream("invoice.txt")
                        );

                String data =
                        (String) r1.readObject();

                r1.close();

                invoiceArea.setText(data);

                JOptionPane.showMessageDialog(
                        this,
                        "Invoice Read Successfully"
                );

            }

            catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Error : " + ex.getMessage()
                );

            }

        });

        // =====================================================
        // CLEAR BUTTON
        // =====================================================

        clearBtn.addActionListener(e -> {

            nameField.setText("");
            phoneField.setText("");
            addressField.setText("");

            productNameField.setText("");
            priceField.setText("");
            qtyField.setText("");

            invoiceArea.setText("");

        });

    }

    // =========================================================
    // RUN METHOD
    // =========================================================

    public void run() {

        setVisible(true);

    }

}