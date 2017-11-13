package com.iovine.antonio.activestore.folderdeleter;

import com.iovine.antonio.activestore.dateUtil.DateUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import static java.nio.file.FileVisitResult.*;


public class FolderDeleterPresenter {

    String path;
    int older_days;

    DateUtil du = new DateUtil();

    public FolderDeleterPresenter(String Path, int Older_days){
        this.older_days  = Older_days;
        this.path = Path;
    }

    //Extract the directory from the path
    public String[] getFoldersOfPath(){

        File file = new File(path);
        String[] directories = file.list(new FilenameFilter() {

            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });

        return directories;
    }


    //Searching for folder older than "older_days" and remove them
    public void getListOfFolderToDelete() throws IOException {

        String[] direcories = getFoldersOfPath();

        for(int i = 0; i < direcories.length; i++){

            if( du.getDateDifference(direcories[i], du.getSystemDate()) > older_days ){
                Path pathToDelete = Paths.get(path.concat("/").concat(direcories[i]));
                deleteFileOrFolder(pathToDelete);

            }
        }
    }


    //delete folder and recursively all file into it without any exception.
    public static void deleteFileOrFolder(final Path path) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
            @Override public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs)
                    throws IOException {
                System.out.println("File to delete" + "\n" + file.toString());
                Files.delete(file);
                return CONTINUE;
            }

            @Override public FileVisitResult visitFileFailed(final Path file, final IOException e) {
                return handleException(e);
            }

            private FileVisitResult handleException(final IOException e) {
                e.printStackTrace(); // replace with more robust error handling
                return TERMINATE;
            }

            @Override public FileVisitResult postVisitDirectory(final Path dir, final IOException e)
                    throws IOException {
                if(e!=null)return handleException(e);
                System.out.println("Folder to delete" + "\n" + dir.toString());
                Files.delete(dir);
                return CONTINUE;
            }
        });
    };


}
