public class StoreRequest {
    public static final int GOOD_BYE = 0;

    public static final int LOAD_PRODUCT = 1;
    public static final int SAVE_PRODUCT = 2;

    public static final int FIND_READER = 3;
    public static final int SAVE_READER = 4;

    public static final int SAVE_BORROW = 5;
    public static final int LOAD_RECORD1 = 6;
    public static final int LOAD_RECORD2 = 7;


    int code;
    String data;

    public StoreRequest(int request, String data) {
        this.code = request;
        this.data = data;
    }
}
