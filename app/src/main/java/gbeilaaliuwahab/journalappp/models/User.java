package gbeilaaliuwahab.journalappp.models;

import com.orm.SugarRecord;

public class User extends SugarRecord<User> {
//    public String username;
    public String email;
//    public String password;

    public User(){

    }

    public User(String email){
        this.email = email;
    }


//    public String getUsername() {
//        return username;
//    }

//    public void setUsername(String username) {
//        this.username = username;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getPassword() {
//        return password;
//    }

//    public void setPassword(String password) {
//        this.password = password;
//    }

    
}
