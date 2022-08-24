package regularexpression;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

/**
 * Pattern类演示
 */
public class PatternTest {
    /**
     * 验证matches方法，用于整体匹配
     * 在验证输入的字符串是否满足条件使用
     */
    @Test
    public void matchesTest() {
        String str = "大河之犬";
        String regex = "^[\u0391-\uffe5]+$";
        boolean matches = Pattern.matches(regex, str);
        System.out.println(matches);
    }
}
