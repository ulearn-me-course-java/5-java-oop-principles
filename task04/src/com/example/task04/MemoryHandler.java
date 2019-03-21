package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {
    private final MessageHandler hndl; //win32 flashbacks
    private final int vol;
    private ArrayList<String> mem = new ArrayList<String>();

    public MemoryHandler(MessageHandler hndl, int vol) {
        this.vol = vol;
        this.hndl = hndl;
    }

    public void collectprint(String msg){
        mem.add(msg);

        if(mem.size() == vol){
            for(String e : mem){
                hndl.print(e);
            }
        }

        mem.clear();
    }


    @Override
    public void print(String msg) {
        for (String e : mem) {
            hndl.print(e);
        }

        mem.clear();
    }
}
