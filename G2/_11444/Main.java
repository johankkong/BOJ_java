package G2._11444;

import java.util.Scanner;

public class Main {
    private static final long MOD = 1_000_000_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long result = fibo(n);
        System.out.println(result);
    }

    private static long fibo(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long[][] result = matrixPower(new long[][] {{1, 1}, {1, 0}}, n - 2);
        return result[0][0];
    }

    private static long[][] matrixPower(long[][] matrix, long power) {
        long[][] result = new long[][] {{1, 1}, {1, 0}};
        while (power > 0) {
            if ((power & 1) == 1) {
                result = mutiplyMatrix(result, matrix);
            }
            if (power != 1) {
                matrix = mutiplyMatrix(matrix, matrix);
            }
            power >>= 1;
        }
        return result;
    }

    private static long[][] mutiplyMatrix(long[][] matrix1, long[][] matrix2) {
        return new long[][] {
                {((matrix1[0][0] * matrix2[0][0]) + (matrix1[0][1] * matrix2[1][0])) % MOD,
                        ((matrix1[0][0] * matrix2[0][1]) + (matrix1[0][1] * matrix2[1][1])) % MOD},
                {((matrix1[1][0] * matrix2[0][0]) + (matrix1[1][1] * matrix2[1][0])) % MOD,
                        ((matrix1[1][0] * matrix2[0][1]) + (matrix1[1][1] * matrix2[1][1])) % MOD},
        };
    }
}
