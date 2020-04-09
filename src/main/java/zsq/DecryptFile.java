package zsq;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DecryptFile
{
    String path;
    public DecryptFile(String path)
    {
        this.path = path;
    }

    public void decryptFile(String path)
    {
        try
        {
            File inf = new File(path);
            File outf = new File(path+".txt");
            if( !inf.isFile() || !inf.exists() )
                System.out.println(" 文件出错!");
            if( (!outf.isFile() || !outf.exists() ) && inf.exists() )
                outf.createNewFile();
            byte b[] = new byte[1024*1024];
            FileInputStream fi = new FileInputStream(inf);
            FileOutputStream fo = new FileOutputStream(outf);
            int len = fi.read(b);
            while(len!=-1)
            {
                for(int i=0;i<len;i++)
                {
                    b[i]^=1;
                    fo.write(b[i]);
                }
                len = fi.read(b);
            }
            fi.close();
            fo.close();
            inf.delete();
            outf.renameTo(new File(path));
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}