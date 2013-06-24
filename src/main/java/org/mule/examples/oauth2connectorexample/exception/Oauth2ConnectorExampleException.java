package org.mule.examples.oauth2connectorexample.exception;

@SuppressWarnings("serial")
public class Oauth2ConnectorExampleException extends Exception {

	public Oauth2ConnectorExampleException() {
	}

	public Oauth2ConnectorExampleException(String message) {
		super(message);
	}

	public Oauth2ConnectorExampleException(Throwable cause) {
		super(cause);
	}

	public Oauth2ConnectorExampleException(String message, Throwable cause) {
		super(message, cause);
	}

}
