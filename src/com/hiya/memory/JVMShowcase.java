package com.hiya.memory;

/**
 * 第 1 步 、向操作系统申请空闲内存。JVM 对操作系统说“给我 64M空闲内存”，于是，JVM 向操作系统申请空闲内存作系统就查找自己的内存分配表，
 * 找了段 64M 的内存写上“Java 占用”标签，然后把内存段的起始地址和终止地址给 JVM，JVM 准备加载类文件。
     第 2 步，分配内存。JVM 分配内存。JVM 获得到 64M 内存，就开始得瑟了，首先给 heap 分个内存，然后给栈内存也分配好。
     第 3 步，文件检查和分析class 文件。若发现有错误即返回错误。
     第 4 步，加载类。加载类。由于没有指定加载器，JVM 默认使用 bootstrap 加载器，就把 rt.jar 下的所有类都加载到了堆类存的Method Area，JVMShow 也被加载到内存中。
     我们来看看Method Area区域，如下图：（这时候包含了 main 方法和 runStaticMethod方法的符号引用，因为它们都是静态方法，在类加载的时候就会加载）
    Heap 是空，Stack 是空，因为还没有对象的新建和线程被执行。
      第 5 步、执行方法。执行 main 方法。执行启动一个线程，开始执行 main 方法，在 main 执行完毕前，方法区如下图所示：
（public final static String ClASS_CONST = "I'm a Const";  ）
     在 Method Area 加入了 CLASS_CONST 常量，它是在第一次被访问时产生的（runStaticMethod方法内部）。
 
     堆内存中有两个对象 object 和 showcase 对象，如下图所示：（执行了JVMShowcase showcase=new JVMShowcase();  ）
为什么会有 Object 对象呢？是因为它是 JVMShowcase 的父类，JVM 是先初始化父类，然后再初始化子类，甭管有多少个父类都初始化。
 
在栈内存中有三个栈帧，如下图所示：
于此同时，还创建了一个程序计数器指向下一条要执行的语句。
 
第 6 步，释放内存。释放内存。运行结束，JVM 向操作系统发送消息，说“内存用完了，我还给你”，运行结束。

 * @author zjq
 *
 */
public class JVMShowcase
{
    // 静态类常量,
    public final static String ClASS_CONST = "I'm a Const";
    // 私有实例变量
    private int instanceVar = 15;

    public static void main(String[] args)
    {
        // 调用静态方法
        runStaticMethod();
        // 调用非静态方法
        JVMShowcase showcase = new JVMShowcase();
        showcase.runNonStaticMethod(100);
    }

    // 常规静态方法
    public static String runStaticMethod()
    {
        return ClASS_CONST;
    }

    // 非静态方法
    public int runNonStaticMethod(int parameter)
    {
        int methodVar = this.instanceVar * parameter;
        return methodVar;
    }
}