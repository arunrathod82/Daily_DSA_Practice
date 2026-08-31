public class CharacterReplacement {

    // Problem: Longest Repeating Character Replacement
    // Platform: LeetCode
    // Approach: Sliding Window + Frequency Array
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int ans = 0;

        for(int right = 0; right < s.length(); right++){

            int index = s.charAt(right) - 'A';

            freq[index]++;

            maxFreq = Math.max(maxFreq, freq[index]);

            while((right - left + 1) - maxFreq > k){

                int leftIndex = s.charAt(left) - 'A';

                freq[leftIndex]--;

                left++;
            }

            ans = Math.max(
                    ans,
                    right - left + 1
            );
        }

        return ans;
    }

    public static void main(String[] args) {

        CharacterReplacement solution = new CharacterReplacement();

        String s = "AABABBA";
        int k = 1;

        int result = solution.characterReplacement(s, k);

        System.out.println("Answer: " + result);
    }
}