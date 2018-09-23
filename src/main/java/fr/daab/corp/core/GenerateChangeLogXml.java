package fr.daab.corp.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class GenerateChangeLogXml {

    @Value("${classpath:databaseChangeLogSample.xml}")
    private Resource changelogSampleFile;

    public void parsingScript(){

    }
}
