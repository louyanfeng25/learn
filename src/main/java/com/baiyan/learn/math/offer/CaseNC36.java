package com.baiyan.learn.math.offer;

/**
 * NC36 在两个长度相等的排序数组中找到上中位数
 *
 * <href>
 *     https://www.nowcoder.com/practice/6fbe70f3a51d44fa9395cfc49694404f?tpId=117&&tqId=37808&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/27
 */
public class CaseNC36 {

    /**
     * 简单逻辑，双指针遍历，当两个指针遍历的个数加起来等于一个数组的size时，结果解释上中位数
     * @param arr1
     * @param arr2
     * @return
     */
    public int findMedianinTwoSortedAray1 (int[] arr1, int[] arr2) {
        int leftArr1 = 0;
        int leftArr2 = 0;
        int res = 0;
        while (leftArr1+leftArr2 < arr1.length){
            if(arr1[leftArr1]<=arr2[leftArr2]){
                res = arr1[leftArr1++];
            }else {
                res = arr2[leftArr2++];
            }
        }
        return res;
    }

    /**
     * 如果每个数组中只有一个元素，较小的那个元素就是整体的上中位数，如果两个元素相等，随便返回哪个都可以。
     *
     * 如果数组中不止一个元素，找到两个数组的中间位置mid1和mid2。
     *
     * 如果arr1[mid1] == arr2[mid2]，不管每个数组中元素的个数是奇数还是偶数，这两个数都可以是整体的上中位数，返回其中一个就可以。
     *
     * 如果arr1[mid1] > arr2[mid2]，每个数组的个数是奇数的情况下：数组arr1中mid1位置以后的数都不可能是整体的上中位数，数组arr2中mid2位置以前的数都不可能是整体的上中位数。所以现在只需要考虑arr1[left1…mid1]、arr2[mid2…right]，这两部分的元素个数相同，它们的上中位数就是整体的上中位数。
     *
     * 如果arr1[mid1] > arr2[mid2]，每个数组的个数是偶数的情况下：数组arr1中mid1位置以后的数都不可能是整体的上中位数，数组arr2中mid2位置以后包括mid2位置，都不可能是整体的上中位数。所以现在只需要考虑arr1[left1…mid1]、arr2[mid2+1…right]，这两部分的元素个数相同，它们的上中位数就是整体的上中位数。
     *
     * arr1[mid1] < arr2[mid2]的情况，分析同上。
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int findMedianinTwoSortedAray2 (int[] arr1, int[] arr2) {
        int l1 = 0;
        int r1 = arr1.length-1;
        int l2 = 0;
        int r2 = arr2.length-1;
        while (l1<r1){
            int mid1 = (r1-l1)/2;
            int mid2 = (r2-l2)/2;
            int k = r1 - l1 + 1;
            if(mid1 == mid2){
                return arr1[mid1];
            }else if(arr1[mid1] > arr2[mid2]){
                //偶数时，arr1右边的数据跟arr2左边的都不可能成为上中位数了
                if(k%2 == 0){
                    r1 = mid1;
                    l2 = mid2+1;
                } else{
                    r1 = mid1;
                    l2 = mid2;
                }
            }
            else if (arr1[mid1] < arr2[mid2]){
                if(k%2 == 0){
                    r2 = mid2;
                    l1 = mid1+1;
                } else {
                    r2 = mid2;
                    l1 = mid1;
                }
            }
        }
        return Math.min(arr1[l1],arr2[l2]);
    }



}
