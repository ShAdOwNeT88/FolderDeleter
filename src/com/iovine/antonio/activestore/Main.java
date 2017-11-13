package com.iovine.antonio.activestore;

import com.iovine.antonio.activestore.folderdeleter.FolderDeleterPresenter;
import com.iovine.antonio.activestore.pathUtil.PathUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String pathToAnalize, days_older;
        PathUtil pu = new PathUtil();

        //Check if command option are right
        if( (args[0].equals("-p")) && (args[2].equals("-d"))){
            //Extract passed argument throw terminal
            pathToAnalize = args[1];
            days_older = args[3];
            //Check if passed argument are not null
            if( !(pathToAnalize.isEmpty()) && !(days_older.isEmpty()) && (pu.checkIfPathExist(pathToAnalize)) ){
                FolderDeleterPresenter fdp = new FolderDeleterPresenter(pathToAnalize,Integer.parseInt(days_older));
                fdp.getListOfFolderToDelete();
            }

            else {
                System.out.println("COMMAND USAGE");
                System.out.println("java -jar FolderDeleter.jar -p /to/path/desired -d number_od_days_older_check");
            }
        }
    }
}
