package com.ccl.snakeyaml;

/**
 * Created by ccl on 16/9/27.
 */

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class HelloSnakeYAML {
    public static void test1() {
        try {
            Yaml yaml = new Yaml();
            URL url = HelloSnakeYAML.class.getClassLoader().getResource("conf.yaml");
            if (url != null) {
                Object obj = yaml.load(new FileInputStream(url.getFile()));
                System.out.println(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        try {
            Contact c1 = new Contact("test1", 1, Arrays.asList(
                    new Phone("home", "1111"),
                    new Phone("work", "2222")));
            Contact c2 = new Contact("test2", 23, Arrays.asList(
                    new Phone("home", "1234"),
                    new Phone("work", "4321")));
            List contacts = Arrays.asList(c1, c2);
            Yaml yaml = new Yaml();
            yaml.dump(contacts, new FileWriter("contact.yaml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("resoult 1");
        test1();
        System.out.println("resoult 2");
        test2();
    }
}
