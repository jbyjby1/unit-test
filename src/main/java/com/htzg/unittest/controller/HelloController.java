package com.htzg.unittest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String helloWorld(){
        return "hello world!";
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Hello json(){
        Hello hello = new Hello("greetings", "hello world!");
        return hello;
    }

    private class Hello {
        private String title;
        private String value;

        private List<String> list;

        private Hello hello;

        public Hello(){}

        public Hello(String title, String value) {
            this.title = title;
            this.value = value;
            list = new ArrayList<>();
            list.add(title);
            list.add(value);
            Hello hello = new Hello();
            hello.setTitle(title);
            hello.setValue(value);
            this.hello = hello;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }

        public Hello getHello() {
            return hello;
        }

        public void setHello(Hello hello) {
            this.hello = hello;
        }
    }

}
