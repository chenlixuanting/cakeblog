package cn.edu.guet.cake.blog.web.service;

import cn.edu.guet.cake.blog.web.pojo.Admin;

/**
 * @author Administrator
 */
public interface AdminService {

    /**
     * 通过account获得管理员
     *
     * @param account
     * @return
     * @throws Exception
     */
    Admin getAdminByAccount(String account) throws Exception;

    /**
     * 增加管理员
     *
     * @param admin
     * @throws Exception
     */
    void saveAdmin(Admin admin) throws Exception;

    /**
     * 通过id获取管理员
     *
     * @param id
     * @return
     * @throws Exception
     */
    Admin getAdminById(Integer id) throws Exception;

}
