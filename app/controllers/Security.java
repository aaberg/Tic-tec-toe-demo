package controllers;

import models.User;

/**
 * Created by IntelliJ IDEA.
 * User: lars
 * Date: 10/20/11
 * * Time: 6:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Security extends Secure.Security {

    public static boolean authenticate(String username, String password){

        User user = User.find("byEmail", username).first();

        if (user == null){
            return false;
        }

        return user.checkPassword(password);
    }
}
