package controllers;

import models.User;
import org.apache.commons.io.IOUtils;
import play.cache.Cache;
import play.data.validation.Valid;
import play.libs.Codec;
import play.libs.F;
import play.libs.WS;
import play.mvc.Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by IntelliJ IDEA.
 * User: lars
 * Date: 10/20/11
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Users extends Controller {

    public static void list(){

        List<User> users = User.findAll();

        render(users);
    }


    public static void edit(Long id){

        if (id != null){
            User user = User.findById(id);

            render(user);
        }

        render();
    }

    public static void save(@Valid User user){

        if (validation.hasErrors()){
            validation.keep();
            params.flash();
            edit(null);
        }

        user.save();

        list();
    }

    public static void delete(Long id){
        User user = User.findById(id);

        user.delete();

        list();
    }

    public static void gravatar(String email) throws ExecutionException, InterruptedException, IOException {

        email = email.trim().toLowerCase();

        byte[] imgData = (byte[])play.cache.Cache.get("gravatar_" + email);

        if (imgData == null){
            String hashedEmail = Codec.hexMD5(email);

            String url = "http://www.gravatar.com/avatar/" + hashedEmail;

            F.Promise<WS.HttpResponse> promise = WS.url(url).getAsync();
            await(promise);

            imgData = IOUtils.toByteArray( promise.get().getStream() );
            Cache.set("gravatar_" + email, imgData);
        }

        ByteArrayInputStream stream = new ByteArrayInputStream(imgData);

        renderBinary(stream);
    }
}
