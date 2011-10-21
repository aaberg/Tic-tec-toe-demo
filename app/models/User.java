package models;

import play.data.validation.Email;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;
import play.libs.Crypto;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Date;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: lars
 * Date: 10/20/11
 * Time: 5:25 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class User extends Model {

    @Required
    public String fullName;

    @Required
    public Date birthDate;

    @Required @Email
    public String email;

    public String passwordHash;

    public String passwordSalt;

    @Required @MinSize(6) @Transient
    private String password;

    public void setPassword(String password){

        this.password = password;

        this.passwordSalt = UUID.randomUUID().toString() + UUID.randomUUID().toString();
        this.passwordHash = Crypto.passwordHash(passwordSalt+password);
    }

    public boolean checkPassword(String password){
        String hash = Crypto.passwordHash( this.passwordSalt+password );

        return this.passwordHash.equals(hash);
    }
}
