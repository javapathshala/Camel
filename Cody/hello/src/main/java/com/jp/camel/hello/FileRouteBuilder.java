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

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 *
 *
 *
 * @author dimit.chadha
 * @since 1.0
 * @version 1.0
 */
public class FileRouteBuilder extends RouteBuilder
{

    @Override
    public void configure()
    {
        try
        {
            FileProcessor fp = new FileProcessor();
            from("file:C:\\sourceLocation?noop=true")
                    .doTry()
                    .process(fp)
                    .to("file:C:\\destLocation")
                    .doCatch(FileCamelException.class).process(new Processor()
            {
                public void process(Exchange exchange) throws Exception
                {
                    System.out.println(((Exception) exchange.getProperty(Exchange.EXCEPTION_CAUGHT)).getMessage());
                }
            });

        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            System.out.println("OK");
        }

    }

//    @Override
//    public void configure() throws Exception
//    {
//        from("file:C:/inputFolder?noop=true").doTry().process(new MyProcessor()).to("file:C:/outputFolder")
//                .doCatch(CamelCustomException.class).process(new Processor()
//        {
//
//            public void process(Exchange exchange) throws Exception
//            {
//                System.out.println("handling ex");
//            }
//        }).log("Received body ");
//
//        from("file:C:/inbox?noop=true").process(new MyProcessor()).to("file:C:/outbox");
//    }
}
