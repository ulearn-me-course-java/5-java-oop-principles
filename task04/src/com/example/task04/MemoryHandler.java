package com.example.task04;

public class MemoryHandler implements MessageHandler {

    private final String[] messages;
    private final MessageHandler messageHandler;
    private int messageCount;

    /**
     * @param poolLength Количество сохраняемых до логирования сообщений
     * @param messageHandler Обработчик сообщений после переполнения пула
     */
    public MemoryHandler(int poolLength, MessageHandler messageHandler) {
        messages = new String[poolLength];
        this.messageHandler = messageHandler;
    }

    /**
     * @return Количество сохраняемых до логирования сообщений
     */
    public int getPoolLength() {
        return messages.length;
    }

    /**
     * Возвращает массив содержащихся сообщений
     *
     * @return Копия массива сообщений
     */
    public String[] getMessages() {
        String[] output = new String[messageCount];
        System.arraycopy(messages, 0, output, 0, messageCount);
        return output;
    }

    @Override
    public void logMessage(String message) {
        messages[messageCount] = message;
        messageCount++;
        if (messageCount == getPoolLength()) {
            for (String s : messages) {
                messageHandler.logMessage(s);
            }
            messageCount = 0;
        }
    }
}
