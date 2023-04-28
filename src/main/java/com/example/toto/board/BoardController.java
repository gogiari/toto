package com.example.toto.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.toto.board.service.BoardService;
import com.example.toto.board.vo.BoardVo;
import com.example.toto.menu.service.MenuService;
import com.example.toto.menu.vo.MenuVo;

@Controller
@RequestMapping("/Board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    private MenuService  menuService;
    
    @RequestMapping("/List")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();

        // 메뉴
        List<MenuVo> menuList = menuService.getMenuList();
        System.out.println(menuList);


        // BoardList - 게시글 목록
        List<BoardVo> boardList = boardService.getBoardList();

        mv.setViewName("board/list");
        mv.addObject("boardList", boardList);
        mv.addObject("menuList", menuList);
        System.out.println("fuck : " + boardList);
        System.out.println("nope" + menuList);
        return mv;
    }
}
