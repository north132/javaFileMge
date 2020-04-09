package zsq;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Scanner s=new Scanner(System.in);
        String curPath= new String();
        while(true)
        {
            String op = s.next();
            switch (op)
            {
                case"mkdir":
                    String pathCreate=s.next();
                    String nameCreate=s.next();
                    CreateFile create=new CreateFile(pathCreate,nameCreate);
                    create.createFile();
                    break;

                case"rm":
                    File dir=new File(s.next());
                    if(dir.exists()&&dir.isDirectory())
                    {
                        DeleteFile delete=new DeleteFile(dir);
                        delete.delete(dir);
                        System.out.println("删除成功");
                    }
                    else
                        System.out.println("找不到文件路径。"+dir);
                    break;

                case"ls":
                    File dirList=new File(".");
                    //System.out.println(curPath);
                    if(dirList.isDirectory()&&dirList.exists())
                    {
                        ListFile list=new ListFile(dirList);
                        list.listFile(dirList);
                    }
                    else
                        System.out.println("当前路径为空！");
                    break;

                case"cp":
                    String src = s.next();
                    String des = s.next();
                    CopyFile copy = new CopyFile(src,des);
                    copy.copyFile(src,des);
                    break;

                case"encrypt":
                    String pathEn = s.next();
                    EncryptFile encrypt = new EncryptFile(pathEn);
                    encrypt.encryptFile(pathEn);
                    break;

                case"decrypt":
                    String pathDe = s.next();
                    DecryptFile decrypt = new DecryptFile(pathDe);
                    decrypt.decryptFile(pathDe);
                    break;

                default:
                    break;
            }
        }
    }
}
