public class ServerResponse {
    public static final int OK = 0;

    public static final int USER_NOT_FOUND = 1;
    public static final int SAVE_USER_ERROR = 2;

    public static final int PRODUCT_NOT_FOUND = 3;
    public static final int SAVE_PRODUCT_ERROR = 4;

    public static final int ORDER_NOT_FOUND = 5;
    public static final int SAVE_ORDER_ERROR = 6;

    public static final int SAVE_RETURN_ERROR = 7;
    public static final int RETURN_NOT_FOUND = 5;

    public static final int CUSTOMER_NOT_FOUND = 9;
    public static final int SAVE_CUSTOMER_ERROR = 10;

    public int code = 0;
    public String data = "";


}
