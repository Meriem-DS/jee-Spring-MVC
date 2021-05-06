package Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("Controller")
public class AppConfig {
	@Bean //POUR DIRE QUE C'EST UNE CLASSE
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver(); //PERMET DE SAVOIR OU SE TROUVE JSP ET SERVLET DANS NOTRE PROJET
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");//PATH OU SE TROUVE FICHIERS
		resolver.setSuffix(".jsp");//EXTENSION DES FICHIE RECHERCHE
		return resolver;
	}

}