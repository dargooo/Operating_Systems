import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

    MainView mView;

    public MainController(MainView mainView) {
        mView = mainView;
        mView.btnCheckout.addActionListener(this);
        mView.btnAdd.addActionListener(this);
        mView.btnUpdate.addActionListener(this);
        mView.btnOrder.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mView.btnCheckout) {
            StoreManager.checkoutView.show();
            StoreManager.mainView.dispose();
        }
        if (e.getSource() == mView.btnAdd || e.getSource() == mView.btnUpdate) {
            StoreManager.productView.show();
            StoreManager.mainView.dispose();
        }
        if (e.getSource() == mView.btnOrder) {
            StoreManager.searchView.show();
            StoreManager.mainView.dispose();
        }
    }
}
