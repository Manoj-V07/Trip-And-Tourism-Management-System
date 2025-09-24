package com.triporganiser;    

public class Admin extends User{                /* Admin Class is inherrited from the User Class */

    public Admin(int userId , String name , String username , String password){
        super(userId , name , username , password);  /* Calls the constuctor of the User Calss and initializes the Admin Object */
    }
}