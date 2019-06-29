import java.sql.*;

public class Main {
public static void main(String[] args) throws SQLException {

    TableOperations connect = new TableOperations();
    connect.createTable();
    connect.Interface();

    }
}
