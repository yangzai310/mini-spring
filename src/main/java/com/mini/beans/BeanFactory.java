package com.mini.beans;

public interface BeanFactory {

    Object getBean(String classId) throws BeansException;

    void registerBeanDefinition(BeanDefinition beanDefinition);

}
