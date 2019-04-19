import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class HistoryView extends JFrame {

    CustomerModel customer;
    RemoteDataAccess db;
    public JButton btnOK;
    public JPanel central, p;
    public Container c, c1, c2, c3, c4;

    public HistoryView(CustomerModel customer, RemoteDataAccess da) {
        this.customer = customer;
        db = da;

        this.setTitle("*** Customer's Status ***");
        this.setSize(new Dimension(600,400));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(30,30,20,30));
        p.setLayout(new BorderLayout());

        //top line
        JPanel line1 = new JPanel();
        line1.setBorder(BorderFactory.createEmptyBorder(0,30,20,30));
        line1.add(new JLabel("Customer's name: "));
        line1.add(new JLabel(customer.name));
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
        c1.setLayout(new BoxLayout(c1, BoxLayout.PAGE_AXIS));
        c2.setLayout(new BoxLayout(c2, BoxLayout.Y_AXIS));
        c3.setLayout(new BoxLayout(c3, BoxLayout.Y_AXIS));
        c4.setLayout(new BoxLayout(c4, BoxLayout.Y_AXIS));
        c1.add(new JLabel("Type"));
        c1.add(new JLabel("========="));
        c2.add(new JLabel("Order/Return ID"));
        c2.add(new JLabel("=============="));
        c3.add(new JLabel("Date"));
        c3.add(new JLabel("============="));
        c4.add(new JLabel("Amount"));
        c4.add(new JLabel("====="));

        List<OrderModel> list = db.loadOrders(customer.userName);
        List<ReturnModel> list2 = db.loadReturns(customer.userName);

        for (OrderModel order : list) {
            c1.add(new JLabel("Order"));
            c2.add(new JLabel(String.valueOf(order.orderID)));
            c3.add(new JLabel(order.date));
            c4.add(new JLabel("$ " + order.total));
        }
        for (ReturnModel returnModel : list2) {
            c1.add(new JLabel("Return", JLabel.TRAILING));
            c2.add(new JLabel(String.valueOf(returnModel.returnID), JLabel.TRAILING));
            c3.add(new JLabel(returnModel.date, JLabel.TRAILING));
            c4.add(new JLabel("$ " + returnModel.total));
        }

        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);
        p.add(c, BorderLayout.CENTER);

        //bottom line
        JPanel line2 = new JPanel();
        line2.setLayout(new BoxLayout(line2, BoxLayout.PAGE_AXIS));

        JPanel line3 = new JPanel();
        btnOK = new JButton("OK");
        line3.add(btnOK);
        line2.add(line3);
        p.add(line2, BorderLayout.PAGE_END);

        this.getContentPane().add(p);

    }
}
