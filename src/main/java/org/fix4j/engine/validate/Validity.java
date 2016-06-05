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
package org.fix4j.engine.validate;

import java.util.function.Function;

public interface Validity {
	boolean isValid();
	String getValidationMessage();
	
	public Validity VALID = new Validity() {
		@Override
		public boolean isValid() {
			return true;
		}
		@Override
		public String getValidationMessage() {
			return "valid";
		}
		public String toString() {
			return "Valid";
		}
	}; 
	public Validity INVALID = new Validity() {
		@Override
		public boolean isValid() {
			return false;
		}
		@Override
		public String getValidationMessage() {
			return "invalid";
		}
		public String toString() {
			return "Invalid";
		}
	}; 
	public Function<String, Validity> INVALID_WITH_MESSAGE = (m) -> new Validity() {
		@Override
		public boolean isValid() {
			return false;
		}
		
		@Override
		public String getValidationMessage() {
			return m;
		}
		public String toString() {
			return "Invalid(" + m + ")";
		}
	};
	public Validity NO_SUCH_TAG = INVALID_WITH_MESSAGE.apply("No such tag");
}
