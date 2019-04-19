import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoteDataAccess {

    Socket socket;
    BufferedReader in;
    PrintWriter out;
    Gson gson = new Gson();

    public boolean connect() {
        try {
            socket = new Socket("localhost", 8008);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Connection to StoreServer successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public boolean disconnect() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    /*
     * user
     */
    public UserModel findUser(String userName) {
        UserModel user = null;

        System.out.println("Request load user with userName = " + userName);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.LOAD_USER, userName);

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //
            ServerResponse response = gson.fromJson(ans, ServerResponse.class); // convert JSON string to a response object!

            if (response.code == ServerResponse.OK)
                user = gson.fromJson(response.data, UserModel.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    public boolean saveUser(UserModel user) {
        System.out.println("Request save user with userName = " + user.userName);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.SAVE_USER, gson.toJson(user));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //

            ServerResponse response = gson.fromJson(ans, ServerResponse.class); // convert JSON string to a response object!

            return (response.code == ServerResponse.OK);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public CustomerModel findCustomer(String userName) {
        CustomerModel customer = null;

        System.out.println("Request load customer with userName = " + userName);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.LOAD_CUSTOMER, userName);

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //
            ServerResponse response = gson.fromJson(ans, ServerResponse.class); // convert JSON string to a response object!

            if (response.code == ServerResponse.OK)
                customer = gson.fromJson(response.data, CustomerModel.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }


    public boolean saveCustomer(CustomerModel customer) {
        System.out.println("Request save customer with userName = " + customer.userName);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.SAVE_CUSTOMER, gson.toJson(customer));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //

            ServerResponse response = gson.fromJson(ans, ServerResponse.class); // convert JSON string to a response object!

            return (response.code == ServerResponse.OK);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }





    /*
     * product
     */
    public boolean saveProduct(ProductModel product) {
        System.out.println("Request save product with id = " + product.productID);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.SAVE_PRODUCT, gson.toJson(product));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //

            ServerResponse response = gson.fromJson(ans, ServerResponse.class); // convert JSON string to a response object!

            return (response.code == ServerResponse.OK);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public ProductModel loadProduct(int productID) {
        ProductModel product = null;

        System.out.println("Request load product with id = " + productID);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.LOAD_PRODUCT, String.valueOf(productID));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //
            ServerResponse response = gson.fromJson(ans, ServerResponse.class); // convert JSON string to a response object!

            if (response.code == ServerResponse.OK)
                product = gson.fromJson(response.data, ProductModel.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    public ProductModel findProduct(int barcode) {
        ProductModel product = null;

        System.out.println("Request load product with barcode = " + barcode);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.FIND_PRODUCT, String.valueOf(barcode));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //
            ServerResponse response = gson.fromJson(ans, ServerResponse.class); // convert JSON string to a response object!

            if (response.code == ServerResponse.OK)
                product = gson.fromJson(response.data, ProductModel.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }




    /*
     * order
     */
    public List<OrderModel> loadOrders(String userName) {
        OrderModel[] arr = null;

        System.out.println("Request load orders with userName = " + userName);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.LOAD_ORDERS, userName);

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //
            ServerResponse response = gson.fromJson(ans, ServerResponse.class); // convert JSON string to a response object!

            if (response.code == ServerResponse.OK)
                arr = gson.fromJson(response.data, OrderModel[].class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (arr == null || arr.length == 0)     return new ArrayList<OrderModel>();
        else    return Arrays.asList(arr);
    }


    public boolean saveOrder(OrderModel order) {
        System.out.println("Request save order with customer = " + order.customer);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.SAVE_ORDER, gson.toJson(order));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //

            ServerResponse response = gson.fromJson(ans, ServerResponse.class); // convert JSON string to a response object!

            return (response.code == ServerResponse.OK);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }



    /*
     * return
     */
    public boolean saveReturn(ReturnModel returnModel) {
        System.out.println("Request save return with id = " + returnModel.returnID);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.SAVE_RETURN, gson.toJson(returnModel));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //

            ServerResponse response = gson.fromJson(ans, ServerResponse.class); // convert JSON string to a response object!

            return (response.code == ServerResponse.OK);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ReturnModel> loadReturns(String userName) {
        ReturnModel[] arr = null;

        System.out.println("Request load returns with userName = " + userName);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.LOAD_RETURNS, userName);

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //
            ServerResponse response = gson.fromJson(ans, ServerResponse.class); // convert JSON string to a response object!

            if (response.code == ServerResponse.OK)
                arr = gson.fromJson(response.data, ReturnModel[].class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (arr == null || arr.length == 0)     return new ArrayList<ReturnModel>();
        else    return Arrays.asList(arr);
    }



}
