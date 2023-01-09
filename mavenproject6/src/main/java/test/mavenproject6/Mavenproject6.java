/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package test.mavenproject6;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author zg
 */
public class Mavenproject6 {

    public static void main(String[] args) {
        Subscriber sub1 = new Subscriber("zipper01", "123456");
        Subscriber sub2 = (new ObjectMapper()).convertValue(sub1, Subscriber.class);
        System.out.println(sub2.name + ", " + sub2.password);
    }
}
