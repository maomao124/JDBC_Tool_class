import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FunctionTest
{
    Function function = new Function();

    @org.junit.jupiter.api.Test
    void find()
    {
        ArrayList<Student> list = function.find();
        for (Student student : list)
        {
            System.out.println(student.getNo() + "\t\t" + student.getName() + "\t\t" + student.getSex() + "\t\t" + student.getAge());
        }
        System.out.println();
    }

    @org.junit.jupiter.api.Test
    void findById()
    {
        Student student = function.findById(1547);
        System.out.println("学号：" + student.getNo() + "\t\t" + "姓名：" + student.getName() +
                "\t\t" + "性别：" + student.getSex() + "\t\t" + "年龄：" + student.getAge());
        System.out.println();
    }

    @org.junit.jupiter.api.Test
    void insert()
    {
        Function function = new Function();
        Student student1 = new Student(13, "杨某人", "男", 20);
        int result = function.insert(student1);
        if (result == 0)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("插入失败！");
        }
        else
        {
            System.out.println("插入成功");
        }
        System.out.println();
        ArrayList<Student> list = function.find();
        for (Student student : list)
        {
            System.out.println(student.getNo() + "\t\t" + student.getName() + "\t\t" + student.getSex() + "\t\t" + student.getAge());
        }
        System.out.println();
    }

    @org.junit.jupiter.api.Test
    void update()
    {
        Function function = new Function();
        Student student1 = function.findById(13);
        student1.setName("杨某");
        int result = function.update(student1);
        if (result == 0)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("更新失败！");
        }
        else
        {
            System.out.println("更新成功");
        }
        System.out.println();

        ArrayList<Student> list = function.find();
        for (Student student : list)
        {
            System.out.println(student.getNo() + "\t\t" + student.getName() + "\t\t" + student.getSex() + "\t\t" + student.getAge());
        }
        System.out.println();
    }

    @org.junit.jupiter.api.Test
    void testUpdate()
    {

    }

    @org.junit.jupiter.api.Test
    void delete()
    {
        Function function = new Function();
        int result = function.delete(13);
        if (result == 0)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("删除失败！");
        }
        else
        {
            System.out.println("删除成功");
        }
        System.out.println();

        ArrayList<Student> list = function.find();
        for (Student student : list)
        {
            System.out.println(student.getNo() + "\t\t" + student.getName() + "\t\t" + student.getSex() + "\t\t" + student.getAge());
        }
        System.out.println();
    }

    @org.junit.jupiter.api.Test
    void sort()
    {
        {
            Function function = new Function();
            ArrayList<Student> list = function.sort("no", "desc");

            for (Student student : list)
            {
                System.out.println(student.getNo() + "\t\t" + student.getName() + "\t\t" + student.getSex() + "\t\t" + student.getAge());
            }
        }
        System.out.println();
        System.out.println();
        {
            Function function = new Function();
            ArrayList<Student> list = function.sort("name", "asc");

            for (Student student : list)
            {
                System.out.println(student.getNo() + "\t\t" + student.getName() + "\t\t" + student.getSex() + "\t\t" + student.getAge());
            }
        }
        System.out.println();
        System.out.println();
        {
            Function function = new Function();
            ArrayList<Student> list = function.sort("name", "desc");

            for (Student student : list)
            {
                System.out.println(student.getNo() + "\t\t" + student.getName() + "\t\t" + student.getSex() + "\t\t" + student.getAge());
            }
        }
        System.out.println();
        System.out.println();
        {
            Function function = new Function();
            ArrayList<Student> list = function.sort("sex", "asc");

            for (Student student : list)
            {
                System.out.println(student.getNo() + "\t\t" + student.getName() + "\t\t" + student.getSex() + "\t\t" + student.getAge());
            }
        }

        System.out.println();
        System.out.println();
        {
            Function function = new Function();
            ArrayList<Student> list = function.sort("sex", "desc");

            for (Student student : list)
            {
                System.out.println(student.getNo() + "\t\t" + student.getName() + "\t\t" + student.getSex() + "\t\t" + student.getAge());
            }
        }

        System.out.println();
        System.out.println();
        {
            Function function = new Function();
            ArrayList<Student> list = function.sort("age", "asc");

            for (Student student : list)
            {
                System.out.println(student.getNo() + "\t\t" + student.getName() + "\t\t" + student.getSex() + "\t\t" + student.getAge());
            }
        }

        System.out.println();
        System.out.println();
        {
            Function function = new Function();
            ArrayList<Student> list = function.sort("age", "desc");

            for (Student student : list)
            {
                System.out.println(student.getNo() + "\t\t" + student.getName() + "\t\t" + student.getSex() + "\t\t" + student.getAge());
            }
        }
        System.out.println();
    }
}