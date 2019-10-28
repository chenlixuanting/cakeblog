package cn.edu.guet.cake.blog.web.controller;

import cn.edu.guet.cake.blog.web.constant.Constant;
import cn.edu.guet.cake.blog.web.constant.StatusCode;
import cn.edu.guet.cake.blog.web.pojo.Admin;
import cn.edu.guet.cake.blog.web.pojo.Result;
import cn.edu.guet.cake.blog.web.service.AdminService;
import cn.edu.guet.cake.blog.web.service.LabelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 * @author Administrator
 */
@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private LabelService labelService;

    /**
     * 管理员登录界面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "admin/login";
    }

    /**
     * 后台首页
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        return "admin/index";
    }

    /**
     * 菜单1
     *
     * @return
     */
    @RequestMapping(value = "/menu1", method = RequestMethod.GET)
    public String menu1() {
        return "admin/menu1";
    }

    /**
     * 菜单2
     *
     * @return
     */
    @RequestMapping(value = "/menu2", method = RequestMethod.GET)
    public String menu2() {
        return "admin/menu2";
    }

    /**
     * 后台操作面板
     *
     * @return
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "admin/welcome";
    }

    /**
     * 管理员个人信息界面
     *
     * @return
     */
    @RequestMapping(value = "/admin-info", method = RequestMethod.GET)
    public String adminInfo() {
        return "admin/article-info-manage";
    }

    /**
     * 博文书写面板
     *
     * @return
     */
    @RequestMapping(value = "/write-blog", method = RequestMethod.GET)
    public String writeBlog() {
        return "admin/write-blog";
    }

    /**
     * 文章完善信息项管理
     *
     * @return
     */
    @RequestMapping(value = "/article-info-manage", method = RequestMethod.GET)
    public String articleList() {
        return "admin/article-info-manage";
    }

    /**
     * 登录认证
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result verify(Admin admin, HttpServletRequest request) throws Exception {
        Result result = new Result();
        Admin admindb = adminService.getAdminByAccount(admin.getAccount());
        if (StringUtils.isEmpty(admindb)) {
            result.setMessage("账号不存在!");
        } else {
            if (admin.getPassword().equals(admindb.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute(Constant.ADMIN, admindb);
                result.setCode(StatusCode.OK);
                result.setFlag(Boolean.TRUE);
                result.setMessage("登录成功!");
            } else {
                result.setMessage("密码错误!");
            }
        }
        return result;
    }

    /**
     * 便捷注册接口
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public Result register(HttpServletRequest request) throws Exception {
        Result result = new Result();
        Admin admin = new Admin();
        admin.setAccount("root");
        admin.setPassword("root");
        admin.setCreatetime(new Timestamp(System.currentTimeMillis()));
        admin.setUsername("陈宣锦");
        adminService.saveAdmin(admin);
        result.setCode(StatusCode.OK);
        result.setFlag(Boolean.TRUE);
        log.info("便捷注册管理员");
        result.setMessage("注册成功!");
        return result;
    }

}
