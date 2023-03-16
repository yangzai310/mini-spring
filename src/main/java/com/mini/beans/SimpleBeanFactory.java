package com.mini.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleBeanFactory implements BeanFactory {

    private List<BeanDefinition> beanDefinitionList = new ArrayList<>();
    private List<String> beanNameList = new ArrayList<>();
    private Map<String, Object> simpleBeanMap = new HashMap<>();

    @Override
    public Object getBean(String className) throws BeansException {
        Object obj = simpleBeanMap.get(className);
        if(obj == null) {
            int i = beanNameList.indexOf(className);
            if (i == -1) {
                throw new BeansException("bean 不存在");
            }
            BeanDefinition beanDefinition = beanDefinitionList.get(i);
            try {
                obj = Class.forName(beanDefinition.getClassName()).newInstance();
                simpleBeanMap.put(beanDefinition.getId(), obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }


    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        beanDefinitionList.add(beanDefinition);
        beanNameList.add(beanDefinition.getId());
    }
}
