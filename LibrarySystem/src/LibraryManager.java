import com.sun.org.apache.regexp.internal.RE;

public class LibraryManager {
    static RemoteDataAccess dao = new RemoteDataAccess();


    static BookView bookView = new BookView();
    static BookController bookController = new BookController(bookView, dao);

    static ReaderView readerView = new ReaderView();
    static ReaderController readerController = new ReaderController(readerView);

    static BorrowView borrowView = new BorrowView();
    static BorrowController borrowController = new BorrowController(borrowView, dao);

    static AddReaderView addReaderView = new AddReaderView();
    static AddReaderController addReaderController = new AddReaderController(addReaderView, dao);

    static RecordView recordView = new RecordView();
    static RecordController recordController = new RecordController(recordView, dao);

    public static void main(String[] args) {

        dao.connect();

        readerView.show();
    }
}
