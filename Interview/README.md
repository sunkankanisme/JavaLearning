# Java 面试八股

## 1 二分查找

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



## 2 排序算法

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



### 2.1 冒泡排序

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



### 2.2 选择排序

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



### 2.3 插入排序

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



### 2.4 希尔排序

> 解决插入排序较大元素移动次数过多的问题，使用变化的间隙进行分组，对组内的元素进行插入排序，当间隙的值为 1 时，完成一次正常的插入排序即完成数组的排序。

https://en.wikipedia.org/wiki/Shellsort



### 2.5 快速排序

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



## 3 集合

- 目标

1 掌握 Arraylist 的扩容机制

2 掌握 Iterator 的 fail-fast、fail-safe 机制



### 3.1 Arraylist

#### 3.1.1 扩容机制

- `add`

无参的 ArrayList 默认初始大小是 0，当添加新元素时，触发首次扩容大小为 10，使用新数组代替旧数组。当数组元素满了之后触发第二次扩容，扩容至当前大小的 1.5 倍，计算方式是 `oldSize + (oldSize >> 1)`。

`0 -> 10 -> 15 -> 22 -> ...`



- `addAll(Collection e)`

无元素：`max(10, 实际元素个数)`

有元素：`max(原容量 * 1.5, 实际元素个数)`



#### 3.1.2 迭代器特性

> fail-fast：一旦遍历时发现更改，则抛出异常
>
> fail-safe: 一旦遍历时发现更改，应当能有应对策略，例如牺牲一定的一致性让整个遍历完成



ArrayList 采用的是 fail-fast，当在遍历过程中修改之后会抛出并发修改异常，CopyOnWriteArrayList 采用的是 fail-safe

- 实现原理

> fail-fast：`iter.modCount != list.expectedModCount`
>
> fail-safe:  使用快照记录当前集合，对快照进行遍历，添加元素时将原数组复制出来再添加不会影响到旧数组（读写分离）



### 3.2 LinkedList

#### 3.2.1 ArrayList 和 LinkedList

|              | **ArrayList**                                                | **LinkedList**                              |
| ------------ | ------------------------------------------------------------ | ------------------------------------------- |
| 底层数据结构 | 基于数组，需要连续内存                                       | 基于双向链表，无需连续内存                  |
| 随机访问能力 | 随机访问快，基于下标访问                                     | 随机访问慢，要沿着链表遍历                  |
| 增删元素能力 | 尾部插入和删除性能较好，<br/>其他部分插入和删除元素都会移动元素因此性能会低 | 头尾插入性能较高，<br/>中间操作涉及链表遍历 |
| *            | 可以利用 cpu 缓存，局部性原理                                | 占用内存多                                  |



### 3.3 HashMap

#### 3.1 底层数据结构

- Java 1.7 和 1.8 之后有何不同

> jdk 1.7 数组加链表
>
> jdk 1.8 数组加（链表 | 红黑树）



- 为什么使用红黑树，为什么不直接使用树，何时会树化，何时会退化为链表？

**扩容：**HashMap 初始化大小为 16，元素个数超过到总个数的 3 / 4，或当同一链表元素个数超过 8 个且数组容量 <= 64（优先扩容解决链表过长）

**为何使用红黑树：**红黑树用来避免 Dos 攻击，防止链表超长时性能下降，树化是偶然情况；链表的查找、更新的时间复杂度是 O(1)，而红黑树的查找更新时间复杂度是 O(log<sub>2</sub>n)，TreeNode 占用空间也比普通的 Node 大，如非必要尽量还是使用链表

**树化：**链表元素个数超过 8，且数组容量 >= 64。链表过长影响性能，使用二叉树可以提升查找性能

**退化：**在扩容时如果拆分树，树的元素个数小于 6 则会退化为链表；remove 树节点前检查，若 root，root.left，root.right，root.left.left 有一个为 null，也会退化为链表



#### 3.2 索引计算

- 计算方法

计算对象的 hashcode()，在调用 HashMap 的 hash() 方法进行二次哈希，最后 &(capacity - 1) 得到索引

`HashMap.hash(key.hashcode()) & (capacity - 1)`



- 二次哈希的作用

二次哈希是为了综合高位数据，让 hash 分布更为均匀，防止超长链表的产生



- 容量为 2 的 n 次幂的作用

计算索引时，如果是 2 的 n 次幂可以使用位运算代替取模，销量更高；扩容时 `hash & oldCap == 0` 的元素留在原来的位置，不满足的元素 `新位置 = 原始位置 + oldCap`



