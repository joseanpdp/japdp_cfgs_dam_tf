package japdp.damtf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración para redireccionar las solicitudes a la página de inicio de la aplicación React.
 * Implementa WebMvcConfigurer para configurar el enrutamiento de vistas.
 */
@Configuration
public class ForwardToIndexConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		String viewName = "forward:/react/index.html";
		registry.addViewController("/react").setViewName(viewName);
		registry.addViewController("/react/").setViewName(viewName);
	}

}
