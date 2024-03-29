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
 *    permission of Intalio.  For written permission,
 *    please contact info@exolab.org.
 *
 * 4. Products derived from this Software may not be called "Exolab"
 *    nor may "Exolab" appear in their names without prior written
 *    permission of Intalio. Exolab is a registered
 *    trademark of Intalio.
 *
 * 5. Due credit should be given to the Exolab Project
 *    (http://www.exolab.org/).
 *
 * THIS SOFTWARE IS PROVIDED BY INTALIO AND CONTRIBUTORS
 * ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL
 * INTALIO OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Copyright 1999-2004 (C) Intalio Inc. All Rights Reserved.
 *
 * $Id: UUIDGenerator.java,v 1.1 2010/06/18 16:47:15 smhuang Exp $
 */

package org.exolab.jms.common.uuid;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;


/**
 * Universally Unique Identifier (UUID) generator.
 * <p>
 * A UUID is an identifier that is unique across both space and time,
 * with respect to the space of all UUIDs. A UUID can be used for
 * objects with an extremely short lifetime, and to reliably identifying
 * very persistent objects across a network. UUIDs are 128 bit values
 * and encoded as 36 character identifiers.
 * <p>
 * This generator produces time-based UUIDs based on the varient
 * specified in a February 4, 1998 IETF draft.
 * <p>
 * Unprefixed identifiers are generated by calling {@link #create()
 * create}. A method is also provided to create prefixed identifiers.
 * Prefixed identifiers are useful for logging and associating
 * identifiers to application objects.
 * <p>
 * To assure that identifiers can be presisted, identifiers must be
 * kept within the limit of {@link #MAXIMUM_LENGTH} characters.
 * This includes both prefixed identifiers and identifiers created
 * by the application. The {@link #trim trim} method can be used to
 * trim an identifier to the maximum allowed length. If an* identifier
 * was generated with no prefix, or with the maximum supported prefix
 * legnth, the identifier is guaranteed to be short enough and this
 * method is not required.
 * <p>
 * Convenience methods are also provided for converting an identifier
 * to and from an array of bytes. The conversion methods assume that
 * the identifier is a prefixed or unprefixed encoding of the byte
 * array as pairs of hexadecimal digits.
 * <p>
 * The UUID specification prescribes the following format for
 * representing UUIDs. Four octets encode the low field of the time
 * stamp, two octects encode the middle field of the timestamp,
 * and two octets encode the high field of the timestamp with the
 * version number. Two octets encode the clock sequence number and
 * six octets encode the unique node identifier.
 * <p>
 * The timestamp is a 60 bit value holding UTC time as a count of 100
 * nanosecond intervals since October 15, 1582. UUIDs generated in
 * this manner are guaranteed not to roll over until 3400 AD.
 * <p>
 * The clock sequence is used to help avoid duplicates that could arise
 * when the clock is set backward in time or if the node ID changes.
 * Although the system clock is guaranteed to be monotonic, the system
 * clock is not guaranteed to be monotonic across system failures.
 * The UUID cannot be sure that no UUIDs were generated with timestamps
 * larger than the current timestamp.
 * <p>
 * If the clock sequence can be determined at initialization, it is
 * incremented by one, otherwise it is set to a random number.
 * The clock sequence MUST be originally (i.e. once in the lifetime
 * of a system) initialized to a random number to minimize the
 * correlation across systems. The initial value must not be correlated
 * to the node identifier.
 * <p>
 * The node identifier must be unique for each UUID generator.
 * This is accomplished using the IEEE 802 network card address.
 * For systems with multiple IEEE 802 addresses, any available address
 * can be used. For systems with no IEEE address, a 47 bit random value
 * is used and the multicast bit is set so it will never conflict with
 * addresses obtained from network cards.
 * <p>
 * The UUID state consists of the node identifier and clock sequence.
 * The state need only be read once when the generator is initialized,
 * and the clock sequence must be incremented and stored back. If the
 * UUID state cannot be read and updated, a random number is used.
 * <p>
 * The UUID generator is thread-safe.
 * <p>
 * This class originally came from Tyrex: http://tyrex.sourceforge.net
 *
 * @author <a href="mailto:arkin@intalio.com">Assaf Arkin</a>
 * @version $Revision: 1.1 $ $Date: 2010/06/18 16:47:15 $
 */
public final class UUIDGenerator {

    /**
     /**
     * The identifier resolution in bytes. Identifiers are 16-byte
     * long, or 128 bits. Without a prefix, an identifier can be
     * represented as 36 hexadecimal digits and hyphens.
     * (4 hyphens are used in the UUID format)
     */
    public static final int RESOLUTION_BYTES = 16;


    /**
     * The maximum length of an identifier in textual form.
     * Prefixed identifiers and application identifiers must be
     * less or equal to the maximum length to allow persistence.
     * This maximum length is 64 characters.
     */
    public static final int MAXIMUM_LENGTH = 64;


    /**
     * The maximum length of an identifier prefix. Identifiers
     * created using {@link #create(String) create(String)} with
     * a prefix that is no longer than the maximum prefix size
     * are guaranteed to be within the maximum length allowed
     * and need not be trimmed.
     */
    public static final int MAXIMUM_PREFIX = 28;


    /**
     * The variant value determines the layout of the UUID. This
     * variant is specified in the IETF February 4, 1998 draft.
     * Used for character octets.
     */
    private static final int UUID_VARIANT_OCTET = 0x08;


    /**
     * The variant value determines the layout of the UUID. This
     * variant is specified in the IETF February 4, 1998 draft.
     * Used for byte array.
     */
    private static final int UUID_VARIANT_BYTE = 0x80;


    /**
     * The version identifier for a time-based UUID. This version
     * is specified in the IETF February 4, 1998 draft. Used for
     * character octets.
     */
    private static final int UUID_VERSION_CLOCK_OCTET = 0x01;


    /**
     * The version identifier for a time-based UUID. This version
     * is specified in the IETF February 4, 1998 draft. Used for
     * byte array.
     */
    private static final int UUID_VERSION_CLOCK_BYTE = 0x10;


    /**
     * The version identifier for a name-based UUID. This version
     * is specified in the IETF February 4, 1998 draft. Used for
     * character octets.
     */
    private static final int UUID_VERSION_NAME_OCTET = 0x03;


    /**
     * The version identifier for a name-based UUID. This version
     * is specified in the IETF February 4, 1998 draft. Used for
     * byte array.
     */
    private static final int UUID_VERSION_NAME_BYTE = 0x30;


    /**
     * The version identifier for a random-based UUID. This version
     * is specified in the IETF February 4, 1998 draft. Used for
     * character octets.
     */
    private static final int UUID_VERSION_RANDOM_CLOCK = 0x04;


    /**
     * The version identifier for a random-based UUID. This version
     * is specified in the IETF February 4, 1998 draft. Used for
     * byte array.
     */
    private static final int UUID_VERSION_RANDOM_BYTE = 0x40;


    /**
     * The difference between Java clock and UUID clock. Java clock
     * is base time is January 1, 1970. UUID clock base time is
     * October 15, 1582.
     */
    private static final long JAVA_UUID_CLOCK_DIFF = 0x0b1d069b5400L;


    /**
     * Efficient mapping from 4 bit value to lower case hexadecimal digit.
     */
    private final static char[] HEX_DIGITS = new char[]{
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};


    /**
     * The number of UUIDs that can be generated per clock tick.
     * UUID assumes a clock tick every 100 nanoseconds. The actual
     * clock ticks are measured in milliseconds and based on the
     * sync-every property of the clock. The product of these two
     * values is used to set this variable.
     */
    private static int _uuidsPerTick;


    /**
     * The number of UUIDs generated in this clock tick. This counter
     * is reset each time the clock is advanced a tick. When it reaches
     * the maximum number of UUIDs allowed per tick, we block until the
     * clock advances.
     */
    private static int _uuidsThisTick;


    /**
     * The last clock. Whenever the clock changes, we record the last clock
     * to identify when we get a new clock, or when we should increments
     * the UUIDs per tick counter.
     */
    private static long _lastClock;


    /**
     * The clock sequence. This is randomly initialised, and is made of
     * four hexadecimal digits.
     */
    private static char[] _clockSeqOctet;


    /**
     * The clock sequence. The clock sequence is obtained from the UUID
     * properties and incremented by one each time we boot, or is
     * generated randomaly if missing in the UUID properties. The clock
     * sequence is made of two bytes.
     */
    private static byte[] _clockSeqByte;


    /**
     * The node identifier. The node identifier is obtained from the
     * UUID properties, or is generated if missing in the UUID properties.
     * The node identifier is made of twelve hexadecimal digits.
     */
    private static char[] _nodeIdentifierOctet;


    /**
     * The node identifier. The node identifier is obtained from the
     * UUID properties, or is generated if missing in the UUID properties.
     * The node identifier is made of six bytes.
     */
    private static byte[] _nodeIdentifierByte;


    /**
     * Creates and returns a new identifier.
     *
     * @return An identifier
     */
    public static String create() {
        return String.valueOf(createTimeUUIDChars());
    }


    /**
     * Creates and returns a new prefixed identifier.
     * <p>
     * This method is equivalent to <code>prefix + create()</code>.
     *
     * @param prefix The prefix to use
     * @return A prefixed identifier
     */
    public static String create(String prefix) {
        StringBuffer buffer;

        if (prefix == null) {
            throw new IllegalArgumentException("Argument 'prefix' is null");
        }
        buffer = new StringBuffer(MAXIMUM_LENGTH - MAXIMUM_PREFIX + prefix.length());
        buffer.append(prefix);
        buffer.append(createTimeUUIDChars());
        return buffer.toString();
    }


    /**
     * Creates and returns a new identifier.
     *
     * @return An identifier
     */
    public static byte[] createBinary() {
        return createTimeUUIDBytes();
    }


    /**
     * Converts a prefixed identifier into a byte array. An exception
     * is thrown if the identifier does not match the excepted textual
     * encoding.
     * <p>
     * The format for the identifier is <code>prefix{nn|-}*</code>:
     * a prefix followed by a sequence of bytes, optionally separated
     * by hyphens. Each byte is encoded as a pair of hexadecimal digits.
     *
     * @param prefix The identifier prefix
     * @param identifier The prefixed identifier
     * @return The identifier as an array of bytes
     * @throws InvalidIDException The identifier does not begin with
     * the prefix, or does not consist of a sequence of hexadecimal
     * digit pairs, optionally separated by hyphens
     */
    public static byte[] toBytes(String prefix, String identifier)
        throws InvalidIDException {

        int index;
        char digit;
        byte nibble;
        byte[] bytes;
        byte[] newBytes;

        if (identifier == null) {
            throw new IllegalArgumentException("Argument identifier is null");
        }
        if (prefix == null) {
            throw new IllegalArgumentException("Argument prefix is null");
        }
        if (!identifier.startsWith(prefix)) {
            throw new InvalidIDException(
                "Invalid identifier: expected prefix " + prefix
                + "in identifier " + identifier);
        }

        index = 0;
        bytes = new byte[(identifier.length() - prefix.length()) / 2];
        for (int i = prefix.length(); i < identifier.length(); ++i) {
            digit = identifier.charAt(i);
            if (digit == '-') {
                continue;
            }
            if (digit >= '0' && digit <= '9') {
                nibble = (byte) ((digit - '0') << 4);
            } else if (digit >= 'A' && digit <= 'F') {
                nibble = (byte) ((digit - ('A' - 0x0A)) << 4);
            } else if (digit >= 'a' && digit <= 'f') {
                nibble = (byte) ((digit - ('a' - 0x0A)) << 4);
            } else {
                throw new InvalidIDException(
                    "character " + String.valueOf(digit)
                    + " encountered, expected hexadecimal digit in identifier "
                    + identifier);
            }
            ++i;
            if (i == identifier.length()) {
                throw new InvalidIDException(
                    "Invalid identifier: odd number of hexadecimal digits in "
                    + "identifier " + identifier);
            }
            digit = identifier.charAt(i);
            if (digit >= '0' && digit <= '9') {
                nibble = (byte) (nibble | (digit - '0'));
            } else if (digit >= 'A' && digit <= 'F') {
                nibble = (byte) (nibble | (digit - ('A' - 0x0A)));
            } else if (digit >= 'a' && digit <= 'f') {
                nibble = (byte) (nibble | (digit - ('a' - 0x0A)));
            } else {
                throw new InvalidIDException(
                    "character " + String.valueOf(digit)
                    + " encountered, expected hexadecimal digit in identifier "
                    + identifier);
            }
            bytes[index] = nibble;
            ++index;
        }
        if (index == bytes.length) {
            return bytes;
        }
        newBytes = new byte[index];
        while (index-- > 0) {
            newBytes[index] = bytes[index];
        }
        return newBytes;
    }


    /**
     * Converts an identifier into a byte array. An exception is
     * thrown if the identifier does not match the excepted textual
     * encoding.
     * <p>
     * The format for the identifier is <code>{nn|-}*</code>:
     * a sequence of bytes, optionally separated by hyphens.
     * Each byte is encoded as a pair of hexadecimal digits.
     *
     * @param identifier The identifier
     * @return The identifier as an array of bytes
     * @throws InvalidIDException The identifier does not consist
     * of a sequence of hexadecimal digit pairs, optionally separated
     * by hyphens
     */
    public static byte[] toBytes(String identifier) throws InvalidIDException {
        int index;
        char digit;
        byte nibble;
        byte[] bytes;
        byte[] newBytes;

        if (identifier == null) {
            throw new IllegalArgumentException("Argument identifier is null");
        }
        index = 0;
        bytes = new byte[identifier.length() / 2];
        for (int i = 0; i < identifier.length(); ++i) {
            digit = identifier.charAt(i);
            if (digit == '-')
                continue;
            if (digit >= '0' && digit <= '9')
                nibble = (byte) ((digit - '0') << 4);
            else if (digit >= 'A' && digit <= 'F')
                nibble = (byte) ((digit - ('A' - 0x0A)) << 4);
            else if (digit >= 'a' && digit <= 'f')
                nibble = (byte) ((digit - ('a' - 0x0A)) << 4);
            else {
                throw new InvalidIDException(
                    "character " + String.valueOf(digit)
                    + " encountered, expected hexadecimal digit in identifier "
                    + identifier);
            }
            ++i;
            if (i == identifier.length()) {
                throw new InvalidIDException(
                    "Invalid identifier: odd number of hexadecimal digits in "
                    + "identifier " + identifier);
            }
            digit = identifier.charAt(i);
            if (digit >= '0' && digit <= '9')
                nibble = (byte) (nibble | (digit - '0'));
            else if (digit >= 'A' && digit <= 'F')
                nibble = (byte) (nibble | (digit - ('A' - 0x0A)));
            else if (digit >= 'a' && digit <= 'f')
                nibble = (byte) (nibble | (digit - ('a' - 0x0A)));
            else {
                throw new InvalidIDException(
                    "character " + String.valueOf(digit)
                    + " encountered, expected hexadecimal digit in identifier "
                    + identifier);
            }
            bytes[index] = nibble;
            ++index;
        }
        if (index == bytes.length)
            return bytes;
        newBytes = new byte[index];
        while (index-- > 0)
            newBytes[index] = bytes[index];
        return newBytes;
    }


    /**
     * Converts a byte array into a prefixed identifier.
     * <p>
     * The format for the identifier is <code>prefix{nn|-}*</code>:
     * a prefix followed by a sequence of bytes, optionally separated
     * by hyphens. Each byte is encoded as a pair of hexadecimal digits.
     *
     * @param prefix The identifier prefix
     * @param byte An array of bytes
     * @return A string representation of the identifier
     */
    public static String fromBytes(String prefix, byte[] bytes) {
        StringBuffer buffer;

        if (prefix == null)
            throw new IllegalArgumentException("Argument prefix is null");
        if (bytes == null || bytes.length == 0)
            throw new IllegalArgumentException("Argument bytes is null or an empty array");
        buffer = new StringBuffer(prefix);
        for (int i = 0; i < bytes.length; ++i) {
            buffer.append(HEX_DIGITS[(bytes[i] & 0xF0) >> 4]);
            buffer.append(HEX_DIGITS[(bytes[i] & 0x0F)]);
        }
        return buffer.toString();
    }


    /**
     * Converts a byte array into an identifier.
     * <p>
     * The format for the identifier is <code>{nn|-}*</code>: a sequence
     * of bytes, optionally separated by hyphens. Each byte is encoded as
     * a pair of hexadecimal digits.
     *
     * @param bytes An array of bytes
     * @return A string representation of the identifier
     */
    public static String fromBytes(byte[] bytes) {
        StringBuffer buffer;

        if (bytes == null || bytes.length == 0)
            throw new IllegalArgumentException("Argument bytes is null or an empty array");
        buffer = new StringBuffer();
        for (int i = 0; i < bytes.length; ++i) {
            buffer.append(HEX_DIGITS[(bytes[i] & 0xF0) >> 4]);
            buffer.append(HEX_DIGITS[(bytes[i] & 0x0F)]);
        }
        return buffer.toString();
    }


    /**
     * Truncates an identifier so that it does not extend beyond
     * {@link #MAXIMUM_LENGTH} characters in length.
     *
     * @param identifier An identifier
     * @return An identifier trimmed to {@link #MAXIMUM_LENGTH} characters
     */
    public static String trim(String identifier) {
        if (identifier == null)
            throw new IllegalArgumentException("Argument identifier is null");
        if (identifier.length() > MAXIMUM_LENGTH)
            return identifier.substring(0, MAXIMUM_LENGTH);
        return identifier;
    }


    /**
     * Returns a time-based UUID as a character array. The UUID
     * identifier is always 36 characters long.
     *
     * @return A time-based UUID
     */
    public static char[] createTimeUUIDChars() {
        long clock;
        char[] chars;
        long nextClock;

        // Acquire lock to assure synchornized generation
        synchronized (UUID.class) {
            clock = Clock.clock();
            while (true) {
                if (clock > _lastClock) {
                    // Since we are using the clock interval for the UUID space,
                    // we must make sure the next clock provides sufficient
                    // room so UUIDs do not roll over.
                    nextClock = _lastClock + (_uuidsThisTick / 100);
                    if (clock <= nextClock)
                        clock = Clock.synchronize();
                    if (clock > nextClock) {
                        // Clock reading changed since last UUID generated,
                        // reset count of UUIDs generated with this clock.
                        _uuidsThisTick = 0;
                        _lastClock = clock;
                        // Adjust UUIDs per tick in case the clock sleep ticks
                        // have changed.
                        _uuidsPerTick = Clock.getUnsynchTicks() * 100;
                        break;
                    }
                }

                if (_uuidsThisTick + 1 < _uuidsPerTick) {
                    // Clock did not advance, but able to create more UUIDs
                    // for this clock, proceed.
                    ++_uuidsThisTick;
                    break;
                }

                // Running out of UUIDs for the current clock tick, must
                // wait until clock advances. Possible that clock did not
                // advance in background, so try to synchronize it first.
                clock = Clock.synchronize();
                if (clock <= _lastClock) {
                    // if (Configuration.verbose)
                    //Logger.tyrex.debug(Messages.message("tyrex.uuid.fastHolding"));
                    while (clock <= _lastClock) {
                        // UUIDs generated too fast, suspend for a while.
                        try {
                            Thread.currentThread().sleep(Clock.getUnsynchTicks());
                        } catch (InterruptedException except) {
                        }
                        clock = Clock.synchronize();
                    }
                }
            }

            // Modify Java clock (milliseconds) to UUID clock (100 nanoseconds).
            // Add the count of uuids to low order bits of the clock reading,
            // assuring we get a unique clock.
            clock = (_lastClock + JAVA_UUID_CLOCK_DIFF) * 100 + _uuidsThisTick;

            chars = new char[36];
            // Add the low field of the clock (4 octets)
            chars[0] = HEX_DIGITS[(int) ((clock >> 28) & 0x0F)];
            chars[1] = HEX_DIGITS[(int) ((clock >> 24) & 0x0F)];
            chars[2] = HEX_DIGITS[(int) ((clock >> 20) & 0x0F)];
            chars[3] = HEX_DIGITS[(int) ((clock >> 16) & 0x0F)];
            chars[4] = HEX_DIGITS[(int) ((clock >> 12) & 0x0F)];
            chars[5] = HEX_DIGITS[(int) ((clock >> 8) & 0x0F)];
            chars[6] = HEX_DIGITS[(int) ((clock >> 4) & 0x0F)];
            chars[7] = HEX_DIGITS[(int) (clock & 0x0F)];
            chars[8] = '-';
            // Add the medium field of the clock (2 octets)
            chars[9] = HEX_DIGITS[(int) ((clock >> 44) & 0x0F)];
            chars[10] = HEX_DIGITS[(int) ((clock >> 40) & 0x0F)];
            chars[11] = HEX_DIGITS[(int) ((clock >> 36) & 0x0F)];
            chars[12] = HEX_DIGITS[(int) ((clock >> 32) & 0x0F)];
            chars[13] = '-';
            // Add the high field of the clock multiplexed with version number (2 octets)
            chars[14] = HEX_DIGITS[(int) (((clock >> 60) & 0x0F) | UUID_VERSION_CLOCK_OCTET)];
            chars[15] = HEX_DIGITS[(int) ((clock >> 56) & 0x0F)];
            chars[16] = HEX_DIGITS[(int) ((clock >> 52) & 0x0F)];
            chars[17] = HEX_DIGITS[(int) ((clock >> 48) & 0x0F)];
            chars[18] = '-';
            // Add the clock sequence and version identifier (2 octets)
            chars[19] = _clockSeqOctet[0];
            chars[20] = _clockSeqOctet[1];
            chars[21] = _clockSeqOctet[2];
            chars[22] = _clockSeqOctet[3];
            chars[23] = '-';
            // Add the node identifier (6 octets)
            chars[24] = _nodeIdentifierOctet[0];
            chars[25] = _nodeIdentifierOctet[1];
            chars[26] = _nodeIdentifierOctet[2];
            chars[27] = _nodeIdentifierOctet[3];
            chars[28] = _nodeIdentifierOctet[4];
            chars[29] = _nodeIdentifierOctet[5];
            chars[30] = _nodeIdentifierOctet[6];
            chars[31] = _nodeIdentifierOctet[7];
            chars[32] = _nodeIdentifierOctet[8];
            chars[33] = _nodeIdentifierOctet[9];
            chars[34] = _nodeIdentifierOctet[10];
            chars[35] = _nodeIdentifierOctet[11];
        }
        return chars;
    }


    /**
     * Returns a time-based UUID as a character array. The UUID
     * identifier is always 16 bytes long.
     *
     * @return A time-based UUID
     */
    public static byte[] createTimeUUIDBytes() {
        long clock;
        byte[] bytes;
        long nextClock;

        // Acquire lock to assure synchronized generation
        synchronized (UUIDGenerator.class) {
            clock = Clock.clock();
            while (true) {
                if (clock > _lastClock) {
                    // Since we are using the clock interval for the UUID
                    // space, we must make sure the next clock provides
                    // sufficient room so UUIDs do not roll over.
                    nextClock = _lastClock + (_uuidsThisTick / 100);
                    if (clock <= nextClock) {
                        clock = Clock.synchronize();
                    }
                    if (clock > nextClock) {
                        // Clock reading changed since last UUID generated,
                        // reset count of UUIDs generated with this clock.
                        _uuidsThisTick = 0;
                        _lastClock = clock;
                        // Adjust UUIDs per tick in case the clock sleep ticks
                        // have changed.
                        _uuidsPerTick = Clock.getUnsynchTicks() * 100;
                        break;
                    }
                }

                if (_uuidsThisTick + 1 < _uuidsPerTick) {
                    // Clock did not advance, but able to create more UUIDs
                    // for this clock, proceed.
                    ++_uuidsThisTick;
                    break;
                }

                // Running out of UUIDs for the current clock tick, must
                // wait until clock advances. Possible that clock did not
                // advance in background, so try to synchronize it first.
                clock = Clock.synchronize();
                if (clock <= _lastClock) {
                    // if (Configuration.verbose)
                    // Logger.tyrex.debug(Messages.message("tyrex.uuid.fastHolding"));
                    while (clock <= _lastClock) {
                        // UUIDs generated too fast, suspend for a while.
                        try {
                            Thread.currentThread().sleep(Clock.getUnsynchTicks());
                        } catch (InterruptedException ignore) {
                        }
                        clock = Clock.synchronize();
                    }
                }
            }

            // Modify Java clock (milliseconds) to UUID clock (100 nanoseconds).
            // Add the count of uuids to low order bits of the clock reading,
            // assuring we get a unique clock.
            clock = (_lastClock + JAVA_UUID_CLOCK_DIFF) * 100 + _uuidsThisTick;

            bytes = new byte[16];
            // Add the low field of the clock (4 octets)
            bytes[0] = (byte) ((clock >> 24) & 0xFF);
            bytes[1] = (byte) ((clock >> 16) & 0xFF);
            bytes[2] = (byte) ((clock >> 8) & 0xFF);
            bytes[3] = (byte) (clock & 0xFF);
            // Add the medium field of the clock (2 octets)
            bytes[4] = (byte) ((clock >> 40) & 0xFF);
            bytes[5] = (byte) ((clock >> 32) & 0xFF);
            // Add the high field of the clock multiplexed with version
            // number (2 octets)
            bytes[6] = (byte) (((clock >> 60) & 0xFF)
                | UUID_VERSION_CLOCK_BYTE);
            bytes[7] = (byte) ((clock >> 48) & 0xFF);
            // Add the clock sequence and version identifier (2 octets)
            bytes[8] = _clockSeqByte[0];
            bytes[9] = _clockSeqByte[1];
            // Add the node identifier (6 octets)
            bytes[10] = _nodeIdentifierByte[0];
            bytes[11] = _nodeIdentifierByte[1];
            bytes[12] = _nodeIdentifierByte[2];
            bytes[13] = _nodeIdentifierByte[3];
            bytes[14] = _nodeIdentifierByte[4];
            bytes[15] = _nodeIdentifierByte[5];
        }
        return bytes;
    }


    /**
     * Returns true if the UUID was created on this machine.
     * Determines the source of the UUID based on the node
     * identifier.
     *
     * @param uuid The UUID as a byte array
     * @return True if created on this machine
     */
    public static boolean isLocal(byte[] uuid) {
        if (uuid == null)
            throw new IllegalArgumentException("Argument uuid is null");
        if (uuid.length != 16)
            return false;
        return (uuid[10] == _nodeIdentifierByte[0] &&
            uuid[11] == _nodeIdentifierByte[1] &&
            uuid[12] == _nodeIdentifierByte[2] &&
            uuid[13] == _nodeIdentifierByte[3] &&
            uuid[14] == _nodeIdentifierByte[4] &&
            uuid[15] == _nodeIdentifierByte[5]);
    }

    /**
     * Initialise the generator
     * <p>
     * This method generates the node identifier and clock sequence, and
     * sets {@link #_uuidsPerTick} to the number of UUIDs allowed per clock
     * tick.
     */
    private static void initialize() {
        // Random random = new SecureRandom();
        Random random = new Random();
        String nodeIdString;
        long nodeIdLong;
        String seqString;
        int seqInt;

        // Generate the node identifier, as we can't determine the IEEE 802
        // address of the local host.
        // As a result, it must have bit 48 set.
        nodeIdLong = random.nextLong();
        nodeIdLong = nodeIdLong | (1 << 47);

        // Generate the clock sequence
        seqInt = random.nextInt(1 << 12);
        seqInt = seqInt & 0x1FFF;

        // Convert clock sequence to 4 hexadecimal digits
        _clockSeqOctet = new char[4];
        _clockSeqOctet[0] = HEX_DIGITS[(int) ((seqInt >> 12) & 0x0F)];
        _clockSeqOctet[1] = HEX_DIGITS[(int) ((seqInt >> 8) & 0x0F)];
        _clockSeqOctet[2] = HEX_DIGITS[(int) ((seqInt >> 4) & 0x0F)];
        _clockSeqOctet[3] = HEX_DIGITS[(int) (seqInt & 0x0F)];

        _clockSeqByte = new byte[2];
        _clockSeqByte[0] = (byte) ((seqInt >> 8) & 0xFF);
        _clockSeqByte[1] = (byte) (seqInt & 0xFF);

        // Need to mask UUID variant on clock sequence
        _clockSeqOctet[0] = HEX_DIGITS[(int) ((seqInt >> 12) & 0x0F)
            | UUID_VARIANT_OCTET];
        _clockSeqByte[0] = (byte) (((seqInt >> 8) & 0xFF)
            | UUID_VARIANT_BYTE);

        // Convert node identifier to 12 hexadecimal digits
        _nodeIdentifierOctet = new char[12];
        for (int i = 0; i < 12; ++i) {
            _nodeIdentifierOctet[i] =
                HEX_DIGITS[(int) ((nodeIdLong >> ((11 - i) * 4)) & 0x0F)];
        }
        _nodeIdentifierByte = new byte[6];
        for (int i = 0; i < 6; ++i) {
            _nodeIdentifierByte[i] =
                (byte) ((nodeIdLong >> ((5 - i) * 8)) & 0xFF);
        }

        // The number of UUIDs allowed per tick depends on the number of
        // ticks between each advance of the clock, adjusted for 100
        // nanosecond precision.
        _uuidsPerTick = Clock.getUnsynchTicks() * 100;
    }

    static {
        initialize();
        // This makes sure we miss at least one clock tick, just to be safe.
        _uuidsThisTick = _uuidsPerTick;
        _lastClock = Clock.clock();
    }


    public static void main(String[] args) {
        long clock;
        HashSet hash;
        String id;
        int count = 1000000;

        for (int i = 0; i < 10; ++i) {
            System.out.println(create());
        }
        clock = System.currentTimeMillis();
        hash = new HashSet(count / 100, 100);
        for (int i = 0; i < count; ++i) {
            if ((i % 10000) == 0)
                System.out.println("Checked " + i);
            id = create();
            if (hash.contains(id))
                System.out.println("Duplicate id " + id);
            else
                hash.add(id);
        }
        clock = System.currentTimeMillis() - clock;
        System.out.println("Generated " + count + " UUIDs in " + clock + "ms");
    }

    /**
     * An exception indicating the identifier is invalid and
     * cannot be converted into an array of bytes.
     */
    public static class InvalidIDException extends Exception {

        public InvalidIDException(String message) {
            super(message);
        }
    }

}
