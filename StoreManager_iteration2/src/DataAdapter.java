import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAdapter {
    Connection conn = null;

    public void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:store.db";
            // create a connection to the database
            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection(url);

            if (conn == null)
                System.out.println("Cannot make the connection!!!");
            else
                System.out.println("The connection object is " + conn);

            System.out.println("Connection to SQLite has been established.");

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM product_table");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
                        + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7));
            }

            ResultSet rs2 = stmt.executeQuery("SELECT * FROM order_table");
            while (rs2.next()) {
                System.out.println(rs2.getString(1) + " " + rs2.getString(2) + " " + rs2.getString(3) + " $" + rs2.getString(4)
                        + " $" + rs2.getString(5) + " $" + rs2.getString(6));
            }

            ResultSet rs4 = stmt.executeQuery("SELECT * FROM return_table");
            while (rs4.next()) {
                System.out.println(rs4.getString(1) + " " + rs4.getString(2) + " " + rs4.getString(3) + " $" + rs4.getString(4)
                        + " $" + rs4.getString(5) + " $" + rs4.getString(6));
            }

            ResultSet rs3 = stmt.executeQuery("SELECT * FROM user_table");
            while (rs3.next()) {
                System.out.println(rs3.getInt(1) + " " + rs3.getString(2) + " " + rs3.getString(3) + " " + rs3.getString(4) + " " + rs3.getString(5));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveProduct(ProductModel product) {
        try {

            if (loadProduct(product.productID) == null) {           // this is a new product!
                String query = "INSERT INTO product_table(product_id, name, barcode, quantity, price, provider, provider_contact)" + " values (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, product.productID);
                ps.setString(2, product.name);
                ps.setInt(3, product.barcode);
                ps.setDouble(4, product.quantity);
                ps.setDouble(5, product.price);
                ps.setString(6, product.provider);
                ps.setString(7, product.contact);
                ps.execute();
            }
            else {
                String query = "UPDATE product_table SET product_id = ?, name = ?, barcode = ?, quantity = ?, price = ?, provider = ?, provider_contact = ?  WHERE product_id = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, product.productID);
                ps.setString(2, product.name);
                ps.setInt(3, product.barcode);
                ps.setDouble(4, product.quantity);
                ps.setDouble(5, product.price);
                ps.setString(6, product.provider);
                ps.setString(7, product.contact);
                ps.setInt(8, product.productID);
                ps.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ProductModel loadProduct(int productID) {
        ProductModel product = null;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM product_table WHERE product_id = " + productID);
            if (rs.next()) {
                product = new ProductModel();
                product.productID = rs.getInt(1);
                product.name = rs.getString(2);
                product.barcode = rs.getInt(3);
                product.quantity = rs.getDouble(4);
                product.price = rs.getDouble(5);
                product.provider = rs.getString(6);
                product.contact = rs.getString(7);
            }
            else {
                return product;
            }

        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return product;
    }

    public ProductModel findProduct(int barcode) {
        ProductModel product = null;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM product_table WHERE barcode = " + barcode);
            if (rs.next()) {
                product = new ProductModel();
                product.productID = rs.getInt(1);
                product.name = rs.getString(2);
                product.barcode = rs.getInt(3);
                product.quantity = rs.getDouble(4);
                product.price = rs.getDouble(5);
                product.provider = rs.getString(6);
                product.contact = rs.getString(7);
            }
            else {
                return product;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return product;
    }

    public int maxOrderID() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT max(order_id) FROM order_table");
            return rs.getInt(1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int maxReturnID() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT max(return_id) FROM return_table");
            return rs.getInt(1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int maxUserID() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT max(user_id) FROM user_table");
            return rs.getInt(1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void saveOrder(OrderModel order) {
        try {

            String query = "INSERT INTO order_table values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, order.orderID);
            ps.setString(2, order.customer);
            ps.setString(3, order.date);
            ps.setDouble(4, order.subTotal);
            ps.setDouble(5, order.tax);
            ps.setDouble(6, order.total);
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void saveReturn(ReturnModel returnModel) {
        try {

            String query = "INSERT INTO return_table values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, returnModel.returnID);
            ps.setString(2, returnModel.customer);
            ps.setString(3, returnModel.date);
            ps.setDouble(4, returnModel.subTotal);
            ps.setDouble(5, returnModel.tax);
            ps.setDouble(6, returnModel.total);
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<OrderModel> searchName(String name) {
        List<OrderModel> list = new ArrayList<OrderModel>();
        try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM order_table WHERE customer = ?");) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                OrderModel order = new OrderModel();
                order.orderID = rs.getInt(1);
                order.customer = rs.getString(2);
                order.date = rs.getString(3);
                order.subTotal = rs.getDouble(4);
                order.tax = rs.getDouble(5);
                order.total = rs.getDouble(6);
                list.add(order);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<OrderModel> searchDate(String date) {
        List<OrderModel> list = new ArrayList<OrderModel>();
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM order_table WHERE date_time = ?");
            pstmt.setString(1, date);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                OrderModel order = new OrderModel();
                order.orderID = rs.getInt(1);
                order.customer = rs.getString(2);
                order.date = rs.getString(3);
                order.subTotal = rs.getDouble(4);
                order.tax = rs.getDouble(5);
                order.total = rs.getDouble(6);
                list.add(order);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void addUser(UserModel user) {
        try {

            String query = "INSERT INTO user_table values (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, user.userId);
            ps.setString(2, user.userName);
            ps.setString(3, user.password);
            ps.setString(4, user.name);
            ps.setString(5, user.role);
            ps.execute();

            if (user.role.equals("customer")) {
                String query2 = "INSERT INTO customer_table values (?, ?, ?, ?, ?)";
                PreparedStatement ps2 = conn.prepareStatement(query2);
                ps2.setInt(1, user.userId);
                ps2.setString(2, user.userName);
                ps2.setString(3, user.name);
                ps2.setString(4, "");
                ps2.setString(5, "");
                ps2.execute();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public UserModel findUser(String userName) {
        UserModel user = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user_table WHERE user_name = ?");
            pstmt.setString(1, userName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new UserModel();
                user.userId = rs.getInt(1);
                user.userName = rs.getString(2);
                user.password = rs.getString(3);
                user.name = rs.getString(4);
                user.role = rs.getString(5);
            }
            else {
                return user;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public void saveUser(UserModel user) throws SQLException {
        String query = "UPDATE user_table SET user_id = ?, user_name = ?, pass_word = ?, role = ?  WHERE user_name = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, user.userId);
        ps.setString(2, user.userName);
        ps.setString(3, user.password);
        ps.setString(4, user.role);
        ps.setString(5, user.userName);
        ps.execute();
    }

    public CustomerModel findCustomer(int userId) {
        CustomerModel customer = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM customer_table WHERE user_id = ?");
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                customer = new CustomerModel();
                customer.userId = rs.getInt(1);
                customer.userName = rs.getString(2);
                customer.name = rs.getString(3);
                customer.addr = rs.getString(4);
                customer.phone = rs.getString(5);
            }
            else {
                return customer;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customer;
    }

    public void saveCustomer(CustomerModel customer) throws SQLException {
        String query = "UPDATE customer_table SET user_id = ?, user_name = ?, name = ?, address = ?, phone = ? WHERE user_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, customer.userId);
        ps.setString(2, customer.userName);
        ps.setString(3, customer.name);
        ps.setString(4, customer.addr);
        ps.setString(5, customer.phone);
        ps.setInt(6, customer.userId);
        ps.execute();

        String query2 = "UPDATE user_table SET user_name = ? where user_id = ?";
        PreparedStatement ps2 = conn.prepareStatement(query2);
        ps2.setString(1,customer.userName);
        ps2.setInt(2, customer.userId);
        ps2.execute();
    }

}
