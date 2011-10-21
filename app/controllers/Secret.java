package controllers;

import play.mvc.Controller;
import play.mvc.With;

/**
 * Created by IntelliJ IDEA.
 * User: lars
 * Date: 10/20/11
 * Time: 6:35 PM
 * To change this template use File | Settings | File Templates.
 */
@With(Secure.class)
public class Secret extends Controller {

    public static void stuff(){
        render();
    }
}