#### 3.3 put 方法流程

- 基本流程

1 HashMap 是懒惰创建数组的，首次使用才创建

2 计算索引（桶下标）

3 如果桶下标还没有人占用，创建 Node 占位返回

4 如果桶下标已经有人占用

​	① 已经是 TreeNode 走红黑树的添加或者更新逻辑

​	② 是普通的 Node，走链表的添加或更新逻辑，如果链表长度超过树化阈值，走树化逻辑

5 返回前检查容量是否超过了阈值，一旦超过则进行扩容（新添加元素再检查扩容）



- Java 1.7 和 1.8 的 Put 方法有何不同

① 链表插入节点时，1.7 是头插法，1.8 是尾插法

② 扩容时 1.7 是大于等于阈值且没有空位时才扩容，而 1.8 是大于阈值就扩容

③ 1.8 在扩容计算 Node 索引时，会优化



- 加载（扩容）因子为何默认是 0.75f

1 取 0.75 是在空间占用与查询时间之间取得较好的权衡

2 大于这个值，空间节省了，但是链表会较长影响性能

3 小于这个值，冲突减少了，但是扩容会更加频繁，空间占用多



#### 3.4 面试题

- 多线程下的问题

扩容死链（Java 1.7）：链表内的元素相互引用 `a <--> b`

数据错乱（Java 1.7 / 1.8）：丢失插入的数据



- key 是否可以为 null，作为 key 的对象有什么要求？

1 HashMap 的 key 可以作为 null，但 Map 的其它实现则不然

2 作为 key 的对象必须重写 hashcode 和 equals 方法，且 key 的内容不能修改



- String 对象的 hashcode() 是如何设计的，为啥每次乘的是 31

> 目标是达到较为均匀的散列效果，每个字符串的 hashcode 足够独特，31 的散列特性比较好，31 的乘法运算可以被优化



## 4 设计模式

### 4.1 单例模式

> 掌握单例模式常见的 5 种实现方式
>
> 了解 Jdk 中有哪些地方体现了单例模式



- 饿汉式

> 构造方法私有化、定义私有的静态 `private static final` 的成员变量实例，提供获取实例的方法

```java
static class SingletonE implements Serializable {
    private static final SingletonE instance = new SingletonE();

    private SingletonE() {
        // 预防使用反射破坏单例的手段
        if (instance != null) {
            throw new RuntimeException("单例对象不能重复创建");
        }
    }

    public static SingletonE getInstance() {
        return instance;
    }

    // 预防使用序列化破坏单例的手段
    @Serial
    public Object readResolve() {
        return instance;
    }
}
```



- 饿汉式-枚举类

```java
// 使用枚举类创建单例（饿汉式）
enum SingletonEnum {
    INSTANCE;

    private SingletonEnum() {
        System.out.println("private SingletonEnum");
    }

    public static SingletonEnum getInstance() {
        return INSTANCE;
    }
}
```



- 懒汉式-同步方法

```java
static class SingletonL {
    private static SingletonL INSTANCE = null;

    private SingletonL() {
    }

    // 使用同步代码块
    public synchronized static SingletonL getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonL();
        }

        return INSTANCE;
    }
}
```



- 懒汉式-双重检查锁 DCL

```java
static class SingletonL {
    /*
     * 保证线程之间的可见性和有序性
     */
    private static volatile SingletonL INSTANCE = null;

    private SingletonL() {
    }

    // 双重检查锁
    public static SingletonL getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (SingletonL.class) {
                if (INSTANCE != null) {
                    INSTANCE = new SingletonL();
                }
            }
        }

        return INSTANCE;
    }
```

`volatile`：禁止指令重排，`new Instance()` 并不是原子性的，防止对象未完全初始化就被其他线程使用

![image-20221114210629277](C:\Users\sunkl\AppData\Roaming\Typora\typora-user-images\image-20221114210629277.png)



- 懒汉式-内部类

```java
/*
 * 懒汉式单例，推荐
 */
class SingletonInnerClass implements Serializable{
    private SingletonInnerClass() {

    }

    /*
     * 创建静态内部类
     */
    private static class Holder{
        static SingletonInnerClass INSTANCE = new SingletonInnerClass();
    }

    public static SingletonInnerClass getInstance() {
        return Holder.INSTANCE;
    }
}
```



### 4.2 Unsafe

![image-20221114181415041](D:\System\Picture\markdown\README\image-20221114181415041.png)



