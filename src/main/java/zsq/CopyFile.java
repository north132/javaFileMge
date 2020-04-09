package zsq;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CopyFile
{
    String src;
    String des;
    public CopyFile(String src,String des)
    {
        this.src=src;
        this.des=des;
    }
    public void copyFile(String src,String des)
    {
        try
        {
            File srcf = new File(src);
            File desf = new File(des);
            if(!srcf.exists())
                System.out.println("　源文件不存在!");

            byte b[] = new byte[1024*1024*5];
            if(srcf.isFile())
            {
                FileInputStream fin = new FileInputStream(srcf);
                FileOutputStream fout = new FileOutputStream(desf);
                try
                {
                    int len = fin.read(b);
                    while(len!=-1)
                    {
                        fout.write(b,0,len);
                        len = fin.read(b);
                    }
                    fin.close();
                    fout.close();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                File fs[] = srcf.listFiles();
                if(!desf.exists())
                    desf.mkdir();
                for(int i=0;i<fs.length;i++)
                {
                    copyFile(fs[i].getAbsolutePath(),des+File.separator+fs[i].getName());
                }
            }
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}