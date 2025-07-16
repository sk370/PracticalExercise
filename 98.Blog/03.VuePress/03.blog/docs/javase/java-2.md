---
icon: edit
date: 2022-06-15
category:
  - 编程语言
  - Java
# tag:
#   - tag A
#   - tag B
description: 
  - 本文介绍了Java语言的基础，是Java语言的第二部分。
---
# Java语言基础（中）

## 第8章 多线程基础

### 8.1 基本概念

#### 8.1.1 程序、进程、线程

1. 程序（program）：完成特定任务、用某种语言编写的指令集合。是一段静态的代码。
1. 进程（process）：程序的一次执行过程，或者正在运行的一个程序。
   - 进程是系统分配资源的基本单位，根据进程执行的生命周期，系统会为不同时期的进程分配不同的内存空间。
3. 线程（thread）：程序内部的一条执行路径，一个进程可以含有多个进程。
   - 如果一个进程可以**并行**执行多个线程，则进程支持多线程。
   - 每个线程拥有独立的运行栈和程序计数器。
   - 同一进程的多个线程共享相同的堆空间（对象、属性共享）、方法区，优点是线程间通信更便捷、高效，但多个线程同时操作公共资源会有安全隐患。
4. Java中线程的分类（区别在于JVM何时离开）：
   - 守护线程：服务用户线程，通过在start()方法前调用`thread.setDaemon(true)`可以把一个用户线程变成守护线程。
      - 垃圾回收是一个典型的守护线程
      - JVM中都是守护线程时，JVM就会退出。
   - 用户线程：

#### 8.1.2 单核、多核

1. 单核：CPU仅有一个核心数，同一时间内，只能执行一个线程任务。执行多个线程时，采取的是不断切换线程的方式。
   - 由于CPU频率高、线程切换时间短，让人感觉”同时“执行了多个线程
2. 多核：CPU有多个核心，每个核心可以执行一个线程。
2. java.exe：一个Java运行程序至少有3个线程：
   - main()：主线程
   - gc()：垃圾回收线程
   - 异常处理线程：发生异常时，会影响主线程。

#### 8.1.3 并行、并发

1. 并行：多个CPU执行多个任务。
1. 并发：一个CPU同时执行多个任务。

### 8.2 创建多线程

#### 8.1 方式一：继承Thread类

1. 创建步骤：
   - 定义子类继承Thread类
   - 子类中重写Thread类中run()方法
   - 创建Thread子类对象
      - 创建一个对象即代表开启一个线程，要开启多个该线程，需要创建多个该对象。
   - 调用子类对象的start()方法。
2. 注意点：
   - 使用Tread子类对象直接调用`run()`方法不会开启分支线程，它表示在main线程内，调用了Thread子类对象的方法。
   - 使用Thread子类对象调用`start()`方法会开启一个线程，开启线程后`run()`方法何时执行全由CPU调度决定，即main线程和分支线程中的语句执行具有随机性。
   - 一个实例化的Thread子类对象只能调用一次`star()`方法，重复调用时，会抛出异常：IllegalThreadStateException。
3. 常用方法：
   - `start()`：启动当前线程；调用当前线程的run()方法
   - `run()`：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
   - `currentThread()`：静态方法，返回执行当前代码的线程
   - `getName()`：获取当前线程的名字
   - `setName("str")`：设置当前线程的名字
   - `yield()`：释放调用线程在cpu中的执行权，后续执行哪个线程由CPU确定，有可能还是这个线程。当前进程进入就绪状态。
   - `join()`：在线程a中调用线程b的join()，此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态。
      - 有异常问题，可以根据使用位置进行throws或try-catch处理。
   - `~~stop()~~`~~：已过时。当执行此方法时，强制结束当前线程。~~
   - `sleep(long millitime)`：让当前线程“睡眠”指定的millitime毫秒。在指定的millitime毫秒时间内，当前线程是阻塞状态。
      - 有异常问题，由于该方法使用在`run()`方法中，而`run()`方法是对父类Thread中`run()`方法的重写，且Thread中`run()`方法没有抛出异常，根据继承的特性（子类的异常不大于父类），所以子类的`run()`方法不能抛出异常，只能由try-catch处置。
   - `isAlive()`：判断当前线程是否存活。
4. 线程优先级：
   - 等级：
      - `MAX_PRIORITY`：10
      - `MIN _PRIORITY`：1
      - `NORM_PRIORITY`：5 （默认等级）
   - 方法：
      - `getPriority()`：返回线程优先等级
      - `setPriority(int num)`：设置有限等级
   - 注意点：设置了高等级的优先级，并不代表一定执行完该线程后执行其他线程，而是提高了CPU执行该线程的概率而已。
5. Thread类构造器
   - `Thread()`：
   - `Thread(String threadname`)：创建指定名称的线程
      - 搭配`super(threadname)`才能在getName()时获得名字
   - `Thread(Runnable target)`：
   - `Thread(Runnable target, String name)`：  

#### 8.2.2 方式二：实现Runnable接口

1. 创建步骤：
   - 定义类，实现Runnable接口。
   - 实现类中实现Runnable接口中的run方法
   - 创建实现类对象
   - 创建Thread类对象，将实现类对象作为参数传入。
   - 使用Thread类的对象调用`start()`方法。
2. 两种方式比较：
   - 相同点：
      - 实现类（继承类）都需要重写`run()`
      - 都具有线程安全问题
   - 不同点：
      - 方式二没有单继承的局限性
      - 方式二更适合多个线程共享数据（数据只有一份）的情况
   - 开发中优先选择方式二

#### 8.2.3 方式三：实现Callable接口

1. 创建步骤：
   - 创建一个实现Callable的实现类
   - 实现call方法，将此线程需要执行的操作声明在call()中
   - 创建Callable接口实现类的对象
   - 创建FutureTask的对象，将此Callable接口实现类的对象作为传递到FutureTask构造器中
   - 创建Thread对象，将FutureTask的对象作为参数传递到Thread类的构造器中，Thread的对象调用start()
   - FutureTask的实例对象调用get()方法，获取重写call方法的返回值。
2. Callable的优点：
   - call()可以返回值的。
   - call()可以抛出异常，被外面的操作捕获，获取异常的信息。
   - Callable是支持泛型

#### 8.2.4 方式四：使用线程池（ThreadPool）

1. 创建步骤：
   - 提供指定线程数量的线程池：`ExecutorService service = Executors.newFixedThreadPool(10);`
      - `service1.setCorePoolSize(15)`
      - `service1.setKeepAliveTime()`
   - 执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
      - `service.execute(Runnable runable)`
      - `service.submit(Callable callable)`
   - 关闭连接池：`service.shutdown()`
2. 优点：
   - 提高响应速度（减少了创建新线程的时间）
   - 降低资源消耗（重复利用线程池中线程，不需要每次都创建）
   - 便于线程管理：
      - corePoolSize：核心池的大小
      - maximumPoolSize：最大线程数
      - keepAliveTime：线程没任务时最多保持多长时间后会终止

### 8.3 线程的生命周期

1. 新建：
   - 继承方式（方式一）：Thread类子类的对象被创建。
   - 实现方式（方式二）：Thread类声明并创建。
2. 就绪：处于新建状态的线程调用start()后，将进入线程队列等待CPU时间片，此时它已具备了运行的条件，只是没分配到CPU资源
2. 运行：当就绪的线程被调度并获得CPU资源时,便进入运行状态。
2. 阻塞：线程被人为挂起或执行输入输出操作时，会让出 CPU资源，并临时中止自己的执行，即进入阻塞状态。
   - 阻塞时临时状态，不可以作为最终状态。
5. 死亡：线程完成了它的全部工作、线程被提前强制性地中止、出现异常导致结束。
   - 死亡是线程的最终状态。

![image.png](/images/javase/java-2/image.png)

### 8.4 线程安全

#### 5.4.1 线程安全问题——同步机制

1. 线程安全问题：未处理的多线程任务在处理共享数据时，会造成数据破坏（重复数据、缺失数据、数据超范围等）。
   - 原因：处理共享数据的情况时，一个线程多条语句只执行了一部分，未处理完时，另一个线程参与进来，也要处理共享数据，造成共享数据错误。
   - 解决办法：单线程处理数据，执行完后再让其他线程参与——**同步机制**。
   - 解决原理：给共享资源加锁，第一个访问资源的线程进行资源锁定，在解锁之前其他线程无法访问，解锁之后，其他线程可以锁定并使用。

