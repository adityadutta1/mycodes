package com.BinarySearch;

import java.util.*;
public class RotatedSortedArray {
    public static int binarySearchRotated(List<Integer> nums, int target) {
            int left=0;
            int right=nums.size()-1;
            while(left<=right)
            {
                int mid=(left+right)/2;
                // Target value is present at the middle of the array


                if(nums.get(mid)==target)
                    return mid;
                // start to mid is sorted
                if(nums.get(left)<=nums.get(mid))
                {
                    if(target>=nums.get(left) && nums.get(mid)>target)
                    {
                        // target is within the sorted first half of the array

                        right=mid-1;

                    }
                    else
                    {
                        // target is not within the sorted first half, so let’s examine the unsorted second half
                        left=mid+1;
                    }
                }
                // mid to end is sorted
                else
                {
                    if(target<=nums.get(right) && nums.get(mid)<target)
                    {
                        // target is within the sorted second half of the array
                        left=mid+1;
                    }
                    else
                    {
                        // target is not within the sorted second half, so let’s examine the unsorted first half
                        right=mid-1;
                    }
                }
            }
            return -1;


    }
}

