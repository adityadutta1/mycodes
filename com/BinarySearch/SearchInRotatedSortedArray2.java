package com.BinarySearch;
import java.util.*;
public class SearchInRotatedSortedArray2 {
//in this problem usual BinarySearch will fail
    //as we dont know which side id sorted correctly
    // if case arise where arr[left] and arr[right] are equal
    /*
    *
    * arr = [2, 5, 6, 0, 0, 1, 2, 2]
target = 0
At some point during the search, you might have:


left = 0, right = 7, mid = 3
Now the key comparisons would be:
arr[left] = arr[0] = 2
arr[mid] = arr[3] = 0
arr[right] = arr[7] = 2
    *
    * */
    public static boolean search(int[] arr, int target) {

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the target is found at mid
            if (arr[mid] == target) {
                return true;
            }

            // ********** Handle duplicates (important for this problem)
            if (arr[left] == arr[mid] && arr[right] == arr[mid]) {
                left++;
                right--;
                continue;
            }
            // If left half is sorted
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;  // search in left half
                } else {
                    left = mid + 1;   // search in right half
                }
            }
            // If right half is sorted
            else {
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;   // search in right half
                } else {
                    right = mid - 1;  // search in left half
                }
            }
        }

        return false;  // Target not found
    }

}
