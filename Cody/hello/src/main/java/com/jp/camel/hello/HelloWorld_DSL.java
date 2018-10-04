/*
 * Copyright (c) Java Pathshala
 * Wisdom Being Shared
 * All rights reserved.
 *
 * No parts of this source code can be reproduced without written consent from
 * Java Pathshala
 * JavaPathshala.com
 *
 */
package com.jp.camel.hello;

import static com.jp.camel.hello.HelloWorld.doFileSetup;
import java.io.File;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 *
 *
 * @author dimit.chadha
 * @since 1.0
 * @version 1.0
 */
public class HelloWorld_DSL
{

    private static final long DURATION_MILIS = 100;
    private static final String SOURCE_FOLDER = "c:\\sourceLocation";
    private static final String DESTINATION_FOLDER = "c:\\destLocation";

    public static void main(String[] args) throws Exception
    {
        doFileSetup();
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("app-context-camel.xml");
        context.start();
        System.out.println("File moved !");
        Thread.sleep(DURATION_MILIS);
        context.stop();
    }

    public static void doFileSetup() throws Exception
    {
        File f = new File(SOURCE_FOLDER);
        f.delete();
        f.mkdir();
        File fs1 = new File("c:\\sourceLocation\\text1.txt");
        fs1.delete();
        fs1.createNewFile();
        File f1 = new File(DESTINATION_FOLDER);
        f1.delete();
        f1.mkdir();
    }
}
