package com.example.task04;

public class ConsoleHandler implements MessageHandler
{
    @Override
    public void Handle(String message)
    {
        System.out.println(message);
    }
}
