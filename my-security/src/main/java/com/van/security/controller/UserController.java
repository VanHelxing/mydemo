package com.van.security.controller;

import com.van.security.domain.SysUser;
import com.van.security.mapper.SysUserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Resource
    private SysUserMapper sysUserMapper;


    @GetMapping("user/findUsers")
    public String findUsersAll(ModelMap modelMap){
        Map<String, Object> params = new HashMap<>();
        List<SysUser> users = sysUserMapper.findByParams(params);
        modelMap.addAttribute("users", users);
        return "user/user";
    }

    @GetMapping("product/findProducts")
    public String findProductAll(){
        return "product/product";
    }


    /**
     * 开始页面
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
