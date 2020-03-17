package com.example.task03;

/**
 * Интерфейс для интервалов времени в определенных единицах
 */
public interface TimeUnit {

    /**
     * Возвращает продолжительность текущего интервала, пересчитанного в миллисекундах.
     *
     * @return количество миллисекунд в текущем интервале
     */
    long toMillis();

    /**
     * Возвращает продолжительность текущего интервала, пересчитанного в секундах.
     * При необходимости округлять по обычным правилам округления (число, меньшее 0.5 переходит в 0, большее или равное - в 1)
     *
     * @return количество секунд в текущем интервале
     */
    long toSeconds();

    /**
     * Возвращает продолжительность текущего интервала, пересчитанного в минутах.
     * При необходимости округлять по обычным правилам округления (число, меньшее 0.5 переходит в 0, большее или равное - в 1)
     *
     * @return количество минут в текущем интервале
     */
    long toMinutes();

    /**
     * Возвращает продолжительность текущего интервала, пересчитанного в минутах.
     * При необходимости округлять по обычным правилам округления (число, меньшее 0.5 переходит в 0, большее или равное - в 1)
     *
     * @return количество часов в текущем интервале
     */
    long toHours();
}
