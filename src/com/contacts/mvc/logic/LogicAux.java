package com.contacts.mvc.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.contacts.mvc.logic.aux.Constants;

public class LogicAux {

    private static final Logger logger = LogManager.getLogger(LogicAux.class);
	
	private LogicAux() {}
	
	public static Logic getLogic(String className) throws ClassNotFoundException {
		
		Class<?> classLogic = null;
		Logic logic = null;
		
	    try {
	    	classLogic = Class.forName(Constants.PACKAGE_LOGIC + className);
	    } catch (ClassNotFoundException e) {
	    	logger.error("Logic not found", e);
	    	classLogic = Class.forName(Constants.PACKAGE_LIST);
	    }
	    
	    try {
	    	logic = (Logic) classLogic.newInstance();
	    } catch (InstantiationException | IllegalAccessException e) {
	    	logger.error("Error instantiating new Logic", e);
	    }
	    
	    return logic;
	}

}