package com.liubiao1.leetcode.array;


/**
 * 48. 旋转图像
 * <p>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution48 {

    public static int[][] array3 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    /**
     * 题目中要求原地（不能利用另一个数组）。
     * 解题思路：分析旋转90度后，原位置的数[i][j]在旋转后的位置.
     * <p>
     * 1、最终找到规律：对于矩阵中第 i 行的第 j 个元素，在旋转后，它出现在倒数第 i 列的第 j 个位置。（解题核心）
     * 2、我们应该枚举哪些位置 (row,col) 进行上述的原地交换操作呢？
     * n为偶数：我们需要枚举n^2 / 4 = (n/2) * (n/2) 个位置
     * n为基数：我们需要枚举（n^2-1） / 4 = (（n-1）/2) * (（n+1）/2) 个位置.正中间不用旋转，所以-1
     */
    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                // 交换到指定位置
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }

        return matrix;

    }

    public static void main(String[] args) {
        rotate(array3);
    }

}
