package com.yx.sort;

/**
 * 二分法 实现
 * @author yx start
 * @create 2020/6/21,15:06
 */
public class BinarySearch {
    // 计算会递归多少次
    private static int runNum = 0 ;
    public static void main(String[] args) {
        // 构建查询数组长度
        int[] arrays =  new int[100];
        for (int i = 0; i < 100 ; i++) {
            arrays[i] = i+1 ;
        }
        // 查询数据的位置
        int fieldValue = 44;
       int position =  binarySearch(arrays,0,arrays.length-1,fieldValue);
        System.out.println("元素的位置=>"+fieldValue+"==位置在>"+position+1+"运行次数="+runNum );
    }

    private static int binarySearch(int[] arrays, int start, int end, int fieldValue) {
        runNum ++;
        // 通过发现输入头和尾的数据时 需要运行6次，简化一下
        if( arrays[start]==fieldValue ){
            return start ;
        }
        if(arrays[end] == fieldValue){
            return end;
        }
        // 起始位置关系
        if(start<=end){
            System.out.println("当前开始"+start+",当前结束"+end);
            // 中间位置
            int middlePosition = (start+end)/2;
            // 中间值的位置
            int middleValue = arrays[middlePosition];
            // 如果正好符合
            if(middleValue == fieldValue){
                return middlePosition;
            }
            // 说明在区间的左边
            if(middleValue > fieldValue){
               return  binarySearch(arrays,start,middlePosition-1,fieldValue);
            }
            // 说明在区间的右边
            if(middleValue < fieldValue){
                return  binarySearch(arrays,middlePosition+1,end,fieldValue);
            }
        }
        return -1;
    }
}
