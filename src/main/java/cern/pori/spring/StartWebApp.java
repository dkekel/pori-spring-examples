package cern.pori.spring;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class StartWebApp {

  private static final int PORT = 8080;

  public static void main(String[] args) throws LifecycleException, IOException {
    // Create Tomcat instance
    Tomcat tomcat = new Tomcat();
    tomcat.setPort(PORT);
    tomcat.getConnector();

    // Create temp directory for Tomcat
    File tempDir = Files.createTempDirectory("tomcat-base-dir").toFile();
    tempDir.deleteOnExit();
    tomcat.setBaseDir(tempDir.getAbsolutePath());

    // Add context
    String webappDirLocation = "src/main/webapp/";
    Context context = tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());

    // Add class files to the context
    File additionWebInfClasses = new File("build/classes/java/main");
    WebResourceRoot resources = new StandardRoot(context);
    resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
        additionWebInfClasses.getAbsolutePath(), "/"));
    context.setResources(resources);

    // Start Tomcat
    tomcat.start();
    System.out.println("Application started on port " + PORT);
    tomcat.getServer().await();
  }

}
