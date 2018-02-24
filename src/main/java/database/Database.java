package database;

import java.sql.*;

public class Database {
    private static String url = "jdbc:mysql://localhost:3306/crypt";
    private static String user = "root";
    private static String password = "root";
    private static Connection connection;
    private static Statement statement;

    public static Connection getConnection()  {

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Exception to connect to SQL");
        }

        return connection;
    }
    public static Statement getStatement(){
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            System.out.println("Statement");
        }
        return  statement;
    }
    public static void update( Statement statement, String user, String password){

            String query = "INSERT  INTO  crypt.users  (user, password) VALUES(?,?)";
        try  (PreparedStatement ps = statement.getConnection().prepareStatement(query)){
            ps.setString(1, user);
            ps.setString(2, password);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                getConnection().close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static  void execute(Statement statement, String user, String password){
            String query = "SELECT  user, password From users WHERE user = ? AND  password = ?";


        try  (PreparedStatement pq  = statement.getConnection().prepareStatement(query)) {
            pq.setString(1,user);
            pq.setString(2,password);
            ResultSet  set = pq.executeQuery();
           while (set.next()){

               System.out.println(set.getString("user") + " - " + set.getString("password"));
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                getConnection().close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
