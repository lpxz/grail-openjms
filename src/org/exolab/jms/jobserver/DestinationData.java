// **********************************************************************
//
// Generated by the ORBacus IDL to Java Translator
//
// Copyright (c) 2005
// IONA Technologies, Inc.
// Waltham, MA, USA
//
// All Rights Reserved
//
// **********************************************************************

// Version: 4.3.2

package org.exolab.jms.jobserver;

//
// IDL:org.exolab.jms/org/exolab/jms/jobserver/DestinationData:1.0
//
/***/

final public class DestinationData implements org.omg.CORBA.portable.IDLEntity
{
    private static final String _ob_id = "IDL:org.exolab.jms/org/exolab/jms/jobserver/DestinationData:1.0";

    public
    DestinationData()
    {
    }

    public
    DestinationData(byte[] content)
    {
        this.content = content;
    }

    public byte[] content;
}