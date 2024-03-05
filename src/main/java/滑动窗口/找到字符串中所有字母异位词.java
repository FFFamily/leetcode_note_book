package 滑动窗口;

import java.util.*;

public class 找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    /**
     * 怎么才能判断一个字符串是某个字符串的异位词呢
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        int right = 0;
        HashMap<Character,Integer> pmap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pmap.put(c,pmap.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer> smap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        while (right < s.length()){
            char c = s.charAt(right);
            if (pmap.containsKey(c)){
                // 包含
                smap.put(c,smap.getOrDefault(c,0)+1);
            }else {
                left++;
            }
            right++;
            if ((right - left) == p.length()){
                boolean f = true;
                for (Map.Entry<Character, Integer> item : pmap.entrySet()) {
                    if (!Objects.equals(smap.get(item.getKey()), item.getValue())){
                        f = false;
                        break;
                    }
                }
                if (f){
                    res.add(left);
                    left = right;
                    smap = new HashMap<>();
                }else {
                    smap.remove(s.charAt(left));
                    left++;
                }
            }
        }
        return res;
    }

}
