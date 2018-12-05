package com.hiya.memory;

/**
 * �� 1 �� �������ϵͳ��������ڴ档JVM �Բ���ϵͳ˵������ 64M�����ڴ桱�����ǣ�JVM �����ϵͳ��������ڴ���ϵͳ�Ͳ����Լ����ڴ�����
 * ���˶� 64M ���ڴ�д�ϡ�Java ռ�á���ǩ��Ȼ����ڴ�ε���ʼ��ַ����ֹ��ַ�� JVM��JVM ׼���������ļ���
     �� 2 ���������ڴ档JVM �����ڴ档JVM ��õ� 64M �ڴ棬�Ϳ�ʼ��ɪ�ˣ����ȸ� heap �ָ��ڴ棬Ȼ���ջ�ڴ�Ҳ����á�
     �� 3 �����ļ����ͷ���class �ļ����������д��󼴷��ش���
     �� 4 ���������ࡣ�����ࡣ����û��ָ����������JVM Ĭ��ʹ�� bootstrap ���������Ͱ� rt.jar �µ������඼���ص��˶�����Method Area��JVMShow Ҳ�����ص��ڴ��С�
     ����������Method Area��������ͼ������ʱ������� main ������ runStaticMethod�����ķ������ã���Ϊ���Ƕ��Ǿ�̬������������ص�ʱ��ͻ���أ�
    Heap �ǿգ�Stack �ǿգ���Ϊ��û�ж�����½����̱߳�ִ�С�
      �� 5 ����ִ�з�����ִ�� main ������ִ������һ���̣߳���ʼִ�� main �������� main ִ�����ǰ������������ͼ��ʾ��
��public final static String ClASS_CONST = "I'm a Const";  ��
     �� Method Area ������ CLASS_CONST �����������ڵ�һ�α�����ʱ�����ģ�runStaticMethod�����ڲ�����
 
     ���ڴ������������� object �� showcase ��������ͼ��ʾ����ִ����JVMShowcase showcase=new JVMShowcase();  ��
Ϊʲô���� Object �����أ�����Ϊ���� JVMShowcase �ĸ��࣬JVM ���ȳ�ʼ�����࣬Ȼ���ٳ�ʼ�����࣬�¹��ж��ٸ����඼��ʼ����
 
��ջ�ڴ���������ջ֡������ͼ��ʾ��
�ڴ�ͬʱ����������һ�����������ָ����һ��Ҫִ�е���䡣
 
�� 6 �����ͷ��ڴ档�ͷ��ڴ档���н�����JVM �����ϵͳ������Ϣ��˵���ڴ������ˣ��һ����㡱�����н�����

 * @author zjq
 *
 */
public class JVMShowcase
{
    // ��̬�ೣ��,
    public final static String ClASS_CONST = "I'm a Const";
    // ˽��ʵ������
    private int instanceVar = 15;

    public static void main(String[] args)
    {
        // ���þ�̬����
        runStaticMethod();
        // ���÷Ǿ�̬����
        JVMShowcase showcase = new JVMShowcase();
        showcase.runNonStaticMethod(100);
    }

    // ���澲̬����
    public static String runStaticMethod()
    {
        return ClASS_CONST;
    }

    // �Ǿ�̬����
    public int runNonStaticMethod(int parameter)
    {
        int methodVar = this.instanceVar * parameter;
        return methodVar;
    }
}