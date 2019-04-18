import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BorrowController implements ActionListener {

    BorrowView borrowView;
    RemoteDataAccess myDB;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    public BorrowController(BorrowView view, RemoteDataAccess dao) {
        borrowView = view;
        myDB = dao;
        borrowView.btnBorrow.addActionListener(this);
        borrowView.btnExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == borrowView.btnBorrow) {
            borrow();
        }

        if (e.getSource() == borrowView.btnExit) {
            LibraryManager.readerView.show();
            LibraryManager.borrowView.dispose();
            //System.exit(0);
        }
    }

    public void borrow() {
        int bookID = Integer.valueOf(borrowView.txtBookID.getText());
        BookModel book = myDB.loadBook(bookID);
        if (book == null) {
            JOptionPane.showMessageDialog(null, "Book id doesn't exist!");
            return;
        }

        int readerID = Integer.valueOf(borrowView.txtReaderID.getText());
        ReaderModel reader = myDB.findReader(readerID);
        if (reader == null) {
            JOptionPane.showMessageDialog(null, "Reader id doesn't exist!");
            return;
        }

            BorrowModel borrow = new BorrowModel();
            Date date = new Date();
            Date date2 = new Date(date.getYear(), date.getMonth() + 1, date.getDate());
            borrow.startDate = this.dateFormat.format(date);
            borrow.bookID = bookID;
            borrow.readerID = readerID;
            borrow.dueDate = this.dateFormat.format(date2);
            myDB.saveBorrow(borrow);
            String bookName = book.title;
            String readerName = reader.readerName;
            JOptionPane.showMessageDialog(null, readerName + " borrows <" + bookName + "> successfully!");

    }
}
