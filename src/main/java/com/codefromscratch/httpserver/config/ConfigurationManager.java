package com.codefromscratch.httpserver.config;
import com.codefromscratch.httpserver.util.Json;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigurationManager {
    private static ConfigurationManager myConfigurationManager;
    private Configuration myCurrentConfiguration;

    private ConfigurationManager(){

    }

    public static ConfigurationManager getInstance(){
        if(myConfigurationManager == null){
            ConfigurationManager myConfigurationManager = new ConfigurationManager();
        }
        return myConfigurationManager;
    }

    public void loadConfigurationFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        StringBuilder sb = new StringBuilder();
        int i;
        while((i = fileReader.read()) != -1){
            sb.append((char)i);
        }
        JsonNode conf = Json.parse(sb.toString());
        myCurrentConfiguration = Json.fromJson(conf,Configuration.class);
    }

    public Configuration getCurrentConfiguration(){
        if (myCurrentConfiguration == null){
            throw new HttpConfigurationException("No configuration set");
        }
        return myCurrentConfiguration;

    }


}
