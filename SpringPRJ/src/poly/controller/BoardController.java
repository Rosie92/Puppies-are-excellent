package poly.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import poly.service.impl.BoardService;

@Controller
public class BoardController {

	private Logger log = Logger.getLogger(this.getClass().getName());

	@Resource(name = "BoardService")
	private BoardService BoardService;
	
	
	
}
