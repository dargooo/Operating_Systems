public class StoreResponse {
    public static final int OK = 0;

    public static final int PRODUCT_NOT_FOUND = 1;
    public static final int SAVE_PRODUCT_ERROR = 2;

    public static final int READER_NOT_FOUND = 3;
    public static final int SAVE_READER_ERROR = 4;

    public static final int SAVE_BORROW_ERROR = 5;
    public static final int LOAD_BORROW_ERROR1 = 6;
    public static final int LOAD_BORROW_ERROR2 = 7;

    public int code = 0;
    public String data = "";


}
