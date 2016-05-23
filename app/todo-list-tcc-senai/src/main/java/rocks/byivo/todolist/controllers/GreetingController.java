/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author byivo
*/
@Controller
public class GreetingController {
    
  
    @RequestMapping("welcome")
    public ModelAndView greeting() {
        
       return new ModelAndView("welcome", "message", "Hello World");
    }
    
    @RequestMapping("welcome2")
    @ResponseBody
    public String greeting2() {
        
       return "YEAHOOOO";
    }
}
