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
 * $Id: ClassHelper.java,v 1.1 2010/06/18 16:49:42 smhuang Exp $
 */
package org.exolab.jms.plugins.proxygen;


/**
 * Helper class for performing reflection.
 *
 * @author <a href="mailto:tma@netspace.net.au">Tim Anderson</a>
 * @version $Revision: 1.1 $ $Date: 2010/06/18 16:49:42 $
 */
public class ClassHelper {

    /**
     * Prevent construction of helper class/
     */
    private ClassHelper() {
    }


    /**
     * Returns the package of a class. This is a workaround for AntClassLoader,
     * which doesn't provide package information (at least in versions &lt;=
     * 1.5.1)
     *
     * @param clazz the class
     * @return the package name of the class
     */
    protected static String getPackage(Class clazz) {
        String result = null;
        if (clazz.getPackage() != null) {
            result = clazz.getPackage().getName();
        } else {
            int lastDot = clazz.getName().lastIndexOf(".");
            if (lastDot != -1) {
                result = clazz.getName().substring(0, lastDot);
            }
        }
        return result;
    }

    /**
     * Returns the qualified name of a class.
     *
     * @param clazz the class
     * @return the qualified name of the class
     */
    protected static String getQualifiedName(Class clazz) {
        String result = null;
        if (clazz.isArray()) {
            result = "";
            while (clazz.isArray()) {
                result += "[]";
                clazz = clazz.getComponentType();
            }
            result = clazz.getName() + result;
        } else {
            result = clazz.getName();
        }
        return result;
    }

}
