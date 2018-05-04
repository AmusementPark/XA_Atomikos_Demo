package zsh.demos.xa.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zsh.demos.xa.serv.XAService;

@RestController
@RequestMapping("/")
public class XACtrl {
	
	@Autowired XAService xaService;
	
	@GetMapping("transaction")
	public void doTransaction() {
		xaService.doTransaction();
	}
}
