package com.example.getitems.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum AttributeEnum {
    // Need to match the service values
    Unknown(0),

    // The speed of the character, impacts movement, and initiative
    Speed(10),

    // The defense score, to be used for defending against attacks
    Defense(12),

    // The Attack score to be used when attacking
    Attack(14),

    // Current Health which is always at or below MaxHealth
    CurrentHealth(16),

    // The highest value health can go
    MaxHealth(18);

    // Returns the Localized String
    // Make sure all strings are in the string table
    @Override
    public String toString() {
        switch(this){
            case Unknown:
                return "Unknown";
            case Speed:
                return "Speed";
            case Defense:
                return "Defense";
            case Attack:
                return "Attack";
            case CurrentHealth:
                return "Current Health";
            case MaxHealth:
                return "Max Health";
        }
        return "Unknown";
    }

    private int intValue;
    private static final List<String> VALUES;

    static {
        VALUES = new ArrayList<>();
        for (AttributeEnum someEnum : AttributeEnum.values()) {
            VALUES.add(someEnum.toString());
        }
    }

    public static List<String> getValues() {
        return Collections.unmodifiableList(VALUES);
    }

    AttributeEnum(int value) {
        intValue = value;
    }

    // Lookup the string for the value
    public static String getString(int value){
        for (AttributeEnum item : AttributeEnum.values()) {
            if (value == item.intValue){
                return item.toString();
            }
        }
        return null;
    }

    // Lookup the value for the string
    public static int getValue(String string){
        for (AttributeEnum item : AttributeEnum.values()) {
            if (string.equals(item.toString())){
                return item.intValue;
            }
        }
        return -1;
    }

}