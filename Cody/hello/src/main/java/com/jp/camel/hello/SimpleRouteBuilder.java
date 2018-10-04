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

import org.apache.camel.builder.RouteBuilder;

/**
 *
 *
 *
 * @author dimit.chadha
 * @since 1.0
 * @version 1.0
 */
public class SimpleRouteBuilder extends RouteBuilder
{

    @Override
    public void configure() throws Exception
    {
        from("file:C:\\sourceLocation?noop=true").process(new SimpleProcessor()).to("file:C:\\destLocation");
    }

}
