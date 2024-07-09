package com.company.Utils;

public class IdGenretor {
    private static int id=0;

    private IdGenretor(){

    };

    public static int getId(){
        id++;
        return id;
    }
}
