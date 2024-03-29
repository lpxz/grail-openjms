/**
 * Redistribution and use of this software and associated documentation
 * ("Software"), with or without modification, are permitted provided
 * that the following conditions are met:
 *
 * 1. Redistributions of source code must retain copyright
 *    statements and notices.  Redistributions must also contain a
 *    copy of this document.
 *
 * 2. Redistributions in binary form must reproduce the
 *    above copyright notice, this list of conditions and the
 *    following disclaimer in the documentation and/or other
 *    materials provided with the distribution.
 *
 * 3. The name "Exolab" must not be used to endorse or promote
 *    products derived from this Software without prior written
 *    permission of Exoffice Technologies.  For written permission,
 *    please contact info@exolab.org.
 *
 * 4. Products derived from this Software may not be called "Exolab"
 *    nor may "Exolab" appear in their names without prior written
 *    permission of Exoffice Technologies. Exolab is a registered
 *    trademark of Exoffice Technologies.
 *
 * 5. Due credit should be given to the Exolab Project
 *    (http://www.exolab.org/).
 *
 * THIS SOFTWARE IS PROVIDED BY EXOFFICE TECHNOLOGIES AND CONTRIBUTORS
 * ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL
 * EXOFFICE TECHNOLOGIES OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Copyright 2004 (C) Exoffice Technologies Inc. All Rights Reserved.
 *
 * $Id: VMManagedConnectionFactoryTest.java,v 1.1 2010/06/18 16:49:23 smhuang Exp $
 */
package org.exolab.jms.net.vm.connector;

import java.rmi.RemoteException;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.exolab.jms.net.vm.VMManagedConnectionFactory;
import org.exolab.jms.net.uri.URI;
import org.exolab.jms.net.connector.ManagedConnectionFactoryTestCase;
import org.exolab.jms.net.connector.ManagedConnectionFactory;
import org.exolab.jms.net.connector.ConnectionRequestInfo;
import org.exolab.jms.net.connector.URIRequestInfo;


/**
 * Tests the {@link VMManagedConnectionFactory}
 *
 * @version     $Revision: 1.1 $ $Date: 2010/06/18 16:49:23 $
 * @author      <a href="mailto:tma@netspace.net.au">Tim Anderson</a>
 */
public class VMManagedConnectionFactoryTest
    extends ManagedConnectionFactoryTestCase {

    /**
     * Construct an instance of this class for a specific test case.
     *
     * @param name the name of test case
     */
    public VMManagedConnectionFactoryTest(String name) {
        super(name);
    }

    /**
     * Sets up the test suite
     *
     * @return a test suite
     */
    public static Test suite() {
        return new TestSuite(VMManagedConnectionFactoryTest.class);
    }

    /**
     * The main line used to execute the test cases
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    /**
     * Creates a managed connection factory
     *
     * @return the new managed connection factory
     * @throws Exception for any error
     */
    protected ManagedConnectionFactory createManagedConnectionFactory()
        throws Exception {
        return new VMManagedConnectionFactory();
    }

    /**
     * Returns connection request info suitable for creating a managed
     * connection
     *
     * @return connection request info for creating a managed connection
     * @throws Exception for any error
     */
    protected ConnectionRequestInfo getManagedConnectionRequestInfo()
        throws Exception {
        return new URIRequestInfo(new URI("vm://"));
    }

    /**
     * Returns connection request info suitable for creating a managed
     * connection acceptor
     *
     * @return connection request info for creating a managed connection
     * acceptor
     * @throws Exception for any error
     */
    protected ConnectionRequestInfo getAcceptorConnectionRequestInfo()
        throws Exception {
        return new URIRequestInfo(new URI("vm://"));
    }

}
