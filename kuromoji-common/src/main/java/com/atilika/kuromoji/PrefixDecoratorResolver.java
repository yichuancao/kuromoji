/**
 * Copyright 2010-2013 Atilika Inc. and contributors (see CONTRIBUTORS.md)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.  A copy of the
 * License is distributed with this work in the LICENSE.md file.  You may
 * also obtain a copy of the License from
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.atilika.kuromoji;

import java.io.IOException;
import java.io.InputStream;

/**
 * Applies a given prefix to the resources passed to a given resolver.
 */
public final class PrefixDecoratorResolver implements ResourceResolver {
    private final ResourceResolver delegate;
    private final String prefix;

    public PrefixDecoratorResolver(String prefix, ResourceResolver resolver) {
        assert prefix != null;
        assert resolver != null;

        this.delegate = resolver;
        this.prefix = prefix;
    }

    @Override
    public InputStream resolve(String resourceName) throws IOException {
        return delegate.resolve(prefix + resourceName);
    }
}
