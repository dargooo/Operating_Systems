import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class RecordController implements ActionListener {

    RecordView myView;
    RemoteDataAccess myDB;

    public RecordController(RecordView view, RemoteDataAccess dao) {
        myView = view;
        myDB = dao;
        myView.btnBook.addActionListener(this);
        myView.btnReader.addActionListener(this);
        myView.btnExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myView.btnBook) {
            searchByBook();
        }

        if (e.getSource() == myView.btnReader) {
            searchByReader();
        }

        if (e.getSource() == myView.btnExit) {
            LibraryManager.readerView.show();
            LibraryManager.recordView.dispose();
        }
    }


    private void searchByBook() {
        try {
            int bookID = Integer.parseInt(myView.txtBookID.getText());
            BookModel book = myDB.loadBook(bookID);
            List<BorrowModel> list = myDB.loadBorrowByBook(bookID);

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                BorrowModel borrow = list.get(i);
                ReaderModel reader = myDB.findReader(borrow.readerID);
                sb.append(reader.readerName);
                sb.append(" borrowed <");
                sb.append(book.title);
                sb.append("> on ");
                sb.append(borrow.startDate);
                sb.append(". Due: ");
                sb.append(borrow.dueDate);
                sb.append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
        catch (NumberFormatException ex) {

            ex.printStackTrace();
        }
    }


    private void searchByReader() {
        try {
            int readerID = Integer.parseInt(myView.txtReaderID.getText());
            ReaderModel reader = myDB.findReader(readerID);
            List<BorrowModel> list = myDB.loadBorrowByReader(readerID);

            StringBuffer sb = new StringBuffer("");
            for (BorrowModel borrow : list) {
                BookModel book = myDB.loadBook(borrow.bookID);
                sb.append(reader.readerName);
                sb.append(" borrowed <");
                sb.append(book.title);
                sb.append("> on ");
                sb.append(borrow.startDate);
                sb.append(". Due: ");
                sb.append(borrow.dueDate);
                sb.append("\n");
            }

            JOptionPane.showMessageDialog(null, sb.toString());
        }
        catch (NumberFormatException ex) {

            ex.printStackTrace();
        }
    }


}
