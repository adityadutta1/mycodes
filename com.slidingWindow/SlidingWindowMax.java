public class SlidingWindowMax {

    //removing from array list takes O (Length of array) if we remove from starting of an array
    //therefore we use the queue ds to optimize our solution further

        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> deque = new ArrayDeque<>();
            int n = nums.length, ind = 0;
            int[] res = new int[n - k + 1];


    /*
    peekFirst
    pollFirst
    addFirst
    addLast
    */
            for (int i = 0; i < n; i++) {
                // need to keep the queue in monotinically decreasing
                // keep a queue in decreasing order, as on the front(first) there must be maximum
            /*my comment
            this will check whther we have an decreasing deque for incoming element  , if not we remove from last
            */

                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                    deque.pollLast();

                deque.addLast(i);

                while (!deque.isEmpty() && (i - deque.peekFirst()) >= k)
                    deque.pollFirst();

                if (i >= (k - 1))
                    res[ind++] = nums[deque.peekFirst()];
            }
            return res;
        }
    }

