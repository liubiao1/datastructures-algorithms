package com.liubiao1.algorithms.sort;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * 冒泡排序：
 * 1、比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 3、针对所有的元素重复以上的步骤，除了最后一个；
 * 4、重复步骤1~3，直到排序完成。
 * <p>
 * 排序过程如下，假设原始数组为  3 9 -1  8
 * <p>
 * 第一趟排序：
 * 3 9 -1 8  //逆序才交换
 * 3 -1 9 8
 * 3 -1 8 9   这次确定了最大值 9
 * 第二趟排序：
 * -1 3 8 9
 * -1 3 8 9  这次确定了第二大的 8
 * 第三趟排序：
 * -1 3 8 9  这次确定了第三大的 3
 * 冒泡排序规则总结：
 * 1、一共进行了数组大小 - 1 次循环
 * 2、每一趟排序的次数在减少，因为每次都确定了一个最大或者最小的数
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {3, 9, -1, 8};
        // 从分析和结果来看明显存在缺陷，其实很早就有序了，但是还是不断的扫描
//        print(array, array.length);
        // 增加flag，如果一次没交换可以直接终止,  明显就只需要扫描2躺
//        print1(array, array.length);
        // 测试冒泡的速度, 时间复杂都为 n * n,
        int[] test = new int[20000];
        for (int i = 0; i < test.length; i++) {
            test[i] = (int) (Math.random() * 50000);
        }
        int begin = LocalDateTime.now().getNano();
        print1(test, test.length);
        int end = LocalDateTime.now().getNano();
        System.out.println("总共花了" + (end - begin) + "纳秒");
//        Arrays.stream(test).forEach(System.out::print);
//        System.out.println(Arrays.toString(test));
    }

    private static void print1(int[] array, int length) {
        boolean flag = false;
        for (int i = 1; i < length; i++) {
            if (array[i] < array[i - 1]) {
                flag = true; //进来过
                int j = array[i];
                array[i] = array[i - 1];
                array[i - 1] = j;
            }
        }
        if (flag == false) {
            return;
        } else {
            flag = false;
        }
//        //第几趟
//        int m = array.length - length + 1;
//        Arrays.stream(array).forEach(new IntConsumer() {
//            @Override
//            public void accept(int value) {
//                System.out.println("第" + m + "躺结果为" + value);
//            }
//        });
        if (length - 1 > 0) {
            print1(array, length - 1); /*** 递归可能抛出StackOverflowError异常，因为虚拟机栈溢出，函数调用的太深了。通过设置虚拟机参数-Xss10m，为虚拟机栈分配了10M的内存，使这个算法可以正常执行***/
        }
    }

    // 每一趟方法
    private static void print(int[] array, int length) {
        for (int i = 1; i < length; i++) {
            if (array[i] < array[i - 1]) {
                int j = array[i];
                array[i] = array[i - 1];
                array[i - 1] = j;
            }
        }
        //第几趟
        int m = array.length - length + 1;
        Arrays.stream(array).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println("第" + m + "躺结果为" + value);
            }
        });
        if (length - 1 > 0) {
            print(array, length - 1);
        }
    }

}
