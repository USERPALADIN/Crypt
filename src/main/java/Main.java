import database.Database;
import database.User;

import java.sql.Statement;
import java.util.Scanner;

public class Main {
    private static    Statement statement;
    public static void main(String[] args) {
       scan();

        System.out.println(User.exit());

    }

    private static  void crypt(String user, String password) {

        StringBuffer su = new StringBuffer(user);
        StringBuffer sp = new StringBuffer(password);
        System.out.println(su.reverse());
        System.out.println(sp.reverse());
        user = String.valueOf(su);
        password = String.valueOf(sp);
        Database.update(Database.getStatement(), user, password);



    }
//    private  static  Map<String, String> unCrypt(String user){
//
//    }
    private  static  void scan(){
        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();
        String password  = sc.nextLine();
        crypt(user,password);


    }
}
