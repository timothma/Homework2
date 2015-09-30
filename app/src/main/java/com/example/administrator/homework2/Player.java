package com.example.administrator.homework2;

import java.io.Serializable;

/**
 * Created by macnary17 on 9/27/2015.
 */

//simple Player object
public class Player implements Serializable {
    String name;
    String uniformNumber;
    String goals;


    public Player(){
        name = "JohnDow";
        uniformNumber = "4";
        goals = "3";
    }
}
