package com.practice.ormlite;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testRun() {
        List<String> tags = Arrays.asList("a", "b", "c");
        System.out.println(tags.toString());
        String value = testTemplate("hello");
        System.out.printf(value);

        List<Integer> sourceList = new LinkedList<>();
        List<? extends Object> convertList = sourceList;
        System.out.println((String)convertList.get(0));
        test2(sourceList);
    }

    public static <T extends Object, D> String testTemplate(T value) {
        D value2 = (D) value;
        return value2.toString();
    }


    public List<? extends Number> test2(List<? extends Number> sourceList) {
        List<Number> destList = new LinkedList<>();
        destList.addAll(sourceList);
        return destList;
    }

}