// all solutions need to be pick so we use the for loop into the recursive function and keep calling it

class Solution {
    int[][] serves = {{100, 0}, {75, 25}, {50, 50}, {25, 75}};
    double[][] t;

    public double solve(double A, double B) {
        if (A <= 0 && B <= 0)
            return 0.5;

        if (A <= 0)
            return 1.0;
        if (B <= 0)
            return 0.0;

        if (t[(int) A][(int) B] != -1.0)
            return t[(int) A][(int) B];

        double probability = 0.0;

        for (int i = 0; i < serves.length; i++) {
            int A_serve = serves[i][0];
            int B_serve = serves[i][1];

            probability += 0.25 * solve(A - A_serve, B - B_serve);
        }

        return t[(int) A][(int) B] = probability;
    }

    public double soupServings(int n) {
        if (n >= 5000)
            return 1.0;

        t = new double[n + 1][n + 1];
        for (double[] arr : t) {
            Arrays.fill(arr, -1.0);
        }

        return solve(n, n);
    }
}
