package org.mule.examples.oauth2connectorexample.exception;

@SuppressWarnings("serial")
public class Oauth2ConnectorExampleTokenExpiredException extends Exception {

	public Oauth2ConnectorExampleTokenExpiredException() {
	}

	public Oauth2ConnectorExampleTokenExpiredException(String message) {
		super(message);
	}

	public Oauth2ConnectorExampleTokenExpiredException(Throwable cause) {
		super(cause);
	}

	public Oauth2ConnectorExampleTokenExpiredException(String message, Throwable cause) {
		super(message, cause);
	}
}
