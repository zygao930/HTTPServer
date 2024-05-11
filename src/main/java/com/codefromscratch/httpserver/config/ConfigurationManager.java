package com.codefromscratch.httpserver.config;

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

    public void loadConfigurationFile(String filePath){

    }

    public void getCurrentConfiguration(){

    }


}
