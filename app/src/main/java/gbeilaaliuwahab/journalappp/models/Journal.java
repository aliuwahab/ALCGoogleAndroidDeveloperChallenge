package gbeilaaliuwahab.journalappp.models;

import com.orm.SugarRecord;

public class Journal extends SugarRecord<Journal>{
    public String title;
//    public String description;
    public Boolean status;

    // defining a relationship
    User user;


    public Journal(){

    }

    //Constructor
    public Journal(String title,Boolean status, User user){
        this.title = title;
//        this.description = description;
        this.status = status;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getDescription() {
//        return description;
//    }

//    public void setDescription(String description) {
//        this.description = description;
//    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public Long getId() {
        return id;
    }



}
