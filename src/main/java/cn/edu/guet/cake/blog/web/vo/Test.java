package cn.edu.guet.cake.blog.web.vo;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Test {

    public void xmlBeanFactory(){

        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(""));

    }

}
