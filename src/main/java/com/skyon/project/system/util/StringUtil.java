package com.skyon.project.system.util;

/**
 * @author wangtf
 * @description:
 * @menu
 * @date 2021/10/25 9:48
 */

public class StringUtil {

    /**
     * 判断str1中包含str2的个数
     * @param str1
     * @param str2
     * @return counter
     */
    public static int countStr(String str1, String str2) {
        int counter =0;
        if (StringUtil.isEmp(str1)&&StringUtil.isEmp(str2))
            return 0;
        if (str1.indexOf(str2) == -1) {
            return 0;
        } else if (str1.indexOf(str2) != -1) {
            while(str1.indexOf(str2) >= 0) {
                counter++;
                str1 = str1.substring(str1.indexOf(str2) + str2.length());
            }
            return counter;
        }
        return 0;
    }


    public static boolean isEmp(String str1) {
        if(str1==null||str1=="")
            return true;
        return false;
    }

    public static void main(String[] args) {
                String a = "a,v,a";
                String b = ",";
                System.out.println(countStr(a, b));
            }

}
