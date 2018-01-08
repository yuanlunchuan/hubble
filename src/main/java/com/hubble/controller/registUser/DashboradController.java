package com.hubble.controller.registUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hubble.service.IMessageService;
import com.hubble.util.Enquiry;

@Controller
@RequestMapping("/registUser/dashborad")
public class DashboradController {
	@Autowired
	private IMessageService messageService;

	@RequestMapping(value="", method=RequestMethod.GET)
	public String show(@RequestParam(value="pageSize", defaultValue="10", required=false) Integer pageSize,
			@RequestParam(value="pageNumber", defaultValue="1", required=false) Integer pageNumber,
			ModelMap model){
		Enquiry enquiry = new Enquiry();
		enquiry.setPageNumber(pageNumber);
		enquiry.setPageSize(pageSize);

		model.addAttribute("messages", messageService.findByEnquiry(enquiry));
		return "registUser/dashborad/show";
	}
}
