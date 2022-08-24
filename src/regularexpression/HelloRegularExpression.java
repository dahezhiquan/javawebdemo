package regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式快速入门
 */
public class HelloRegularExpression {
    public static void main(String[] args) {
        String content = "Go的语法接近C语言，但对于变量的声明有所不同。Go支持垃圾回收功能" +
                "。Go的并行模型是以东尼·霍尔的通信顺序进程（CSP）为基础，采取类似模型的" +
                "其他语言包括Occam和Limbo，但它也具有Pi运算的特征，比如通道传输。在" +
                "1.8版本中开放插件（Plugin）的支持，这意味着现在能从Go中动态加载部分" +
                "函数。\n" +
                "与C++相比，Go并不包括如枚举、异常处理、继承、泛型、断言、虚函数等功" +
                "能，但增加了 切片(Slice) 型、并发、管道、垃圾回收、接口" +
                "（Interface）等特性的语言级支持。Go 2.0版本将支持泛型，对于断言的" +
                "存在，则持负面态度，同时也为自己不提供类型继承来辩护。\n" +
                "不同于Java，Go内嵌了关联数组（也称为哈希表(Hashes)或字典" +
                "(Dictionaries) ），就像字符串类型一样。a11c8abcABCaBc";

        // 实例：找到文本中的所有英文单词（含字母）
        // 先创建一个Pattern模式对象
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        // 创建一个匹配器对象
        Matcher matcher = pattern.matcher(content);
        // 开始匹配
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }

        // 实例：找到a-z之间的任意一个字符
        Pattern pattern1 = Pattern.compile("[a-z]");
        Matcher matcher1 = pattern1.matcher(content);
        while (matcher1.find()) {
            System.out.println("2找到：" + matcher1.group(0));
        }

        // 实例：找到abc字符，不区分大小写
        Pattern pattern2 = Pattern.compile("(?i)abc");
        Matcher matcher2 = pattern2.matcher(content);
        while (matcher2.find()) {
            System.out.println("3找到：" + matcher2.group(0));
        }

        // 实例：找到abc字符，b不区分大小写
        Pattern pattern3 = Pattern.compile("a((?i)b)c");
        Matcher matcher3 = pattern3.matcher(content);
        while (matcher3.find()) {
            System.out.println("4找到：" + matcher3.group(0));
        }

        // 实例：找到abc字符，不区分大小写，设置参数的方式
        Pattern pattern4 = Pattern.compile("abc", Pattern.CASE_INSENSITIVE);
        Matcher matcher4 = pattern4.matcher(content);
        while (matcher4.find()) {
            System.out.println("5找到：" + matcher4.group(0));
        }

        // 实例：找到非数字字母字符的所有字符（含中文）
        Pattern pattern5 = Pattern.compile("\\W", Pattern.CASE_INSENSITIVE);
        Matcher matcher5 = pattern5.matcher(content);
        while (matcher5.find()) {
            System.out.println("6找到：" + matcher5.group(0));
        }
    }
}
