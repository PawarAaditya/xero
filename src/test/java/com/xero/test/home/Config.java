package com.xero.test.home;

import java.io.*;
import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import java.util.*;


public class Config {


    public String getSecurityQuestionsAnswer(String question){

        String result="NA";
        File yamlFile = new File(getClass().getClassLoader().getResource("/resources/security.yml").getFile());
        YamlReader yamlReader = null;
         try {
            yamlReader = new YamlReader(new FileReader(yamlFile));
            Map map = (Map) yamlReader.read();
            Map wfNamesMap = (Map) map.get("SecurityQuestions");
            Map wfNameMap = (Map) wfNamesMap.get(question);
            result = wfNameMap.get(question).toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (YamlException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }


    }

