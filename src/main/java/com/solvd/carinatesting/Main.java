package com.solvd.carinatesting;

public class Main {
    public static void main(String[] args) {

        // API
        // _config.properties ---> github_token ---> https://github.com/settings/personal-access-tokens
        // mvn clean test -Dsuite=api

        // WEB
        // (selenium + webdriver) directory --->
            // java -Dwebdriver.chrome.driver=chromedriver -jar selenium-server-4.29.0.jar standalone
            // java -jar selenium-server-4.29.0.jar standalone --selenium-manager true --log-level FINE --log ./trace.log
            // java -jar selenium-server-4.29.0.jar standalone
        // mvn clean test -Dsuite=web

    }
}