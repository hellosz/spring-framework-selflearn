package com.ralph.domain.pojo;

/**
 * @ClassName: Hero
 * @description: 实体类示例
 * @author: Neng.Tian
 * @create: 2024-04-09 17:28
 **/
public class Hero {

    private String name;

    private String sex;

    public void attack() {
        System.out.println("开始攻击~");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
