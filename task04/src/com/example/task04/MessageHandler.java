package com.example.task04;

import java.io.IOException;

public interface MessageHandler {
    public void publish(RecordLog recordLog) throws IOException;
}
