package com.baiyan.learn.math.offer;

/**
 * NC105 二分查找-II
 *
 * <href>
 * https://www.nowcoder.com/practice/4f470d1d3b734f8aaf2afb014185b395?tpId=188&&tqId=38588&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/12/09
 */
public class CaseNc105 {


    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 不要使用(left+right)/2，虽然结果相同，但是若left和right太大，直接相加会导致整形溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                //[left,high]中去寻找第一个target,right在不断的往小值缩小
                right = mid;
            }
        }
        //right>=0是为了应对这种测试用例[],0
        return right >= 0 && nums[right] == target ? right : -1;
    }

}
