package regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 分组
 */
public class Grouping {
    public static void main(String[] args) {
        // 编号分组
        Pattern pattern = Pattern.compile("(\\d\\d)(\\d\\d)");
        Matcher matcher = pattern.matcher("7788 abc7765");
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
            System.out.println("找到分组1：" + matcher.group(1));
            System.out.println("找到分组2：" + matcher.group(2));
        }

        // 命名分组
        Pattern pattern2 = Pattern.compile("(?<g1>\\d\\d)(?<g2>\\d\\d)");
        Matcher matcher2 = pattern2.matcher("7788 abc7765");
        while (matcher2.find()) {
            System.out.println("找到：" + matcher2.group(0));
            System.out.println("找到分组1：" + matcher2.group("g1"));
            System.out.println("找到分组2：" + matcher2.group("g2"));
        }
    }
}
