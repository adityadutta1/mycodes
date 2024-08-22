import java.util.*;
public class RotatedSortedArray {
    public static int binarySearchRotated(List<Integer> nums, int target) {
            int left=0;
            int right=nums.size()-1;
            while(left<=right)
            {
                int mid=(left+right)/2;
                if(nums.get(mid)==target)
                    return mid;
                if(nums.get(left)<=nums.get(mid))
                {
                    if(target>=nums.get(left) && nums.get(mid)>target)
                    {
                        right=mid-1;
                    }
                    else
                    {
                        left=mid+1;
                    }
                }
                else
                {
                    if(target<=nums.get(right) && nums.get(mid)<target)
                    {
                        left=mid+1;
                    }
                    else
                    {
                        right=mid-1;
                    }
                }
            }
            return -1;


    }
}

