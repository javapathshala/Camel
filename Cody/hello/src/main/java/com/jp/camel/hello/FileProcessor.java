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

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 *
 *
 * @author dimit.chadha
 * @since 1.0
 * @version 1.0
 */
public class FileProcessor implements Processor
{

    public void process(Exchange exchange) throws FileCamelException
    {
        try
        {
            String originalFileName = exchange.getIn().getHeader(Exchange.FILE_NAME, String.class);
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//            int i = 3 / 0;
            String changedFileName = dateFormat.format(date) + "-" + originalFileName;
            exchange.getIn().setHeader(Exchange.FILE_NAME, changedFileName);
            System.out.println("File Moved");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            exchange.setException(e);
//            exchange.getIn().setHeader(Exchange.EXCEPTION_CAUGHT, new FileCamelException("Unable to move file"));
            throw new FileCamelException("Unable to move file.................................");
        }

    }

}
