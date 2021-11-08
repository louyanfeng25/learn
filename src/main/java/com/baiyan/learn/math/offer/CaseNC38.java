package com.baiyan.learn.math.offer;


import java.util.ArrayList;

/**
 * NC38 螺旋矩阵
 *
 * <href>
 *     https://www.nowcoder.com/practice/7edf70f2d29c4b599693dc3aaeea1d31?tpId=117&&tqId=37738&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/08
 */
public class CaseNC38 {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0){
            return new ArrayList<>();
        }
        int x = 0;
        int y = 0;
        int xLength = matrix.length;
        int yLength = matrix[0].length;
        //1：下行，2右行，3上行，4左行
        int flag = 1;
        ArrayList<Integer> result = new ArrayList<>();
        while (true) {
            if(x<0 || x>=xLength || y<0 || y>=yLength || matrix[x][y]==101){
                break;
            }
            result.add(matrix[x][y]);
            matrix[x][y] = 101;
            if(flag ==1){
                y++;
                if(y==yLength || matrix[x][y] ==101){
                    flag = 2;
                    y--;
                    x++;
                }
                continue;
            }
            if(flag ==2){
                x++;
                if(x==xLength || matrix[x][y] ==101){
                    flag = 3;
                    x--;
                    y--;
                }
                continue;
            }
            if(flag ==3){
                y--;
                if(y==-1 || matrix[x][y] ==101){
                    flag = 4;
                    y++;
                    x--;
                }
                continue;
            }
            if(flag ==4){
                x--;
                if(x==0 || matrix[x][y] ==101){
                    flag = 1;
                    x++;
                    y++;
                }
                continue;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        CaseNC38 caseNC38 = new CaseNC38();
        int[][] ints = {{1}};
        ArrayList<Integer> list = caseNC38.spiralOrder(ints);
        list.forEach(System.out::println);
    }


}
