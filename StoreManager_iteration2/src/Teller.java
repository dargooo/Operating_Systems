import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import com.google.gson.*;

public class Teller extends Thread {
    protected Socket socket;
    protected DataAdapter dao;

    public Teller(Socket incoming, DataAdapter dao) {
        this.socket = incoming;
        this.dao = dao;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(
                            socket.getOutputStream()));

            while (true) {
                String str = in.readLine();
                if (str == null) break; // client closed connection
                System.out.println("Received from client: " + str);

                Gson gson = new Gson();
                StoreRequest request = gson.fromJson(str, StoreRequest.class);
                ServerResponse response = new ServerResponse();

                if (request.code == StoreRequest.GOOD_BYE) break; // the client wants to stop!

                /*
                 * user
                 */
                if (request.code == StoreRequest.LOAD_USER) {
                    String userName = request.data;
                    UserModel user = dao.findUser(userName);

                    if (user == null)
                        response.code = ServerResponse.USER_NOT_FOUND;
                    else
                        response.data = gson.toJson(user);

                    out.println(gson.toJson(response));
                    out.flush();
                }

                if (request.code == StoreRequest.SAVE_USER) {
                    UserModel user = gson.fromJson(request.data, UserModel.class);

                    if  (dao.saveUser(user))
                        response.code = ServerResponse.OK;
                    else
                        response.code = ServerResponse.SAVE_USER_ERROR;

                    out.println(gson.toJson(response));
                    out.flush();
                }

                if (request.code == StoreRequest.LOAD_CUSTOMER) {
                    String userName = request.data;
                    CustomerModel customer = dao.findCustomer(userName);

                    if (customer == null)
                        response.code = ServerResponse.CUSTOMER_NOT_FOUND;
                    else
                        response.data = gson.toJson(customer);

                    out.println(gson.toJson(response));
                    out.flush();
                }

                if (request.code == StoreRequest.SAVE_CUSTOMER) {
                    CustomerModel customer = gson.fromJson(request.data, CustomerModel.class);

                    if  (dao.saveCustomer(customer))
                        response.code = ServerResponse.OK;
                    else
                        response.code = ServerResponse.SAVE_CUSTOMER_ERROR;

                    out.println(gson.toJson(response));
                    out.flush();
                }



                /*
                 * product
                 */
                if (request.code == StoreRequest.LOAD_PRODUCT) {
                    int productID = Integer.parseInt(request.data);
                    ProductModel product = dao.loadProduct(productID);

                    if (product == null)
                        response.code = ServerResponse.PRODUCT_NOT_FOUND;
                    else
                        response.data = gson.toJson(product);

                    out.println(gson.toJson(response));
                    out.flush();
                }

                if (request.code == StoreRequest.SAVE_PRODUCT) {
                    ProductModel product = gson.fromJson(request.data, ProductModel.class);

                    if  (dao.saveProduct(product))
                        response.code = ServerResponse.OK;
                    else
                        response.code = ServerResponse.SAVE_PRODUCT_ERROR;

                    out.println(gson.toJson(response));
                    out.flush();
                }

                if (request.code == StoreRequest.FIND_PRODUCT) {
                    int barcode = Integer.parseInt(request.data);
                    ProductModel product = dao.findProduct(barcode);

                    if (product == null)
                        response.code = ServerResponse.PRODUCT_NOT_FOUND;
                    else
                        response.data = gson.toJson(product);

                    out.println(gson.toJson(response));
                    out.flush();
                }



                /*
                 * order
                 */
                if (request.code == StoreRequest.LOAD_ORDERS) {
                    String userName = request.data;
                    List<OrderModel> list = dao.loadOrders(userName);

                    if (list == null || list.size() == 0)
                        response.code = ServerResponse.ORDER_NOT_FOUND;
                    else
                        response.data = gson.toJson(list);

                    out.println(gson.toJson(response));
                    out.flush();
                }

                if (request.code == StoreRequest.SAVE_ORDER) {
                    OrderModel order = gson.fromJson(request.data, OrderModel.class);

                    if  (dao.saveOrder(order))
                        response.code = ServerResponse.OK;
                    else
                        response.code = ServerResponse.SAVE_ORDER_ERROR;

                    out.println(gson.toJson(response));
                    out.flush();
                }


                /*
                 * return
                 */
                if (request.code == StoreRequest.LOAD_RETURNS) {
                    String userName = request.data;
                    List<ReturnModel> list = dao.loadReturns(userName);

                    if (list == null || list.size() == 0)
                        response.code = ServerResponse.RETURN_NOT_FOUND;
                    else
                        response.data = gson.toJson(list);

                    out.println(gson.toJson(response));
                    out.flush();
                }

                if (request.code == StoreRequest.SAVE_RETURN) {
                    ReturnModel returnModel = gson.fromJson(request.data, ReturnModel.class);

                    if  (dao.saveReturn(returnModel))
                        response.code = ServerResponse.OK;
                    else
                        response.code = ServerResponse.SAVE_RETURN_ERROR;

                    out.println(gson.toJson(response));
                    out.flush();
                }
            }
            in.close();
            out.close();
            socket.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
