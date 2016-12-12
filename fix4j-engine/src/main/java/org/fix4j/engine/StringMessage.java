/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 fix4j.org (tools4j.org)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.fix4j.engine;

import org.tools4j.mmap.io.MessageWriter;

import java.time.Clock;

/**
 * Created by ryan on 3/06/16.
 */
public class StringMessage implements Message {

    private final String content;

    public StringMessage(final String content) {
        this.content = content;
    }

    @Override
    public int length() {
        return content.length();
    }

    @Override
    public byte byteAt(int index) {
        return (byte) content.charAt(index);
    }

    @Override
    public Message encode(int sequenceNumber, Clock clock, MessageWriter appender) {
        return this;
    }
}
