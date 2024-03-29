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
 * Copyright 2000-2001,2003 (C) Exoffice Technologies Inc. All Rights Reserved.
 */

package org.exolab.jms.selector;


/**
 * This class is the base class for all expressions that are binary
 * operators.
 *
 * @version     $Revision: 1.1 $ $Date: 2010/06/18 16:48:12 $
 * @author      <a href="mailto:tma@netspace.net.au">Tim Anderson</a>
 * @see         Expression
 * @see         Operator
 */
abstract class BinaryOperator extends Operator {

    /**
     * The left-hand side of the binary expression
     */
    private final Expression _lhs;

    /**
     * The right-hand side of the binary expression
     */
    private final Expression _rhs;

    /**
     * Construct a new <code>BinaryOperator</code>
     *
     * @param operator the operator
     * @param lhs the left hand side of the expression
     * @param rhs the right hand side of the expression
     */
    public BinaryOperator(final String operator, final Expression lhs,
                          final Expression rhs) {
        super(operator);
        _lhs = lhs;
        _rhs = rhs;
    }

    /**
     * Returns the left hand side of the expression
     *
     * @return the left hand side of the expression
     */
    public final Expression left() {
        return _lhs;
    }

    /**
     * Returns the right hand side of the expression
     *
     * @return the right hand side of the expression
     */
    public final Expression right() {
        return _rhs;
    }

    /**
     * Returns a stringified version of the expression
     *
     * @return a stringified version of the expression
     */
    public final String toString() {
        StringBuffer result = new StringBuffer();
        result.append('(');
        result.append(_lhs.toString());
        result.append(' ');
        result.append(operator());
        result.append(' ');
        result.append(_rhs.toString());
        result.append(')');
        return result.toString();
    }

} //-- BinaryOperator
