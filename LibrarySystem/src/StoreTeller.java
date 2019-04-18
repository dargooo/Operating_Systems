import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import com.google.gson.*;

public class StoreTeller extends Thread {
    protected Socket socket;
    protected DataAccess dao;

    public StoreTeller(Socket incoming, DataAccess dao) {
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
                StoreResponse response = new StoreResponse();


                if (request.code == StoreRequest.GOOD_BYE) break; // the client wants to stop!

                if (request.code == StoreRequest.LOAD_PRODUCT) {
                    int id = Integer.parseInt(request.data);
                    BookModel book = dao.loadBook(id);

                    if (book == null)
                        response.code = StoreResponse.PRODUCT_NOT_FOUND;
                    else
                        response.data = gson.toJson(book);

                    out.println(gson.toJson(response));
                    out.flush();
                    continue;
                }

                if (request.code == StoreRequest.SAVE_PRODUCT) {
                    BookModel book = gson.fromJson(request.data, BookModel.class);

                    if  (dao.saveBook(book))
                        response.code = StoreResponse.OK;
                    else
                        response.code = StoreResponse.SAVE_PRODUCT_ERROR;

                    out.println(gson.toJson(response));
                    out.flush();
                }

                if (request.code == StoreRequest.FIND_READER) {
                    int id = Integer.parseInt(request.data);
                    ReaderModel reader = dao.findReader(id);

                    if (reader == null)
                        response.code = StoreResponse.READER_NOT_FOUND;
                    else
                        response.data = gson.toJson(reader);

                    out.println(gson.toJson(response));
                    out.flush();
                    continue;
                }

                if (request.code == StoreRequest.SAVE_READER) {
                    ReaderModel reader = gson.fromJson(request.data, ReaderModel.class);

                    if  (dao.saveReader(reader))
                        response.code = StoreResponse.OK;
                    else
                        response.code = StoreResponse.SAVE_READER_ERROR;

                    out.println(gson.toJson(response));
                    out.flush();
                }

                if (request.code == StoreRequest.SAVE_BORROW) {
                    BorrowModel borrow = gson.fromJson(request.data, BorrowModel.class);

                    if  (dao.saveBorrow(borrow))
                        response.code = StoreResponse.OK;
                    else
                        response.code = StoreResponse.SAVE_BORROW_ERROR;

                    out.println(gson.toJson(response));
                    out.flush();
                }

                if (request.code == StoreRequest.LOAD_RECORD1) {
                    int id = Integer.parseInt(request.data);
                    List<BorrowModel> borrows = dao.loadBorrowByBook(id);

                    if (borrows == null)
                        response.code = StoreResponse.LOAD_BORROW_ERROR1;
                    else
                        response.data = gson.toJson(borrows);

                    out.println(gson.toJson(response));
                    out.flush();
                    continue;
                }

                if (request.code == StoreRequest.LOAD_RECORD2) {
                    int id = Integer.parseInt(request.data);
                    List<BorrowModel> borrows = dao.loadBorrowByReader(id);

                    if (borrows == null)
                        response.code = StoreResponse.LOAD_BORROW_ERROR2;
                    else
                        response.data = gson.toJson(borrows);

                    out.println(gson.toJson(response));
                    out.flush();
                    continue;
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
