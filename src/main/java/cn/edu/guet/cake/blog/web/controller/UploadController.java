package cn.edu.guet.cake.blog.web.controller;

import cn.edu.guet.cake.blog.web.constant.Constant;
import cn.edu.guet.cake.blog.web.constant.StatusCode;
import cn.edu.guet.cake.blog.web.pojo.Picture;
import cn.edu.guet.cake.blog.web.service.PictureService;
import cn.edu.guet.cake.blog.web.util.FileUploadUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
     * @param request
     * @param layuiFile
     * @param editorFile
     * @return
     * @throws Exception
     */
    @RequestMapping("/blog-pic")
    @ResponseBody
    public JSONObject blogPicture(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile layuiFile, @RequestParam(value = "editormd-image-file", required = false) MultipartFile editorFile) throws Exception {

        MultipartFile file = null;

        if (layuiFile != null)
            file = layuiFile;

        if (editorFile != null)
            file = editorFile;

        if (file != null) {

            JSONObject result = new JSONObject();

            //获取博客图片文件的本地
            String blogPicturePath = request.getServletContext().getRealPath(Constant.BLOG_PICTURE_SAVE_PATH);
            String fileName = file.getOriginalFilename();
            String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
            String randName = UUID.randomUUID().toString() + fileSuffix;
            String localPath = Constant.WEB_ROOT + randName;
            if (FileUploadUtil.upload(blogPicturePath, randName, file.getInputStream())) {
                Picture picture = new Picture();
                picture.setCreatetime(new Timestamp(System.currentTimeMillis()));
                picture.setLocalpath(localPath);
                int id = pictureService.savePicture(picture);
                result.put("id", picture.getId());
                result.put("url", localPath);
                result.put("message", "图片上传成功!");
                result.put("success", StatusCode.UPLOAD_OK);
            } else {
                result.put("message", "图片上传失败!");
                result.put("success", StatusCode.UPLOAD_ERROR);
            }
            return result;
        } else {
            throw new Exception();
        }
    }

}
