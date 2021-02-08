package com.knoldus;

public class User {
        private int id;
        private String username;
        private int age;
        private String course;

        public User() {
        }
        public User(int id, String username, int age, String course) {
            this.id = id;
            this.username = username;
            this.age = age;
            this.course = course;
        }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }
    public int getAge(){
            return this.age;
    }
    public String getCourse(){
            return this.course;
    }

        public String toString() {
            return "{id=" +id+ ", name='" + username + "', age=" + age + ", course=" + course + "}";
        }
    }

