package com.boxydev.belote;

import java.util.ArrayList;

public class Bot extends Player {
    private static ArrayList<String> FIRST_NAMES = new ArrayList<String>() {{
        add("Thierry");
        add("Matthieu");
        add("Maxime");
        add("Thomas");
    }};
    private static Integer COUNT = 0;

    public Bot(String name, Integer position) {
        super(name, position);
    }

    public Bot() {
        name = generateName();
        position = ++COUNT;
    }

    private String generateName() {
        int index = (int) (Math.random() * FIRST_NAMES.size());
        String firstName = FIRST_NAMES.get(index);
        FIRST_NAMES.remove(index);
        return firstName;
    }
}
