package org.mule.examples.oauth2connectorexample.client;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.mule.examples.oauth2connectorexample.entities.UsersListResponse;
import org.mule.examples.oauth2connectorexample.exception.Oauth2ConnectorExampleException;
import org.mule.examples.oauth2connectorexample.exception.Oauth2ConnectorExampleTokenExpiredException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class FourSquareClient {

	static final private Log logger = LogFactory.getLog(FourSquareClient.class);
	
	// / The client used to call the REST Service
	private Client jerseyClient;
	// / The Library used to map from JSON-Pojo & Pojo-JSON
	private ObjectMapper jacksonMapper;
	// / The Base url of the API
	private String apiUrl;
	// / The version of the API
	private String apiVersion;

	public FourSquareClient() {
		this(null, null);
	}

	public FourSquareClient(String apiUrl, String apiVersion) {
		this.apiUrl = StringUtils.isEmpty(apiUrl) ? "https://api.foursquare.com" : apiUrl;
		this.apiVersion = StringUtils.isEmpty(apiVersion) ? "v2" : apiVersion;

		jerseyClient = new Client();
		jacksonMapper = new ObjectMapper();
	}
	
	public UsersListResponse usersGetList(String accessToken, String userId, String group, String location) 
			throws Oauth2ConnectorExampleTokenExpiredException, Oauth2ConnectorExampleException {
		
		logger.info("Calling usersGetList - AccessToken: " + accessToken);
		
		URI uri = UriBuilder.fromPath(apiUrl).path("/{apiVersion}/users/{USER_ID}/lists").build(apiVersion, userId);
		WebResource wr = jerseyClient.resource(uri);
		
		// Warning!... queryParam does not modify the current WebResource. Instead it returns a new instance.
		// So, if you do not assign the result WebResource to the one that makes the call, the param will never be added
		wr = wr.queryParam("oauth_token", accessToken);
		
		if (StringUtils.isNotEmpty(group))
			wr = wr.queryParam("group", group);
		
		if (StringUtils.isNotEmpty(location))
			wr = wr.queryParam("ll", location);
		
		UsersListResponse result = null;
		
		try {
			logger.info(wr.toString());			
			String res = wr.type(MediaType.APPLICATION_JSON_TYPE).get(String.class);
			logger.info("Response: " + res);
			result = jacksonMapper.readValue(res, UsersListResponse.class);
			
		} catch (UniformInterfaceException e) {
			ClientResponse cl = e.getResponse();
			int statusCode = cl.getStatus();
			String message = "";
			try {
				message = cl.getEntity(String.class);
			} catch (Throwable ex) {}
			
			// If the result code is 401 it means that the actual token passed in the call is no longer valid
			if (statusCode == 401) {
				throw new Oauth2ConnectorExampleTokenExpiredException("The access token has expired", e);
			} else {
				throw new Oauth2ConnectorExampleException(
						String.format("ERROR - statusCode: %d - message: %s", statusCode, message), 
						e);
			}
		} catch (JsonParseException e) {
			throw new Oauth2ConnectorExampleException("ERROR - Error Parsing the JSON", e);
		} catch (JsonMappingException e) {
			throw new Oauth2ConnectorExampleException("ERROR - Error Parsing the JSON", e);
		} catch (IOException e) {
			throw new Oauth2ConnectorExampleException(e);
		}
		
		return result;
	}
}
