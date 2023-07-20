
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i : asteroids) {
            while (!stack.isEmpty() && i < 0 && stack.peek() > 0) {
                int sum = i + stack.peek();
                if (sum > 0) {
                    i = 0; // negative one destroyed
                    break;
                } else if (sum < 0) {
                    stack.pop(); // positive one destroyed
                } else if (sum == 0) {
                    stack.pop(); // Both asteroids destroyed
                    i = 0;
                    break;
                }
            }

            if (i != 0) { // while negative one destroyed or not, positive was pushed
                stack.push(i);
            }
        }

        int[] result = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[i] = stack.peek();
            stack.pop();
            i--;
        }

        return result;
    }
}


