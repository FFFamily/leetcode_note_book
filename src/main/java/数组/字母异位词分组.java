package 数组;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class 字母异位词分组 {
    public static void main(String[] args) {
        groupAnagrams1(new String[]{"ac","c"});
    }

    /**
     * 这个方法被 ["ac","c"] 校验住了
     * 原因是 a - a = 0 , 所以 ac 和 c 的 key 值相同
     */
    public static List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<Integer,List<String>> map = new HashMap<>();
        for (String str : strs) {
            int key = 0;
            for (char c : str.toCharArray()) {
                key += c - 'a';
            }
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 替换成 A 能解决 1 中的问题
     * 但是又有了新的 duh 和 ill
     * 小写字母的 ascii 大于 大写字母的，所以会有负值 这是不对的
     * 也就是说 这个 定义 key 的方式不对的
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<Integer,List<String>> map = new HashMap<>();
        for (String str : strs) {
            int key = 0;
            for (char c : str.toCharArray()) {
                key += c - 'A';
            }
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 用这种笨方法定义 key 值
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
