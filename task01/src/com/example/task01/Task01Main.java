package com.example.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task01Main {
    public static void main(String[] args) {
        Logger log = new Logger("ASAS", Important.WARNING, "bullshit");
        System.out.println(log);
    }
}
