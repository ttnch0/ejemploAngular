package com.example.crudApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.crudApp.Models.User;
import com.example.crudApp.Service.userService;

@Controller
@RequestMapping("/users")
public class userController {
	
	private userService userServ;
	
	@Autowired
	public userController(userService userServ) {
		this.userServ = userServ;
	}
	
	// add mapping for "/list"
		@GetMapping("/list")
		public String userList(Model model) {
			
			// get employees from data base
			List<User> users = userServ.findAll();
				
			// add to the spring model
			model.addAttribute("users", users);
			 
			return "users/list-users";
		}
			
		// add mapping for "/add" to add new employees
		@GetMapping("/add")
		public String addUser(Model model) {
				
			// create model attribute to bind form data
			User user = new User();
				
			model.addAttribute("user", user);
				
			return "users/register-users";
		}
			
		@GetMapping("/update")
		public String updateUser(@RequestParam("userId") int id, Model model) {
			
			// get the employee from the service
			User user = userServ.findById(id);
				
			// set employee as a model attribute to pre-populate the form
			model.addAttribute("user", user);
				
			// send over to our form
			return "users/register-users";
		}
			
		@GetMapping("/delete")
		public String delete(@RequestParam("userId") int id) {
				
			// delete employee
			userServ.deleteById(id);
				
			// return to list
			return "redirect:/users/list";
		}
			
		@PostMapping("/save")
		public String saveUser(@ModelAttribute("user") User user) {
				
			// save the employee
			userServ.save(user);
				
			// use a redirect to prevent duplicated submissions
			return "redirect:/users/list";
		}

}
