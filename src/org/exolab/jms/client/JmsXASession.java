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
 * Copyright 2005 (C) Exoffice Technologies Inc. All Rights Reserved.
 *
 * $Id: JmsXASession.java,v 1.1 2010/06/18 16:45:38 smhuang Exp $
 */
package org.exolab.jms.client;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TransactionInProgressException;
import javax.jms.XASession;
import javax.transaction.xa.XAResource;


/**
 * Client implementation of the <code>javax.jms.XASession</code> interface.
 *
 * @author <a href="mailto:tma@netspace.net.au">Tim Anderson</a>
 * @version $Revision: 1.1 $ $Date: 2010/06/18 16:45:38 $
 */
class JmsXASession
        extends JmsSession
        implements XASession {

    /**
     * The XA resource.
     */
    private JmsXAResource _xares;


    /**
     * Construct a new <code>JmsXASession</code>.
     *
     * @param connection the owner of the session
     * @throws JMSException if the session cannot be created
     */
    public JmsXASession(JmsConnection connection) throws JMSException {
        super(connection, true, Session.CLIENT_ACKNOWLEDGE);
        _xares = new JmsXAResource(getServerSession());
    }

    /**
     * Gets the session associated with this <code>XASession</code>.
     *
     * @return the  session object
     */
    public Session getSession() {
        return this;
    }

    /**
     * Returns an XA resource to the caller.
     *
     * @return an XA resource to the caller
     */
    public XAResource getXAResource() {
        return _xares;
    }

    /**
     * Indicates whether the session is in transacted mode.
     *
     * @return true
     */
    public boolean getTransacted() {
        return true;
    }

    /**
     * Throws a <code>TransactionInProgressException</code>, since it should not
     * be called for an <code>XASession</code> object.
     *
     * @throws TransactionInProgressException if invoked
     */
    public void commit() throws JMSException {
        throw new TransactionInProgressException(
                "Cannot call commit on XASession");
    }

    /**
     * Throws a <code>TransactionInProgressException</code>, since it should not
     * be called for an <code>XASession</code> object.
     *
     * @throws TransactionInProgressException if invoked
     */
    public void rollback() throws JMSException {
        throw new TransactionInProgressException(
                "Cannot call rollback on XASession");
    }

}
