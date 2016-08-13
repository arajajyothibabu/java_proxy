package com.aascar;

import sun.util.logging.PlatformLogger;

import java.net.HttpURLConnection;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) throws Exception {

        //AbstractFactory.createDefaultImplementation(HttpURLConnection.class);
        new UsingByteBuddy();
        //PlatformLogger platformLogger = PlatformLogger.getLogger("sun.net.www.protocol.http.HttpURLConnection");
        //platformLogger.setLevel(PlatformLogger.Level.ALL);
        new SampleHttpUrlConnection();
        //SampleHttpUrlConnection sampleHttpUrlConnection = (SampleHttpUrlConnection) ProxyHttpUrlConnection.newInstance(new SampleHttpUrlConnection());

    }
}
