package com.hiya.classloader;

import java.lang.reflect.Method;

public class ClassLoaderDemo {
    
    
    public static void main(String[] args) 
    {
           //showPath();
           // diskLoader();
    }

    /**
     * 显示 加载路径 
     */
    private static void  showPath() 
    {
        //通过System.getProperty("sun.boot.class.path")得到了字符串bootClassPath,这个应该就是BootstrapClassLoader加载的jar包路径
        System.out.println(System.getProperty("sun.boot.class.path"));
        
        //D:\Soft files\java8\lib\ext;C:\Windows\Sun\Java\lib\ext
        System.out.println(System.getProperty("java.ext.dirs"));
        
        //D:\WorkSpaces2\JvmPro\bin
        System.out.println(System.getProperty("java.class.path"));
        
        ClassLoader cl = Loader1.class.getClassLoader();
        // System.out.println(cl.toString());
        // System.out.println(cl.getParent().toString());
         //System.out.println(cl.getParent().getParent().toString());
          //sun.misc.Launcher$AppClassLoader@2a139a55  说明Loader1.class文件是由AppClassLoader加载的。
       
         cl = int.class.getClassLoader();
         //System.out.println("ClassLoader is:"+cl.toString());
         // java.lang.NullPointerException  int.class是由Bootstrap ClassLoader加载

    }
    
    /**
     * 自定义内加载 
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
