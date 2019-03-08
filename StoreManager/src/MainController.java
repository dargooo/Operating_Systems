import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

    MainView mView;

    public MainController(MainView mainView) {
        mView = mainView;
        mView.btnUpdate.addActionListener(this);
        mView.btnAdd.addActionListener(this);
        mView.btnUpdate.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mView.btnCheckout) {

        }
        if (e.getSource() == mView.btnAdd || e.getSource() == mView.btnUpdate) {
            StoreManager.productView.show();
        }
    }
}
