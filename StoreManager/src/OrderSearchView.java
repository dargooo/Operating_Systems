import javax.swing.*;
import java.awt.*;

public class OrderSearchView extends JFrame {

    public JTextField txtFirst = new JTextField(8);
    public JTextField txtLast = new JTextField(8);
    public JTextField txtYear = new JTextField(4);
    public JTextField txtMonth = new JTextField(4);
    public JTextField txtDate = new JTextField(4);

    public JButton btnName = new JButton("Search by Name");
    public JButton btnDate = new JButton("Search by Date");
    public JButton btnCancel = new JButton("Cancel");
    public Container c, c1, c2, c3, c4, c5, c6;
    public JPanel p;

    public OrderSearchView() {

        this.setTitle("*** Search Order ***");
        this.setSize(new Dimension(600, 400));
        p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(30,30,0,30));
        p.setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));
        JPanel line1 = new JPanel();
        //line1.add(new JLabel("Enter Customer's Name: "));
        line1.add(new JLabel("First"));
        line1.add(txtFirst);
        line1.add(new JLabel("Last"));
        line1.add(txtLast);
        line1.add(btnName);
        p1.add(line1);

        JPanel line2 = new JPanel();
        //line2.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        line2.add(new JLabel("** Or **"));
        p1.add(line2);

        JPanel line3 = new JPanel();
        line3.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        //line3.add(new JLabel("Enter Order's date: "));
        line3.add(new JLabel("Year"));
        line3.add(txtYear);
        line3.add(new JLabel("Month"));
        line3.add(txtMonth);
        line3.add(new JLabel("Day"));
        line3.add(txtDate);
        line3.add(btnDate);
        p1.add(line3);

        p.add(p1, BorderLayout.PAGE_START);



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
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);
        c.add(c5);
        c.add(c6);
        p.add(c, BorderLayout.CENTER);



        JPanel line4 = new JPanel();
        line4.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        btnCancel = new JButton("Return");
        //btnSearch = new JButton("Search");
        line4.add(btnCancel);
        //line4.add(btnSearch);
        p.add(line4, BorderLayout.PAGE_END);

        this.getContentPane().add(p);

    }

    public void addTxt(Container cn, String s) {
        cn.add(new JLabel(s));
    }


    public void clear() {
        txtDate.setText("");
        txtFirst.setText("");
        txtLast.setText("");
        txtMonth.setText("");
        txtYear.setText("");

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
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);
        c.add(c5);
        c.add(c6);
        p.add(c, BorderLayout.CENTER);

    }

}
