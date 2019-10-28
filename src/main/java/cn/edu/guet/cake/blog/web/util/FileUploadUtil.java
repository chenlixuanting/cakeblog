package cn.edu.guet.cake.blog.web.util;

import java.io.*;

/**
 * 文件上传工具类
 *
 * @author Administrator
 */
public class FileUploadUtil {

    /**
     * 上传文件
     *
     * @param dir
     * @param file
     * @param inputStream
     * @return
     */
    public static boolean upload(String dir, String file, InputStream inputStream){
        BufferedOutputStream bufferedOutputStream = null;
        try{
            File dirFile = new File(dir);
            if(!dirFile.exists()){
                //如果目录不存在，则创建目录
                dirFile.mkdir();
            }
            File destFile = new File(dir+'\\'+file);
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFile));
            byte[] buf = new byte[1024];
            int count = 0;
            while ((count = inputStream.read(buf)) != -1){
                bufferedOutputStream.write(buf,0,count);
            }
            //刷新缓存区
            bufferedOutputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedOutputStream != null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

}
