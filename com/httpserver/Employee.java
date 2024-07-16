package com.httpserver;

public class Employee {
    private String name;
    private String email;
  Employee(){
      this.name ="";
      this.email ="";
  }
  Employee(String name, String email){
      this.name = name;
      this.email = email;
  }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "{"+"\n"+"  \"name\": "+name+"\n"+"  \"email\": "+email+"\n"+"}";
    }
}
