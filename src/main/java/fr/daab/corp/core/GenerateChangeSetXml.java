package fr.daab.corp.core;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class GenerateChangeSetXml {

    @Value("${classpath:changesetSample.xml}")
    private Resource changeSetTemplateFile;



}
