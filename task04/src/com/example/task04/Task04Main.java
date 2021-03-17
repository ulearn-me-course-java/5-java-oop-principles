package com.example.task04;

import java.util.concurrent.TimeUnit;

public class Task04Main {
    public static void main(String[] args) {

        ConsoleHandler console = new ConsoleHandler();
        console.log("console handler works");

        //FileHandler file = new FileHandler("C:\\test");
        //file.log("FileHandler works");
        //file.log("FileHandler works gooood");

        /*RotationFileHandler rotation = new RotationFileHandler("C:\\test", 5);
        rotation.log("rotation works");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rotation.log(" does rotation works?");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rotation.log(" Yeah it is surely works");*/

        MemoryHandler memory = new MemoryHandler(2);
        memory.log("test1");
        memory.log("test2");
        memory.log("test3");
        memory.log("test4");
    }
}