### 4.3 单例模式案例

> jdk 中的单例模式

`java.lang.Runtime`

```txt

```

`java.lang.System`

```java
public static Console console() {
    if (cons == null) {
        synchronized (System.class) {
            cons = sun.misc.SharedSecrets.getJavaIOAccess().console();
        }
    }
    return cons;
}
```

`java.util.Collections`

```java
// 内部类
java.util.Collections.EmptySet
java.util.Collections#emptyListIterator
```





## 5 并发篇

### 5.1 线程的状态

> 掌握 Java 线程的状态
>
> 掌握 Java 线程状态之间转换
>
> 辨析两种说法，六种状态 vs 五种状态



- Java 线程的状态

![image-20221116102555909](D:\System\Picture\markdown\README\image-20221116102555909.png)

- 五种状态的说法

![image-20221116104725865](D:\System\Picture\markdown\README\image-20221116104725865.png)



### 5.2 线程池的核心参数

- 常用的线程池

- 线程池的核心参数

1 `corePoolSize`：核心线程的数目，最多保留的线程数

2 `maximumPoolSize`：最大线程数目，核心线程 + 救急线程

3 ` keepAliveTime`：生存时间，针对救急线程的空闲存活时间

4 `unit`：时间单位，针对救急线程

5 `workQueue`：阻塞队列，用于存放暂时无法处理的任务

6 `threadFactory`：线程工厂，可以为线程创建时起个好名字

7 `handler`：拒绝策略，四种



**救急线程：**当核心线程都在忙，同时任务队列也放满了，这时候就要使用到救急线程来执行任务。救急线程执行完成之后，受 3，4 条件控制，在时间范围内没有任务则终止救急线程。

**拒绝策略：**当核心线程，任务队列，救急线程都无法处理时，再有新的任务到达时的策略

> AbortPolicy：抛出异常
>
> CallerRunsPolicy：由调用者 submit 线程来执行任务
>
> DiscardPolicy：丢弃任务
>
> DiscardOldestPolicy：丢弃最老的任务，自身加入任务队列中



### 5.2 sleep vs wait

- 共同点

`wait()`, `wait(long)`, `sleep(long)` 的效果都是让当前线程暂时放弃 cpu 的使用权进入阻塞状态



- 不同点

**方法归属不同：**sleep(long) 是 Thread 的静态方法，而 wait(), wait(long) 都是 Object 的成员方法，每个对象都有

**醒来时机不同：**执行 sleep(long) 和 wait(long) 的线程都会在等待指定的毫秒后醒来；wait(long) 和 wait() 还可以被 notify() 唤醒，wait() 如果不唤醒则会一直等待下去；它们都可以被打断唤醒 `new Thread().interrupt()`

**锁的特性不同：**wait() 的调用必须先获取 wait 对象的锁，而 sleep 则无此限制；wait() 会在执行后释放对象锁，允许其他线程获得对象锁，而 sleep 如果在 synchronized 代码块中执行，并不会释放对象锁



### 5.3 lock vs synchronized

- 语法层面

1 synchronized 是关键字，源码在 jvm 中，用 c++ 语言实现

2 Lock 是接口，源码由 jdk 提供，用 Java 语言实现

3 使用 synchronized 时，退出同步代码块即会自动释放锁，而使用 Lock 时，需要手动调用 unlock 方法释放锁

- 功能层面

1 二者均属于悲观锁、都具备锁的互斥、同步、锁重入（给同一个对象加多道锁）功能

2 Lock 提供了许多 synchronized 不具备的功能，例如获取等待状态、公平锁、可打断、可超时、多条件变量

3 Lock 有适合不同场景的实现，如：ReentrantLock，ReentrantReadWriteLock

- 性能层面

1 没有激烈竞争时，synchronized 做了很多优化，如 偏向锁、轻量级锁、性能不错

2 在竞争激烈时，Lock 的实现通常会提供更好的性能



### 5.4 volatile 

- volatile 能否保证线程安全？

> 线程安全主要考虑三个方面：可见性、有序性、原子性
>
> 1 可见性：一个线程对共享变量的修改，另一个线程能看到最新的结果（JIT编译器导致可见性失效）
>
> 2 有序性：一个线程内代码按照编写顺序执行
>
> 3 原子性：一个线程内多行代码以一个整体运行，期间不能有其他线程的代码插队

volatile 修饰的变量只能保证可见性和有序性（加屏障），但是并不能保证原子性















































































