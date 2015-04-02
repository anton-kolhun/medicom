package com.springapp.mvc;

import com.springapp.beans.PersonView;
import com.springapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private PersonService personService;

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

    @RequestMapping("/createPerson")
    public void createPerson() {
        personService.createPerson();
    }

    @RequestMapping("/find")
    public void findPerson() {
        personService.findPerson();
    }
}