package com.ccl.reflect;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by ccl on 16/8/29.
 */
public class TestMain {
    public static void main(String[] args) {
        Student stu = new Student();
        try {
            //Field field = Student.class.getField("pub");//获取类的public 字段
            Field field = stu.getClass().getDeclaredField("id");//可以获取一个类的所有字段
            System.out.println(field);
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), stu.getClass());
            //获得set方法
            Method method = pd.getWriteMethod();
            method.invoke(stu, 12);
            //获得get方法
            Method get = pd.getReadMethod();
            Object getValue = get.invoke(stu);
            System.out.println("field:"+field.getName()+"---getValue:"+getValue);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
