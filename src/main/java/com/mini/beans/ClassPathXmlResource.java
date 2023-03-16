package com.mini.beans;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;

public class ClassPathXmlResource implements Resource {

    private Document document;
    private Element element;
    private Iterator<Element> iterator;


    public ClassPathXmlResource(String fileName) throws Exception {
        SAXReader saxReader = new SAXReader();
        URL resource = this.getClass().getClassLoader().getResource(fileName);
        document = saxReader.read(resource);
        element = document.getRootElement();
        iterator = element.elements().iterator();
    }


    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public Object next() {
        return this.iterator.next();
    }
}