#### 8.4.2 Synchronized处理线程安全问题

1. Synchronized（同步）语法：
   - 同步代码块：`synchronized(同步监视器){}`
   - 同步方法：`public synchronized void show(){}`
2. Synchronized细节：
   - 同步监视器必须唯一。
   - 同步代码块：同步监视器可设置为`类名.class`、`this`、任一对象（静态或非静态），取决于是否唯一。
   - 同步方法：静态方法同步监视器默认为`类名.class`，非静态方法同步监视器默认为`this`
3. 同步监视器一般情况：
   - 在实现Runnable接口创建多线程的方式中，可以考虑使用this充当同步监视器。
     在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。 

#### 8.4.3 死锁及lock处理线程安全问题

1. 死锁：不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源。
   - 出现死锁后，不会出现异常、不会出现提示、程序也不会运行，处于阻塞状态，无法继续。
2. Lock（JDK5.0新增）：
   - 引入`java.util.concurrent.locks.ReentrantLock;`包
      - `java.util.concurrent.locks.Lock`接口是控制多个线程对共享资源进行访问的工具。  
      - `ReentrantLock`类实现了 Lock。
   - 创建`ReentrantLock`对象：`private ReentrantLock lock = new ReenTrantLock();`
      - 根据对象是否唯一（lock是否唯一），可以在声明时使用static、或static final修饰。
   - 在出现共享资源操作的代码前调用`lock()`方法
   - 在结束共享资源操作的代码后调用`unlock()`方法
      - 如果操作资源共享的代码需要使用try包裹，则必须把`unlock()`写入finally语句块，`lock()`则不是必须要写入try中
3. synchronized与Lock的异同：
   - 相同：二者都可以解决线程安全问题
   - 不同：
      - synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器。
      - Lock需要手动的启动同步，同时结束同步也需要手动的实现。
4. 使用的优先顺序：Lock ---> 同步代码块（已经进入了方法体，分配了相应资源 ) --->同步方法（在方法体之外)
   - 同步代码块包裹的共享资源操作代码可以更小。

#### 8.4.4 同步的深入理解

1. 同步的范围：
   - 确定同步代码范围时，要将所有操作共享数据的语句包裹在内。
   - 范围太大：操作数据的语句变为单线程的，没有发挥多线程的功能。
   - 范围太小：操作共享数据的语句由遗漏，同步不起作用。
2. 同步的问题：
   - 优点：解决了线程安全的问题。
   - 缺点：操作同步代码时，只有一个线程运行，其他线程等待，相当于单线程过程，效率低。
3. 释放锁的操作：
   - 同步方法、同步代码块执行结束
   - 同步方法、同步代码块中遇到break、return
   - 同步方法、同步代码块中出现未处理的Error或Exception
   - 同步方法、同步代码块中执行了线程对象的`wait()`
4. 不会释放锁的操作:
   - 同步方法、同步代码块中调用`Thread.sleep()`、`Thread.yield()`方法暂停当前线程的执行
   - 其他线程调用了当前执行线程的`suspend()`方法将该线程挂起。
      - 应尽量避免使用`suspend()`和`resume()`控制线程。
5. 线程安全的懒汉式单例模式

```java
class Singleton {
    private static Singleton instance = null;
    private Singleton() {    }
    //  1. 方式一
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    //  2. 方式二
    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
```

- 方式一效率优于方式二，假如有n个线程需要创建当前对象，多核CPU让k个线程运行到`getInstance()`：
  - 方式一中共有k个线程判断对象是否等于null，1个线程执行同步代码块并创建对象，k-1个线程执行同步代码块结束判断，后续n-k个线程不会再进入同步代码块。
  - 方式二中共有1个线程执行同步代码块并创建对象，k-1个线程执行同步代码块结束判断，后续n-k个线程还会执行同步代码块进行判断。

### 8.5 线程通信

1. `wait()`：一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
1. `notify()`：一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，由JVM决定执行哪个。
1. `notifyAll()`：一旦执行此方法，就会唤醒所有被wait的线程。
1. 说明：
   - 三个方法必须使用在同步代码块或同步方法中。
   - 三个方法的调用者必须是同步代码块或同步方法中的同步监视器。否则，会出现IllegalMonitorStateException异常
   - 三个方法是定义在java.lang.Object类中。
5. sleep() 和 wait()的异同
   - 相同点：
      - 都可以使当前进程进入阻塞状态
   - 不同点：
      - 声明位置不同：`slee()`声明在Thread类中，`wait()`声明在Object类中。
      - 调用要求不同：`slee()`可以在任何需要的场景下调用，`wait()`必须在同步方法、同步代码块中调用。
      - `sleep()`不会释放同步监视器、`wait()`会释放同步监视器。

## 第9章 集合

### 9.1 概念

- 用于存储数量不等的多个对象、具有映射关系的关联数组。

### 9.2 集合框架体系

1. 单列集合（Collection）：存放单个对象，有两个重要的子接口，其实现子类都是单列集合。
   - List：
      - ArrayList
      - Vector
      - LinkedList
   - Set：
      - HashSet
         - LinkedHashSet
      - TreeSet
   - ![image.png](/images/javase/java-2/image-1660812212181.png)
2. 双列集合（Map）：存放k-v形式的数据
   - Hashtable
      - Properties
   - HashMap
      - LinkedHashMap
   - TreeMap
   - ![image.png](/images/javase/java-2/image-1660812218745.png)

### 9.3 Collection

#### 9.3.1 Collection接口的特点

1. Collection接口没有直接的实现子类，是通过它的子接口Set和List实现的。
1. Collection实现子类可以存放多个元素，每个元素可以是Object
1. Collection的实现类，List是有序的，Set不是有序的
1. Collection的实现类，有的可以存放重复的元素，有的不可以

#### 9.3.2 Collection接口实现类遍历元素方式

1. Tterator（迭代器）：
   - 所有实现了Collection接口的集合类都有一个`iterator()`方法，用以返回一个迭代器
   - Iterator仅用于集合遍历，本身并不存放对象。
   - 使用流程：
      - 创建迭代器：`Iterator it = 集合对象.iterator()`
      - 遍历对象：`while(it.hasNext()){it.next()}`
         - 使用`it.next()`之前必须使用`hasNext()`方法进行判断，否则在调用完最后一条时会抛出`NoSuchElementException`异常。
         - while循环结束后，迭代器指向集合中最后一个元素，如果再调用`next()`方法，会抛出异常，如果希望再次遍历，则需要重置迭代器：`it = 集合对象.iterator()`
      - IDEA快捷模板：`itit`，`Ctrl+j`显示所有的快捷模板
2. 增强for循环：
   - 语法：`for( 元素类型 元素名 : 集合名或数组名){ 访问元素 }`
   - 只能用于遍历集合和数组。
   - 本质就是简化版的迭代器（底层代码）。
3. 不可用普通for循环，因为子接口Set不支持索引

### 9.4 List

#### 9.4.1 特点

1. List集合类的元素有序（添加和取出顺序一致），且可重复。
1. List集合类每个元素都有器对应的顺序索引，可通过索引取出元素——使用`get()`
1. List接口实现类常用的有`ArrayList`、`LinkedList`、`Vector`
   - ![image.png](/images/javase/java-2/image-1660812227166.png)

#### 9.4.2 常用方法

#### 9.4.3 遍历方式

1. 使用Iterator迭代器：迭代器的`next()`取出的就是每个对象
1. 使用增强for循环
1. 使用普通for循环

#### 9.4.4 ArrayList

1. 特点：
   - 可以存放null，且可存放多个
   - 基本等同于Vector，但ArrayList线程不安全。
2. 底层：
   - ArrayList的数据由一个`transient`修饰的`Object[]` 存储。可变数组
      - `transient`表示不可被序列化
   - `ArrayList()`：初始容量为0，第一次添加元素容量变为10，后续扩容按照当前容量的1.5倍增大
   - `ArrayList(int initialCapacity)`：初始容量为initialCapacity，后续扩容按照当前容量的1.5倍增大
>
> 3. IDEA补充知识：
>    - IDEA在debug时，会阉割数据
>    - 解决方式：（去掉下列两个红框的勾选）。
>       - ![image.png](/images/javase/java-2/image-1660812232833.png)

#### 9.4.5 Vector

1. 特点：
   - 可以存放null，且可存放多个
   - Vector类的操作方法带有`synchronized`，所以是线程安全的。
