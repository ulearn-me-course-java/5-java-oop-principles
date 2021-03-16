package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {
        ConsoleHandler ch = new ConsoleHandler();
        ch.log(Level.INFO,"wefghjk");
        ch.log(Level.ERROR, ":LK");

        FileHandler fh = new FileHandler("m.txt");
        fh.log(Level.DEBUG, "df");
        fh.log(Level.WARNING,"qw");

        RotationFileHandler rh = new RotationFileHandler();
        rh.setInterval(60_000);
        rh.log(Level.INFO,"adgsh");
        rh.log(Level.INFO,"sghj");

        MemoryHandler mh = new MemoryHandler(new FileHandler("mh.txt"));
        mh.log(Level.INFO, "info");
        mh.log(Level.INFO, "info1");
        mh.log(Level.INFO, "info2");
        mh.log(Level.INFO, "info3");
        mh.write();
        mh.log(Level.INFO, "info4");
        mh.log(Level.INFO, "info5");
        mh.log(Level.INFO, "info6");
        mh.write();
    }
}
