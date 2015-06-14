package server;

import java.io.IOException;
import java.net.URI;

import org.apache.log4j.PropertyConfigurator;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import server.Configuration.ConfigProps;

/**
 * Main class.
 * 
 */
public class MainClass {

	private static final String LOG_PROPERTIES_FILE = "config/log4j.properties";

	private static String baseUri;

	/**
	 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
	 * application.
	 * 
	 * @return Grizzly HTTP server.
	 */
	public static HttpServer startServer() {
		// create a resource config that scans for JAX-RS resources and
		// providers
		// in com.example package
		final ResourceConfig rc = new ResourceConfig().packages("server.controller.resource");

		// create and start a new instance of grizzly http server
		// exposing the Jersey application at BASE_URI
		baseUri = Configuration.INSTANCE.readString(ConfigProps.BASE_URI);
		final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(baseUri), rc);
		StaticHttpHandler staticHttpHandler = new StaticHttpHandler(
				Configuration.INSTANCE.readString(ConfigProps.DOC_ROOT_FOLDER));
		staticHttpHandler.setFileCacheEnabled(false);
		server.getServerConfiguration().addHttpHandler(staticHttpHandler);
		return server;
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		configureLogger();
		final HttpServer server = startServer();
		System.out.println(String.format("Report server started with WADL available at "
				+ "%sapplication.wadl\nHit enter to stop it...", baseUri));
		System.in.read();
		server.shutdownNow();
	}

	private static void configureLogger() {
		PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
	}



}
