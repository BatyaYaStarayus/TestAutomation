package main.java;

import sun.net.www.URLConnection;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by ivan.kozlov on 27.03.2017.
 */
public class FileCreation {

    protected void createTestReportFile(String gameName) {

        File testReportFile = new File(setTestReportFileName(gameName));

    }

    protected String getGameLegalName(String gameName) throws IOException{

        URL gisURL = new URL("https://gis.netent.com/game/gamelist/");
        java.net.URLConnection smth = gisURL.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(smth.getInputStream()));

//        @TODO
        String gameLegalName = "";
        return gameLegalName;
    }

    protected String setTestReportFileName(String gameName) {

        String latestReleasedDistribution = "";
        String testReportFileName = ("Test Report " + gameName + " " + latestReleasedDistribution);

        return testReportFileName;
    }

}
