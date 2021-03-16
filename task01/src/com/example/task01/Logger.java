package com.example.task01;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.text.MessageFormat;

public class Logger {

    Relevance level = Relevance.DEBUG;
    String message;
    Date date = new Date();
    private static ArrayList<Logger> logs = new ArrayList<Logger>();
    private String loggerName;

    public Logger( Relevance l, String mes){

        level = l;
        message = mes;

    }
    public Logger(String n){
        loggerName = n;
    }

    public void setLoggerName(String n){
            loggerName = n;
    }

    public String getName(){
        return loggerName ;
    }


    public static Logger getLogger(String n){

        for ( Logger  l: logs){
            if(l != null && l.loggerName ==n) return l;
        }
        return new Logger(n);
    }

    private void LogMessage(Relevance l, String mes){
        logs.add(new Logger(l,mes));
        if(level.ordinal() <= l.ordinal() ){
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    l,
                    new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()),
                    loggerName,
                    mes));
        }

    }

    public void setLevel(Relevance l){
        level = l;
    }
    public Relevance getLevel(){
        return level;
    }

    public void debug(String s){
        LogMessage(Relevance.DEBUG, s);
    }
    public void debug(String form,Object ... args){
        debug(MessageFormat.format( form,args));
    }

    public void error(String s){
        LogMessage(Relevance.ERROR, s);
    }
    public void error(String form,Object ... args){
        error(MessageFormat.format(form,args));
    }

    public void info(String s){
        LogMessage(Relevance.INFO, s);
    }
    public void info(String form,Object ... args){
        info(MessageFormat.format(form,args));
    }

    public void warning(String s){
        LogMessage(Relevance.WARNING, s);
    }
    public void warning(String form,Object ... args){
        warning(MessageFormat.format(form,args));
    }

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof Logger)) return false;
        Logger log = (Logger) o;
        return  this.loggerName.equals( ((Logger) o).loggerName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(loggerName);
    }
}
