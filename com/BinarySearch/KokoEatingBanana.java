class Solution {
  public static int minEatingSpeed(int[] piles, int h) {
        int low = 1; // Minimum speed
        int totalBananas = 0; // Total bananas
        //**  difference  is that arrays are not sorted
        // so we need to check whether our selected value is correct or not 
        //by everytime passing it via a checking function

        
        // here banana value will be  scanned
//high will be highest in pile
        // Calculate total bananas and set high to maximum pile
        int high = 0; 
        for (int pile : piles) {
            totalBananas += pile;
            high = Math.max(high, pile);
        }

        // Calculate initial mid as total bananas divided by h
        int mid = 0;

        // Perform binary search
        while (low < high) {
            // Adjust mid based on current low and high
            mid = (low + high) / 2;

            if (canFinish(piles, mid, h)) {
                high = mid; // Try to find a smaller speed
            } else {
                low = mid + 1; // Increase the speed
            }
        }

        return low; // This will be the minimum speed
    }
}
