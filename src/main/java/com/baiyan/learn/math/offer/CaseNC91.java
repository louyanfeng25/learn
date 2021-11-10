package com.baiyan.learn.math.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * NC91 最长上升子序列(三)
 *
 * <href>
 *      https://www.nowcoder.com/practice/9cf027bf54714ad889d4f30ff0ae5481?tpId=117&&tqId=37796&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/10
 */
public class CaseNC91 {

    /**
     * 这道题用的是动态规划加二分查找的思路，
     * 动态数组maxLen保存的是当前下标i所对应元素能形成的最长递增子序列的长度，
     * maxLen[0]初始化为1，动态数组seq没有明确的含义，但其长度是最终的连续递增子序列的长度，
     * 由于算法的原因，seq中保存的元素很接近最后的连续递增子数组，但确实不是最终的连续递增子数组，
     * 原因在下面进行说明。对于数组arr[2,1,5,3,6,4,8,9,7]，
     * 下面开始分析maxLen和seq的生成过程：
     *
     * 初始条件下，maxLen[0] = 1, seq[0] = arr[0]，也即maxLen = [1], seq = [2];
     * 当进来一个新的元素1，由于1比2小，我们在seq中寻找第一个大于等于1的元素，即2，将其替换为1，同时maxLen[1] = seq.size()，即maxLen = [1, 1];
     * 当遍历到5，由于5比1大，直接添加，seq = [1, 5], maxLen[2] = seq.size(), maxLen = [1, 1, 2];
     * 当遍历到3，由于3比5小，在seq中寻找第一个大于等于3的元素，即5，替换，seq = [1, 3], maxLen = [1, 1, 2, 2];
     * 遍历到6，seq = [1, 3, 6], maxLen = [1, 1, 2, 2, 3];
     * 遍历到4，seq = [1, 3, 4], maxLen = [1, 1, 2, 2, 3, 3];
     * 遍历到8，seq = [1, 3, 4, 8], maxLen = [1, 1, 2, 2, 3, 3, 4];
     * 遍历到9，seq = [1, 3, 4, 8, 9], maxLen = [1, 1, 2, 2, 3, 3, 4, 5];
     * 最后遍历到7，seq = [1, 3, 4, 7, 9], maxLen = [1, 1, 2, 2, 3, 3, 4, 5, 4];
     *
     *
     * 可以看到，maxLen含义明确，始终代表的是以当前元素结尾的最长连续子序列的长度，
     * 而seq则多数时候也可以代表最长连续子序列，但因为我们算法的原因，并不完全是最终结果，
     * 比如看第9步，7应该是在9之后的，但我们仍然把它放到了前面，为什么会这样呢？
     * 主要是算法的惯性，当我们遇到一个新的元素比seq当前最后一个元素小的时候，
     * 我们会默认先找到seq中大于等于该元素的第一个元素，并且将其替换为当前元素，
     * 这可以保证在维持当前最大长度的同时，把更小的元素放在前面，
     * 这样在某些情况下可以减小seq中的最大值，保证后面有更多的元素可以加入，
     * 比如有一段序列[8,11,7,9,10],如果没有上面那个动态更新，那seq中是[8,11]，
     * 后面的10就无论如何加不进来了，但有了这个动态更新之后，8会被替换成7，11会被替换成9，
     * 10就可以加到最后的结果里面了。
     *
     * 前一部分利用动态规划和二分查找的方法获得了maxLen和seq数组，
     * 其中有用的信息是seq的size和maxLen的内容，seq的size即是最后res的size，
     *
     *
     * 我们从maxLen从后往前遍历，变量j表示res剩下还未填充的元素，
     * 初始化为res的size，当发现maxLen[i] = j的时候，将j减一（下标），
     * 同时res[j]赋值为arr[i]，从算法的性质可知，
     * maxLen中的元素代表的是以arr[i]结束的最长连续子数组的长度，
     * 因此maxLen中两个数相同的话，越靠后的数据，对应的arr中的数也是越小的，
     * 比如上面第6步中，maxLen = [1, 1, 2, 2, 3, 3]，
     * 最后一个3对应的seq是[1,3,4],倒数第二个3对应的是[1,3,6],我们从后往前遍历，
     * 刚好可以形成一个按ASCII码值排序更小的结果。代码如下:
     *
     * @param arr
     * @return
     */
    public int[] LIS (int[] arr) {
        int len = arr.length;
        //当前下标i所对应元素能形成的最长递增子序列的长度
        List<Integer> maxLen = new ArrayList<>(len);
        //长度为最终的最长子序列的长度
        List<Integer> seq = new ArrayList<>();
        if(len<=1) {
            return arr;
        }
        seq.add(arr[0]);
        maxLen.add(1);
        for(int i=1; i<len; i++){
            if(arr[i]>seq.get(seq.size()-1)){
                seq.add(arr[i]);
                maxLen.add(seq.size());
            }else{
                //二分法寻找在数组中第一个大于等于arr[i]的数据
                int left = 0, right = seq.size();
                while(left<right){
                    int mid = left + (right - left) / 2;
                    if(seq.get(mid)<arr[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                //加入最优长度
                maxLen.add(right+1);
                //替换数值
                seq.set(right,arr[i]);
            }
        }
        //从后往前根据maxLen的长度寻找，从后往前遍历，当seq.size等于maxLen的元素时
        //即为结果数据，又因为算法以最小结尾保存，因此首次遍历到的想等值即为最小的数组。
        int[] res = new int[seq.size()];
        for(int i=maxLen.size()-1, j=seq.size(); j>0; i--){
            if(maxLen.get(i)==j) {
                res[--j] = arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CaseNC91 caseNC91 = new CaseNC91();
        int[] lis = caseNC91.LIS(new int[]{2,1,5,3,6,4,8,9,7});
        Arrays.stream(lis).forEach(System.out::println);
    }
}
