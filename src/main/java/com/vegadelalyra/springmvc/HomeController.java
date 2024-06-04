package com.vegadelalyra.springmvc;

import com.vegadelalyra.springmvc.dao.AlienDao;
import com.vegadelalyra.springmvc.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private AlienDao dao;

    @ModelAttribute
    public void modelData(Model m) {
        m.addAttribute("name", "Aliens!");
    }

    @RequestMapping("/")
    public String home() {
        System.out.println("home page requested");

        return "index";
    }

    @RequestMapping("add")
    public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m) {

        int num3 = i + j;
        m.addAttribute("num3", num3);

        return "result";
    }

    @GetMapping("getAliens")
    public String getAliens(Model m) {

        m.addAttribute("result", dao.getAliens());

        return "alienator";
    }

    @GetMapping("getAlien")
    public String getAlien(@RequestParam("aid") int aid, Model m) {

        m.addAttribute("result", dao.getAlien(aid));

        return "alienator";
    }


    @PostMapping("addAlien")
    public String addAlien(@ModelAttribute("result") Alien a) {

        dao.addAlien(a);

        return "alienator";
    }
}
