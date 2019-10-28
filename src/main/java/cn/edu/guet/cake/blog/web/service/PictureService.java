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
    void savePicture(Picture picture) throws Exception;

}
