import javax.swing.*;
import java.awt.*;

public class ReturnView extends JFrame {

    public JTextField txtBarcode, txtQuantity, txtCustomer;

    public JButton btnSave, btnCancel, btnReturn;
    public Container c, c1, c2, c3, c4, c5, c6;
    public JPanel p;

    public ReturnView() {
        this.setTitle("*** Return ***");
        this.setSize(new Dimension(600,400));

        p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(30,30,20,30));
        p.setLayout(new BorderLayout());

        //top lines
        JPanel line1 = new JPanel();
        txtBarcode = new JTextField(10);
        txtQuantity = new JTextField(10);
        btnSave = new JButton("Save");
        line1.add(new JLabel("Barcode："));
        line1.add(txtBarcode);
        line1.add(new JLabel("      Quantity："));
        line1.add(txtQuantity);
        line1.add(btnSave);
        p.add(line1, BorderLayout.PAGE_START);

        //central box
        c = new JPanel();
        FlowLayout f = new FlowLayout();
        c.setLayout(f);
        f.setAlignment(FlowLayout.CENTER);
        f.setHgap(0);
        c1 = new Container();
        c2 = new Container();
        c3 = new Container();
        c4 = new Container();
        c5 = new Container();
        c6 = new Container();
        c1.setLayout(new BoxLayout(c1, BoxLayout.PAGE_AXIS));
        c2.setLayout(new BoxLayout(c2, BoxLayout.Y_AXIS));
        c3.setLayout(new BoxLayout(c3, BoxLayout.Y_AXIS));
        c4.setLayout(new BoxLayout(c4, BoxLayout.Y_AXIS));
        c5.setLayout(new BoxLayout(c5, BoxLayout.Y_AXIS));
        c6.setLayout(new BoxLayout(c6, BoxLayout.Y_AXIS));
        c1.add(new JLabel("Product ID"));
        c1.add(new JLabel("==========="));
        c2.add(new JLabel("Name"));
        c2.add(new JLabel("========"));
        c3.add(new JLabel("Quantity"));
        c3.add(new JLabel("=========="));
        c4.add(new JLabel("Price"));
        c4.add(new JLabel("========"));
        c5.add(new JLabel("Tax"));
        c5.add(new JLabel("======="));
        c6.add(new JLabel("Total"));
        c6.add(new JLabel("===="));
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);
        c.add(c5);
        c.add(c6);
        p.add(c, BorderLayout.CENTER);

        //bottom line
        JPanel line2 = new JPanel();
        line2.setLayout(new BoxLayout(line2, BoxLayout.PAGE_AXIS));

        JPanel line0 = new JPanel();
        txtCustomer = new JTextField(10);
        line0.add(new JLabel("Customer's Name: "));
        line0.add(txtCustomer);
        line2.add(line0);

        JPanel line3 = new JPanel();
        btnCancel = new JButton("Cancel");
        btnReturn = new JButton("Return");
        line3.add(btnCancel);
        line3.add(btnReturn);
        line2.add(line3);
        p.add(line2, BorderLayout.PAGE_END);

        this.getContentPane().add(p);
    }

    public void addTxt(Container cn, String s) {
        cn.add(new JLabel(s));
    }

    public void clear() {
        c.removeAll();
        FlowLayout f = new FlowLayout();
        c.setLayout(f);
        f.setAlignment(FlowLayout.CENTER);
        f.setHgap(0);
        c1 = new Container();
        c2 = new Container();
        c3 = new Container();
        c4 = new Container();
        c5 = new Container();
        c6 = new Container();
        c1.setLayout(new BoxLayout(c1, BoxLayout.PAGE_AXIS));
        c2.setLayout(new BoxLayout(c2, BoxLayout.Y_AXIS));
        c3.setLayout(new BoxLayout(c3, BoxLayout.Y_AXIS));
        c4.setLayout(new BoxLayout(c4, BoxLayout.Y_AXIS));
        c5.setLayout(new BoxLayout(c5, BoxLayout.Y_AXIS));
        c6.setLayout(new BoxLayout(c6, BoxLayout.Y_AXIS));
        c1.add(new JLabel("Product ID"));
        c1.add(new JLabel("==========="));
        c2.add(new JLabel("Name"));
        c2.add(new JLabel("========"));
        c3.add(new JLabel("Quantity"));
        c3.add(new JLabel("=========="));
        c4.add(new JLabel("Price"));
        c4.add(new JLabel("========"));
        c5.add(new JLabel("Tax"));
        c5.add(new JLabel("======="));
        c6.add(new JLabel("Total"));
        c6.add(new JLabel("===="));
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);
        c.add(c5);
        c.add(c6);
        p.add(c, BorderLayout.CENTER);

        txtBarcode.setText("");
        txtQuantity.setText("");
        txtCustomer.setText("");

    }


}
