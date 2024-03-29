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
 * Copyright 2000-2005 (C) Exoffice Technologies Inc. All Rights Reserved.
 *
 * $Id: JmsTopicSubscriber.java,v 1.1 2010/06/18 16:45:40 smhuang Exp $
 */
package org.exolab.jms.client;

import javax.jms.Topic;
import javax.jms.TopicSubscriber;


/**
 * Client implementation of the <code>javax.jms.TopicSubscriber</code>
 * interface.
 *
 * @author <a href="mailto:jima@comware.com.au">Jim Alateras</a>
 * @author <a href="mailto:tma@netspace.net.au">Tim Anderson</a>
 * @version $Revision: 1.1 $ $Date: 2010/06/18 16:45:40 $
 */
class JmsTopicSubscriber
        extends JmsMessageConsumer
        implements TopicSubscriber {

    /**
     * If <code>true</code>, indicates that locally published messages are
     * inhibited.
     */
    private final boolean _noLocal;


    /**
     * Construct a new <code>JmsTopicSubscriber</code>
     *
     * @param session    the session responsible for the consumer
     * @param consumerId the identity of the consumer
     * @param topic      the topic to subscribe to
     * @param selector   the message selector. May be <code>null</code>
     * @param noLocal    if <code>true</code>, indicates that locally published
     */
    public JmsTopicSubscriber(JmsSession session, long consumerId,
                              Topic topic, String selector,
                              boolean noLocal) {
        super(session, consumerId, topic, selector);
        _noLocal = noLocal;
    }

    /**
     * Returns the topic associated with this subscriber.
     *
     * @return the topic associated with this subscriber
     */
    public Topic getTopic() {
        return (Topic) getDestination();
    }

    /**
     * Returns if locally published messages are being inhibited.
     *
     * @return <code>true</code> if locally published messages are being
     *         inhibited.
     */
    public boolean getNoLocal() {
        return _noLocal;
    }

}

