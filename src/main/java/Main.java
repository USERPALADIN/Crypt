import database.Database;
import database.User;

import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        scan();


    }

    private static void crypt(String user, String password) {

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
    private static void scan() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите пользователя и пароль");
        String user = sc.nextLine();
        String password = sc.nextLine();
        System.out.println("Выберите функцию. 1 Шифрование. 2 Дешифрование 3 Выход");
        int choose;
        while (true) {
            choose = sc.nextInt();
            if (choose == 1) {
                crypt(user, password);

            }
            if (choose == 2) {
                uncrypt(user, password);
            }
            if (choose == 3) {
                break;
            }
        }
    }

    private static void uncrypt(String user, String password) {
        StringBuffer su = new StringBuffer(user);
        StringBuffer sp = new StringBuffer(password);
        System.out.println(su.reverse());
        System.out.println(sp.reverse());
        user = String.valueOf(su);
        password = String.valueOf(sp);
        Database.execute(Database.getStatement(), user, password);

    }
}
