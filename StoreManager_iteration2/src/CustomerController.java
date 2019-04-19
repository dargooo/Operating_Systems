import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerController implements ActionListener {

    CustomerView customerView;
    CustomerModel customer;

    public CustomerController(CustomerView view, CustomerModel customer) {
        customerView = view;
        this.customer = customer;
        customerView.btnExit.addActionListener(this);
        customerView.btnInfo.addActionListener(this);
        customerView.btnStatus.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customerView.btnInfo) {
            if (customer == null)   return;
            Application.customerInfoView = new CustomerInfoView();
            Application.customerInfoController = new CustomerInfoController(Application.customerInfoView, customer, Application.db);
            Application.customerInfoView.build(customer);
            Application.customerInfoView.show();
            Application.customerView.dispose();
        }
        if (e.getSource() == customerView.btnStatus) {
            if (customer == null)   return;
            Application.historyView = new HistoryView(customer, Application.db);
            Application.historyController = new HistoryController(Application.historyView);
            Application.historyView.show();
            Application.customerView.dispose();
        }
        if (e.getSource() == customerView.btnExit) {
            Application.customerInfoView = null;
            Application.customerInfoController = null;
            customer = null;
            Application.loginView.show();
            Application.customerView.dispose();
        }
    }
}
