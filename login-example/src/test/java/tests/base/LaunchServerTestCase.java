package tests.base;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;

import server.Configuration;
import server.MainClass;
import server.Configuration.ConfigProps;

public abstract class LaunchServerTestCase {
	private HttpServer server;

	@Before
	public void setUpServer() throws Exception {
		server = MainClass.startServer();
		final String baseUri = Configuration.INSTANCE.readString(ConfigProps.BASE_URI);
		System.out.println("@Before - Grizzly server started on: " + baseUri);
	}

	@After
	public void tearDownServer() {
		server.shutdownNow();
		System.out.println("\n@After - Grizzly server shut down");
	}

}
