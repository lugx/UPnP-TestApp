/*
 * Copyright (C) 2010 Teleal GmbH, Switzerland
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.teleal.cling.binding.xml.parser;

import org.teleal.common.xml.DOMParser;
import org.teleal.common.xml.NamespaceContextMap;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;

/**
 * @author Christian Bauer
 */
public class ServiceDOMParser extends DOMParser<ServiceDOM> {

    @Override
    protected ServiceDOM createDOM(Document document) {
        return new ServiceDOM(document);
    }

    public NamespaceContextMap createDefaultNamespaceContext(String... optionalPrefixes) {
        NamespaceContextMap ctx = new NamespaceContextMap() {
            @Override
            protected String getDefaultNamespaceURI() {
                return ServiceDOM.NAMESPACE_URI;
            }
        };
        for (String optionalPrefix : optionalPrefixes) {
            ctx.put(optionalPrefix, ServiceDOM.NAMESPACE_URI);
        }
        return ctx;
    }

    public XPath createXPath() {
        return super.createXPath(createDefaultNamespaceContext(ServiceElement.XPATH_PREFIX));
    }
}