2. 底层：
   - 底层使用`Object[]`存放数据
   - `Vector()`：初始容量0，第一次添加后10，不足时按当前容量的2倍扩容。
   - `Vector(int initialCapacity)`：初始容量为initialCapacity，不足时按当前容量的2倍扩容。

#### 9.4.6 LinkedList

1. 特点：
   - 可以存放null，且可存放多个
   - 线程不安全，添加删除效率比数组高，查找效率较低
2. 底层：
   - 底层维护了一个双向链表
      - LinkedeList中有两个属性first、last，分别指向链表中第一个和最后一个节点
      - 每个节点都含有3个属性：prev、next、item
      - 只有无参构造器`LinkedList()`，默认容量0，添加一个数组，容量+1。
3. LinkedList和ArrayList的选择
   - 改查较多，选择ArrayList
   - 增删较多，选择LinkedList
      - 业务中，一般查询较多、增删较少，建议使用ArrayList

### 9.5 Set

#### 9.5.1 特点

1. 无序（添加和取出顺序不一定一致），元素不可重复，最多只可包含一个null。
   - 元素不可重复按照equals是否相等理解。（基本数据类型会自动装箱，但包装类重写了equals方法，比较的还是具体值；字面量字符串在常量池；构造器创建的字符串比较的也是具体内容（equals））
   - 但一旦数据确定，每次的取出顺序一致
   - hashcode是根据对象的地址值确定的
2. 没有索引
2. 常用实现类有：`HashSet`、`LinkedHashSet`、`TreeSet`
   - ![image.png](/images/javase/java-2/image-1660812278755.png)

#### 9.5.2 常用方法

#### 9.5.3 遍历方式

1. 迭代器
1. 增强for循环
1. 不能使用普通for循环

#### 9.5.4 HashSet

1. 特点：
   - 可以存放null，但只能存放一个。
   - 相同数据只能存放一个
      - 注意字符串的特殊性（面试题）：![image.png](/images/javase/java-2/image-1660812285548.png)
      - 其他对象可以添加成功：![image.png](/images/javase/java-2/image-1660812287543.png)
   - 数据存入与取出顺序不一定一致
>
> 2. 底层（数据结构）：
>    - 底层实际上是HashMap，而HashMap的底层是数组+链表+红黑树
>       - 调用HashSet构造器后，会先执行HashMap()构造器，并创建table表（数组），初始容量为0，再取得加载因子0.75
>       - 添加元素时，先计算得到该元素的hash值，并转换得到索引值
>       - 第一次添加时，将table扩容到16，并把第一次添加的元素放到表中的指定位置
>       - 后续添加时，比较索引值，如果表中该索引已有值，则在该值后的数据链中比较，添加到最后
>          - 注意：这里比较元素内容是否相同，取决于加入元素的`equals()`方法，通过重写`equals()`和`hasCode()`可以控制元素能否加入
>       - JAVA8中，如果数据链的数据已有8个，先对表按2倍进行扩容，如果表已经扩容过，并且表到了64，则将该表转换为红黑树
>       - 平时链表数据没到8个，但表到达12个（16*0.75），就会对表按照2倍进行扩容，并以此类推
>    - 数组类型为`HashMap$Node`，数据类型为`HashMap$Node`。

#### 9.5.5 LinkedHashSet

1. 特点：
   - HashSet的子类、并实现了Set接口
   - 可以存放null、但只能存放一个
   - 相同数据只能添加一个
   - 元素取出顺序固定，且与加入顺序一致。
2. 底层：
   - 底层使用了一个hashtable（数组） 和双向链表存储数据，
      - 数组是`HashMap$Node`类型
         - 数组有head和tail
      - 数据类型为`LinkedHashMap$Entry`类型，LinkedHashMap是HashMap的子类。
         - 每个元素有before和after
   - 初始容量为0，第一次添加时，直接将数组table 扩容到16，再添加一个元素时，先求hash值，再求索引，确定在表中的位置，然后再将元素添加到链表中【机制同HashSet】

#### 9.5.6 TreeSet

1. 特点：
   - 使用无参构造器时，仍然是无序的（输出顺序与输入顺序不一致）。
   - 使用带比较器的构造器`TreeSet(Comparator<? super E> comparator)`：可以设定指定的添加规则及顺序。
      - 添加规则：取决于比较器中比较的属性，比较器返回0时则不能加入
      - 顺序：根据比较器指定的顺序或者逆序确定。
      - 匿名内部类的比较器规则会被创建时底层的compare()调用
2. 底层：
   - 底层就是TreeMap，TreeMap底层就是Entry
   - 存放的数据类型是TreeMap$Entry
   - 初始化大小是0，添加一个容量+1

### 9.6 Map

#### 9.6.1 Map接口的特点

1. Map与Collection并列存在，用于保存具有映射关系的数据。key-value（双列元素）。
1. Map中的key和value可以时任意数类型，会封装到`HashMap$Node`对象中，数据类型为`HashMap$Node`。
1. Map中的key不允许重复，原因同HashSet（key相同则hashcode和索引值相同，在table表（数组）的位置相同），相同的key等价于替换元素。
1. Map中的value可以重复
1. Map中的key可以为null，value也可以为null，key为null时只能添加一个（等价于替换），value可以多个为null
1. Map中常用String作为key，实际上key只要是Object就都可以（包含基本数据类型）
1. Map中的key和value存在一一对应关系，使用`get(key)`，就可以得到唯一的一个value
:::warning

8. Map中的数据存储：一对k-v是存放在`HashMap$Node`中的，由于Node实现了Entry接口，所以在一定理解上，可以说一对k-v就是一个Entry
   - 源码韩顺平分析：
      - k-v 最后是 `HashMap$Node node = newNode(hash, key, value, null)`
      - k-v 为了方便程序员的遍历，还会创建 EntrySet 集合 ，该集合存放的元素的类型 Entry, 而一个Entry对象就有k,v EntrySet<Entry<K,V>> 即： `transient Set<Map.Entry<K,V>> entrySet;`
      - entrySet 中， 定义的类型是 Map.Entry ，但是实际上存放的还是 HashMap$Node这是因为 `static class Node<K,V> implements Map.Entry<K,V>`
      - 当把 HashMap$Node 对象 存放到 entrySet 就方便我们的遍历, 因为 Map.Entry 提供了重要方法K getKey(); V getValue();
      - ![image.png](/images/javase/java-2/image-1660812291859.png)
   - 源码个人理解：
      - k-v在创建时执行的是`HashMap$Node node = newNode(hash, key, value, null)`，所以k-v的数据类型就是`HashMap$Node`，数组类型也是`HashMap$Node`。
      - Map.Entry有重要的`getKey()`、`getValue()`可以获取元素的k-v值，有了这两个方法，就大大方便了使用（遍历）。![image.png](/images/javase/java-2/image-1660812294638.png)
         - 而在Map中，通过`keySet()`获取`Set`类型的所有key，`values()`获取`Collection`类型的所有vaule，将这二者存放在了一个Set表中。
         - 这个Set表就是EntrySet集合，集合中每一个元素是Entry类型，拥有key和value：`transient Set<Map.Entry<K,V>> entrySet;`
            - EntrySet和Node都是HashMap的内部类![image.png](/images/javase/java-2/image-1660812296959.png)
      - 为了使`HashMap$Node`类型的数据能够用上面两个方法，HashMap$Node类实现了Map.Entry：`static class Node<K,V> implements Map.Entry<K,V>`
:::

9. 常用实现类：`HashMap`（使用率最高）、`Hashtable`、`Properties`
   - ![image.png](/images/javase/java-2/image-1660812299482.png)

#### 9.6.2 Map接口常用方法

#### 9.6.3 Map接口遍历方法

1. 方式一：使用Map的`keySet()`方法取出所有的key，而取出的key类型为Set，因此可以使用两种方式：
   - 增强for循环：
   - 使用迭代器：
      - 迭代器的`next()`取出的是key
2. 方式二：使用Map的`values()`方法取出所有的value，而取出的value类型为Collection，因此可以使用两种方式：
   - 增强for循环：
   - 使用迭代器：
      - 迭代器的`next()`取出的是value
3. 方式三：使用Map的`entrySet()`方法取出所有的entry，而取出的entry类型为HashMap$Node，HashMap$Node实现了Map.Entry，而Map.Entry有`getKey()`和`getValue()`
   - 使用EntrySet的增强for循环：
      - 前提条件：使用向上转型，转为Map.Entry。![image.png](/images/javase/java-2/image-1660812327949.png)
   - 使用迭代器：
      - 迭代器的`next()`取出的是entry，entry类型为HashMap$Node，HashMap$Node实现了Map.Entry。
      - ![image.png](/images/javase/java-2/image-1660812332456.png)

