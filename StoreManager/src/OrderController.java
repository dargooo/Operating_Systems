import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderController implements ActionListener {

    CheckoutView cView;
    SQLiteDataAccess db;
    DecimalFormat df = new DecimalFormat(".##");
    Double subTotal = 0.0, taxTotal = 0.0, costToal = 0.0;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    public OrderController(CheckoutView view, SQLiteDataAccess sql) {
        cView = view;
        cView.btnCheckout.addActionListener(this);
        cView.btnCancel.addActionListener(this);
        cView.btnSave.addActionListener(this);
        db = sql;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cView.btnCancel) {
            StoreManager.mainView.show();
            StoreManager.checkoutView.setVisible(false);
            StoreManager.checkoutView.clear();
        }
        if (e.getSource() == cView.btnSave) {
            loadOrderline();
        }
        if (e.getSource() == cView.btnCheckout) {
            createOrder();
        }
    }

    private void createOrder() {
        OrderModel order = new OrderModel();
        order.orderID = db.maxOrderID() + 1;
        order.customer = cView.txtCustomer.getText();
        order.subTotal = Double.parseDouble(df.format(subTotal));
        order.tax = Double.parseDouble(df.format(taxTotal));
        order.total = Double.parseDouble(df.format(costToal));
        Date date = new Date();
        order.date = dateFormat.format(date);
        db.saveOrder(order);
        JOptionPane.showMessageDialog(null, "" + order.customer + "'s order checked out successfully!\n"
                 + "Total Amount: $" + order.total);
    }

    private void loadOrderline() {
        try {
            int barcode = Integer.parseInt(cView.txtBarcode.getText());
            ProductModel p = db.findProduct(barcode);
            if (p == null) {
                JOptionPane.showMessageDialog(null, "Where did you get that barcode?");
                return;
            }
            else {
                double q = Double.parseDouble(cView.txtQuantity.getText());
                if (q > p.quantity) {
                    JOptionPane.showMessageDialog(null, "We don't have that much " + p.name + "!");
                    return;
                }
                cView.addTxt(cView.c1, String.valueOf(p.productID));
                cView.addTxt(cView.c2, p.name);
                cView.addTxt(cView.c3, String.valueOf(q));
                double price = p.price * q, tax = price * 0.09, total = tax + price;
                subTotal += price;
                taxTotal += tax;
                costToal += total;
                cView.addTxt(cView.c4, String.valueOf(df.format(price)));
                cView.addTxt(cView.c5, String.valueOf(df.format(tax)));
                cView.addTxt(cView.c6, String.valueOf(df.format(total)));

                //update product
                p.quantity -= q;
                db.saveProduct(p);
            }
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for ProductID");
            ex.printStackTrace();
        }
    }
}
