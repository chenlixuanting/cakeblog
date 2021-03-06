package cn.edu.guet.cake.blog.web.service.impl;

import cn.edu.guet.cake.blog.web.mapper.PictureMapper;
import cn.edu.guet.cake.blog.web.pojo.Picture;
import cn.edu.guet.cake.blog.web.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureMapper pictureMapper;

    /**
     * 保存新图片
     *
     * @param picture
     * @throws Exception
     */
    @Override
    public int savePicture(Picture picture) throws Exception {
        return pictureMapper.insert(picture);
    }

    @Override
    public Picture getPictureById(Integer id) throws Exception {
        return pictureMapper.selectByPrimaryKey(id);
    }

}