#### 9.6.4 HashMap

1. 特点：
   - 使用率最高
   - key不能重复，但value可以重复，允许使用null的key和null的value
   - 如果添加相同的key，则会覆盖原来的key-val，等同于修改（替换）
   - 线程不安全
2. 底层：
   - 底层以key-val的方式来存储数据（数组及数据均为HashMap$Node类型）
   - 与HashSet一样，不保证映射顺序，因为底层是以hash表的方式来存储（数组+链表+红黑树）
   - ![image.png](/images/javase/java-2/image-1660812335569.png)
   - **扩容机制：同HashSet，**唯一区别在于HashSet计算哈希值是元素，HashMap计算时是key
   - 初始化数据容量为0

#### 9.6.5 LinkedHashMap

1. 特点：
   - 继承了HashMap，实现了Map。
   - 线程不安全
   - 如果有相同key，后者替换前者；value可以重复，允许使用null的key和null的value
2. 底层
   - 底层使用数组+双向链表 转 红黑树
   - 初始容量为0

#### 9.6.6 Hashtable

1. 特点：
   - 键和值都不能为null，会抛出NullPointerException
   - 线程安全的
2. 底层：
   - 底层是一个数组，类型为`Hashtable$Entry`，实现了Map.Entry。元素类型也为`Hashtable$Entry`![image.png](/images/javase/java-2/image-1660812338767.png)
   - 初始化大小为11，临界值为8（11*0.75）
   - 当添加数据数量到达8时，对数组进行扩容，扩容为当前容量 *2 + 1，新的临界值变为当前容量* 0.75

#### 9.6.7 Properties

1. 特点：
   - 继承了Hashtable：不能添加null的key或value，会发生NullPointerException
   - 线程安全
   - 如果有相同key，后者替换前者
   - 可以用与`xxx.properties`文件中，加载数据到`Properties`类中进行读取和修改
2. 底层
   - 初始容量为0，底层使用数组，元素类型、扩容机制同Hashtab

#### 9.6.8 TreeMap

1. 特点：
   - 使用无参构造器时，仍然是无序的（输出顺序与输入顺序不一致）。
   - 使用带比较器的构造器`TreeMap(Comparator<? super E> comparator)`：可以设定指定的添加规则及顺序。
      - 添加规则：取决于比较器中比较的属性，比较器返回0时则不能加入
      - 顺序：根据比较器指定的顺序或者逆序确定。
      - 匿名内部类的比较器规则会被创建时内部的compare()调用
2. 底层：
   - 底层就是Entry
   - 存放的数据类型是`TreeMap$Entry`![image.png](/images/javase/java-2/image-1660812342500.png)
   - 初始化大小是0，添加一个容量+1
:::warning
**比较（个人总结）：**
**注意：容量和**`**size()**`**不同。**`**size()**`**指的是有多少实际的数据。**
![image.png](/images/javase/java-2/image-1660812344841.png)
:::

### 9.7 Collections工具类

#### 9.7.1 介绍

1. 操作Set、List、Map等集合的工具类。
1. 能够对集合进行排序、查找、修改等工作。

#### 9.7.2 排序操作

1. `reverse(List)`：反转List中的元素顺序
1. `shuffle(List)`：对List集合进行随机排序，每次调用都进行一次随机
1. `sort(List)`：对List结合的元素进行自然排序（从小到大）
1. `sort(List, Comparator)`：根据比较器的规则对List集合的元素进行排序
1. `swap(List, int i, int j)`：交换List和i和j位置的元素
   - i或j超范围时抛出索引越界异常

#### 9.7.3 查找、替换

- 使用`copy()`方法前必须确认目标集合与源集合有同样的size（注意size不是容量），否则会发生数组越界异常。

## 第10章 泛型

### 10.1 泛型的引出

#### 10.1.1 个人理解

- 集合中的添加的元素可以是任意类型，但某些特定需求下，需要将添加的类型限定在某一种类型，以保证开发效率、代码规范等目的。
- 这种情况下靠人为去控制添加的元素类型不具有显示意义，编译器也不会在编译程序的时候指出这种失误。
- 为了**保证添加的元素类型一致、编译器能够在编译阶段（程序书写阶段）就发现错误、后续的代码中简化代码**，java在JDK5.0时引入了泛型，它在集合、接口等有确定传入类型需求的类、接口声明时添加了占位元素，使得在使用时，用指定的元素类型替换占位元素，以达到上述目的。

#### 10.1.2 官方理解

- 泛型又称参数化类型，用于解决数据类型的安全性问题
- 需要在类声明或实例化时指定具体类型。
- java泛型可以保证程序在编译时不出现警告，运行时也就不会产生ClassCastException，同时能够使diamagnetic更简洁、健壮。
- 泛型的作用是：可以在类声明时，通过一个标识，表示类中某个属性、某个方法的返回值、某个方法的参数是指定类型。

### 10.2 使用泛型

#### 10.2.1 泛型的实例化

1. 在创建对象时，`<>`中写上具体的参数类型。
   - 例子：`List<String> list = new ArrayList<String>();`
   - 简写：`List<String> list = new ArrayList<>();`
      - 好处：由编译器去自动推断数据类型，进一步保证数据安全。
2. 细节：
   - 写入的数据类型只能是引用类型，传入基本数据类型会报错
   - 可以写入声明时指定的类型，或指定类型的子类型
   - `<>`内不传入时，默认的泛型是Object

#### 10.2.2 获取泛型的方法

1. `getGenericSuperclass()`：与`getSuperclass()`方法类似，获取带泛型的父类类型。返回类型为`Type`。

1.

### 10.3 自定义泛型

#### 10.3.1 自定义泛型类

1. 泛型的声明
   - `class 类名<K, V>{}`
   - K、V、T都不表示具体值或具体的类型，而是一个占位标记符，可以是任意标识符。
      - 一般E使用在集合中
      - T使用在类中
      - K表示键
      - V表示值
      - N表示数值类型
      - ?表示不确定的java类型
   - `<>`内可以写入多个，表示多个泛型
2. 声明细节：
   - 泛型可以是属性、方法参数、方法返回值、构造器参数
   - 泛型是数组时，不能在声明时初始化。
      - 数组在`new`时，不确定泛型类型就不能在内存中开辟空间
   - 静态属性、静态方法（参数、返回值）不能是泛型
      - 静态属性和静态方法随类的加载而加载，此时对象还没有创建，JVM无法初始化泛型
   - 泛型的类型在创建对象时确定
      - 如果没有指定类型，则默认为Object

#### 10.3.2 自定义泛型接口

1. 泛型的声明
   - `interface 接口名<T>{}`
   - K、V、T都不表示具体值或具体的类型，而是一个占位标记符，可以是任意标识符。
      - 一般E使用在集合中
      - T使用在类中
      - K表示键
      - V表示值
      - N表示数值类型
      - ?表示不确定的java类型
   - `<>`内可以写入多个，表示多个泛型
2. 声明细节：
   - 泛型可以是方法参数、方法返回值
      - 不可以是属性，接口的属性是`public static final`
   - 静态方法（参数及返回值）不能是泛型
   - 泛型的类型在继承接口或实现接口时确定
      - 如果没有指定类型，则默认为Object，且实现类默认使用Object
      - 继承接口时确定：子接口的实现类会自动使用子接口确定的类型
      - 实现接口时确定：实现类会自动使用实现类确定的类型

#### 10.3.3 自定义泛型方法

1. 泛型的声明：`修饰符 <参数类型列表> 返回类型 方法名(参数列表){}`
1. 声明细节：
   - 可以定义在普通类、普通接口中，也可以定义在泛型类、泛型接口中。
   - 泛型方法被调用时类型会确定
   - `public void eat(E e){}`修饰符后没有泛型标识，表示这个方法不是泛型方法，而是方法使用了（类声明的）泛型
   - 泛型方法可以使用类声明的泛型，也可以使用自己声明的泛型

### 10.4 泛型的继承和通配符

![image.png](/images/javase/java-2/image-1660812413575.png)
>
> - 不对，泛型没有继承性

通配符注意点：
![image.png](/images/javase/java-2/image-1660812415631.png)

## 第11章 IO流

### 11.1 文件

#### 11.1.1 文件流

