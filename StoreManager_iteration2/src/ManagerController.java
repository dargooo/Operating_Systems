import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerController implements ActionListener {

    ManagerView managerView;

    public ManagerController(ManagerView managerView) {
        this.managerView = managerView;
        managerView.btnExit.addActionListener(this);
        managerView.btnUpdate.addActionListener(this);
        managerView.btnAdd.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == managerView.btnAdd || e.getSource() == managerView.btnUpdate) {
            Application.productView.show();
            Application.managerView.dispose();
        }
        if (e.getSource() == managerView.btnExit) {
            Application.loginView.show();
            Application.managerView.dispose();
        }
    }
}
