package com.ben.java.core.serialize.json;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserGroup {
    private String name;
    private List<User> users = new ArrayList<User>();
}