1. 流：数据在数据源（文件）和程序（内存）之间经历的路径
1. 输入流：数据从数据源（文件）到程序（内存）的路径
1. 输出流：数据从程序（内存）到数据源（文件）的路径

#### 11.1.2 常用操作

1. 创建文件对象
   - `new File(String str)`：通过指定路径创建File实例
   - `File(File parent, String child)`：通过父目录文件和子路径搭配创建File实例
   - `File(String parent, String child)`：通过父目录和子路径搭配创建File实例
2. 获取文件相关信息
   - `createNewFile()`：在指定路径生成目标文件，并保存在磁盘里
      - 该方法有异常问题
   - `getName()`：获取文件名
   - `getAbsolutePath()`：获取文件的绝对路径（带文件名）
   - `getParent()`：获取父级目录
   - `length()`获取文件内容有多少字节，根据文件的编码获取
      - UTF-8编码中，汉字3个字节
   - `exists()`：文件是否存在
   - `isFile()`：是不是一个文件
   - `isDirectory()`：是不是一个目录
3. 目录操作和文件删除：
   - `delete()`：删除文件或空文件夹
   - `mkdir()`：创建一级目录
   - `mkdirs()`：创建多级目录

### 11.2 IO流原理及分类

#### 11.2.1 I/O流原理

1. 用于数据传输，如读写文件，网络通讯。
1. java.io包下提供了各种流（stream）类和接口，用以获取不同类的数据，并通过方法输入或输出数据。
1. 输入input：读取外部数据到内存（程序）中
1. 输出output：将程序（内存）中的数据输出到存储设备中。

#### 11.2.2 流的分类：写、out：自身→外部，读、input：外部→自身

1. 按照操作数据单位分：字节流（8字节）二进制文件、字符流（按字符）文本文件
1. 按数据流向：输入流、输出流
1. 按流的角色：节点流、处理流/包装流
   - 节点流：从一个特定的数据源读写数据
      - 数据源：存放数据的地方，可以是文件、字符串、数组、管道
   - 处理流/包装流：建立在已有的流之上，为程序提供更强大、更灵活的读写功能
      - 如BufferedReader、BufferedWriter
      - 处理流类的底层封装了节点流的Wrtie或Reader对象，根据多态，可以使用各种Writer和Reader的子类对象
:::warning
节点流和处理流的区别和联系：

- 节点流是底层流，直接更数据源相接
- 处理流包装节点流，可以消除不同节点流的实现差异，也可以提供更方便的方法完成输入输出
- 处理流对节点流的包装，使用了修饰器涉及模式，不会直接与数据源相连
- 处理流提高了性能：主要以增加缓冲的方式提高输入输出的效率
- 处理流提供了操作的便捷：处理流可能提供了一系列编辑的方法来一次输入输出大批量的数据，使用更加灵活方便。
:::
![image.png](/images/javase/java-2/image-1660812426394.png)

| 抽象基类 | 字节流       | 字符流 |
| -------- | ------------ | ------ |
| 输入流   | InputStream  | Reader |
| 输出流   | OutputStream | Writer |

- java的io流涉及40多个类，都是从上述4个抽象基类派生而来
- 这4个基类派生出来的子类名称都是以基类名作为子类名的后缀

4. IO流体系图

![java.io.png](/images/javase/java-2/java.io.png)

### 11.3 节点流/文件流

#### 11.3.1 FileInputStream

1. 创建文件输入流对象：`new FileInputStream(filePath)`：
   - 有异常问题
2. `read()`：从输入流中读取一个字节的数据，
   - 到达文件末尾时，返回-1（读取完毕）
   - 有异常问题
   - 读入的字节数据是ASCII编码，使用字符强转可得到原文
3. `read(byte[] b)`：一次读取b.length()个字节存入到b中，返回实际读取的字节数量
   - 到达文件末尾时，返回-1（读取完毕）
   - 有异常问题
   - 读入的字节数据是ASCII编码组成的数组，转换为字符串时可使用`String(byte[] bytes, int offset, int length)`构造器
      - offset：byte[]数组起点下标
      - length：读入byte[]字节长度
4. `read(byte[] b, int off, int len)`：开发中使用这个
   - 到达文件末尾时，返回-1（读取完毕）
   - 有异常问题
5. `close()`：关闭文件输入流，并释放与该流相关的所有系统资源
   - 由于创建输入流对象有异常问题，该方法须在finally块中调用，以保证确实执行。

#### 11.3.2 FileOutputStream

1. 创建文件输出流对象：
   - `new FileOutputStream(filePath)`：覆盖模式
   - `new FileOutputStream(filePath, true)`：追加模式：第二个参数设置为true时，输出的字节流是追加的方式
   - 有异常问题
2. `write(int b)`：将单个字节数据输出到输出流，传入的是一个ASCII整数，或者一个字符（会自动类型转换为整型）
   - 有异常问题
3. `write(byte[] b)`：将b.length()个字节输出到输出流
   - 有异常问题
   - 可搭配String的`getBytes(str)`使用，将字符串转换为字符数组
4. `write(byte[] b, int off, int len)`：将字节数组b，从下标off开始的len个字节数据输出到输出流。开发中使用这个
   - 有异常问题
5. `close()`：关闭文件输出流，并释放与该流相关的所有系统资源
   - 由于创建输出流对象有异常问题，该方法须在finally块中调用，以保证确实执行。

#### 11.3.3 文件拷贝

1. 搭配输入输出流使用

#### 11.3.4 FileReader

1. 创建文件读取对象：`new FileReader(filePath)`：
   - 有异常问题
2. `reader()`：读取单个字符，读入的是个整数
   - 到达文件末尾时，返回-1（读取完毕）
   - 有异常问题
   - 读入的字符数据是ASCII编码，使用字符强转可得到原文
4. `read(byte[] b)`：一次读取b.length()个字符存入到b中，返回实际读取的字符数量
   - 到达文件末尾时，返回-1（读取完毕）
   - 有异常问题
   - 读入的字符数据是ASCII编码组成的数组，转换为字符串时可使用`String(char[] chars, int offset, int length)`构造器
      - offset：char[]数组起点下标
      - length：读入char[]字节长度
5. `read(char[] b, int off, int len)`：开发中使用这个
   - 到达文件末尾时，返回-1（读取完毕）
   - 有异常问题
6. `close()`：关闭文件读取对象，并释放与该流相关的所有系统资源
   - 由于创建文件读取对象有异常问题，该方法须在finally块中调用，以保证确实执行。

#### 11.3.5 FileWrite

1. 创建文件写入流对象：
   - `new FileWriter(filePath)`：覆盖模式
   - `new FileWriter(filePath, true)`：追加模式：第二个参数设置为true
   - 有异常问题
2. `write(int b)`：将单个字符数据输出到输出流，传入的是一个ASCII整数，或者一个字符（会自动类型转换为整型）
   - 有异常问题
3. `write(char[] b)`：将b.length()个字符输出到输出流
   - 有异常问题
4. `write(char[] b, int off, int len)`：将字符数组b，从下标off开始的len个字符数据输出到输出流。开发中使用这个
   - 有异常问题
