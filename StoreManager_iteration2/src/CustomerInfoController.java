import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerInfoController implements ActionListener {

    RemoteDataAccess db;
    CustomerModel customer;
    CustomerInfoView customerInfoView;

    public CustomerInfoController(CustomerInfoView view, CustomerModel customerModel, RemoteDataAccess da) {
        customer = customerModel;
        customerInfoView = view;
        db = da;
        customerInfoView.btnUpdate.addActionListener(this);
        customerInfoView.btnReturn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == customerInfoView.btnUpdate) {
            saveInfo();
        }
        if (e.getSource() == customerInfoView.btnReturn) {
            Application.customerView.show();
            Application.customerInfoView.dispose();

        }
    }

    public void saveInfo() {
        try {
            customer.addr = customerInfoView.txtAddr.getText();
            customer.phone = customerInfoView.txtPhone.getText();
            db.saveCustomer(customer);
            JOptionPane.showMessageDialog(null, "Customer Info saved successfully!");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid format for infos.");
            e.printStackTrace();
        }
    }
}
