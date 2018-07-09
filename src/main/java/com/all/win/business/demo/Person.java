package com.all.win.business.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @Description:
 * @Author: fakerCoder
 * @Date: 2018/7/6 13:54
 * @Version: 1.0.0
 */
public class Person  {

    private String name ;
    private String address;
    private String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getA(){
        return "this is A";
    }
    public void setExtra(String extra) {
    }
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person();
        person.setName("jack");
        person.setAddress("苏州");
        person.setMobile("13814932489");
        String str = objectMapper.writeValueAsString(person);
        System.out.println(str);

        System.out.println("***************************************************************************************");

        Person person1 = objectMapper.readValue("{\"name\":\"davenkin\",\"address\":\"\"}",Person.class);

        System.out.println("name = " + person1.getName());
        System.out.println("address = " + person1.getAddress());
        System.out.println("mobile = " + person1.getMobile());
        System.out.println("a = " + person1.getA());

        System.out.println("======================================================================================");
        Person per = objectMapper.readValue("{\"name\":\"davenkin\",\"address\":\"\",\"mobile\":null,\"extra\":\"extra-value\"}", Person.class);

        System.out.println("name: " + per.getName());
        System.out.println("address: " + per.getAddress());
        System.out.println("mobile: " + per.getMobile());

    }
}
