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

import java.io.File;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 *
 *
 * @author dimit.chadha
 * @since 1.0
 * @version 1.0
 */
public class HelloWorld
{

    public static void main(String[] args) throws Exception
    {
        doFileSetup();

        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new SimpleRouteBuilder());
        context.start();
        Thread.sleep(3000);
        context.stop();

    }

    public static void doFileSetup() throws Exception
    {
        File f = new File("c:\\sourceLocation");
        f.delete();
        f.mkdir();
        File fs1 = new File("c:\\sourceLocation\\text1.txt");
        fs1.delete();
        fs1.createNewFile();
        File f1 = new File("c:\\destLocation");
        f1.delete();
        f1.mkdir();
    }
}
