package com.example.com.user.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.com.user.service.UserService;
import com.example.com.user.vo.UserVo;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService userService;
    
    @RequestMapping("/List")
    public ModelAndView list() {

        ModelAndView mv = new ModelAndView();

        List<UserVo> userList = userService.getUserList();

        mv.setViewName("user/List");
        mv.addObject("userList", userList);
        return mv;
    }
    
    @RequestMapping("/WriteForm")
    public String writeForm() {
        return "user/write";
    }
    
    @RequestMapping("/Write")
    public ModelAndView write(UserVo userVo) {
        ModelAndView mv = new ModelAndView();
        userService.insertUser(userVo);
        mv.setViewName("redirect:/User/List");
        return mv;
    }

    @RequestMapping("/View")
    public ModelAndView view(String userid) {
        ModelAndView mv = new ModelAndView();
        UserVo vo = userService.getUser(userid);
        System.out.println("userid: " + vo);
        mv.setViewName("user/view");
        mv.addObject("user", vo);

        return mv;
    }
}
