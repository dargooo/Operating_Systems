import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductController implements ActionListener {

    ProductView pView;
    SQLiteDataAccess db;

    public ProductController(ProductView view, SQLiteDataAccess dao) {
        pView = view;
        db = dao;
        pView.btnCheck.addActionListener(this);
        pView.btnCancel.addActionListener(this);
        pView.btnSave.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pView.btnCheck) {
            display();
        }

        if (e.getSource() == pView.btnSave) {
            saveProduct();
        }

        if (e.getSource() == pView.btnCancel) {
            StoreManager.mainView.show();
            StoreManager.productView.setVisible(false);
            StoreManager.productView.clear();
        }

    }



    private void saveProduct() {
        ProductModel productModel = new ProductModel();

        try {
            int productID = Integer.parseInt(pView.txtProductID.getText());
            productModel.productID = productID;
            productModel.name = pView.txtProductName.getText();
            productModel.barcode = Integer.parseInt(pView.txtProductBarcode.getText());
            productModel.quantity = Double.parseDouble(pView.txtProductQuantity.getText());
            productModel.price = Double.parseDouble(pView.txtProductPrice.getText());
            productModel.provider = pView.txtProvider.getText();
            productModel.contact = pView.txtContact.getText();

            db.saveProduct(productModel);
            JOptionPane.showMessageDialog(null, "Product saved successfully!");

        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for ProductID");
            ex.printStackTrace();
        }    }



    private void display() {
        try {
            int productID = Integer.parseInt(pView.txtProductID.getText());
            ProductModel productModel = db.loadProduct(productID);
            if (productModel == null) {
                JOptionPane.showMessageDialog(null, "New product!");
                pView.txtProductName.setText("");
                pView.txtProductBarcode.setText("");
                pView.txtProductQuantity.setText("");
                pView.txtProductPrice.setText("");
                pView.txtProvider.setText("");
                pView.txtContact.setText("");
            }
            else {
                JOptionPane.showMessageDialog(null, "Product Exists!");
                pView.txtProductName.setText(productModel.name);
                pView.txtProductBarcode.setText(String.valueOf(productModel.barcode));
                pView.txtProductQuantity.setText(String.valueOf(productModel.quantity));
                pView.txtProductPrice.setText(String.valueOf(productModel.price));
                pView.txtProvider.setText(productModel.provider);
                pView.txtContact.setText(productModel.contact);
            }
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for ProductID");
            ex.printStackTrace();
        }
    }
}
