import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddReaderController implements ActionListener {

    AddReaderView addReaderView;
    RemoteDataAccess myDB;

    public AddReaderController(AddReaderView view, RemoteDataAccess dao) {
        addReaderView = view;
        myDB = dao;
        addReaderView.btnLoad.addActionListener(this);
        addReaderView.btnSave.addActionListener(this);
        addReaderView.btnExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addReaderView.btnLoad) {
            findReader();
        }

        if (e.getSource() == addReaderView.btnSave) {
            saveReader();
        }

        if (e.getSource() == addReaderView.btnExit) {
            LibraryManager.readerView.show();
            LibraryManager.addReaderView.dispose();
        }
    }

    private void saveReader() {
        ReaderModel reader = new ReaderModel();

        try {
            int readerID = Integer.parseInt(addReaderView.txtReaderID.getText());
            reader.readerID = readerID;
            reader.readerName = addReaderView.txtName.getText();
            reader.address = addReaderView.txtAddr.getText();
            reader.phone = addReaderView.txtPhone.getText();

            myDB.saveReader(reader);
            JOptionPane.showMessageDialog(null, "Reader saved successfully!");


        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for ReaderID");
            ex.printStackTrace();
        }
    }



    private void findReader() {
        try {
            int readerID = Integer.parseInt(addReaderView.txtReaderID.getText());
            ReaderModel reader = myDB.findReader(readerID);
            if (reader != null) {
                addReaderView.txtName.setText(reader.readerName);
                addReaderView.txtAddr.setText(reader.address);
                addReaderView.txtPhone.setText(reader.phone);
            }
            else {
                addReaderView.txtName.setText("");
                addReaderView.txtAddr.setText("");
                addReaderView.txtPhone.setText("");
                JOptionPane.showMessageDialog(null, "Invalid format for ReaderID");
            }
        }
        catch (NumberFormatException ex) {

            ex.printStackTrace();
        }
    }
}
