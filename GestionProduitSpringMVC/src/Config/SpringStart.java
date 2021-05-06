package Config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//ANNOTATIO : pour dire à spring que c'est une classe  config
@Configuration
@EnableWebMvc //Pour activer le support Spring MVC via une classe de configuration Java Cela permettra de mettre en place le support de base dont nous avons besoin pour un projet MVC, comme les contrôleurs d'enregistrement et les mappages...
@ComponentScan(basePackageClasses = SpringStart.class)//RECONNAIRE LA CLASSE C'EST UN POINT DE DEPART POINT DE CONFIG
public class SpringStart implements WebApplicationInitializer{
	
//IMPLEMENTER LES METHODE DE CETTE INTERFACE 
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("Apps is Starting!!!");
		AnnotationConfigWebApplicationContext webCtxt= new AnnotationConfigWebApplicationContext();
		webCtxt.register(SpringStart.class);
		webCtxt.setServletContext(servletContext);
		ServletRegistration.Dynamic servlet=servletContext.addServlet("ServletDispatcher", new DispatcherServlet(webCtxt)); //DECLARER SERVLET DISPATCHER 
		servlet.setLoadOnStartup(1);
		//IMPORTANT
		servlet.addMapping("*.do"); //URL QUI SE TERMINE PAR EXT DO
		servlet.addMapping("/actions/*");//ET J'ACCEPTE QUI CONTIENT /ACTIONS
		
	}
}