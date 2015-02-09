package com.springapp.config;

import com.springapp.beans.PersonView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Created with IntelliJ IDEA.
 * User: akol
 * Date: 7/2/13
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class BeanConfig {
  /**
   * Create xml marshaller needed for returning of xml
   * @return xml marshaller
   */
  @Bean(name= {"marshaller", "unmarshaller"})
  public Jaxb2Marshaller xmlMarshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setClassesToBeBound(PersonView.class);
    return marshaller;
  }
}
