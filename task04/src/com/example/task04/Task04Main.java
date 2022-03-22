package com.example.task04;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Arrays;

public class Task04Main {
    public static void main(String[] args)throws IOException {
        Logger log = new Logger("test");
        log.setLevel(Logger.SeverityLevels.INFO);
        ArrayList<MessageHandler> messageHandlers = new ArrayList<>();
        log.addMessageHandlers(new MemoryHandler(1, new ConsoleHandler()));
        log.log( Logger.SeverityLevels.INFO, "he");
    }
}
class Logger{

    private String name;
    private SeverityLevels level;
    private static final ArrayList<Logger> loggers = new ArrayList<>();
    private ArrayList<MessageHandler> messageHandlers = new ArrayList<>();

    public Logger(String name){
        this.name = name;
        loggers.add(this);
    }
    public void clearMessageHandlers(){
        messageHandlers.clear();
    }

    public void addMessageHandlers(MessageHandler... handlers){
        messageHandlers.addAll(Arrays.asList(handlers));
    }
    public void setLevel(SeverityLevels severityLevel){
        this.level = severityLevel;
    }
    public SeverityLevels getLevel(){
        return this.level;
    }

    public String getName(){
        return this.name;
    }
    public static Logger getLogger(String name){

        for (Logger log: loggers) {
            if(log.name == name)
                return log;
        }

        return new Logger(name);
    }
    public void log(SeverityLevels severityLevel, String message) throws IOException {

        if (this.level != null && level.compareTo(this.level) < 0) {
            return;
        }
        Date date  = new Date();
        String dateTime = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date);
        String logMessage = String.format("[%s] %s %s - %s", level, dateTime, name, message);
        for (MessageHandler handler: messageHandlers){
            handler.log(logMessage);
        }

    }
    public void log(SeverityLevels severityLevel, String messageTemplate, Object... messageMod) throws IOException {

        log(severityLevel, String.format(messageTemplate, messageMod));
    }

    public void debug(String message) throws IOException{
        log(SeverityLevels.DEBAG, message);
    }
    public void debug(String message, Object... messageMod)throws IOException{
        log(SeverityLevels.DEBAG, String.format(message, messageMod));
    }
    public void info(String message)throws IOException{
        log(SeverityLevels.INFO, message);
    }
    public void info(String message, Object... messageMod)throws IOException{
        log(SeverityLevels.INFO, String.format(message,  messageMod));
    }
    public void warning(String message)throws IOException{
        log(SeverityLevels.WARNING, message);
    }
    public void warning(String message, Object... messageMod)throws IOException{
        log(SeverityLevels.WARNING, String.format(message, messageMod));
    }
    public void error(String message)throws IOException{
        log(SeverityLevels.ERROR, message);
    }
    public void error(String message, Object... messageMod)throws IOException{
        log(SeverityLevels.ERROR, String.format(message, messageMod));
    }
    static enum SeverityLevels {
        DEBAG, INFO, WARNING, ERROR
    }

}
