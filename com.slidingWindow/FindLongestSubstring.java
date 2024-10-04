import java.util.*;
 class FindLongestSubstring {
        public static int findLongestSubstring(String str) {

            // Check the length of input str
            if (str.length() == 0) {
                return 0;
            }

            int n = str.length();
            int windowStart = 0, longest = 0, windowLength = 0, i = 0;

            Hashtable <Character, Integer> lastSeenAt = new Hashtable <Character, Integer> ();

            // Traverse input str to find the longest substring
            // without repeating characters.
            for (i = 0; i < n; i++) {
                // If the current element is not present in the hash map,
                // then store it in the hash map with the current index as the value.
                if (!lastSeenAt.containsKey(str.charAt(i))) {
                    lastSeenAt.put(str.charAt(i), i);
                } else {

                    // If the current element is present in the hash map,
                    // it means that this element may have appeared before.
                    // Check if the current element occurs before or after `windowStart`.
                    if (lastSeenAt.get(str.charAt(i)) >= windowStart) {
                        windowLength = i - windowStart;
                        if (longest < windowLength) {
                            longest = windowLength;
                        }


                        windowStart = lastSeenAt.get(str.charAt(i)) + 1;
                    }

                    // Update the last occurence of
                    // the element in the hash table
                    lastSeenAt.replace(str.charAt(i), i);
                }
            }

            // Update the longest substring's
            // length and starting index.
            if (longest < i - windowStart) {
                longest = i - windowStart;
            }

            return longest;
        }

        //Driver code
        public static void main(String[] arg) {
            String[] inputs = {
                    "abcabcbb",
                    "pwwkew",
                    "bbbbb",
                    "ababababa",
                    "",
                    "ABCDEFGHI",
                    "ABCDEDCBA",
                    "AAAABBBBCCCCDDDD"
            };
            for (int i = 0; i < inputs.length; i++) {
                int str = Solution.findLongestSubstring(inputs[i]);
                System.out.print(i + 1);
                System.out.println("\tInput string: " + inputs[i]);
                System.out.println("\n\tLength of longest substring: " + str);
                System.out.println(new String(new char[100]).replace('\0', '-'));
            }

        }
    }
