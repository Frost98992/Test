import java.sql.*;
import java.util.Scanner;

public class TableOperations {
    String username = "root";
    String password = "123";
    String connectorURL = "jdbc:mysql://localhost:3306/test";
    Connection connection;
    TableOperations() throws SQLException {

       connection = DriverManager.getConnection(connectorURL, username, password);
        System.out.println("SUCCESSFUL connection");

    }
    String SQL;
    Scanner in = new Scanner(System.in);
    int choice=0;
    int id;
    String name;
    String surname;
    String faculty;
    Statement st;
    ResultSet result;

    void add() throws SQLException {
        System.out.println("Введите фамилию студента: ");
        surname = in.next();
        System.out.println("Введите имя студента: ");
        name = in.next();
        System.out.println("Введите факультет студента: ");
        faculty = in.next();

        System.out.print("Добавлена строка: ");
//        System.out.print(id+" ");
        System.out.print(name+" ");
        System.out.print(surname+" ");
        System.out.println(faculty);
        SQL  = "INSERT INTO Student(name, surname, faculty) VALUES ('"+ name + "', '"+ surname + "', '"+ faculty +"');";
        connect(SQL);
    }
    void delete() throws SQLException {
        SQL = "DELETE FROM Student WHERE id="+id;
        connect(SQL);
    }

    void show() throws SQLException {
        SQL = "SELECT * FROM Student";
        result = st.executeQuery(SQL);
        System.out.println("Данные из таблицы: ");
        int i=1;
        while (result.next()) {
            String str = result.getString("name")
                    +" "+result.getString("surname")+" "+result.getString("faculty");
            System.out.println("Строка "+ i + ": " + str);
            i++;

        }
        System.out.println(" ");
    }

    void Interface() throws SQLException {


        while (choice!=4) {
            System.out.println("Выберите действие: ");
            System.out.println(" ");
            System.out.println("1 - Добавить запись в таблицу");
            System.out.println("2 - Удалить запись из таблицу");
            System.out.println("3 - Вывести все записи таблицы");
            System.out.println("4 - Выход");

            choice = in.nextInt();

            switch (choice) {
                case 1: {

//                    System.out.println("Введите id: ");
//                    id = in.nextInt();

                    add();
                    break;
                }
                case 2: {
                    System.out.println("Введите id стоки, которую хотите удалить: ");
                    id = in.nextInt();
                    delete();
                    break;
                }
                case 3: {
                    show();
                    break;
                }
                case 4: break;
                default:
                {
                    System.out.println("Введите корректное число!!! ");
                    break;
                }


            }
        }

    }


    void connect(String SQL) throws SQLException {
        st = connection.createStatement();
        st.executeUpdate(SQL);
    }
//    void select(String SQL) throws SQLException {
//        st = connection.createStatement();
//        st.executeQuery(SQL);
//    }


    void createTable() throws SQLException {
        SQL = "CREATE TABLE IF NOT EXISTS Student" +
                "(id INTEGER AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "surname VARCHAR(255) NOT NULL," +
                "faculty VARCHAR(255) NOT NULL)";
        connect(SQL);
    }




}

