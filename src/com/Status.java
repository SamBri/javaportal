package com;

public enum Status{

	// list of status
	SESSION_REDIRECT, 
	SESSION_FORWARDS, 
	REQUEST_REDIRECT, 
	REQUEST_FORWARDS, 
	APPLICATION_REDIRECT, 
	APPLICATION_FORWARDS;
	
	
	Status() {
		
	}
	
	

	//return status to user
	public static String toString(Status s) {

		switch (s) {
		case SESSION_REDIRECT:
			return "Status:" + Status.SESSION_REDIRECT.toString();

		case SESSION_FORWARDS:
			return "Status:" + Status.SESSION_FORWARDS.toString();

		case REQUEST_REDIRECT:
			return "Status:" + Status.REQUEST_REDIRECT.toString();
			
		case REQUEST_FORWARDS:
			return "Status:" + Status.REQUEST_FORWARDS.toString();
			
		case APPLICATION_REDIRECT:
			return "Status:" + Status.APPLICATION_REDIRECT.toString();
			
		case APPLICATION_FORWARDS:
			return "Status:" + Status.APPLICATION_FORWARDS.toString();
		default:
			break;

		}
		
		//no selection, report error
		return "Error, No Selection";
	}

}
