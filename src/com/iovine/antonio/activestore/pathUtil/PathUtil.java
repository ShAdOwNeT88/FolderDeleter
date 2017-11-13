package com.iovine.antonio.activestore.pathUtil;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtil {

    public PathUtil(){}

    //Method used for check if Path passed into command exist
    public boolean checkIfPathExist(String Path){

        Path path = Paths.get(Path);
        boolean exist;

        if(Files.exists(path)){
            System.out.println("Path exist");
            exist = true;
        }

        else {
            System.out.println("ERROR ON PATH" + "\n" + "Path doesn't exist");
            exist = false;
        }

        return exist;
    }
}
