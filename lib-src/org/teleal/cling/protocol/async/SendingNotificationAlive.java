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

package org.teleal.cling.protocol.async;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.meta.LocalDevice;
import org.teleal.cling.model.types.NotificationSubtype;


public class SendingNotificationAlive extends SendingNotification {

    public SendingNotificationAlive(UpnpService upnpService, LocalDevice device) {
        super(upnpService, device);
    }

    @Override
    protected void execute() {
        log.fine("Sending alive messages ("+getBulkRepeat()+" times) for: " + getDevice());
        super.execute();
    }

    protected NotificationSubtype getNotificationSubtype() {
        return NotificationSubtype.ALIVE;
    }

}
