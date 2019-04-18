import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookController implements ActionListener {
    BookView myView;
    RemoteDataAccess myDB;

    public BookController(BookView view, RemoteDataAccess dao) {
        myView = view;
        myDB = dao;
        myView.btnLoad.addActionListener(this);
        myView.btnSave.addActionListener(this);
        myView.btnExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myView.btnLoad) {
            loadProductAndDisplay();
        }

        if (e.getSource() == myView.btnSave) {
            saveProduct();
        }

        if (e.getSource() == myView.btnExit) {
            LibraryManager.readerView.show();
            LibraryManager.bookView.dispose();
            //System.exit(0);
        }
    }

    private void saveProduct() {
        BookModel bookModel = new BookModel();

        try {
            int bookID = Integer.parseInt(myView.txtBookID.getText());
            bookModel.bookID = bookID;
            bookModel.title = myView.txtTitle.getText();
            bookModel.author = myView.txtAuthor.getText();
            bookModel.pages = Integer.parseInt(myView.txtPages.getText());
            bookModel.publicationYear = Integer.parseInt(myView.txtPublicationYear.getText());

            myDB.saveBook(bookModel);
            JOptionPane.showMessageDialog(null, "Book saved successfully!");


        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for BookID");
            ex.printStackTrace();
        }    }



    private void loadProductAndDisplay() {
        try {
            int bookID = Integer.parseInt(myView.txtBookID.getText());
            BookModel bookModel = myDB.loadBook(bookID);
            if (bookModel != null) {
                myView.txtTitle.setText(bookModel.title);
                myView.txtAuthor.setText(bookModel.author);
                myView.txtPages.setText(String.valueOf(bookModel.pages));
                myView.txtPublicationYear.setText(String.valueOf(bookModel.publicationYear));
            }
            else {
                myView.txtTitle.setText("");
                myView.txtAuthor.setText("");
                myView.txtPages.setText("");
                myView.txtPublicationYear.setText("");
                JOptionPane.showMessageDialog(null, "Invalid format for BookID");
            }
        }
        catch (NumberFormatException ex) {

            ex.printStackTrace();
        }
    }
}
