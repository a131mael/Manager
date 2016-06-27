package org.aaf.engine.util;

import javax.naming.InitialContext;

public class ServiceLocator {

	private InitialContext jndiContext;
	private static ServiceLocator instance;

	private ServiceLocator() {
		try {
			jndiContext = new InitialContext();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static ServiceLocator getInstance() {
		if (instance == null) {
			instance = new ServiceLocator();
		}
		return instance;
	}

	public Object getEJB(String jndiName) {
		Object ref = null;
		try {
			ref = jndiContext.lookup(jndiName);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return ref;
	}

}
