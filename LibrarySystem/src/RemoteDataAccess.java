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
            System.out.println("Connection to DataServer works!");
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




    public boolean saveBook(BookModel book) {
        System.out.println("Request save book with id = " + book.bookID);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.SAVE_PRODUCT, gson.toJson(book));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //

            StoreResponse response = gson.fromJson(ans, StoreResponse.class); // convert JSON string to a response object!

            return (response.code == StoreResponse.OK);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public BookModel loadBook(int bookID) {
        BookModel book = null;

        System.out.println("Request load book with id = " + bookID);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.LOAD_PRODUCT, String.valueOf(bookID));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //
            StoreResponse response = gson.fromJson(ans, StoreResponse.class); // convert JSON string to a response object!

            if (response.code == StoreResponse.OK)
                book = gson.fromJson(response.data, BookModel.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }



    public ReaderModel findReader(int readerID) {
        ReaderModel reader = null;

        System.out.println("Request find reader with id = " + readerID);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.FIND_READER, String.valueOf(readerID));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //
            StoreResponse response = gson.fromJson(ans, StoreResponse.class); // convert JSON string to a response object!

            if (response.code == StoreResponse.OK)
                reader = gson.fromJson(response.data, ReaderModel.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reader;
    }

    public boolean saveReader(ReaderModel reader) {
        System.out.println("Request save reader with id = " + reader.readerID);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.SAVE_READER, gson.toJson(reader));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //

            StoreResponse response = gson.fromJson(ans, StoreResponse.class); // convert JSON string to a response object!

            return (response.code == StoreResponse.OK);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }




    public boolean saveBorrow(BorrowModel borrow) {
        System.out.println("Request save borrow with book_id = " + borrow.bookID + ", reader_id = " + borrow.readerID);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.SAVE_BORROW, gson.toJson(borrow));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //

            StoreResponse response = gson.fromJson(ans, StoreResponse.class); // convert JSON string to a response object!

            return (response.code == StoreResponse.OK);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<BorrowModel> loadBorrowByBook(int bookID) {
        BorrowModel[] arr = null;
        System.out.println("Request find borrow with Book id = " + bookID);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.LOAD_RECORD1, String.valueOf(bookID));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //
            StoreResponse response = gson.fromJson(ans, StoreResponse.class); // convert JSON string to a response object!
            if (response.code == StoreResponse.OK)
                 arr = gson.fromJson(response.data, BorrowModel[].class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Arrays.asList(arr);
    }


    public List<BorrowModel> loadBorrowByReader(int readerID) {
        BorrowModel[] arr = null;
        System.out.println("Request find borrow with Reader id = " + readerID);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.LOAD_RECORD2, String.valueOf(readerID));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //
            StoreResponse response = gson.fromJson(ans, StoreResponse.class); // convert JSON string to a response object!

            if (response.code == StoreResponse.OK)
                arr = gson.fromJson(response.data, BorrowModel[].class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Arrays.asList(arr);
    }
}
