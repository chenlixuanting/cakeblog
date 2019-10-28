package cn.edu.guet.cake.blog.web.controller;

import cn.edu.guet.cake.blog.web.constant.Constant;
import cn.edu.guet.cake.blog.web.pojo.Picture;
import cn.edu.guet.cake.blog.web.service.PictureService;
import cn.edu.guet.cake.blog.web.util.FileUploadUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/upload")
@Slf4j
public class UploadController {

    @Autowired
    private PictureService pictureService;

    /**
     {
     success : 0 | 1,           // 0 表示上传失败，1 表示上传成功
     message : "提示的信息，上传成功或上传失败及错误信息等。",
     url     : "图片地址"        // 上传成功时才返回
     }
     */

    /**
     * 接收mdeditor上传的图片
     * 必须使用@RequestParam("editormd-image-file") 否则参数绑定失败
     *
     * @param multipartFile
     * @return
     */
    @RequestMapping("/blog-pic")
    public JSONObject blogPicture(HttpServletRequest request, @RequestParam("editormd-image-file") MultipartFile multipartFile) throws Exception {

        JSONObject result = new JSONObject();

        //获取博客图片文件的本地
        String blogPicturePath = request.getServletContext().getRealPath(Constant.BLOG_PICTURE_SAVE_PATH);
        String fileName = multipartFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        String randName = UUID.randomUUID().toString() + fileSuffix;
        String localPath = Constant.WEB_ROOT + randName;

        if (FileUploadUtil.upload(blogPicturePath, randName, multipartFile.getInputStream())) {
            Picture picture = new Picture();
            picture.setCreatetime(new Timestamp(System.currentTimeMillis()));
            picture.setLocalpath(localPath);
            pictureService.savePicture(picture);
            result.put("success", 1);
            result.put("message", "图片上传成功!");
            result.put("url", localPath);
        } else {
            result.put("success", 0);
            result.put("message", "图片上传失败!");
        }

        return result;
    }

}
