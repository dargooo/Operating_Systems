import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccess {
    Connection conn = null;

    public void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:library.db";
            // create a connection to the database
            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection(url);

            if (conn == null)
                System.out.println("Cannot make the connection!!!");
            else
                System.out.println("The connection object is " + conn);

            System.out.println("Connection to SQLite has been established.");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Book");

            while (rs.next())
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)+ " " + rs.getString(5));


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean saveBook(BookModel book) {
        try {
            PreparedStatement stmt;

            if (loadBook(book.bookID) == null) {           // this is a new product!
                stmt = conn.prepareStatement("INSERT INTO Book VALUES (?, ?, ?, ?, ?)");
                stmt.setInt(1,book.bookID);
                stmt.setString(2, book.title);
                stmt.setString(3, book.author);
                stmt.setInt(4, book.pages);
                stmt.setInt(5, book.publicationYear);
            }
            else {
                stmt = conn.prepareStatement("UPDATE book SET book_id = ?, title = ?, author = ?, pages = ?, publicationYear = ?");
                stmt.setInt(1,book.bookID);
                stmt.setString(2, book.title);
                stmt.setString(3, book.author);
                stmt.setInt(4, book.pages);
                stmt.setInt(5, book.publicationYear);
            }
            stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public BookModel loadBook(int bookID) {
        BookModel book = null;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Book WHERE book_id = " + bookID);
            if (rs.next()) {
                book = new BookModel();
                book.bookID = rs.getInt(1);
                book.title = rs.getString(2);
                book.author = rs.getString(3);
                book.pages = rs.getInt(4);
                book.publicationYear = rs.getInt(5);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return book;
    }


    public ReaderModel findReader(int readerID) {
        ReaderModel reader = null;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM reader WHERE reader_id = " + readerID);
            if (rs.next()) {
                reader = new ReaderModel();
                reader.readerID = rs.getInt(1);
                reader.readerName = rs.getString(2);
                reader.address = rs.getString(3);
                reader.phone = rs.getString(4);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return reader;
    }


    public boolean saveReader(ReaderModel reader) {
        try {
            PreparedStatement stmt;

            if (findReader(reader.readerID) == null) {           // this is a new product!
                stmt = conn.prepareStatement("INSERT INTO reader VALUES ( ?, ?, ?, ?)");
                stmt.setInt(1,reader.readerID);
                stmt.setString(2, reader.readerName);
                stmt.setString(3, reader.address);
                stmt.setString(4, reader.phone);
            }
            else {
                stmt = conn.prepareStatement("UPDATE reader SET reader_id = ?, name = ?, address = ?, phonw = ?");
                stmt.setInt(1,reader.readerID);
                stmt.setString(2, reader.readerName);
                stmt.setString(3, reader.address);
                stmt.setString(4, reader.phone);
            }
            stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }



    public boolean saveBorrow(BorrowModel borrow) {
        try {
            PreparedStatement stmt;

                stmt = conn.prepareStatement("INSERT INTO borrow VALUES ( ?, ?, ?, ?)");
                stmt.setInt(1,borrow.bookID);
                stmt.setInt(2, borrow.readerID);
                stmt.setString(3, borrow.startDate);
                stmt.setString(4, borrow.dueDate);

            stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }



    public List<BorrowModel> loadBorrowByBook(int bookID) {
        List<BorrowModel> borrows = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BORROW WHERE book_id = " + bookID);
            if (rs.next()) {
                BorrowModel borrow = new BorrowModel();
                borrow.bookID = rs.getInt(1);
                borrow.readerID = rs.getInt(2);
                borrow.startDate = rs.getString(3);
                borrow.dueDate = rs.getString(4);
                borrows.add(borrow);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return borrows;
    }

    public List<BorrowModel> loadBorrowByReader(int readerID) {
        List<BorrowModel> borrows = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BORROW WHERE reader_id = " + readerID);
            if (rs.next()) {
                BorrowModel borrow = new BorrowModel();
                borrow.bookID = rs.getInt(1);
                borrow.readerID = rs.getInt(2);
                borrow.startDate = rs.getString(3);
                borrow.dueDate = rs.getString(4);
                borrows.add(borrow);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return borrows;
    }
}
