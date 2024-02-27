package 滑动窗口;

import java.util.HashMap;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0,right= 0;
        int length = s.length();
        if (length == 0){
            return 0;
        }
        // 其实这种情况比如map的value不知道存什么的时候，然后又只需要知道是否保存的有key，只需要用HashSet就行
        HashMap<Character,Character> map = new HashMap<>();
        int res = Integer.MIN_VALUE;
        while(right < length){
            char c = s.charAt(right);
            if (map.containsKey(c)){
                map.remove(s.charAt(left));
                left++;
            }else {
                right++;
                if (res < (right - left)){
                    res = right - left;
                }
                map.put(c,c);
            }
        }
        return res;
    }
}