5. `write(String str)`：写入整个字符串
5. `write(String str, int off, int len)`：写入字符串指定部分
5. `close()`：关闭文件输出流，并释放与该流相关的所有系统资源
   - 由于创建输出流对象有异常问题，该方法须在finally块中调用，以保证确实执行。
   - FileWtrie必须关闭流(close())或(flush()，否则不能真正保存到文件
   - 等价于flush()和关闭

### 11.4 处理流

- **BufferedReader和BufferedWriter**
  - **属于字符流，一般用于处理文本文件**，处理声音、视频、doc、pdf等二进制文件时有数据丢失的风险。
  - 关闭流时，只需要关闭外层的BufferedReader或BufferedWriter即可，而不是传入的Reader、Writer对象，底层会自动关闭对应的传入Reader、Writer对象
- BufferedInputStream和BufferedOutputStream
  - 属于字节流，既可处理文本文件，也可处理二进制文件

#### 11.4.1 BufferedReader

1. 创建对象：`new BufferedReader(Reader in)`：
   - 有异常问题。
   - 异常存在于传入的Reader in对象
2. `readLine()`：按行读取，读取完毕返回null
   - 不读入换行

#### 11.5.2 BufferedWriter

1. 创建对象：`new BufferedWriter(Writer out)`
   - 有异常问题。
   - 异常存在于传入的Writer out对象
2. `write(String s, int off, int len)`：写入字符串的一部分
   - 好像不要off和len的时候是传入整个字符串？
3. `newLine()`：插入一个和系统相关的换行符

#### 11.4.3 BufferedInputStream

- `new BufferedInputStream(InputStream in)`
- 类似BufferedReader
- 使用的方法是：`read(byte[] b, int off, int len)`

#### 11.4.4 BufferedOutputStream

- `new BufferedOutputStream(OutputStream out)`
- 类似于BufferedWriter
- 使用的方法是：`write(byte[] b, int off, int len)`

#### 11.4.5 序列化和反序列化

1. 序列化：保存值和数据类型到文件
1. 反序列化：将保存到文件的数据值和数据类型进行恢复
1. 对象要可序列化，则要求该对象实现`Serializable`或`Externalizable`接口。
   - 一般使用`Serializable`，该接口为标记接口——没有任何属性和方法
   - `Externalizable`，继承自`Serializable`，需要重写两个方法
4. 注意事项
   - 读写顺序要一致
   - 序列化或反序列化的对象必须实现`Serializable`或`Externalizable`接口。
   - 序列化的对象建议添加`private static final long serialVersionUID`，提高兼容性
   - 序列化的对象，会默认初始化除static和transient修饰的成员
   - 序列化的对象，其属性类型也需要实现序列化接口，有异常问题
   - 序列化具有继承性，其子类自动可序列化

#### 11.4.6 ObjectOutputStream

1. 特征：字节流、处理流、对象流、提供序列化功能
1. 创建对象：`new ObjectOutputStream(OutputStream out)`
1. `writeInt(int)`：自动装箱，写一个32位的整形数
1. `writeBoolean(boolean)`：自动装箱
1. `writeChar(int)`：自动装箱，写一个16位字符，可传入字符，会自动转换为int
1. `writeDouble(double)`：自动装箱，写一个64位双精度浮点数
1. `writeUTF(String)`：以UTF-8模式写入字符串
1. `writeObject(Object)`：将指定对象写入
1. `close()`
1. 上述均有异常问题。

#### 11.4.7 ObjectInputStream

1. 特征：字节流、处理流、对象流、提供反序列化功能，**反序列化顺序必须与序列化顺序一致。**
1. 创建对象：`new ObjectInputStream(InputStream input)`
1. `readInt()`
1. `readBoolean()`
1. `readChar()`
1. `readDouble()`
1. `readUTF()`
1. `readObject()`：底层表现多塔的特征，编译类型是Object，运行类型是实际的类型，底层会进行造型和强转。但如果使用运行类型的方法，需要进行显式强转。
1. `close()`
1. 上述均有异常问题

### 11.5 标准输入流和输出流（java.lang.Object）

1. `System.in`类：编译类型为`InputStream`、运行类型为`BufferedInputStream`
   - 标准输入
   - 输入源键盘
   - 返回`InputStream`
2. `System.out`类：编译类型为`PrintStream`、运行类型为`PrintStream`
   - 标准输出
   - 输出源显示器
   - 返回`OutputStream`

### 11.6 转换流

- `InputStreamReader`（字符流）：
  - 默认情况下，读取文件时按照utf-8的形式，
  - `Reader`的子类
  - 可以将`InputStream`（字节流）包装成/转换成`Reader`（字符流）
  - `InputStreamReader(InputStream in, Charset cs)`：按照读取文件的cs编码格式进行读入
- `OutputStreamWriter`（字符流）：
  - 指定处理编码
  - `Writer`的子类
  - 可以将`OutputStream`（字节流）转换成`Writer`（字符流）
  - `OutputStreamReader(OutputStream in, Charset cs)`
- 主要用于解决中文文本数据
  - 中文文本数据有乱码问题
  - 中文文本按照字符流处理（读取和写入）效率更高

### 11.7 打印流

- 只有输出流没有输入流

#### 11.7.1 PrintStream

1. 构造器（常用）：
   - `PrintStream(OutputStream out)`：
      - `PrintStream(System.out)`：默认屏幕输出
   - `PrintStream(File file)`：可指定编码
   - `PrintStream(String fileName)`：可指定编码
   - `PrintStream(Writer out)`：可指定编码
2. 使用：`PrintStream out = System.out`
   - `out.print()`：默认情况下，输出位置是标准输出——显示器
   - `print()`底层使用的是`write()`，故可以使用字节流的`write()`方法进行时输出
   - 修改输出位置：`System.setOut(PrintStream ps)`，然后调用`out.print()`
      - 根据创建的`ps`对象，可以输出到指定文件
3. 需要关闭。

#### 11.7.2 PrintWriter

1. 构造器：
   - `PrintWriter(OutputStream out)`：
      - `PrintWriter(System.out)`：默认屏幕输出
   - `PrintWriter(File file)`：可指定编码
   - `PrintWriter(String fileName)`：可指定编码
   - `PrintWriter(Writer out)`：可指定编码
2. 使用：
   - 调用`print()`方法
3. 需要关闭。

### 11.8 Properties

1. 作用：专门用于读写配置文件的集合类
   - 配置文件格式：`键=值`
   - 键值对不需要有空格
   - 值不需要使用引号
   - 默认类型为String
2. 创建对象：`new Properties()`
2. 常见方法：
   - `load(Reader reader)`
   - `loaad(InputStream instream)`：加载配置文件
   - `list(PrintWriter out)`：将此属性列表打印到指定的输出流（键值对的形式）
      - `list(System.out)`：屏幕输出
   - `list(PrintStream out)`
   - `getProperty(String key)`：根据key获取value
   - `setProperty(String key, String value)`：修改、添加键值对到Properties类的对象（此时还没添加到文件里）
   - `store(OutputStream out, String comments)`：将k-v存储到文件中
      - comments会添加文件的开头，以#注释，一般可置为null
   - `store(Writer writer, String comments)`
4. IDEA中使用路径：
   - 绝对路径
   - 工程路径：`src/io.properties`
   - 模块路径：`模块名/src/io.properties`

## 第12章 网络编程

### 12.1 网络相关概念

#### 12.1.1 网络通信

1. 概念：两台设备之间通过网络实现数据传输
1. 网络通信：将数据通过网络从一台设备传输到另一台设备。
1. java.net包提供了一系列接口，供编程使用，往后曾网络通信。
:::warning
推荐课程：
:::

#### 12.1.2 网络

1. 概念：两台或多态设备通过一定物理设备连接起来就构成了网络。
1. 分类：根据覆盖范围分
   - 局域网：
   - 城域网
   - 广域网：万维网时广域网的代表

#### 12.1.3 IP地址

1. 概念：用于唯一标识网络中的每台计算机/主机
1. `ipconfig`：查看本机ip地址
1. IPV4地址表示形式：点分十进制，`xxx.xxx.xxx.xxx`
1. 组成：网络地址 + 主机地址
1. IPV4分类：

![image.png](/images/javase/java-2/image-1660812444522.png)![image.png](/images/javase/java-2/image-1660812447800.png)

6. 本地主机地址：127.0.0.1

#### 12.1.4 域名

1. 概念：将ip地址根据http协议，映射成域名，便于记忆
1. 端口号：
   - 概念：用于标识计算机上某个特定的网络程序（服务）
   - 表示形式：以整数表示，端口范围0~65535（216-1）
   - 0~1024一般系统预留（已被占用）
      - 22：ssh
      - 21：ftp
      - 25：smtp
      - 80：http
   - 常见网络程序端口号：
      - 8080：tomcat
      - 3306：mysql
      - 1521：oracle
      - 1433：sqlserver
3. netstat指令：
   - netstat -an：查看当前主机网络情况，包括端口监听和网络连接状态
      - Listenning表示端口正在监听
   - netstat -an | more：分页显示网络情况，按空格显示下一页

#### 12.1.5 网络通信协议（TCP/IP）

![image.png](/images/javase/java-2/image-1660812454319.png)

1. TCP：Transmission Control Protocol，传输控制协议
   - 使用TCP协议前，须建立TCP连接，形成数据传输通道
   - 传输前，采用“三次握手”确保连接可靠
   - “三次握手”可靠后，可进行大数据量传输
   - 传输完毕后，需要释放已经建立的连接，效率低。
   - TCP协议通信时用到的两个应用进程：客户端、服务端
2. IP：Internet Protocol，网络通讯协议

![image.png](/images/javase/java-2/image-1660812457001.png)

3. UDP协议（用户数据协议）
   - 将数据、源、目的封装成数据包，不需要建立连接
      - 不可靠
   - 每个数据包大小现在在64k内，不适合大数据量传输
   - 传输完毕不需要释放资源，速度快

### 12.2 InetAddress类

1. `getLocalHost()`：静态方法，获取本机InetAddress对象
   - 返回：域名/ip地址
2. `getByName(String host)`：根据指定主机名/域名，获取其ip地址对象
2. `getHostAddress`：通过InetAddress对象，获取其ip地址（主机名）
2. `getHostName()`：通过InetAddress对象，获取其主机名或域名

### 12.3 Socket（套接字）

1. 组成：端口号+ip地址
1. 作用：Socket允许程序把网络当成一个流，数据在两个Socket间通过IO传输
1. 分类：一般将主动发起通信的应用程序成为客户端，等待通信请求的为服务端

![image.png](/images/javase/java-2/image-1660812459772.png)

#### 12.3.1 TCP网络通信编程

![image.png](/images/javase/java-2/image-1660812461813.png)

- 必须关闭Socket，否则会造成服务器占用，导致无法连接
- ServerSocket每调用一次accept()，就会开启一个Socket，所以也必须关闭ServerSocket
- 单向数据传输（客户端单向数据流，服务器单向数据流），可不设置结束标志，可以正常通信。
- 双向数据传输，必须设置结束标志，且关闭位置必须紧邻输出流。否则服务器会阻塞，处于等待状态，无正常输出。
  - 结束标志：`socket.shutdownOutput()`
  - 字符流输出中，可利用`newLine()`和`readLine()`作为结束标志，而不使用`socket.shutdownOutput()`
- 当客户端连接到服务端后，客户端也会通过一个端口与服务端通讯，该端口由TCP/IP随机分配

#### 12.3.2 UDP网络编程

1. `DatagramSocket`类和`DatagramPacket`类【数据包/数据报】实现了基于UDP协议的网络程序
1. UDP协议发送的数据不一定能够安全到达目的地，也不确定何时到达。
1. `DatagramSocket`类和`DatagramPacket`类的对象封装了UDP数据报，包含了发送端的IP地址和端口号，以及接收端IP地址和端口号
1. UDP协议的每个数据报都包含了完整的地址信息，因此无需建立发送方和接收放的连接
1. 基本流程：
   - 通过`DatagramSocket`建立发送端和接收端
      - 没有服务端、客户端的概念
   - 将数据封装到`DatagramPocket`对象
   - 调用`DatagramSocket`的方法接收、发送数据
   - 调用`DatagramPocket`的`getData()`方法解析数据
   - 关闭`DatagramSocket`
6. 注意：必须先启动先接收到数据的端，不然服务会一直阻塞。

## 第13章 反射(Reflection)

### 13.1 反射概述

#### 13.1.1 反射机制

1. 基本认识：反射机制允许程序在执行期间，借助Reflection API取得任何类的内部信息，如成员变量，构造器，成员方法等，并能操作对象的属性和方法，而不会对操作的类代码产生修改。
1. 大概解释：类加载完后，JVM堆内存中就产生一个Class类型的对象（一个类只有一个Class对象），这个对象包含了类的完整结构信息，通过该对象可以得到类的结构。对象相当于镜子。
   - 类加载器使用了同步代码块，保证了即使时多线程情况下，一个类的Class类对象只有一个

#### 13.1.2 反射机制原理示意图（后期再理解，暂时不解）

![image.png](/images/javase/java-2/image-1660812465294.png)

#### 13.1.3 作用

1. 在运行时判断任意一个对象所属的类
1. 在运行时构造任意一个类的对象
1. 在运行时得到任意一个类所具有的成员变量和方法
1. 在运行时调用任意一个对象的成员变量和方法
1. 生成动态代理

#### 13.1.4 反射相关的主要类

1. `java.lang.Class`：代表一个类，Class类对象表示某个类加载后在堆中的对象
1. `java.lang.reflect.Method`：代表类的方法，Method对象表示某个类的方法
1. `java.lang.reflect.Field`：代表类的成员变量，Field对象表示某个类的成员变量
1. `java.lang.reflect.Constructor`：代表类的构造方法，Constructor对象表示构造器

#### 13.1.5 反射的优缺点

1. 优点：可以动态的创建和使用对象（框架底层核心），使用灵活，没有反射机制，框架技术就失去底层支撑。
1. 缺点：反射是解释执行，对执行速度有影响。

#### 13.1.6 反射调用优化——关闭访问检查

1. Method、Field和Constructor的对象都有`setAccessible()`方法
1. `setAccessible()`作用是启动和禁用访问安全检查的开关
1. 传入true表示反射的对象在使用时取消访问检查，提高反射效率。
1. 传入false表示反射的对象在使用是执行访问检查，默认为false。

### 13.2 Class类

#### 13.2.1 基本介绍

1. Class是类的一种，继承自Object类
   - ![image.png](/images/javase/java-2/image-1660812468885.png)
2. Class类对不是new出来的，是系统通过类加载器（ClassLoader）的loadClass()方法创建的。
2. 对于某个类的Class类对象在内存中只有一份，因为类只加载一次。
   - 同一个类的Class类对象，hashcode相同
4. 每个类的实例都会记得自己是由哪个Class实例所生成。
4. 利用Class类的一系列API可以完整得到该Class类对象所对应的那个类的完整结构。
4. Class类的对象存放在堆空间中。
4. 类的字节码二进制数据存放在方法区，称为元数据（包括方法代码、变量名、方法名、访问权限等）

#### 13.2.2 Class类的常用方法

![image.png](/images/javase/java-2/image-1660812471119.png)

- `Class<?> cls = Class.forName(classPath)`：
  - classPath是从src路径开始的全类名
  - `<?>`表示不确定的java类型，也可以省略。
  - 输出`cls`时，显示的是`class classPaht`
  - forName有异常问题
- `cls.getClass()`：输出cls的运行类型——class java.lang.Class
- `cls.getName()`：得到全类名——classPath
- `cls.getPackage().getName()`：从src路径开始的全包名
- `cls.newInstance`：创建实例对象，与new出来的实例对象是两个不同对象
  - 与classPath的类一致（强转后一致）
  - 有异常问题
- `cls.getField("属性名")`：通过反射获取类的属性对象
  - 通过此方式访问设置为private的属性会报错
  - `cls.getField("属性名").getName()`：获取属性名
  - `cls.getField("属性名").get(对象名)`：获取该对象中该属性的值
    - 这里的对象可以是new出来的，也可以是newInstace出来的
  - `cls.getField("属性名").set(对象名, 新值）`：通过反射给属性赋值
    - 这里的对象可以是new出来的，也可以是newInstace出来的
- `cls.getFields()`：获取所有属性的对象数组

```java
package reflect_;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Car car1 = new Car();
        car1.brand = "奔驰";
        System.out.println(car1);//Car{brand='奔驰', price='50000', color='red'}
        System.out.println(car1.getClass());//class reflect_.Car

        System.out.println(car1.getClass().getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(Test.class.getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(car1.getClass().getClassLoader()==Test.class.getClassLoader());//true

        Person person = new Person();
        System.out.println(Person.class.getClassLoader()==person.getClass().getClassLoader());//true
        System.out.println(Person.class.getClassLoader()==car1.getClass().getClassLoader());//true

        System.out.println(Test.class);//class reflect_.Test
        System.out.println(Test.class.getClass());//class java.lang.Class

        String classPath = "reflect_.Car";
        Class<?> cls = Class.forName(classPath);
        System.out.println(cls);//class reflect_.Car
        System.out.println(cls.getClass());//class java.lang.Class
        System.out.println(cls.getName());//reflect_.Car

        System.out.println(cls.getPackage());//package reflect_
        System.out.println(cls.getPackage().getName());//reflect_

        Field brand = cls.getField("brand");
        System.out.println(brand);//public java.lang.String reflect_.Car.brand
        System.out.println(brand.getName());//brand

        Car car = (Car)cls.newInstance();
        System.out.println(car);//Car{brand='宝马', price='50000', color='red'}

        System.out.println(brand.get(car));//宝马
        System.out.println(brand.get(car1));//奔驰

        brand.set(car, "华晨宝马");
        brand.set(car1, "梅赛德斯奔驰");
        System.out.println(brand.get(car));//华晨宝马
        System.out.println(brand.get(car1));//梅赛德斯奔驰

        Field[] fields = cls.getFields();
        System.out.println(fields);//[Ljava.lang.reflect.Field;@74a14482
        for(Field field : fields){
            System.out.print(field.getName() + "\t");//brand price color
        }
    }
}

```

#### 13.2.3 获取Class类对象（实例）
>
> - 根据类加载的不同阶段，可以在不同阶段使用不同方式获取Class类。
>   - 不同方式获取到的Class类对象是同一个，原因为堆内存中一个类只有一个Class对象（反射机制）
>
![image.png](/images/javase/java-2/image-1660812475858.png)

1. `Class.forName(classPath)`：调用`Class`的静态方法
   - 前提：已知一个类的全类名，且该类在类路径下？
   - 应用场景：加载配置文件，读取类全路径，加载类
   - 注意点：有ClassNotFoundEception
   - 阶段：程序编写阶段
2. `类名.class`：调用运行时类的属性
   - 前提：已知一个具体的类
   - 应用场景：多用于参数传递（当作参数传进去），比如通过反射得到对应构造器的对象
   - 注意点：最安全可靠，性能最高
   - 阶段：类的加载阶段
3. `对象.getClass()`：调用运行时类的`getClass()`方法
   - 前提：已知某个类的对象实例
   - 应用场景：有对象实例
   - 注意点：获取到的是运行类型
   - 阶段：程序运行阶段
4. 类加载器【4种】
   - `对象.getClass().getClassLoader()`得到`ClassLoader`（类加载器）。
   - 或者使用`类.class.getClassLoader()`得到，二者返回的classLoader()是同一个。一个类一个类加载器吗？还是许多类一个加载器？测试好像是所有类一个类加载器。
      - ![image.png](/images/javase/java-2/image-1660812482170.png)
   - 通过类加载器得到Class类对象：`类加载器的对象.loadClass(classPath)`
5. `Class<包装类> cls = 基本数据类型.class`
   - 基本数据类型按照上述方式获得
   - 输出时会自动拆箱，得到基本数据类型
6. `Class<包装类> cls = 包装类.TYPE`
   - 基本数据类型的包装类可以按照上述方式获得
   - 输出时会自动拆箱，得到基本数据类型
   - 底层基本数据类型和其包装类是同一个Class类对象

#### 13.2.4 具有Class对象的类

1. 外部类、成员内部类、静态内部类、局部内部类、匿名内部类
   - Class也有，因为Class类是外部类的一种
2. interface
2. enum
2. 数组
2. annotation
2. void
2. 基本数据类型

### 13.3 类加载

#### 13.3.1 基本说明

1. 静态加载：编译时加载相关的类，如果类不存在则报错，具有高依赖性
1. 动态加载：运行时加载需要得类，如果运行时不用该类，即使不存在该类，也不报错，降低了依赖性
1. java通过反射机制实现了动态语言的动态加载，让原本在编译时加载的类到运行时才加载

#### 13.3.2 类的加载时机

1. new创建对象时——静态加载
1. 子类被加载时，父类也被加载——静态加载
1. 调用类中的静态成员时——静态加载
1. 通过反射——动态加载

#### 13.3.3 类的加载过程

![image.png](/images/javase/java-2/image-1660812485739.png)
![image.png](/images/javase/java-2/image-1660812487921.png)

- 加载阶段：JVM将来自不同数据源（class文件、jar包、网络等）的字节码文件，转化为二进制字节流加载到内存中，并生成一个代表该类的java.lang.Class对象
- 连接阶段：
  - 验证：jvm检查字节流信息符合当前虚拟机的要求，并且不会危害虚拟机自身的安全
    - 包括文件格式验证（是否以魔数oxcafebabe开头）、元数据验证、字节码验证和符号引用验证
    - 可以使用`-Xverify:none`参数关闭大部分类的验证措施，缩短虚拟机类加载的时间
  - 准备：JVM对静态变量进行默认初始化并分配内存，这些变量所使用的内存在方法区进行分配
    - 无修饰的变量不会分配内存，那会默认初始化吗？
    - static修饰变量会默认初始化，会分配内存
    - static 和 final修饰的变量会默认初始化，也会分配内存
  - 解析：虚拟机将常来给你吃内的符号引用替换为直接引用
- 初始化阶段：初始化阶段时执行`<clint>()`方法的过程
  - `<clint>()`方法时由编译器按语句在源文件中出现的顺序，依次自动收集类中所有的静态变量赋值动作和静态代码块中的语句，并进行合并
  - 虚拟机会保证一个类的`<clint>()`方法在多线程环境中被正确的加锁、同步，如果多个线程同时初始化一个类，哪个只有一个线程去执行类的`<clint>()`方法，其他线程都会阻塞等待，直到活动线程执行`<clint>()`方法完毕。

### 13.4 通过反射获取类的结构信息

#### 13.4.1 java.lang.Class类及其方法

![image.png](/images/javase/java-2/image-1660812491428.png)

#### 13.4.2 java.lang.reflect.Field类

![image.png](/images/javase/java-2/image-1660812493253.png)

- `getType()`返回的是属性的类型

#### 13.4.3 java.lang.reflect.Method类

![image.png](/images/javase/java-2/image-1660812495093.png)

- `getReturnType()`返回的是返回类型的类型

#### 13.4.4 java.lang.reflect.Constructor类

![image.png](/images/javase/java-2/image-1660812496848.png)

### 13.5 通过反射创建对象

在13.2.3的基础上：

1. 方式一：
   - `Class.forName(classPath)`：得到Class类对象
   - `Class类对象.newInstance()`：得到实例对象
2. 方式二：
   - `Class.forName(classPath)`：得到Class类对象
   - `Class类对象.getConstructor(已知参数类名.class)`：得到带参构造器对象
      - 得到的只是public修饰的构造器
   - `带参构造器对象.newInstance(实参)`：得到对象实例
3. 方式三（私有构造器流程）：
   - `Class.forName(classPath)`：得到Class类对象
   - `Class类对象.getDeclaredConstructor(已知参数类名.class)`：得到带参构造器对象
      - 得到的是各种权限修饰符修饰的构造器（上面只是获得了私有构造器，还不能使用，使用会报错）
   - `构造器对象.setAccessible(true)`：**爆破**，使得私有的构造器可以使用
   - `构造器对象.newInstance(实参)`：得到对象实例

- 以上方式创建的实例对象都是Object类型，但是可以向下转型为指定类型（体现多态）

### 13.6 通过反射访问类中的成员

#### 13.6.1 访问属性

1. 得到类对应的Class类对象：`Class.forName(classPath)`
1. 通过13.5的方式创建Class类对象的实例对象
1. 方式一（访问公开属性）：
   - 通过Class类对象的`getField(已知属性名)`得到本类及父类中public修饰的属性对象
      - `属性对象.get(实例对象名)`可以获得实例对象中的属性值
      - `属性对象.set(实例对象名)`可以修改实例对象中的属性值
4. 方式二（访问非公开属性）：
   - 通过Class类对象的`getDeclaredField(已知属性名)`得到本类中各类修饰符修饰的属性对象
   - `属性对象.setAccessible(true)`：**爆破**，使得私有的构造器可以使用
      - `属性对象.get(实例对象名)`可以获得实例对象中的属性值
      - `属性对象.set(实例对象名,value)`可以修改实例对象中的属性值

- 如果是静态属性，则set和get中的实例对象名，也可以写成null

#### 13.6.2 访问方法

1. 得到类对应的Class类对象：`Class.forName(classPath)`
1. 通过13.5的方式创建Class类对象的实例对象
1. 方式一（访问公开方法）：
   - 通过Class类对象的`getMethod(已知方法名, 形参对象类.class)`得到本类及父类中public修饰的方法对象
      - 能不能写成`getMethod(已知方法名, 形参对象实例.getClass())`？不能，会报找不到这样方法的异常【2022.07.06】【可以，2022.07.12研究，那是因为那个例子中，对类有改造。但还是不明白具体情况下该用哪个】
      - `方法对象.invoke(实例对象名, 实参)`可以调用实例对象中的方法
4. 方式二（访问非公开方法）：
   - 通过Class类对象的`getDeclaredMethod(已知方法名, 形参对象类.class)`得到本类中各类修饰符修饰的方法对象
   - `属性对象.setAccessible(true)`：**爆破**，使得私有的构造器可以使用
      - `方法对象.invoke(实例对象名, 实参)`可以调用实例对象中的方法

- 如果是静态属性，则invoke中的实例对象名，也可以写成null
- 反射中，方法如果有返回值，统一返回Object（编译类型），运行类型按照方法实际的类型执行。
