import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoryController implements ActionListener {

    HistoryView historyView;

    public HistoryController(HistoryView view) {
        historyView = view;
        historyView.btnOK.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == historyView.btnOK) {
            Application.customerView.show();
            Application.historyView.dispose();
        }
    }


}
