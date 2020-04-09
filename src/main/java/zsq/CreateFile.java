package zsq;

import java.io.File;

public class CreateFile
{
    String path;
    String name;
    public CreateFile(String path,String name)
    {
        this.path = path;
        this.name = name;
    }
    public boolean createFile()
    {
        File f = new File(path+File.separator+name);
        if(f.mkdir())
            System.out.println("创建成功！");
        return f.mkdir();
    }
}