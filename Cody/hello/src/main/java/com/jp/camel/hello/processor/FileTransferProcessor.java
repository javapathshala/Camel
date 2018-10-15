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
package com.jp.camel.hello.processor;

import com.jp.camel.hello.exception.FileCamelException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 *
 * @author dimit.chadha
 * @since 1.0
 * @version 1.0
 */
public class FileTransferProcessor implements Processor
{

    private final Logger log = LoggerFactory.getLogger(FileTransferProcessor.class);

    @Override
    public void process(Exchange exchange) throws FileCamelException
    {
        try
        {
            String originalFileName = exchange.getIn().getHeader(Exchange.FILE_NAME, String.class);
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//            int i = 3 / 0;
            String changedFileName = originalFileName + "-" + dateFormat.format(date);
            exchange.getIn().setHeader(Exchange.FILE_NAME, changedFileName);
            log.info("File Moved --> {}", originalFileName);
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            exchange.setException(e);
            throw new FileCamelException("Unable to move file.................................");
        }

    }

}
