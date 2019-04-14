public class StoreManager{

    static SQLiteDataAccess dao = new SQLiteDataAccess();

    static MainView mainView = new MainView();;
    static MainController mainController = new MainController(mainView);

    static ProductView productView = new ProductView();
    static ProductController productController = new ProductController(productView, dao);

    static CheckoutView checkoutView = new CheckoutView();
    static OrderController orderController = new OrderController(checkoutView, dao);

    static OrderSearchView searchView = new OrderSearchView();
    static OrderSearchController searchController = new OrderSearchController(searchView, dao);

    public static void main(String[] args) {

        dao.connect();
        mainView.setVisible(true);
        //searchView.setVisible(true);
        //mainView.show();
        //productView.show();
        //checkoutView.show();
    }


}
