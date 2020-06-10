package mx.com.mencrypto.wso2.is.sso.pocsso.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.providers.ExpiringUsernameAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mx.com.mencrypto.wso2.is.sso.pocsso.models.UserModel;
import mx.com.mencrypto.wso2.is.sso.pocsso.services.SamlUserService;

@Controller
@RequestMapping(path ="/", method = RequestMethod.GET)
public class UserController {
	
	private static final Log LOGGER = LogFactory.getLog(UserController.class);
	
//	@Autowired
//	private SamlUserService rolService;
	
	@GetMapping(path ="/")
	public ModelAndView find(ExpiringUsernameAuthenticationToken userToken) {
		ModelAndView mav = new ModelAndView("user/main");
	    UserModel user = (UserModel) userToken.getPrincipal();
	    mav.addObject("user", user);
//		UserModel user2 = this.userService.findByNameContains(name);
		return mav;	
	}
}
