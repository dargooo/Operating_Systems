import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashierController implements ActionListener {

        CashierView cashierView;

        public CashierController(CashierView cashierView) {
                this.cashierView = cashierView;
                cashierView.btnExit.addActionListener(this);
                cashierView.btnCheckout.addActionListener(this);
                cashierView.btnReturn.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cashierView.btnCheckout) {
                        Application.checkoutView.show();
                        Application.cashierView.dispose();
                }
                if (e.getSource() == cashierView.btnReturn) {
                        Application.returnView.show();
                        Application.cashierView.dispose();
                }
                if (e.getSource() == cashierView.btnExit) {
                        Application.loginView.show();
                        Application.cashierView.dispose();
                }
        }
}
