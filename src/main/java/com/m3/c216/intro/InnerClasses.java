package com.m3.c216.intro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InnerClasses {

    private List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        InnerClasses ic = new InnerClasses();
        ic.doSomething();

        Student s0 = new Student(1, "Harry P");
        ic.swingExample();
    }

    private void swingExample() {
        JFrame frame = new JFrame();
        JButton button = new JButton("Hello World");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("HW button clicked");
            }
        });
        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    private void doSomething() {
        Student s1 = new Student(1, "Harry P");
        System.out.println("student 1 name=" + s1.name);
        students.add(s1);
        students.add(new Student(2, "Hermione G"));
    }

    private void createClassA() {
        MyClass myClass = new MyClass();
        myClass.register(students.get(1));
        myClass.register(students.get(2));
        System.out.println("number of enrolless = " + myClass.enrollees.size());
    }

    private void createClassB() {
        Enrollable enrollable = new Enrollable() {
            private List<Student> enrollees = new ArrayList<>();

            @Override
            public boolean register(Student s) {
                return false;
            }

            @Override
            public boolean deregister(Student s) {
                return false;
            }

            @Override
            public int getNumEnrollees() {
                return enrollees.size();
            }

            public void winLottery() {
            }
        };

        enrollable.register(students.get(1));
        enrollable.deregister(students.get(2));
        System.out.println("number of enrolless = " + enrollable.getNumEnrollees());
        // enrollable.winLottery();
    }

    public void useRunnable() {
        Runnable r = new MyRunnable();
        r.run();

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("bye");
            }
        };
        r2.run();
    }

    private class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("hi");
        }
    }

    public interface Enrollable {
        boolean register(Student s);

        boolean deregister(Student s);

        int getNumEnrollees();
    }

    public class MyClass implements Enrollable {
        private List<Student> enrollees = new ArrayList<>();

        public boolean register(Student s) {
            return enrollees.add(s);
        }

        public boolean deregister(Student s) {
            return enrollees.remove(s);
        }

        public int getNumEnrollees() {
            return enrollees.size();
        }
    }

    private static class Student {
        private final int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
