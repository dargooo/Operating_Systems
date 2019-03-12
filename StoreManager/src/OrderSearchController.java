import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OrderSearchController implements ActionListener {

    OrderSearchView sView;
    SQLiteDataAccess db;

    public OrderSearchController(OrderSearchView view, SQLiteDataAccess dao) {
        sView = view;
        db = dao;
        sView.btnDate.addActionListener(this);
        sView.btnName.addActionListener(this);
        sView.btnCancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sView.btnDate) {
            displayDate();
        }
        if (e.getSource() == sView.btnName) {
            displayName();
        }
        if (e.getSource() == sView.btnCancel) {
            StoreManager.mainView.show();
            StoreManager.searchView.setVisible(false);
            StoreManager.searchView.clear();
        }

    }


    private void displayName() {
        try {
                String name = sView.txtFirst.getText() + " " + sView.txtLast.getText();
                List<OrderModel> list = db.searchName(name);
                if (list.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Your search does not match any order!");
                    return;
                }
                sView.c1.removeAll();
                sView.c2.removeAll();
                sView.c3.removeAll();
                sView.c4.removeAll();
                sView.c5.removeAll();
                sView.c6.removeAll();
                sView.addTxt(sView.c1, "Order ID");
                sView.addTxt(sView.c1, "=======");
                sView.addTxt(sView.c2, "Customer");
                sView.addTxt(sView.c2, "===========");
                sView.addTxt(sView.c3, "Date");
                sView.addTxt(sView.c3, "==========");
                sView.addTxt(sView.c4, "Amount");
                sView.addTxt(sView.c4, "=======");
                sView.addTxt(sView.c5, "Tax");
                sView.addTxt(sView.c5, "=====");
                sView.addTxt(sView.c6, "Total");
                sView.addTxt(sView.c6, "====");

                for (OrderModel order : list) {
                    sView.addTxt(sView.c1, String.valueOf(order.orderID));
                    sView.addTxt(sView.c2, order.customer);
                    sView.addTxt(sView.c3, order.date);
                    sView.addTxt(sView.c4, String.valueOf(order.subTotal));
                    sView.addTxt(sView.c5, String.valueOf(order.tax));
                    sView.addTxt(sView.c6, String.valueOf(order.total));
                }
        }
        catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }


    private void displayDate() {
        try {
                String date = sView.txtYear.getText() + "/" + sView.txtMonth.getText() + "/" + sView.txtDate.getText();
                List<OrderModel> list = db.searchDate(date);
                if (list.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Your search does not match any order!");
                    return;
                }
            sView.c1.removeAll();
            sView.c2.removeAll();
            sView.c3.removeAll();
            sView.c4.removeAll();
            sView.c5.removeAll();
            sView.c6.removeAll();
                sView.addTxt(sView.c1, "Order ID");
                sView.addTxt(sView.c1, "=======");
                sView.addTxt(sView.c2, "Customer");
                sView.addTxt(sView.c2, "===========");
                sView.addTxt(sView.c3, "Date");
                sView.addTxt(sView.c3, "==========");
                sView.addTxt(sView.c4, "Amount");
                sView.addTxt(sView.c4, "=======");
                sView.addTxt(sView.c5, "Tax");
                sView.addTxt(sView.c5, "=====");
                sView.addTxt(sView.c6, "Total");
                sView.addTxt(sView.c6, "====");

                for (OrderModel order : list) {
                    sView.addTxt(sView.c1, String.valueOf(order.orderID));
                    sView.addTxt(sView.c2, order.customer);
                    sView.addTxt(sView.c3, order.date);
                    sView.addTxt(sView.c4, String.valueOf(order.subTotal));
                    sView.addTxt(sView.c5, String.valueOf(order.tax));
                    sView.addTxt(sView.c6, String.valueOf(order.total));
                }
        }
        catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }
}
