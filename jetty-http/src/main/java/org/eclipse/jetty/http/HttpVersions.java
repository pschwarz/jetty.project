// ========================================================================
// Copyright (c) 2004-2009 Mort Bay Consulting Pty. Ltd.
// ------------------------------------------------------------------------
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// and Apache License v2.0 which accompanies this distribution.
// The Eclipse Public License is available at 
// http://www.eclipse.org/legal/epl-v10.html
// The Apache License v2.0 is available at
// http://www.opensource.org/licenses/apache2.0.php
// You may elect to redistribute this code under either of these licenses. 
// ========================================================================

package org.eclipse.jetty.http;

import java.nio.ByteBuffer;

import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.StringMap;


/* ------------------------------------------------------------------------------- */
public enum HttpVersions
{
    HTTP_0_9("HTTP/0.9",9),
    HTTP_1_0("HTTP/1.0",10),
    HTTP_1_1("HTTP/1.1",11);
    
    /* ------------------------------------------------------------ */
    public final static StringMap<HttpVersions> CACHE= new StringMap<HttpVersions>(true);
    static
    {
        for (HttpVersions version : HttpVersions.values())
            CACHE.put(version.toString(),version);
    }
    
    private final String _string;
    private final ByteBuffer _buffer;
    private final int _version;

    /* ------------------------------------------------------------ */
    HttpVersions(String s,int version)
    {
        _string=s;
        _buffer=BufferUtil.toBuffer(s);
        _version=version;
    }

    /* ------------------------------------------------------------ */
    public ByteBuffer toBuffer()
    {
        return _buffer.asReadOnlyBuffer();
    }
    
    /* ------------------------------------------------------------ */
    public int getVerion()
    {
        return _version;
    }

    /* ------------------------------------------------------------ */
    public String toString()
    {
        return _string;
    }
}
