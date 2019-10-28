package cn.edu.guet.cake.blog.web.service.impl;

import cn.edu.guet.cake.blog.web.mapper.AdminMapper;
import cn.edu.guet.cake.blog.web.pojo.Admin;
import cn.edu.guet.cake.blog.web.pojo.AdminExample;
import cn.edu.guet.cake.blog.web.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 通过account获得管理员
     *
     * @param account
     * @return
     */
    @Override
    public Admin getAdminByAccount(String account) throws Exception {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAccountEqualTo(account);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins.size() > 0) {
            return admins.get(0);
        } else {
            return null;
        }
    }

    /**
     * 增加新用户
     *
     * @param admin
     * @return
     */
    @Override
    public void saveAdmin(Admin admin) throws Exception {
        adminMapper.insert(admin);
    }

    /**
     * 通过id获取admin
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Admin getAdminById(Integer id) throws Exception {
        return adminMapper.selectByPrimaryKey(id);
    }

}
