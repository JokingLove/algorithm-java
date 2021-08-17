package com.jokinglove.algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * moka 面试： 查找子列表
 * </p>
 *
 * @author guoyongqiang@forwardx.com
 * @since 2021/8/17 10:26
 */
public class FindSubList {

    public static void main(String[] args) {
        Department department1 = new Department(0, 1, "111");
//        Department department2 = new Department(1, 2, "111");
        Department department3 = new Department(2, 1, "111");
        Department department4 = new Department(3, 1, "111");
        Department department5 = new Department(4, 1, "111");
        Department department6 = new Department(5, 1, "111");
        Department department7 = new Department(6, 5, "111");
        List<Department> allDepartments = new ArrayList<>();
        allDepartments.add(department1);
//        allDepartments.add(department2);
        allDepartments.add(department3);
        allDepartments.add(department4);
        allDepartments.add(department5);
        allDepartments.add(department6);
        allDepartments.add(department7);

        List<Department> sub = getSub(1, allDepartments);
        sub.forEach(System.out::println);

    }

    public static List<Department> getSub(int id, List<Department> allDepartments) {
        List<Department> result = new ArrayList<>();
        for (Department department : allDepartments) {
            if (id == department.getPid()) {
                result.add(department);
                List<Department> sub = getSub(department.getId(), allDepartments);
                if (sub.size() > 0) {
                    result.addAll(sub);
                }
            }
        }
        return result;
    }


    public static class Department {
        private int id;
        private int pid;
        private String name;

        public Department(int id, int pid, String name) {
            this.id = id;
            this.pid = pid;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Department{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                '}';
        }
    }
}
