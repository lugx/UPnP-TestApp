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

package org.teleal.cling.model.meta;

import java.net.URI;


public class ManufacturerDetails {

    private String manufacturer;
    private URI manufacturerURI;

    ManufacturerDetails() {
    }

    public ManufacturerDetails(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ManufacturerDetails(URI manufacturerURI) {
        this.manufacturerURI = manufacturerURI;
    }

    public ManufacturerDetails(String manufacturer, URI manufacturerURI) {
        this.manufacturer = manufacturer;
        this.manufacturerURI = manufacturerURI;
    }

    public ManufacturerDetails(String manufacturer, String manufacturerURI) throws IllegalArgumentException {
        this.manufacturer = manufacturer;
        this.manufacturerURI = URI.create(manufacturerURI);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public URI getManufacturerURI() {
        return manufacturerURI;
    }
}