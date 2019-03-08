public class StoreManager{

    static SQLiteDataAccess dao = new SQLiteDataAccess();

    static MainView mainView = new MainView();
    static MainController mainController = new MainController(mainView);

    static ProductView productView = new ProductView();
    static ProductController productController = new ProductController(productView, dao);



    public static void main(String[] args) {

        dao.connect();
        /*
        ProductModel prod = dao.loadProduct(1); // Apple;
        if (prod != null)
            System.out.println("Product with ID = " + prod.productID + " name = " + prod.name + " price = " + prod.price + " quantity = " + prod.quantity);

        prod.productID = 100;
        prod.name = "Samsung TV";
        prod.price = 399.99;
        prod.quantity = 1000;

        dao.saveProduct(prod);

        prod = dao.loadProduct(100); // Samsung!!!
        if (prod != null)
            System.out.println("Product with ID = " + prod.productID + " name = " + prod.name + " price = " + prod.price + " quantity = " + prod.quantity);
*/
        mainView.show();
        //productView.show();
    }


}
