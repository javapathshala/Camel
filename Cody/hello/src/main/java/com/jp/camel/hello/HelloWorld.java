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

import com.jp.camel.hello.route.FileTransferType;
import com.jp.camel.hello.route.FileTransferRouteBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * Simple executable function to demonstrate Camel file transfer.
 *
 * @author dimit.chadha
 * @since 1.0
 * @version 1.0
 */
public class HelloWorld
{

    private static final long DURATION_MILIS = 10000;

    public static void main(String[] args) throws Exception
    {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new FileTransferRouteBuilder(FileTransferType.MOVE));
        context.start();
        Thread.sleep(DURATION_MILIS);
        context.stop();
    }
}
