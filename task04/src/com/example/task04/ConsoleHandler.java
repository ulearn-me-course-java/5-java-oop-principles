package com.example.task04;

import java.util.List;

public class ConsoleHandler implements MessageHandler{

    Logger logger;

    public ConsoleHandler(){
        this.logger = Logger.getLogger("ConsoleHandlerLogger");
    }

    @Override
    public void log(Level level, String string) {
        logger.log(level, string);
        System.out.println(logger.getLogs().get(logger.getLogs().size() - 1));
    }
}
