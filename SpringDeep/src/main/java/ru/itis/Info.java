package ru.itis;

import javax.annotation.PostConstruct;

/**
 * 16.05.2017
 * Info
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Info {
    private String info;

    public Info(String info) {
        System.out.println("IN CONSTRUCTOR");
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void initInfo() {
        System.out.println("IN INIT");
        this.info = "DEFAULT_INFO";
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("IN POST");
        this.info = "MORE_DEFAULT_INFO";
    }
}
