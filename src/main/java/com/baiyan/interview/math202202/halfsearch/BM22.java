package com.baiyan.interview.math202202.halfsearch;

/**
 * BM22 比较版本号
 *
 * @author baiyan
 * @date 2022-02-25
 */
public class BM22 {


    public int compare(String version1, String version2) {
        String[] arrayV1 = version1.split("\\.");
        String[] arrayV2 = version2.split("\\.");
        int arrayV1Len = arrayV1.length;
        int arrayV2Len = arrayV2.length;
        for (int i = 0; i < Math.max(arrayV1Len, arrayV2Len); i++) {

            String s1 = i >= arrayV1Len ? "0" : deal(arrayV1[i]);
            String s2 = i >= arrayV2Len ? "0" : deal(arrayV2[i]);
            //先比较长度，compareTo的比较是基于等长字符串的情况下比较的
            if (s1.length() > s2.length()){
                return 1;
            }
            if (s1.length() < s2.length()){
                return -1;
            }
            int result = s1.compareTo(s2);
            if(result!=0){
                return result>0 ? 1:-1;
            }
        }
        return 0;

    }

    /**
     * 去除前导0
     *
     * @param s
     * @return
     */
    public String deal(String s) {
        int l = 0;
        int length = s.length();
        while (l < length && s.charAt(l) == '0') {
            l++;
        }
        String substring = s.substring(l, length);

        return substring.length()>0 ? substring : "0";
    }

    public static void main(String[] args) {
        BM22 bm22 = new BM22();
        //-1
        System.out.println(bm22.compare("1.1","1.1.1"));
        //1
        System.out.println(bm22.compare("2.0.1","2"));
        //1
        System.out.println(bm22.compare("0.226","0.36"));
        //0
        System.out.println(bm22.compare("1.1","1.01"));
        //1
        System.out.println(bm22.compare("1.7000000000","1.6000000000"));
    }

}
