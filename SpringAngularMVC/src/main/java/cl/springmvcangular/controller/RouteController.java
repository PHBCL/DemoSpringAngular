package cl.springmvcangular.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouteController {

		@RequestMapping(value={"/menu"}, method=RequestMethod.GET)
		public ModelAndView Menu(HttpServletRequest request, ModelMap model)
		{
			return new ModelAndView("menu/menu");	 
		}
		
}
