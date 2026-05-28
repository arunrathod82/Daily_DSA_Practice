package Trie;

/*
Problem: Longest Common Suffix Queries
Platform: LeetCode
Approach: Trie (Reversed Words)
Time Complexity:
Insert  -> O(total characters)
Search  -> O(query length)

Space Complexity: O(total characters)
*/

import java.util.*;

public class LongestCommonSuffixQueries {

    class TrieNode {

        TrieNode[] children = new TrieNode[26];

        int index;
        int length;

        public TrieNode() {

            index = -1;
            length = Integer.MAX_VALUE;
        }
    }

    TrieNode root = new TrieNode();

    // Insert reversed word into trie
    public void insert(String word, int idx) {

        TrieNode node = root;

        // Update shortest word at root
        if(word.length() < node.length) {
            node.length = word.length();
            node.index = idx;
        }

        for(int i = word.length() - 1; i >= 0; i--) {

            char c = word.charAt(i);

            int ch = c - 'a';

            if(node.children[ch] == null) {
                node.children[ch] = new TrieNode();
            }

            node = node.children[ch];

            // Store shortest word index
            if(word.length() < node.length) {

                node.length = word.length();
                node.index = idx;
            }
        }
    }

    // Search best suffix match
    public int search(String word) {

        TrieNode node = root;

        for(int i = word.length() - 1; i >= 0; i--) {

            char c = word.charAt(i);

            int ch = c - 'a';

            if(node.children[ch] == null) {
                break;
            }

            node = node.children[ch];
        }

        return node.index;
    }

    public int[] stringIndices(
            String[] wordsContainer,
            String[] wordsQuery) {

        // Build Trie
        for(int i = 0; i < wordsContainer.length; i++) {

            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        // Process queries
        for(int i = 0; i < wordsQuery.length; i++) {

            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        LongestCommonSuffixQueries solution =
                new LongestCommonSuffixQueries();

        String[] wordsContainer = {
                "abcd",
                "bcd",
                "xbcd"
        };

        String[] wordsQuery = {
                "cd",
                "bcd",
                "xyz"
        };

        int[] result =
                solution.stringIndices(
                        wordsContainer,
                        wordsQuery
                );

        System.out.println(
                "Result: " +
                Arrays.toString(result)
        );
    }
}
