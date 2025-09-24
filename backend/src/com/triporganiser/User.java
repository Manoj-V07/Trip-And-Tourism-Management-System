package com.triporganiser;

public abstract class User { 
    private int userId;
    private String name;
    private String username;
    private String password;

    /* Constructor used to initialize the object */
    public User(int userId , String name , String username , String password){
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    /* Getter Methods For userId , name , username , password to 
    return when the respective method is called */
    public int getUserId() { return userId; }

    public String getName() { return name; }

    public String getUsername() { return username; }

    public String getPassword()  {return password; }

    /* This default toString function is used to representing 
    the string in customized form*/
    @Override
    public String toString(){
        return "User ID : " + userId + ", Name : " + name + 
        ", Username : " + username;
    }
}