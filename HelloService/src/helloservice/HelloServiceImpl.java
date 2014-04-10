package helloservice;

import ihelloservice.HelloService;

public class HelloServiceImpl implements HelloService{
	public String getHello() {
		return "Hello!!!!!!";
	}
	
	public String getGoodbye() {
		return "Goodbye!!!!!";
	}
}
