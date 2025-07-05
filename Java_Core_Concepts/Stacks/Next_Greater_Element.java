package Java_Core_Concepts.Stacks;

import java.util.Stack;

public class Next_Greater_Element {

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int nxtGreater[] = new int[n];
        for (int i = n-1; i >= 0; i--) {
            //step-1
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            //step-2
            if (stack.isEmpty()) {
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[stack.peek()];
            }
            //step-3
            stack.push(i);
        }


        for (int a : nxtGreater) {
            System.out.print(a+" ");
        }

    }
}
//next greater right
//next smaller left
//next smaller right