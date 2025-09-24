package com.triporganiser;

public class Customer extends User{  /* Customer Class Is Inherited From User Class*/

    public Customer(int userId , String name , String username , String password){
        super(userId , name , username , password);    /* Calls Constructor Of User Class And Intialize The Customer Object */
    }
}