package com.in28minutes.springboot.myFirstWebApp.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	//http://localhost:8080/say-hello
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
	 return	"Hello.. what are you learing today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<html>");
			sb.append("<head>");
				sb.append("<title>");
					sb.append("my first html page");
				sb.append("</title>");
			sb.append("</head>");
			sb.append("<body>");
				sb.append("<h1>My first html page with body</h1>");
			sb.append("</body>");
		sb.append("</html>");
	
	 return	sb.toString();
	}
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
	 return	"sayHello";
	}
}
