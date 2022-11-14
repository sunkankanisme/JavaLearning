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



- 排序思路

> **冒泡排序：**依次两两比较交换，每一轮最大的放到最后
>
> **选择排序：**每一轮选择最小的一个元素，存入轮数索引中
>
> **插入排序：**从 0 索引开始构建有序集合，将后续每一个索引都插入到应该存入的位置
>
> **希尔排序：**不断调整间隙，相同间隙的数据分为一组进行插入排序，当间隙为 1 是完成排序（此时是正常的插入排序），可以将较大的元素迅速移到后方
>
> **快速排序：** 选择一个基准点，将小于和大于基准点的数据分别放在基准点左右两侧，然后使用递归对左右两个集合再次进行排序



- 排序算法的比较

https://en.wikipedia.org/wiki/Sorting_algorithm



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



#### 2.2 选择排序

- 实现思路

1 将数组分为 2 个子集, 排序的和未排序的, 每一轮从未排序的子集中选出最小的元素, 放入排序的子集

2 重复上述步骤,直到整个数组有序



- 代码实现

```java
private static void selection(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
        // i 代表每一轮选择最小的元素需要存入的下标

        // s 代表当前轮最小元素的索引
        int s = i;

        // 每一轮循环的开始从 s+1 开始
        for (int j = s + 1; j < a.length - 1; j++) {
            if (a[s] > a[j]) {
                s = j;
            }
        }

        // 将最小值存入索引位置
        if (s != i) {
            swap(a, s, i);
        }

        System.out.println(i + " " + Arrays.toString(a));
    }
}
```



- 与冒泡的比较

1 二者的平均时间复杂度都是O(n^2^)

2 选择排序一般要快于冒泡, 因为交换的次数少

3 但如果集合有序度高,冒泡优于选择

4 冒泡属于稳定排序算法, 而选择属于不稳定排序



#### 2.3 插入排序

- 文字描述

1 将数组分为两个区域，排序区域和未排序区域，每一轮从未排序区域中取出第一个元素，插入到排序区域（需保证顺序)
2 重复以上步骤，直到整个数组有序



- 优化方式

1 待插入元素进行比较时,遇到比自己小的元素,就代表找到了插入位置,无需进行后续的比较

2 插入时可以直接移动元素而不是交换元素



- 代码实现

```java
public static void insert(int[] a) {
    // i 代表待插入元素的索引
    for (int i = 1; i < a.length; i++) {
        // 将待插入的值存入临时变量, 因为后续操作会将当前索引的值覆盖掉
        int t = a[i];

        // j 代表前面部分有序的数组的索引
        // 将比 t 大的有序数组元素向后移动
        int j = i - 1;
        while (j >= 0) {
            if (t < a[j]) {
                a[j + 1] = a[j];
            } else {
                // 在有序数组中, 当元素比 t 小之后, 之前的元素就不需要比较了
                break;
            }

            j--;
        }

        a[j + 1] = t;
        System.out.println(i + " " + Arrays.toString(a));
    }
}
```



- 与选择排序的比较

1 二者的平均时间复杂度都是O(n^2^)

2 大部分情况下,插入都略优于选择

3 有序集合插入的时间复杂度是O(n)

4 插入属于稳定排序算法,而选择属于不稳定排序



- 缺点

当较大的元素在数组的前面的时候,需要很多次的移动操作



#### 2.4 希尔排序

> 解决插入排序较大元素移动次数过多的问题，使用变化的间隙进行分组，对组内的元素进行插入排序，当间隙的值为 1 时，完成一次正常的插入排序即完成数组的排序。

https://en.wikipedia.org/wiki/Shellsort



#### 2.5 快速排序

- 文字描述

1 每一轮选择一个基准点（pivot）进行分区

​		① 让小于基准点的元素进入一个分区，大于基准点的进入另一个分区

​		② 当分区完成之后，基准点元素的位置就是其最终位置

2 在子分区内重复以上过程，直至分区元素个数少于等于1，这体现的是分而治之的思想



- 实现方式

```java
public static void quick(int[] a, int low, int high) {
    // 只有一个元素或没有元素的时候完成递归
    if (low >= high) return;

    // p 为基准点的正确索引值
    int p = partition(a, low, high);

    // 左边递归, 修改范围
    quick(a, low, p - 1);

    // 右边递归, 修改范围
    quick(a, p + 1, high);
}
```



`单边循环快排`

1 选择最右元素作为基准点元素

2 j 指针负责找到比基准点小的元素，一旦找到则与 i 进行交换

3 i 指针维护小于基准点元素的边界，也是每次交换的目标索引

4 最后基准点与 i 交换，i 即为分区位置

```java
/*
 * 分区方法
 *
 * 返回值: 代表基准点元素所在的正确索引, 用它可以确定下一轮分区的边界
 */
private static int partition(int[] a, int low, int high) {
    // 定义基准点元素
    int pv = a[high];

    // i 是边界为止
    int i = low;

    // j 从边界开始, 到基准点元素的前一个元素为止
    for (int j = low; j < high; j++) {
        // 查找小于基准点的元素, 找到之后与 i 交换, i++
        if (a[j] < pv) {
            // 优化 2 当 i != j 时再交换
            if (i != j) {
                swap(a, i, j);
            }

            i++;
        }
    }
    // 中间状态
    System.out.println("MIDDLE: " + i + " " + Arrays.toString(a));

    // 将基准点与 i 进行交换, 优化 1 当 i != high 时再交换
    if (i != high) {
        swap(a, i, high);
    }

    System.out.println("RESULT: " + i + " " + Arrays.toString(a));

    return i;
}
```



`双边循环快排` / `霍尔分区方案`

1 选择最左元素作为基准点元素

2 j 指针负责从右向左找比基准点小的元素，i 指针负责从左向右找比基准点大的元素，一旦找到则二者交换（当一个找到另一个没找到时, 则等待另一个），直至 i，j 相交

3 最后基准点与 i（此时 i = j ）交换，i 即为分区位置

```java
private static int partition2(int[] a, int low, int high) {
    // 定义基准点元素
    int pv = a[low];

    int i = low;
    int j = high;

    while (i < j) {
        System.out.println(i + ", " + j + ", " + Arrays.toString(a));
        /*
             * j 从右向左找比基准点小的
             * [i < j]: j 查找之后,作为边界已经发生了改变,所以需要动态的判断
             *
             * 必须先运行 j 找小的的逻辑, 因为最后一步 swap(a, low, i) 会出现问题
             */
        while (i < j && a[j] > pv) {
            j--;
        }

        /*
             * i 从左向右找比基准点大的
             * [i < j]:
             * [<=]: i 的第一个元素就是 pv 要使 i 指针向后移动进行查找条件要更改为 a[i] <= pv
             */
        while (i < j && a[i] <= pv) {
            i++;
        }

        swap(a, i, j);
    }

    // 基准点元素与 i/j 元素进行交换
    swap(a, low, i);

    System.out.println("MIDDLE: " + i + " " + Arrays.toString(a));
    return i;
}
```



- 实现要点

1 基准点在左边，并且要先 j 再 i

2 `while(i < j && a[j] > pv) j--`

3 `while(i < j && a[i] >= pv) i++`



- 快速排序的特点

1 平均时间复杂度是 O(nlog<sub>2</sub>n), 最坏时间复杂度 O(n^2^)

2 数据量较大时, 优势非常明显

3 属于不稳定排序















