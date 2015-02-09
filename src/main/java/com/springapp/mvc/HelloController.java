package com.springapp.mvc;

import com.springapp.beans.PersonView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

	/*@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		//model.addAttribute("message", "Hello world!");
		return "hello";
	}*/

    @RequestMapping("grid")
    public String showGridInfo() {
        return "grid";
    }

    @RequestMapping("updateGrid")
    public void updateGrid(@RequestBody List<PersonView> persons, Model model) {
        PersonView view = new PersonView();
        view.setAge("333333");
        model.addAttribute(view);
    }

    @RequestMapping("panel")
    public String showPanel() {
        return "panel";
    }

    @RequestMapping("panel2")
    public String showPanel2() {
        return "panel2";
    }
}