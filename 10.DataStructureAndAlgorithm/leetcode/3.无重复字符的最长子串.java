import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (39.01%)
 * Likes:    8201
 * Dislikes: 0
 * Total Accepted:    2M
 * Total Submissions: 5.1M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        // 个人方法：通过率 251/987
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i);
            set.add(str);
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            String str = s.substring(0, i);
            set.add(str);
        }

        boolean flag = true;
        Map<Integer, String> map = new HashMap<>();
        int k = 1;
        String targetStr = "";
        for(String str : set){
            char[] c = str.toCharArray();

            for (int i = 0; i < c.length; i++) {
                flag = true;
                for (int j = i + 1; j < c.length; j++) {
                    if(c[i] == c[j]){
                        flag = false;
                        break;
                    }
                }
                if(flag == false){
                    break;
                }
            }
            
            if(flag == true){
                map.put(k, str);
                k +=1;
            }
        }

        for(Integer target : map.keySet()){
            if(targetStr.length() < map.get(target).length()){
                targetStr = map.get(target);
            }
        }

        return targetStr.length();
        */

        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                if(ans < j - i){
                    ans = j - i;
                }
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
// @lc code=end

