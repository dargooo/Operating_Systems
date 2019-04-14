import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteDataAccess {
    Connection conn = null;

    public void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:store1.db";
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
            while (rs.next())
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
                        + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7));

            ResultSet rs2 = stmt.executeQuery("SELECT * FROM order_table");
            while (rs2.next())
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " $" + rs.getString(4)
                        + " $" + rs.getString(5) + " $" + rs.getString(6));

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

    public void saveOrder(OrderModel order) {
        try {

            //if (loadProduct(product.productID) == null) {           // this is a new product!
                String query = "INSERT INTO order_table values (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, order.orderID);
                ps.setString(2, order.customer);
                ps.setString(3, order.date);
                ps.setDouble(4, order.subTotal);
                ps.setDouble(5, order.tax);
                ps.setDouble(6, order.total);
                ps.execute();
            //}

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
        try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM order_table WHERE date_time = ?");) {
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

}
