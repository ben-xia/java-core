package com.ben.java.core.json.jackson;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    //    {"name":"YourBatman","age":18,"dog":{"name":"旺财","color":"WHITE"},"hobbies":["篮球","football"]}
    private String name;
    private int age;
    private Dog dog;
    private List<String> hobbies;
}

@Data
class Dog {
    private String name;
//    private Color color;
    private String color;
}
