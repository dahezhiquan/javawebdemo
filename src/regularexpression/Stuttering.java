package regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 结巴去重案例
 * 将结巴的语句恢复为正常的语句
 */
public class Stuttering {
    public static void main(String[] args) {
        String content = "我...要要...学学学学......java";
        // 去掉.
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(content);
        // 将所有的.替换为空
        content = matcher.replaceAll("");

        // 去掉重读的字
        pattern = Pattern.compile("(.)\\1+");
        matcher = pattern.matcher(content);
        content = matcher.replaceAll("$1");
        System.out.println(content);
    }
}
