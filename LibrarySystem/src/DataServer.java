public class DataServer {

    private static DataServer instance = null;

    private DataAccess dao;

    public DataAccess getDataAccess() {
        return dao;
    }

    public static DataServer getInstance() {
        if (instance == null) {
            // check configurationss...
            instance = new DataServer("SQLite");
        }
        return instance;
    }

    private DataServer(String db) {
        if (db.equals("SQLite"))
            dao = new DataAccess();
        // similar implementations for other DBMS...
        dao.connect();
    }

}
