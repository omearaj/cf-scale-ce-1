package com.pivotal.scale;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.app.ApplicationInstanceInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private int requestsServed;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		CloudFactory cf = new CloudFactory();
		Cloud cloud = cf.getCloud();
		requestsServed++;
		ApplicationInstanceInfo ai = cloud.getApplicationInstanceInfo();
		model.addAttribute("instance", ai.getAppId());
		Map<String,Object> props = ai.getProperties();
		model.addAttribute("applicationName", props.get("application_name"));
		model.addAttribute("instance", props.get("instance_index"));
		model.addAttribute("ipAddress", request.getLocalAddr());
		model.addAttribute("port", props.get("port"));
		model.addAttribute("requestsServed", requestsServed);
		Map<String, Object> limits = (Map<String, Object>) props.get("limits");
		for(Map.Entry<String, Object> entry : limits.entrySet())
		{
			model.addAttribute(entry.getKey(), entry.getValue());
			//System.out.println("key: " + entry.getKey() + "value: " + entry.getValue());
		}

		return "index";
	}
	
}
