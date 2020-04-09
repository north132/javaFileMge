package zsq;

import java.io.File;

public class ListFile
{
    File path;
    public ListFile(File path)
    {
        this.path = path;
    }
    public void listFile(File path)
    {
        File fs[]=path.listFiles();
        for(int i=0;i<fs.length;i++)
        {
            if(fs[i].isFile())
                System.out.println("文件："+fs[i]);
            else
            {
                System.out.println("目录："+fs[i]);
                listFile(fs[i]);
            }
        }
    }
}