package fr.daab.corp.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context.xml")
public class LookingAndMapQueriesServiceTest {
    @Autowired
    private LookingAndMapQueriesService lookingAndMapQueriesService;

    @Test
    public void testGetSqlMainDir() throws IOException {
        final File mainSqlFile = lookingAndMapQueriesService.getMainSqlFile();
        Assert.assertTrue(mainSqlFile.isDirectory());
    }

    @Test
    public void testGetVersionSchemaAndFilesTest() {
        // prepare
        final Map<String, Map<String, List<File>>> expectedMap = expectedMap();

        final Map<String, Map<String, List<File>>> actualMap = lookingAndMapQueriesService.getSqlVersions();

        Assert.assertEquals(expectedMap.keySet().iterator().next(), actualMap.keySet().iterator().next());
    }


    @Test
    public void testGetFilesInsideDirectory(){

        List<File> existingSqlFiles = lookingAndMapQueriesService.getFilesInsideDirectory(lookingAndMapQueriesService.getMainSqlFile());

        Assert.assertEquals(12,existingSqlFiles.size());
    }

    private Map<String, Map<String, List<File>>> expectedMap() {
        final Map<String, Map<String, List<File>>> expected = new HashMap<String, Map<String, List<File>>>();
        final Map<String, List<File>> expectedMap = new HashMap<String, List<File>>();

        final List<File> expectedEdlFiles = new ArrayList<File>();
        expectedEdlFiles.add(new File("sqlFiles/2018-MW-36/EDL-ING-2366/EDL-ING-2366_01_create_table.sql"));
        expectedEdlFiles.add(new File("sqlFiles/2018-MW-36/EDL-ING-2366/EDL-ING-2366_02_insert_data.sql"));
        expectedEdlFiles.add(new File("sqlFiles/2018-MW-36/EDL-ING-2366/EDL-ING-2366_03_inser_ref_data.sql"));
        expectedMap.put("EDL", expectedEdlFiles);

        final List<File> expectedImmFiles = new ArrayList<File>();
        expectedImmFiles.add(new File("sqlFiles/2018-MW-36/IMM-ING-2366/IMM-ING-2366_01_create_table.sql"));
        expectedImmFiles.add(new File("sqlFiles/2018-MW-36/IMM-ING-2366/IMM-ING-2366_02_insert_data.sql"));
        expectedImmFiles.add(new File("sqlFiles/2018-MW-36/IMM-ING-2366/IMM-ING-2366_03_inser_ref_data.sql"));
        expectedMap.put("IMM", expectedImmFiles);

        final List<File> expectedMmdFiles = new ArrayList<File>();
        expectedMmdFiles.add(new File("sqlFiles/2018-MW-36/MMD-ING-2366/MMD-ING-2366_01_create_table.sql"));
        expectedMmdFiles.add(new File("sqlFiles/2018-MW-36/MMD-ING-2366/MMD-ING-2366_02_insert_data.sql"));
        expectedMmdFiles.add(new File("sqlFiles/2018-MW-36/MMD-ING-2366/MMD-ING-2366_03_inser_ref_data.sql"));

        expectedMmdFiles.add(new File("sqlFiles/2018-MW-36/MMD-ING-2366/MMD-ING-2366_04_create_table.sql"));
        expectedMmdFiles.add(new File("sqlFiles/2018-MW-36/MMD-ING-2366/MMD-ING-2366_05_insert_data.sql"));
        expectedMmdFiles.add(new File("sqlFiles/2018-MW-36/MMD-ING-2366/MMD-ING-2366_06_inser_ref_data.sql"));
        expectedMap.put("MMD", expectedMmdFiles);

        expected.put("2018-MW-36", expectedMap);
        return expected;
    }
}
