package com.leyou.demo.thymeleafdemo.pojo;

/**
 * @author HackerStar
 * @create 2020-06-25 10:35
 */
public class User {
    String name;
    int age;
    User friend;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, User friend) {
        this.name = name;
        this.age = age;
        this.friend = friend;
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

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }
}
