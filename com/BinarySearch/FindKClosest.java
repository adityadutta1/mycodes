package com.BinarySearch;

public class FindKClosest {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
    /*
    k closest elements
same code will cover upper and lower bound
int x1=-987987;
while l<r

if arr[mid]=x:
  l=mid+1
  if arr[ l]-x <x1-x
       x1=arr[l]


else if mid>x
	r= mid-1;

 at this point I get first nearest to x
now l++ and l-- in my array will do and select nearest one and add to answer list until k-1 elements are done

result list-

while( count <=k-1 )

   if  arr [l+1] -x < arr[l-1] -x
       then l++
       add arr[l++] in result list

else
 r--
 add[r--] in result list
  */
        List<Integer> result = new ArrayList<>();

        int l = 0, r = arr.length - 1;

        // Binary search to find the position of closest element
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        // After binary search, l is the position where arr[l] >= x, so we set two pointers
        l--;  // Set l to the closest element less than x
        r = l + 1;  // Set r to the closest element greater than or equal to x

        // Expand to find the k closest elements
        while (k > 0) {
            if (l < 0) {
                r++;
            } else if (r >= arr.length) {
                l--;
            } else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                l--;
            } else {
                r++;
            }
            k--;
        }

        // Collect result
        for (int i = l + 1; i < r; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
