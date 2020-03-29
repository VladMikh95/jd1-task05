package by.htp.library.controller;

public class Controller {
	
	private final CommandProvider provider = new CommandProvider();
	
	public String action(String request) {//registration login=aaa password=bbb name=Ivan
		String[] params;
		Command command;
		
		params = request.split(" ", 2);
		command = provider.getCommand(params[0]);
		
		String response = command.execute(params[1]);
		
		return response;
	}

}
