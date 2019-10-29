package cn.edu.guet.cake.blog.web.service;

import cn.edu.guet.cake.blog.web.pojo.Picture;

/**
 * @author Administrator
 */
public interface PictureService {

    /**
     * 保存新图片
     *
     * @param picture
     * @throws Exception
     */
    int savePicture(Picture picture) throws Exception;

    Picture getPictureById(Integer id) throws Exception;

}
