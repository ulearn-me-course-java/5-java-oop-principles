package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandler implements MessageHandler{

    private final String directoryPath;
    private FileWriter writer;
    private File file;

    public FileHandler(String p){
        directoryPath = p;
        createNewFile();
        createNewWriter();
    }

    @Override
    public void log(String message)  {
        createNewWriter();
        try {
            writer.write(message+ "\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createNewFile(){
        file = new File((directoryPath +"\\"+ new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()))+".txt" );
        try {
            boolean b = file.createNewFile();
            if(b) System.out.println("file made");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createNewWriter(){
        try {
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
