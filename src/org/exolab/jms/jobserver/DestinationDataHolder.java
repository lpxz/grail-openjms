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
final public class DestinationDataHolder implements org.omg.CORBA.portable.Streamable
{
    public DestinationData value;

    public
    DestinationDataHolder()
    {
    }

    public
    DestinationDataHolder(DestinationData initial)
    {
        value = initial;
    }

    public void
    _read(org.omg.CORBA.portable.InputStream in)
    {
        value = DestinationDataHelper.read(in);
    }

    public void
    _write(org.omg.CORBA.portable.OutputStream out)
    {
        DestinationDataHelper.write(out, value);
    }

    public org.omg.CORBA.TypeCode
    _type()
    {
        return DestinationDataHelper.type();
    }
}