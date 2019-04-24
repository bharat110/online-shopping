package net.kzn.onlineshopping.controller;

import javax.ws.rs.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		// passing the list of categories
		mv.addObject("greeting", "hello");

		return mv;
	}

	@RequestMapping(value = "/greeting")
	public ModelAndView test(@RequestParam("greeting") String greeting) {

		ModelAndView mav = new ModelAndView("page");
		mav.addObject("greeting", greeting);
		return mav;
	}
	
	@RequestMapping(value = "/test/{test}")
	public ModelAndView pathVariable(@PathVariable("test") String test) {

		ModelAndView mav = new ModelAndView("page");
		mav.addObject("test", test);
		return mav;
	}

}
