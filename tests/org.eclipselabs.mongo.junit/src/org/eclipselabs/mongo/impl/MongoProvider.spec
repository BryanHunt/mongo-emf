package org.eclipselabs.mongo.impl

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
	context "single database"
	{
		context "using constructor"
		{
			
		}		
	}
	
	context "replica set"
	{
		context "using constructor"
		{
			
		}		
	}
}