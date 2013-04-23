package vn.edu.rmit.sadi;

import java.io.Serializable;

public class Person implements Serializable {
    private String userName;
    private transient String password;
    private int age;
    private Person friend;

    public Person(String userName, String password, int age) {
        this.userName = userName;
        this.password = password;
        this.age = age;
    }

    public Person getFriend() {
        return friend;
    }

    public void setFriend(Person friend) {
        this.friend = friend;
    }

    @Override
    public String toString() {
        return userName + ":" + password + " (" + age + ")";
    }
}
