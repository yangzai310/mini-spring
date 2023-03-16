package com.mini.context;

import com.mini.beans.*;
public class ClassPathXmlApplicationContext {

    private BeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName) throws Exception {
        ClassPathXmlResource classPathXmlResource = new ClassPathXmlResource(fileName);
        BeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(classPathXmlResource);
        this.beanFactory = beanFactory;
    }

    public Object getBean(String className) throws BeansException {
       return this.beanFactory.getBean(className);
    }
}
