package com.cowboy.sbe.others;/**
 * Created by Administrator on 2017/11/15/0015.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-15 9:36
 **/
public class PatternTest {
    public static void main(String[] args) {
        String sr = "dada ada adad adsda ad asdda adr3 fas daf fas fdsf 234 adda";
        //包含两个匹配组，一个是三个字符，一个是匹配四个字符
        Pattern pet = Pattern.compile("\\b(\\w{3}) *(\\w{4})\\b");
        Matcher match = pet.matcher(sr);
        int countAll = match.groupCount();//2
        while (match.find()) {
            System.out.print("匹配组结果：");
            for (int i = 0; i < countAll; i++) {
                System.out.print(String.format("\n\t第%s组的结果是:%s",i+1,match.group(i + 1)));
            }
            System.out.print("\n匹配的整个结果:");
            System.out.println(match.group());
        }
    }
}
