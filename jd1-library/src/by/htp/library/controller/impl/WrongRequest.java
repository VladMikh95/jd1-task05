package by.htp.library.controller.impl;

import by.htp.library.controller.Command;

public class WrongRequest implements Command{

	@Override
	public String execute(String request) {
		return "Invalid request";
	}
}
