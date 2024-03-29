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
 * Copyright 2001-2005 (C) Exoffice Technologies Inc. All Rights Reserved.
 *
 * $Id: DestinationCacheEventListener.java,v 1.1 2010/06/18 16:44:15 smhuang Exp $
 */

package org.exolab.jms.messagemgr;

import java.sql.Connection;
import javax.jms.JMSException;

import org.exolab.jms.message.MessageImpl;
import org.exolab.jms.persistence.PersistenceException;


/**
 * A DestinationCacheEventListener responds to events generated by a {@link
 * DestinationCache}. It gets notified when a message is added or removed for a
 * particular destination.
 *
 * @author <a href="mailto:jima@comware.com.au">Jim Alateras</a>
 * @author <a href="mailto:tma@netspace.net.au">Tim Anderson</a>
 * @version $Revision: 1.1 $ $Date: 2010/06/18 16:44:15 $
 */
interface DestinationCacheEventListener {

    /**
     * This event is called when a non-persistent message is added to a
     * <code>DestinationCache</code>.
     *
     * @param handle  a handle to the added message
     * @param message the added message
     * @return <code>true</code> if the listener accepted the message; otherwise
     *         <code>false</ode>
     * @throws JMSException if the listener fails to handle the message
     */
    boolean messageAdded(MessageHandle handle, MessageImpl message)
            throws JMSException;

    /**
     * This event is called when a message is removed from the
     * <code>DestinationCache</code>.
     *
     * @param messageId the identifier of the removed message
     * @throws JMSException if the listener fails to handle the message
     */
    void messageRemoved(String messageId) throws JMSException;

    /**
     * This event is called when a persistent message is added to the
     * <code>DestinationCache</code>.
     *
     * @param handle     a handle to the added message
     * @param message    the added message
     * @return <code>true</code> if the listener accepted the message;
     * @throws JMSException         if the listener fails to handle the message
     * @throws PersistenceException if there is a persistence related problem
     */
    boolean persistentMessageAdded(MessageHandle handle, MessageImpl message)
            throws JMSException, PersistenceException;

    /**
     * This event is called when a message is removed from the
     * <code>DestinationCache</code>.
     *
     * @param messageId  the identifier of the removed message
     * @throws JMSException         if the listener fails to handle the message
     * @throws PersistenceException if there is a persistence related problem
     */
    void persistentMessageRemoved(String messageId)
            throws JMSException, PersistenceException;
}

