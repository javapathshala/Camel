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

/**
 *
 *
 *
 * @author dimit.chadha
 * @since 1.0
 * @version 1.0
 */
public class SimpleProcessor implements Processor
{

    public void process(Exchange exchange) throws Exception
    {
        System.out.println("hello --> " + exchange.getCreated() + " ## " + exchange.getExchangeId());
    }

}
