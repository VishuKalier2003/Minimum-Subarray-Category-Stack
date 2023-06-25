/* Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in 
non-decreasing order, then the whole array will be sorted in non-decreasing order. Return the shortest such subarray and 
output its length.
* Eg 1 : nums = [2,6,4,8,10,9,15]      Output = 5 
* Eg 2 : nums = [1,2,3,4]              Output = 0 
* Eg 3 : nums = [1]                    Output = 0 
*/
import java.util.*;
public class MinimumSubarray
{
      public int MinimumContinousSubArraylenght(int nums[])
      {
            Stack<Integer> stackIncrease = new Stack<Integer>();    //* Monotonic Stack -> O(N)
            Stack<Integer> stackDecrease = new Stack<Integer>();    //* Monotonic Stack -> O(N)
            stackDecrease.push(nums[nums.length - 1]);
            stackIncrease.push(nums[0]);
            int lower = 0, upper = 0;      //* Variable Declaration -> O(1)
            for(int i = 0; i < nums.length; i++)     //! Array Traversal -> O(N)
            {
                  if(stackIncrease.peek() <= nums[i])   // If Monotonic Stack is not distorted...
                        stackIncrease.push(nums[i]);
                  else  upper = i;
                  if(stackDecrease.peek() >= nums[i])   // If Monotonic Stack is not distorted...
                        stackDecrease.push(nums[nums.length - i - 1]);
                  else  lower = nums.length - i - 1;
            }
            return Math.abs(lower - upper);    // Getting the Absolute difference of the indices...
      }
      public static void main(String args[])
      {
            // Test Case 1
            int n1[] = {2,6,4,8,10,9,15};
            // Test Case 2
            int n2[] = {1,2,3,4};
            // Test Case 3
            int n3[] = {1};
            MinimumSubarray minimumSubarray = new MinimumSubarray();      // Object creation...
            System.out.println(minimumSubarray.MinimumContinousSubArraylenght(n1));
            System.out.println(minimumSubarray.MinimumContinousSubArraylenght(n2));
            System.out.println(minimumSubarray.MinimumContinousSubArraylenght(n3));
      }
}



//! Time Complexity -> O(N)
//* Space Complexity -> O(k)