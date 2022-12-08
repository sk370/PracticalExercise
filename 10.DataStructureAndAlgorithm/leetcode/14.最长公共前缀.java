/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode.cn/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (42.97%)
 * Likes:    2476
 * Dislikes: 0
 * Total Accepted:    946.5K
 * Total Submissions: 2.2M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
                 String str = "";
         String minStr = strs[0];
         int cnnt = 0;
         //数组长度为0，或者为null返回""
         if(strs.length == 0 || strs == null){
             return "";
         }
         //数组中如果有""，返回""
        for(int i=0;i<strs.length;i++){
             if("".equals(strs[i])){
                 return "";
             }
        }
        //找出数组中最短的字符串
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<minStr.length()){
                minStr = strs[i];
            }
        }
        for(int i=0;i<minStr.length();i++){
            str = minStr.substring(0, minStr.length()-i);//最长的情况
            int j=0;
            for(;j<strs.length;j++){
                if(strs[j].startsWith(str)){//如果前缀匹配，就比较下一个字符串
                    continue;
                }
                if(!strs[j].startsWith(str)){//如果前缀不匹配，开始进行下一轮
                    break;
                }
            }
            if(j == strs.length){//如果成立，证明内层for循环正常结束
                return str;
            }
        }
        return "";

    }
}
// @lc code=end

