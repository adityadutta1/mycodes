package com.BinarySearch;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
 /*    //nums1 nums2
     //both sorted
suppose larger array        A .....Aleft|ARight .....
suppose smaller array        B....Bleft|Bright.......B

                But how to find Aleft ARight
                Bleft Bright??
        just find mid and we can get them
                Mid of the combination of both = A.size()+B.size()
        Smaller Array mid->
      mid=  B.size/2 -1

      Larger Array= mid =
      MidOfCombination- mid of smaller array +1 (+1 for smaller mid and +1 for combination  mid and -1 for 0 indexing  )

  Aleft=A[LargerArratMid]
          ARight=A[LargerArrayMid+1]
                  Bleft=B[mid];
BRight=B[mid+1]

     while (not (  Aleft should be less than BRight )   or  (Bleft should be less than ARight))
        Aleft=A[LargerArratMid]  also if LargerArratMid becomes negative then will - inf
        ARight=A[LargerArrayMid+1] if LargerArrayMid EXCEEDS the array length of A then +Inf
        Bleft=B[mid]; similary will be - inf if neg idx
        BRight=B[mid+1] similarly will be + inf if exceeds the array index
               if   not (  Aleft should be less than BRight )
                    vary your smaller array indexes
                that is move idx  of mid in smaller towards left
               if not   (Bleft should be less than ARight)
                    vary your smaller array indexes
                      that is move idx  of mid in smaller towards right

// now we can easily find median
        if combinationarray size is even
                then (max of aleft and bleft) and (min of aright and bright )/2
#######tHING to rememeber max od aleft abd bleft as left side always have 1 extra element
    if combinationarray size id odd
                if aleft+bleft > aright +bright
                return min aleft ,bleft
                else
                    return min aright ,bright
                */
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0, high = x;

        while (low <= high) {
            // Partitioning nums1 and nums2
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            // Aleft, ARight, Bleft, and Bright
            int Aleft = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int ARight = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            int Bleft = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int BRight = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            // Check if we found the correct partition
            if (Aleft <= BRight && Bleft <= ARight) {
                // Now calculate the median
                // If the combined array size is even
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(Aleft, Bleft) + Math.min(ARight, BRight)) / 2;
                } else { // If the combined array size is odd
                    return (double) Math.max(Aleft, Bleft);
                }
            } else if (Aleft > BRight) {
                // Move towards left in nums1
                high = partitionX - 1;
            } else {
                // Move towards right in nums1
                low = partitionX + 1;
            }
        }
            return 0;



    }
}
