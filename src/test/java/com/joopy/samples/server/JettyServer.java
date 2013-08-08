package com.joopy.samples.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {

	public static void main(final String[] args) throws Exception {
		final String webappDirLocation = "src/main/webapp/";

		final Server server = new Server(8080);
		final WebAppContext root = new WebAppContext();

		root.setContextPath("/");
		root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
		root.setResourceBase(webappDirLocation);

		root.setParentLoaderPriority(true);

		server.setHandler(root);

		server.start();
		server.join();
	}
}
