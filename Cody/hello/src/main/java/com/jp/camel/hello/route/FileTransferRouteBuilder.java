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
package com.jp.camel.hello.route;

import com.jp.camel.hello.processor.FileTransferProcessor;
import java.util.Date;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Camel-based Route Builder for transferring files.
 *
 * @author dimit.chadha
 * @since 1.0
 * @version 1.0
 */
public class FileTransferRouteBuilder extends RouteBuilder
{

    private final String fromEndPoint;
    private final String toEndPoint = "file:E:\\datafiles\\output";
    private final static String FROM_BASE = "file:E:\\datafiles\\input";

    /**
     * <p>
     * The "?noop=true" in the "from" call indicates that nothing should be changed about the files
     * in the "input" directory (the processing should have "noop" effect on the source files).
     * </p>
     * <p>
     * "move" the files rather than "copying" them.
     * In such cases, ?delete=true can be specified instead of ?noop=true
     * when specifying the "from" endpoint.
     * </p>
     * <p>
     * <p>
     * <p>
     * </p>
     * */
    private final static String FROM_NOOP = FROM_BASE + "?noop=true";
    private final static String FROM_MOVE = FROM_BASE + "?delete=true";

    public FileTransferRouteBuilder(final FileTransferType fileTransferType)
    {
        if (fileTransferType != null)
        {
            switch (fileTransferType)
            {
                case COPY_WITHOUT_IMPACTING_ORIGINALS:
                    this.fromEndPoint = FROM_NOOP;
                    break;
                case COPY_WITH_ARCHIVED_ORIGINALS:
                    this.fromEndPoint = FROM_BASE;
                    break;
                case MOVE:
                    this.fromEndPoint = FROM_MOVE;
                    break;
                default:
                    this.fromEndPoint = FROM_NOOP;
            }
        }
        else
        {
            fromEndPoint = FROM_NOOP;
        }
    }

    @Override
    public void configure()
    {
        try
        {
            FileTransferProcessor fp = new FileTransferProcessor();
            from(fromEndPoint)
                    .id("file-transfer111111111111111")
                    .doTry()
                    .process(fp)
                    .to(toEndPoint)
                    .doCatch(Exception.class).process(new Processor()
            {
                @Override
                public void process(Exchange exchange) throws Exception
                {
                    System.out.println(((Exception) exchange.getProperty(Exchange.EXCEPTION_CAUGHT)).getMessage());
                }
            });
            log.info("No Source file found!");

        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            System.out.println("OK");
        }

    }

    private Long dateToTime(Exchange e)
    {
        return e.getProperty(Exchange.TIMER_FIRED_TIME, Date.class).getTime();
    }

    private void log(Object b)
    {
        log.info("body is: {}", b);
    }

    private void log(Message m)
    {
        log.info("message is: {}", m);
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
