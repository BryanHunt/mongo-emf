
package org.eclipselabs.mongoemf.examples.bnd.eclipse;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.emodeling.ResourceSetFactory;
import org.eclipselabs.emodeling.UriHandlerProvider;
import org.eclipselabs.mongoemf.example.model.Child;
import org.eclipselabs.mongoemf.example.model.ModelFactory;
import org.eclipselabs.mongoemf.example.model.Parent;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class MongoEmfComponent
{
	private ResourceSetFactory resourceSetFactory;
	private static final int CHILD_COUNT = 10;
	private static final int PARENT_COUNT = 10;

	@Activate
	public void activate() throws Exception
	{
		System.out.println("Starting Mongo EMF example");
		System.out.print("Writing data to MongoDB");
		URI firstParent = null;

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < PARENT_COUNT; i++)
		{
			if (i % 100 == 0)
				System.out.println();

			System.out.print(".");
			ResourceSet resourceSet = resourceSetFactory.createResourceSet();

			Parent parent = ModelFactory.eINSTANCE.createParent();
			parent.setName("Parent " + i);

			for (int j = 0; j < CHILD_COUNT; j++)
			{
				Child child = ModelFactory.eINSTANCE.createChild();
				child.setName("Child " + i + " " + j);
				parent.getChildren().add(child);

				Resource resource = resourceSet.createResource(URI.createURI("mongodb://localhost/test/Child/"));
				resource.getContents().add(child);

				try
				{
					resource.save(null);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}

			Resource resource = resourceSet.createResource(URI.createURI("mongodb://localhost/test/Parent/"));
			resource.getContents().add(parent);

			try
			{
				resource.save(null);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

			if (firstParent == null)
				firstParent = resource.getURI();
		}

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Time to create " + (PARENT_COUNT * CHILD_COUNT) + " objects: " + ((endTime - startTime) / 1000.0) + " sec");
		ResourceSet resourceSet = resourceSetFactory.createResourceSet();

		startTime = System.currentTimeMillis();
		Resource resource = resourceSet.getResource(firstParent, true);
		endTime = System.currentTimeMillis();
		System.out.println("Time to get first parent: " + (endTime - startTime) + " ms");

		Parent parent = (Parent) resource.getContents().get(0);

		startTime = System.currentTimeMillis();

		for (Child child : parent.getChildren())
			child.getName();

		endTime = System.currentTimeMillis();
		System.out.println("Time to walk " + CHILD_COUNT + " children of first parent: " + (endTime - startTime) + " ms");
		System.out.println("All done");
	}

	@Reference(unbind = "-")
	void bindResourceSetFactory(ResourceSetFactory resourceSetFactory)
	{
		this.resourceSetFactory = resourceSetFactory;
	}

	@Reference(unbind = "-")
	void bindUriHandlerProvider(UriHandlerProvider uriHandlerProvider)
	{}
}
