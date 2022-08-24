package regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 选择匹配符
 */
public class ChooseMatch {
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

        Pattern pattern = Pattern.compile("Go|C|Java");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
