package fr.daab.corp.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LookingAndMapQueriesService {

    @Value("${queries.location}")
    private String queriesDir;

    protected File getMainSqlFile() {
        final String sqlMainDirValue = queriesDir;
        final File sqlMainDirPath = new File(sqlMainDirValue);
        return sqlMainDirPath;
    }

    public Map<String, Map<String, List<File>>> getSqlVersions() {

        return null;
    }

    protected List<File> getFilesInsideDirectory(File directoryFile){
        List<File> insideFiles = new ArrayList<File>();
        if (directoryFile.isDirectory()){
            for(File insideFile : directoryFile.listFiles()){
                insideFiles.addAll(getFilesInsideDirectory(insideFile));
            }
        }else{
            insideFiles.add(directoryFile);
        }
        return insideFiles;
    }
}
