# Java 面试八股

### 1 二分查找

- 实现思路

> 前提: 要求数据内的元素使有序的

1 定义左右边界 `L, R`，确定搜索范围，循环执行二分查找（2,3）

2 获取中间索引 `m = Floor((L + R) / 2)`

3 获取中间索引的值,与目标值 `T` 进行比较

​	① `arr[M] == T` 表示找到目标,返回中间索引

​	② `arr[M] > T` 表示目标值在中间值左边，将右边界设置为 `M - 1` 重新查找

​	③ `arr[M] < T` 表示目标值在中间值的右边，将左边界设置为 `M + 1` 重新查找

4 当 `L > R` s时，表示没有找到，返回 -1



- 经典二分查找

```java
private static int binarySearch(int[] array, int target) {
    int l = 0, r = array.length - 1, m;

    while (l <= r) {
        m = (l + r) / 2;

        if (array[m] == target) {
            return m;
        } else if (array[m] > target) {
            r = m - 1;
        } else {
            l = m + 1;
        }
    }

    return -1;
}
```





- 避免整数溢出的问题

```java
/*
 * 解决整数溢出问题
 *
 * --- 方案一
 *     (l + r) / 2
 * => l/2 + r/2
 * => l - l/2 + r/2
 * => l - (l/2 - r/2)
 * => l + (r/2 - l/2)
 * => l + (r - l) / 2
 *
 * --- 方案二，使用无符号的右移运算
 * (l + r) >>> 1
 *
 */
```



- 笔试题技巧

> 奇数个元素二分取中间值比较
>
> 偶数个元素二分取中间靠左比较



### 2 排序算法

> 目标：
>
> 掌握常见的排序算法（快排、冒泡、选择、插入等）的实现思路。
>
> 手写冒泡、快排的代码。
>
> 了解各个排序算法的特性，如时间复杂度、是否稳定。



#### 2.1 冒泡排序

- 实现思路

1 依次比较数组相邻两个元素的大小,若 a[i] > a[i+1], 则交换两个元素, 两两都比较一遍称为一轮冒泡, 结果是让最大的元素排至最后

2 重复以上步骤, 直到整个数组有序



- 冒泡算法的实现

```java
public static void bubble(int[] a) {
    for (int j = 0; j < a.length - 1; j++) {
        // 优化 2: 定义一个变量用于标识当前轮是否发生了交换
        // 如果一轮没有发生交换,说明数组已经有序
        boolean swapped = false;

        // 优化 1: 内层循环用于 2 个数字比较, 由于每一轮之后都可以减少一次比较
        // 所以可以利用 j减少内层循环的次数
        for (int i = 0; i < a.length - j - 1; i++) {
            if (a[i] > a[i + 1]) {
                swap(a, i, i + 1);
                swapped = true;
            }
        }

        System.out.println(j + ": " + Arrays.toString(a));
        if (!swapped) break;
    }
}
```



- 优化

1 内层循环的次数可以利用外层循环变量动态减少

2 当一轮完全没有发生交换之后说明数据已经有序, 可以退出排序逻辑

3 记录最后一次交换元素时的下标位置, 作为下一轮排序时的比较次数, 当这个索引值为 0 时表示排序完成



- 使用 优化-3 的思想完成冒泡排序

```java
public static void bubbleV2(int[] a) {
    int n = a.length - 1;

    while (true) {
        // 表示最后一次发生交换时的索引位置
        int last = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("比较次数: " + i);
            if (a[i] > a[i + 1]) {
                swap(a, i, i + 1);
                last = i;
            }
        }

        System.out.println(Arrays.toString(a));

        n = last;
        if (n == 0) break;
    }
}
```

































