public class StoreRequest {
    public static final int GOOD_BYE = 0;

    public static final int LOAD_USER = 1;
    public static final int SAVE_USER = 2;

    public static final int LOAD_PRODUCT = 3;
    public static final int SAVE_PRODUCT = 4;

    public static final int LOAD_ORDERS = 5;
    public static final int SAVE_ORDER = 6;

    public static final int SAVE_RETURN = 7;
    public static final int LOAD_RETURNS = 8;

    public static final int LOAD_CUSTOMER = 9;
    public static final int SAVE_CUSTOMER = 10;

    public static final int FIND_PRODUCT = 11;


    int code;
    String data;

    public StoreRequest(int request, String data) {
        this.code = request;
        this.data = data;
    }
}
