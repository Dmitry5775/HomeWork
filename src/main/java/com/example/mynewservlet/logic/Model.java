package com.example.mynewservlet.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {

    private static final Model instance = new Model();

    private final Map<Integer,User>model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new HashMap<>();
        model.put(1,new User("Dmitry","Kushkin",10000));
        model.put(2,new User("Nasty","Toropova",20000));
        model.put(3,new User("Anton","Pirogov",150000));
    }
    public void add(User user,int id) {
        model.put(id,user);
    }
    public void remove(int id) {
        model.remove(id);
    }
    public Map<Integer,User> getFrontList() {
        return model;
    }


}
