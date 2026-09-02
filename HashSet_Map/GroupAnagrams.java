import java.util.*;

public class GroupAnagrams {

    // Problem: Group Anagrams
    // Platform: LeetCode
    // Approach: HashMap + Sorting
    // Time Complexity: O(n * k log k)
    // Space Complexity: O(n * k)

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String word : strs){

            char[] chars = word.toCharArray();

            // Sort characters to create a common key
            Arrays.sort(chars);

            String key = new String(chars);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        GroupAnagrams solution = new GroupAnagrams();

        String[] strs = {
            "eat",
            "tea",
            "tan",
            "ate",
            "nat",
            "bat"
        };

        List<List<String>> result =
                solution.groupAnagrams(strs);

        System.out.println(result);
    }
}