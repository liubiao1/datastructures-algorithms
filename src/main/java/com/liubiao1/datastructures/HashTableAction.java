package com.liubiao1.datastructures;

import java.util.Scanner;

/**
 * 手动实现 HashTable
 */
public class HashTableAction {

    public static void main(String[] args) {
        // 创建自建的Hash表,初始化5条链表
        HashTab hashTab = new HashTab(5);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:添加雇员");
            System.out.println("list:添加雇员");
            System.out.println("exit:添加雇员");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入ID");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Employee employee = new Employee(id, name);
                    hashTab.add(employee);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmployeeById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;

            }
        }
    }

    // 创建哈希表，来管理多条链表
    static class HashTab {
        private EmployeeLinkedList[] employeeLinkedListArray;
        private int size;

        // 根据ID查找雇员
        public void findEmployeeById(int id) {
            int employeeLinkedListNo = hashFun(id);
            Employee employee = employeeLinkedListArray[employeeLinkedListNo].findEmployeeById(id);
            if (employee == null) {
                System.out.println("哈希表中没有该雇员");
            }
            System.out.println("找到了，");
        }

        public HashTab(int size) {
            this.size = size;
            employeeLinkedListArray = new EmployeeLinkedList[size];
            for (int i = 0; i < size; i++) {   // 创建的所有链表都要初始化，不然会报空指针
                employeeLinkedListArray[i] = new EmployeeLinkedList();
            }
        }

        // 添加雇员
        public void add(Employee employee) {
            // 根据员工ID确定插入到那条链表中
            int employeeLinkedListNo = hashFun(employee.id);
            employeeLinkedListArray[employeeLinkedListNo].add(employee);  // 插进去
        }

        // 遍历链表
        public void list() {
            for (int i = 0; i < size; i++) {
                employeeLinkedListArray[i].list();
            }
        }

        //编写散列函数 取模法
        public int hashFun(int id) {
            return id % size;
        }
    }

    // 雇员信息
    static class Employee {
        private int id;
        private String name;
        private Employee next;  // 表示下一个雇员，默认为null

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    // 雇员列表，用链表表示
    static class EmployeeLinkedList {
        private Employee head; // 头指针，第一个雇员

        // 添加雇员, id假定默认是自增的
        public void add(Employee employee) {
            if (head == null) {
                head = employee;
                return;
            }
            // 不是第一个雇员，插到最后
            Employee temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next; // 不是最后就后移
            }
            temp.next = employee;
        }

        // 遍历链表
        public void list() {
            if (head == null) {
                System.out.println("链表为空");
                return;
            }
            System.out.println("链表信息为：");
            Employee temp = head;
            while (true) {
                System.out.printf("=> id=%d name-%s\t", temp.id, temp.name);
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            System.out.println();
        }

        // 根据ID查找雇员
        public Employee findEmployeeById(int id) {
            if (head == null) {
                System.out.println("链表为空");
                return null;
            }
            Employee temp = head;
            while (true) {
                if (temp.id == id) {
                    break;
                }
                if (temp.next == null) {
                    temp = null;
                }
                temp = temp.next;
            }
            return temp;
        }
    }
}
