package com.hubble.util;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class RedirectAttributeHelper {
	public static void successMessage(RedirectAttributes model, String message){
		model.addFlashAttribute("level", "info");
		model.addFlashAttribute("message", message);
	}

	public static void errorMessage(RedirectAttributes model, String message){
		model.addFlashAttribute("level", "error");
		model.addFlashAttribute("message", message);
	}
}
