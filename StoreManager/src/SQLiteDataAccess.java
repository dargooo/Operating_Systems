import java.sql.*;

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


}
