package com.aascar;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by Araja Jyothi Babu on 13-Aug-16.
 */
public class UsingByteBuddy {

    public UsingByteBuddy() {
        ByteBuddyAgent.install();
        new ByteBuddy()
            .redefine(ProxyURLConnection.class)
            .name(HttpURLConnection.class.getName())
            .make()
            .load(HttpURLConnection.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
        System.out.print("-------------------------------Using Proxy Class-----------------------------");
    }
}
