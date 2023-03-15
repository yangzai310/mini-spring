package com.mini.domain.core;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext {

    private String fileName;

    private List<BeanDefinition> beanDefinitionList = new ArrayList<>();

    private Map<String, Object> beanDefinitionMap = new HashMap<>();

    public ClassPathXmlApplicationContext(String fileName) throws Exception {
        this.fileName = fileName;
        readXml();
        initBeanDefinitions();
    }

    private void readXml() throws Exception{
        SAXReader saxReader = new SAXReader();
        URL resource = this.getClass().getClassLoader().getResource(this.fileName);
        Document document = saxReader.read(resource);
        Element rootElement = document.getRootElement();
        for (Element element : (List<Element>) rootElement.elements()) {
            String id = element.attributeValue("id");
            String className = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setId(id);
            beanDefinition.setClassName(className);
            beanDefinitionList.add(beanDefinition);
        }
    }

    private void initBeanDefinitions() throws Exception {
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            Class<?> aClass = Class.forName(beanDefinition.getClassName());
            Object obj = aClass.newInstance();
            beanDefinitionMap.put(beanDefinition.getId(), obj);
        }
    }

    public Object getBean(String classId) {
        return beanDefinitionMap.get(classId);
    }
}
