/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 fix4j.org (tools4j.org)
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
package org.fix4j.sketch;

import java.util.Objects;

public final class Dictionary<T extends MessageType> {
    private final Class<T> klass;
    private final T heartbeatMessageType;

    public static <T extends MessageType> Dictionary<T> of(final Class<T> klass) {
        for (final T messageType : klass.getEnumConstants()) {
            if ("0".equals(messageType.tagValue())) {
                return new Dictionary<>(klass, messageType);
            }
        }
        throw new IllegalArgumentException("MessageType doesn't define a heartbeat");
    }

    private Dictionary(final Class<T> klass, final T heartbeatMessageType) {
        this.klass = klass;
        this.heartbeatMessageType = Objects.requireNonNull(heartbeatMessageType);
    }

    public Message<T> parse(final String fix) {
        return NullMessage.of(heartbeatMessageType);
    }
}
