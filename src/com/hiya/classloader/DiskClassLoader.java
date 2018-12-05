package com.hiya.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DiskClassLoader  extends ClassLoader
{
    private String diskPath;

    public DiskClassLoader(String path) 
    {
        diskPath = path;
    }

    /**
     * ��һ�μ��ص��ڴ��ʱ������һ��
     * ����Ļ�ֱ�Ӵ��ڴ��ȡ class��Ϣ��������������� 
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException 
    {
        FileInputStream is = null;
        ByteArrayOutputStream bos = null;
        String fileName = getFileName(name);
        File file = new File(diskPath,fileName);
        try 
        {
            is = new FileInputStream(file);
            bos = new ByteArrayOutputStream();
            int len = 0;
            try 
            {
                while ((len = is.read()) != -1) 
                {
                    bos.write(len);
                }
            } catch (IOException e) 
            {
                e.printStackTrace();
            }
            byte[] data = bos.toByteArray();
            return defineClass(name,data,0,data.length);
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        finally
        {
            if(null!=is)
            {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null!=bos)
            {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return super.findClass(name);
    }

    private String getFileName(String name) 
    {
        int index = name.lastIndexOf('.');
        if(index == -1)
        { 
            return name+".class";
        }else
        {
            return name.substring(index+1)+".class";
        }
    }
}
