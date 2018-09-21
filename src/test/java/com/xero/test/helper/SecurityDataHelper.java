package com.xero.test.helper;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;


public class SecurityDataHelper {


    public Object object =null;
    public Map<Object,Object> map =null;
    public YamlWriter writer=null;
    public YamlReader reader = null;


    public SecurityDataHelper(String path){
        try {
            reader = new YamlReader(new FileReader(path));
            object = reader.read();
            map = (Map)object;
            reader.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    public Hashtable<String, String> getTestData(String testcaseName){
        ArrayList<String> testData = (ArrayList<String>)(map.get(testcaseName));
        Object[][] data = new Object[1][1];
        Hashtable<String, String> hashTable = new Hashtable<String,String>();
        for(int i =0; i< testData.size(); i++)
        {
            String str = testData.get(i);
            String[] split = str.split(":",2);
            String key = split[0];
            String val = split[1];
            String actualValue = stringReplace(val);
            hashTable.put(key,actualValue);
        }
        return hashTable;
    }

    public String stringReplace(String str)
    {
        String reurnString = str.replace("'", "");
        // System.out.println(reurnString);
        return reurnString;
    }

}
