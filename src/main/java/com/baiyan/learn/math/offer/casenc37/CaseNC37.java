package com.baiyan.learn.math.offer.casenc37;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * NC37 合并区间
 *
 * <href>
 *     https://www.nowcoder.com/practice/69f4e5b7ad284a478777cb2a17fb5e6a?tpId=117&&tqId=37737&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/26
 */
public class CaseNC37 {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals==null || intervals.isEmpty()){
            return intervals;
        }
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
        ArrayList<Interval> results = new ArrayList<>();
        results.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval newNum = intervals.get(i);
            Interval oldNum = results.get(results.size() - 1);
            if(newNum.start<= oldNum.end && newNum.end>=oldNum.end){
                oldNum.end = newNum.end;
            }else if(newNum.start<= oldNum.end){
                continue;
            }else {
                results.add(newNum);
            }
        }
        return results;
    }
}
