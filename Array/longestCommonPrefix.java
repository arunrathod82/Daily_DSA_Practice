/*
Problem: Longest Common Prefix
Approach: Horizontal Scanning (reduce prefix until all strings match)
Time Complexity: O(n * m)
n = number of strings
m = length of the shortest string
Space Complexity: O(1)
*/
public class longestCommonPrefix {

    public String longestCommonPre(String[] strs) {

        String prefix = strs[0];

        for(int i = 1; i < strs.length; i++){
            while(!strs[i].startsWith(prefix)){
                if(prefix.isEmpty()){
                    return "";
                }
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        longestCommonPrefix sol = new longestCommonPrefix();

        String[] strs = {"flower", "flow", "flight"};

        System.out.println("Longest Common Prefix: " + sol.longestCommonPre(strs));
    }
}
