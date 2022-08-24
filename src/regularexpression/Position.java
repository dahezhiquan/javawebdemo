package regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则定位符
 */
public class Position {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^[0-9]+[a-z]*");
        Matcher matcher = pattern.matcher("123abc");
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }

        Pattern pattern2 = Pattern.compile("^[0-9]\\-[a-z]+$");
        Matcher matcher2 = pattern2.matcher("1-a");
        while (matcher2.find()) {
            System.out.println("找到：" + matcher2.group(0));
        }
    }
}
