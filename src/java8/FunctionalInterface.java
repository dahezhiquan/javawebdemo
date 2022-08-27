package java8;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/**
 * java内置的函数式接口
 */
public class FunctionalInterface {

    /**
     * 体验Consumer接口
     */
    @Test
    public void test1() {
        happyTime(600, money -> System.out.println("给我钱" + money));
    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }
}
