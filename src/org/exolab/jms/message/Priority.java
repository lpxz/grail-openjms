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
 * Copyright 2000,2003 (C) Exoffice Technologies Inc. All Rights Reserved.
 *
 * $Id: Priority.java,v 1.1 2010/06/18 16:47:40 smhuang Exp $
 *
 * Date         Author  Changes
 * 02/26/2000   jimm    Created
 */

package org.exolab.jms.message;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javax.jms.JMSException;


/**
 * Wrapper for JMSPriority
 *
 * @version     $Revision: 1.1 $ $Date: 2010/06/18 16:47:40 $
 * @author      <a href="mailto:mourikis@exolab.org">Jim Mourikis</a>
 */
public class Priority implements Externalizable {

    // Version Id used for streaming
    static final long serialVersionUID = 1;

    private int priority_ = 0;

    public Priority() {

    }

    public Priority(int priority) throws JMSException {
        if (priority >= 0 && priority < 10) {
            priority_ = priority;
        } else {
            throw new JMSException("Invalid priority");
        }
    }


    // Marshall out
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeLong(serialVersionUID);
        out.writeInt(priority_);
    }


    // Marshall in
    public void readExternal(ObjectInput in)
        throws IOException, ClassNotFoundException {
        long version = in.readLong();
        if (version == serialVersionUID) {
            priority_ = in.readInt();
        } else {
            throw new IOException("Incorrect version enountered: " +
                version + " This version = " +
                serialVersionUID);
        }
    }


    public int getPriority() {
        return priority_;
    }

    // expedited messages shouldbe delivered ahead of normal
    public boolean isExpedited() {
        return (priority_ >= 5 ? true : false);
    }

    // Comparisons
    public boolean isGreater(Priority toCompare) {
        return (priority_ > toCompare.priority_);
    }

    // Comparisons
    public boolean isEqual(Priority toCompare) {
        return (priority_ == toCompare.priority_);
    }
}

