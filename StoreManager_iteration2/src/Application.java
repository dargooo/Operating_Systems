public class Application {

    static DataAdapter db = new DataAdapter();

    static LoginView loginView = new LoginView();
    static LoginController loginController = new LoginController(loginView, db);

    static ManagerView managerView = new ManagerView();
    static ManagerController managerController = new ManagerController(managerView);
    static ProductView productView = new ProductView();
    static ProductController productController = new ProductController(productView, db);

    static CashierView cashierView = new CashierView();
    static CashierController cashierController = new CashierController(cashierView);
    static CheckoutView checkoutView = new CheckoutView();
    static CheckoutController checkoutController = new CheckoutController(checkoutView, db);
    static ReturnView returnView = new ReturnView();
    static ReturnController returnController = new ReturnController(returnView, db);


    static AdminView adminView = new AdminView();
    static AdminController adminController = new AdminController(adminView);
    static AddUserView addUserView = new AddUserView();
    static AddUserController addUserController = new AddUserController(addUserView, db);
    static ChangeUserView changeUserView = new ChangeUserView();
    static ChangeUserController changeUserController = new ChangeUserController(changeUserView, db);

    static CustomerView customerView = new CustomerView();
    static CustomerController customerController;
    static CustomerInfoView customerInfoView;
    static CustomerInfoController customerInfoController;

    public static void main(String[] args) {
        db.connect();
        loginView.setVisible(true);
        //addUserView.setVisible(true);
        //managerView.setVisible(true);
        //customerView.setVisible(true);
    }
}
