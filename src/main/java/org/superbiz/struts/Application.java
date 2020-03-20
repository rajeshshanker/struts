/**
 * 
 */
package org.superbiz.struts;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

/**
 * @author rshanker5
 *
 */
@SpringBootApplication
public class Application {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Bean
	public FilterRegistrationBean<SiteMeshFilter> siteMeshFilter() {
		logger.info("In Filter Registration Bean");
		FilterRegistrationBean<SiteMeshFilter> registrationBean = new FilterRegistrationBean<SiteMeshFilter>();
		registrationBean.setFilter(new SiteMeshFilter());
		registrationBean.addUrlPatterns("/*");
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean<StrutsPrepareAndExecuteFilter> strutsPrepareAndExecute() {
		logger.info("Prepare and execute");
		FilterRegistrationBean<StrutsPrepareAndExecuteFilter> registrationBean = new FilterRegistrationBean<StrutsPrepareAndExecuteFilter>();
		registrationBean.setFilter(new StrutsPrepareAndExecuteFilter());
		registrationBean.addUrlPatterns("/", "/addUserForm.action", "/addUser.action", "/findUserForm.action",
				"/findUser.action", "/listAllUsers.action");
		return registrationBean;
	}

}
