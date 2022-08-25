package java8;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式演示案例
 */
public class HelloLambda {
    /**
     * Lambda表达式快捷开启线程
     * 第一种：无参，无返回值类型
     */
    @Test
    public void test1() {
        Runnable runnable = () -> System.out.println("我爱中国！");
        runnable.run();
    }

    /**
     * 需要参数，但是没有返回值
     */
    @Test
    public void test2() {
        Consumer<String> con = (String s) -> {
            System.out.println("s=" + s);
        };
        con.accept("dahe");
    }

    /**
     * 类型推断
     * 数据类型可以进行省略操作，可以由编译器进行类型推断
     */
    @Test
    public void test3() {
        Consumer<String> con = (s) -> {
            System.out.println("s=" + s);
        };
        con.accept("dahe");
    }

    /**
     * 参数列表只有一个参数，可以省略括号
     */
    @Test
    public void test4() {
        Consumer<String> con = s -> {
            System.out.println("s=" + s);
        };
        con.accept("dahe");
    }

    /**
     * 参数列表有多个参数，并且可以有返回值
     */
    @Test
    public void test5() {
        Comparator<Integer> comparator = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(comparator.compare(521, 1314));
    }
}
