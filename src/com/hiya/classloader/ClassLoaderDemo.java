package com.hiya.classloader;

import java.lang.reflect.Method;

public class ClassLoaderDemo {
    
    
    public static void main(String[] args) 
    {
           //showPath();
           // diskLoader();
    }

    /**
     * ��ʾ ����·�� 
     */
    private static void  showPath() 
    {
        //ͨ��System.getProperty("sun.boot.class.path")�õ����ַ���bootClassPath,���Ӧ�þ���BootstrapClassLoader���ص�jar��·��
        System.out.println(System.getProperty("sun.boot.class.path"));
        
        //D:\Soft files\java8\lib\ext;C:\Windows\Sun\Java\lib\ext
        System.out.println(System.getProperty("java.ext.dirs"));
        
        //D:\WorkSpaces2\JvmPro\bin
        System.out.println(System.getProperty("java.class.path"));
        
        ClassLoader cl = Loader1.class.getClassLoader();
        // System.out.println(cl.toString());
        // System.out.println(cl.getParent().toString());
         //System.out.println(cl.getParent().getParent().toString());
          //sun.misc.Launcher$AppClassLoader@2a139a55  ˵��Loader1.class�ļ�����AppClassLoader���صġ�
       
         cl = int.class.getClassLoader();
         //System.out.println("ClassLoader is:"+cl.toString());
         // java.lang.NullPointerException  int.class����Bootstrap ClassLoader����

    }
    
    /**
     * �Զ����ڼ��� 
     */
    private static void diskLoader() 
    {
            DiskClassLoader diskLoader = new DiskClassLoader("F:\\6isa");
            try 
            {
                Class<?> c = diskLoader.loadClass("com.hiya.classloader.Loader1");
                if(c != null)
                {
                    try 
                    {
                        Object obj = c.newInstance();
                        Method method = c.getDeclaredMethod("say",null);
                        method.invoke(obj, null);
                    } catch (Exception e) 
                    {
                        e.printStackTrace();
                    }
                }
            } 
            catch (ClassNotFoundException e) 
            {
                e.printStackTrace();
            }
    }
}
