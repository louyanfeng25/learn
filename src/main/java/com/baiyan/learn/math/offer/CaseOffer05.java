package com.baiyan.learn.math.offer;

import java.util.Objects;

/**
 * 剑指 Offer 05. 替换空格
 * @author baiyan
 * @time 2021/6/7 17:17
 */
public class CaseOffer05 {

    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (char n:s.toCharArray()) {
            if(Objects.equals(n,' ')){
                builder.append("%20");
            }else {
                builder.append(n);
            }
        }
        return builder.toString();
    }


}
