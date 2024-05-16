package com.ralph.domain.dao;

/**
 * @ClassName: OuterBeanDao
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-10 08:59
 **/
public class OuterBeanDao {
    public static class InnerBeanDao {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "InnerBeanDao{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
