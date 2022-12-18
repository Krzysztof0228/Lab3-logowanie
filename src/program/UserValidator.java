package program;

import java.util.Map;
import java.util.HashMap;

public class UserValidator {

    private static final String name = "User";
    private static final String password = "12345";

    //private static Map<String, String> loginMap = new HashMap<>();


    public static boolean authenticate(String name, String password){
        if(UserValidator.name.equals(name) && UserValidator.password.equals(password))
            return true;
        else
            return false;
    }

}
