package com.iovine.antonio.activestore;

import com.iovine.antonio.activestore.folderdeleter.FolderDeleterPresenter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("COMMAND USAGE");
        System.out.println("java -jar FolderDeleter.jar -p /home/to/path/desired -d number_od_days_older_check");

        String pathToAnalize, days_older;

        //Check if command option are right
        if( (args[0].equals("-p")) && (args[2].equals("-d"))){
            //Extract passed argument throw terminal
            pathToAnalize = args[1];
            days_older = args[3];
            //System.out.println(pathToAnalize);
            //System.out.println(days_older);
            //Check if passed argument are not null
            if(!(pathToAnalize.isEmpty()) && !(days_older.isEmpty())){
                FolderDeleterPresenter fdp = new FolderDeleterPresenter(pathToAnalize,Integer.parseInt(days_older));
                fdp.getListOfFolderToDelete();
            }
        }

        else {
            System.out.println("Bad Command Usage");
            System.out.println("java -jar FolderDeleter.jar -p /home/to/path/desired -d number_od_days_older_check");
        }


    }
}
