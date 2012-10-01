package org.eclipselabs.mongo.impl

import static org.mockito.Mockito.*

/*
 * The **MongoProvider** enables access to the MongoDB driver through a
 * configured OSGi service.  There is one required service property: uri
 * which must be set to the URI of the MongoDB server.  The uri property
 * may be a single URI or a CSV in the case of a replica set.  The remaining
 * properties correspond to the attributes of MongoOptions.
 * 
 */
describe MongoProvider
{
	context "configuration using constructor"
	{
		fact "a single URI passed to the constructor is available through the API and results in a Mongo instance with a single address"
		{
			val uri = "mongodb://localhost/db"
			val provider = new MongoProviderTestHarness(uri)
			provider.URIs.get(0) should be uri
			provider.serverAddresses should be null
			provider.serverAddress.toString should be "localhost:27017"
		}

		fact "multiple URIs passed to the constructor are available through the API and results in a Mongo instance with multiple address"
		{
			val uri = "mongodb://localhost/db:1, mongodb://localhost/db:2, mongodb://localhost/db:3"
			val provider = new MongoProviderTestHarness(uri)
			provider.URIs.size should be 3
			provider.serverAddresses should not be null
			provider.serverAddress should be null
		}
	}
	
	context "configuration"
	{
		fact "configuration with a single URI creates a Mongo with a single address"
		{
			
		}
	}
}