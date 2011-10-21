package controllers;

import play.i18n.Lang;
import play.mvc.Controller;

/**
 * Created by IntelliJ IDEA.
 * User: lars
 * Date: 10/20/11
 * Time: 6:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Common extends Controller {

    public static void changeLang(String lang, String redirectUrl){
        Lang.change(lang);

        if (redirectUrl == null){
            redirectUrl = "/";
        }

        redirect(redirectUrl);
    }
}
