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
 * $Id: SocketEndpoint.java,v 1.1 2010/06/18 16:49:01 smhuang Exp $
 */

package org.exolab.jms.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.exolab.jms.net.multiplexer.Endpoint;
import org.exolab.jms.net.uri.URI;
import org.exolab.jms.net.uri.URIHelper;


/**
 * Adapts a <code>Socket</code> to the {@link Endpoint} interface.
 *
 * @author <a href="mailto:tma@netspace.net.au">Tim Anderson</a>
 * @version $Revision: 1.1 $ $Date: 2010/06/18 16:49:01 $
 */
public class SocketEndpoint implements Endpoint {

    /**
     * The socket URI.
     */
    private final URI _uri;

    /**
     * The underlying socket.
     */
    private Socket _socket;

    /**
     * The socket input stream.
     */
    private InputStream _in;

    /**
     * The socket output stream.
     */
    private OutputStream _out;


    /**
     * Construct a new <code>SocketEndpoint</code>.
     *
     * @param scheme the URI scheme
     * @param socket the underlying socket
     * @throws IOException for any I/O error
     */
    public SocketEndpoint(String scheme, Socket socket)
            throws IOException {
        _uri = URIHelper.create(scheme,
                                socket.getInetAddress().getHostAddress(),
                                socket.getPort());
        _socket = socket;
        _in = socket.getInputStream();
        _out = socket.getOutputStream();
    }

    /**
     * Returns the URI that the endpoint is connected to
     *
     * @return the URI that the endpoint is connected to
     */
    public URI getURI() {
        return _uri;
    }

    /**
     * Returns an input stream that reads from this endpoint
     *
     * @return an input stream that reads from this endpoint
     */
    public InputStream getInputStream() {
        return _in;
    }

    /**
     * Returns an output stream that writes to this endpoint
     *
     * @return an output stream that writes to this endpoint
     */
    public OutputStream getOutputStream() {
        return _out;
    }

    /**
     * Closes the endpoint
     *
     * @throws IOException if an I/O error occurs while closing the endpoint
     */
    public void close() throws IOException {
        _socket.close();
    }
}
