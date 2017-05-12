package mi.billing.home;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class AboutController {

	@ModelAttribute("module")
	String module() {
		return "about";
	}

	@GetMapping("/about")
	@Secured("ROLE_ADMIN")
	String about() {
		return "home/about";
	}
}
