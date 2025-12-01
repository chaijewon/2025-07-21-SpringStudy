package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// router
@Controller
public class FoodController {
   @GetMapping("food/detail.do")
   public String food_detail(int fno, Model model)
   {
	   model.addAttribute("fno", fno);
	   model.addAttribute("main_jsp", "../food/detail.jsp");
	   return "main/main";
   }
}
