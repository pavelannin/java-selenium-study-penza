/*
 *  MIT License
 *
 *  Copyright (c) 2018 Pavel Annin
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package com.github.anninpavel.selenium.pages;

import java.util.Collections;
import java.util.Set;

/**
 * @author Pavel Annin (https://github.com/anninpavel).
 */
public class PageScope {

    private final Set<Object> scope;

    public PageScope(Object... classes) {
        this.scope = Collections.synchronizedSet(Set.of(classes));
    }

    @SuppressWarnings("unchecked")
    public <T> T getPage(Class<T> clazz) {
        return scope.stream()
                .filter(clazz::isInstance)
                .map(o -> (T) o)
                .findFirst()
                .orElseThrow();
    }
}