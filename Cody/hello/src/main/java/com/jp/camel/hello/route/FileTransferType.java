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

/**
 *
 *
 *
 * @author dimit.chadha
 * @since 1.0
 * @version 1.0
 */
public enum FileTransferType
{
    COPY_WITHOUT_IMPACTING_ORIGINALS("C"),
    COPY_WITH_ARCHIVED_ORIGINALS("A"),
    MOVE("M");

    private final String letter;

    FileTransferType(final String newLetter)
    {
        this.letter = newLetter;
    }

    public String getLetter()
    {
        return this.letter;
    }

    public static FileTransferType fromLetter(final String letter)
    {
        FileTransferType match = null;
        for (final FileTransferType type : FileTransferType.values())
        {
            if (type.getLetter().equalsIgnoreCase(letter))
            {
                match = type;
                break;
            }
        }
        return match;
    }
}
