package 数组;

import java.util.*;

public class 合并区间 {
    public static void main(String[] args) {
        merge2(new int[][]{{1,3},{2,6},{8,10},{15,17}});
    }

    /**
     * 首先的想法是 记录左右边界值
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        int min = intervals[0][0];
        int max = intervals[0][1];
        if (intervals.length == 1){
            return new int[][]{{min,max}};
        }
        List<List<Integer>> list= new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            int itemMin = min;
            int itemMax = max;
            if (left < min){
                min = left;
            }else if(left > max){
                min = left;
                max = right;
            }
            if (right < min){

            }else if (right == min){

            }else {
                max = right;
            }
            if (itemMin != min || itemMax != max){
                List<Integer> arr = new ArrayList<>();
                arr.add(min);
                arr.add(max);
                list.add(arr);
            }
        }
        int[][] array = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> row = list.get(i);
            array[i] = new int[row.size()];
            for (int j = 0; j < row.size(); j++) {
                array[i][j] = row.get(j);
            }
        }
        return array;
    }

    public static int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (merged.isEmpty() || merged.getLast()[1] < left){
                merged.add(new int[]{left,right});
            }else {
                merged.getLast()[1] = Math.max(merged.getLast()[1],right);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


    public static int[][] merge3(int[][] intervals) {
        // 必须要先排序
        int min = intervals[0][0];
        int max = intervals[0][1];
        if (intervals.length == 1){
            return new int[][]{{min,max}};
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<List<Integer>> list= new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if(list.size() == 0 || left > max){
                min = left;
                max = right;
                List<Integer> arr = new ArrayList<>();
                arr.add(min);
                arr.add(max);
                list.add(arr);
                continue;
            }
            if (right > max){
                list.get(list.size() -1).set(1,right);
            }

        }
        int[][] array = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> row = list.get(i);
            array[i] = new int[row.size()];
            for (int j = 0; j < row.size(); j++) {
                array[i][j] = row.get(j);
            }
        }
        return array;
    }





}
