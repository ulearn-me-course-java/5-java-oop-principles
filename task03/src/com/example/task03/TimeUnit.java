package com.example.task03;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * Интерфейс для интервалов времени в определенных единицах
 */
public interface TimeUnit {

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

    long toHours();
    static long division(long a, long b){
        return new BigDecimal(a).divide(new BigDecimal(b), ROUND_HALF_UP).longValue();
    }
}