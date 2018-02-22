package database;

import java.util.HashMap;
import java.util.Map;

public class User {
    private static Map<String, String> users = new HashMap<String, String>();


    public static  Map<String, String> getUsers(){
        return  users;
    }
    public   static  String exit(){

        return getUsers().toString() ;
    }
}
