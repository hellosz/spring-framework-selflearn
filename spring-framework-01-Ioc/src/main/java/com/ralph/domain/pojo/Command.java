package com.ralph.domain.pojo;

/**
 * @ClassName: Command
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-11 08:55
 **/
public class Command {
    private String name;

    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Executing command{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
