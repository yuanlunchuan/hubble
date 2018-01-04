package com.hubble.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hubble.entiy.Message;
import com.hubble.service.IMessageService;

@Controller
@RequestMapping("/admin/messages")
public class MessageController {
	@Autowired
	private IMessageService messageService;

	@RequestMapping(value={""}, method = RequestMethod.GET)
	public String index(ModelMap modelMap){
		modelMap.addAttribute("messages", messageService.getAll());
		return "admin/messages/index";
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id){
		return "admin/messages/show";
	}
	
	@RequestMapping(value="/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") String id, ModelMap model){
		model.addAttribute("message", messageService.get(id));
		return "admin/messages/edit";
	}

	@RequestMapping(value="", method = RequestMethod.PUT)
	public String update(Message message){
		messageService.save(message);
		return "redirect:/admin/messages";
	}

	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String newPage(){
		return "admin/messages/new";
	}

	@RequestMapping(value="", method = RequestMethod.POST)
	public String create(Message message){
		messageService.save(message);
		return "redirect:/admin/messages";
	}
}
