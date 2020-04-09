package zsq;

import java.io.File;

public class DeleteFile
{
    File path;
    public DeleteFile(File path)
    {
        this.path = path;
    }
    public void delete(File path)
    {
        File fs[]=path.listFiles();
        int listleng=fs.length;
        for(int i=0;i<listleng;i++)
        {
            if(fs[i].isFile())
                fs[i].delete();
            else
                delete(fs[i]);    //递归删除
        }
        path.delete();
    }
}