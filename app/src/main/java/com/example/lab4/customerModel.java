package com.example.lab4;

public class customerModel {
    private int id ;
    private String name ;
    private int age;

    private boolean isActive;

    public customerModel(int id, String name, int age ,boolean is) {
        this.id = id;
        this.name = name;
        this.age = age;
        isActive = is;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setisActive(boolean is) {
        isActive = is;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentMod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", is active=" + isActive +
                '}';
    }
}
