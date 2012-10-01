package org.eclipselabs.mongo.impl

import org.eclipselabs.mongo.impl.DatabaseAuthenticationProvider
import java.util.HashMap
import java.util.Map
import org.eclipselabs.mongo.IDatabaseAuthenticationProvider

/*
 * The **DatabaseAuthenticationProvider** provides MongoDB credentials
 * as a configured OSGi service.  There are three service properties
 * that must be read by the service: uri, user, and password.
 */
describe DatabaseAuthenticationProvider
{
	Map<String, Object> properties = new HashMap<String, Object>()

	before
	{
		properties.put(IDatabaseAuthenticationProvider::PROP_URI, "mongodb://localhost/db")
		properties.put(IDatabaseAuthenticationProvider::PROP_USER, "user")
		properties.put(IDatabaseAuthenticationProvider::PROP_PASSWORD, "password")
	}
	
	/*
	 * The provider can be configured outside of an OSGi container
	 * using the constructor.
	 */
	context "configuration using the constructor"
	{
		fact "configuration parameters passed to the constructor are available through the API"
		{
			val provider = new DatabaseAuthenticationProvider("mongodb://localhost/db", "user", "password")
			provider.URI should be "mongodb://localhost/db"
			provider.user should be "user"
			provider.password should be "password"
		}
	}

	/*
	 * The configuration parameters are validated with configure().
	 */
	context "configuration"
	{
		fact "configuration parameters are available through the API"
		{
			subject.configure(properties)
			subject.URI should be "mongodb://localhost/db"
			subject.user should be "user"
			subject.password should be "password"
		}
		
		fact "configure throws exception when URI is missing the database name"
		{
			properties.put(IDatabaseAuthenticationProvider::PROP_URI, "mongodb://localhost/")
			subject.configure(properties) throws IllegalStateException
		}

		fact "configure throws exception when URI is missing the database segment"
		{
			properties.put(IDatabaseAuthenticationProvider::PROP_URI, "mongodb://localhost")
			subject.configure(properties) throws IllegalStateException
		}

		fact "configure throws exception when URI is missing"
		{
			properties.put(IDatabaseAuthenticationProvider::PROP_URI, null)
			subject.configure(properties) throws IllegalStateException
		}
	
		fact "configure throws exception when user is missing"
		{
			properties.put(IDatabaseAuthenticationProvider::PROP_USER, null)
			subject.configure(properties) throws IllegalStateException
		}

		fact "configure throws exception when password is missing"
		{
			properties.put(IDatabaseAuthenticationProvider::PROP_PASSWORD, null)
			subject.configure(properties) throws IllegalStateException
		}
	}
}