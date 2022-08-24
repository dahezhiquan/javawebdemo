package regularexpression;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式实例
 */
public class RegularExpressionExample {
    /**
     * 验证字符串是不是纯汉字
     */
    @Test
    public void isChinese() {
        String str = "大河之犬";
        String regex = "^[\u0391-\uffe5]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println("格式满足！");
        } else {
            System.out.println("格式不满足！");
        }
    }

    /**
     * 验证邮政编码
     * 1-9开头的六位数
     */
    @Test
    public void isZipCode() {
        String str = "123450";
        String regex = "^[1-9]\\d{5}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println("格式满足！");
        } else {
            System.out.println("格式不满足！");
        }
    }

    /**
     * 验证QQ号
     * 1-9开头的5-10位纯数字
     */
    @Test
    public void isQQ() {
        String str = "256789087";
        String regex = "^[1-9]\\d{4,9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println("格式满足！");
        } else {
            System.out.println("格式不满足！");
        }
    }

    /**
     * 验证手机号码
     * 以13，14，15，18开头的到11位数
     */
    @Test
    public void isPhoneNumber() {
        String str = "13245678901";
        String regex = "^1[3|4|5|8]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println("格式满足！");
        } else {
            System.out.println("格式不满足！");
        }
    }

    /**
     * 验证是否为合法的URL
     * 思路：
     * 1.URL开头部分：https://或者http://
     * 2.通过([\w-]+\.)+[\w-]+$匹配https://blog.csdn.net部分
     * 3.匹配其余部分
     */
    @Test
    public void isUrl() {
        String str = "https://blog.csdn.net/Gherbirthday0916?spm=1010.2135.3001.5343";
        String regex = "^((http|https)://)([\\w-]+\\.)+[\\w-]+(\\/[\\w-?=&/%.#]+)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println("格式满足！");
        } else {
            System.out.println("格式不满足！");
        }
    }
}
