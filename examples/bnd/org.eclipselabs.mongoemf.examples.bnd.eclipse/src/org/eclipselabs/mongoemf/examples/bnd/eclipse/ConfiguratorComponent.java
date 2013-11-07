
package org.eclipselabs.mongoemf.examples.bnd.eclipse;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipselabs.emongo.MongoClientProvider;
import org.eclipselabs.emongo.MongoDatabaseProvider;
import org.eclipselabs.emongo.config.ConfigurationProperties;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class ConfiguratorComponent
{
	private volatile ConfigurationAdmin configurationAdmin;

	@Activate
	public void activate() throws IOException
	{
		Configuration config = configurationAdmin.createFactoryConfiguration(ConfigurationProperties.CLIENT_PID, null);

		Dictionary<String, Object> properties = new Hashtable<String, Object>();

		properties.put(MongoClientProvider.PROP_CLIENT_ID, "example");
		properties.put(MongoClientProvider.PROP_URI, "mongodb://localhost");
		config.update(properties);

		config = configurationAdmin.createFactoryConfiguration(ConfigurationProperties.DATABASE_PID, null);
		properties = new Hashtable<String, Object>();
		properties.put(MongoDatabaseProvider.PROP_CLIENT_FILTER, "(" + MongoClientProvider.PROP_CLIENT_ID + "=example)");
		properties.put(MongoDatabaseProvider.PROP_ALIAS, "example");
		properties.put(MongoDatabaseProvider.PROP_DATABASE, "test");
		config.update(properties);
	}

	@Reference(unbind = "-")
	public void bindConfigurationAdmin(ConfigurationAdmin configurationAdmin)
	{
		this.configurationAdmin = configurationAdmin;
	}
}
