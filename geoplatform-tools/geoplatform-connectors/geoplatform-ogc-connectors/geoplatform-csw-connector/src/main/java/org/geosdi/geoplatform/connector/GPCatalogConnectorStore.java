/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2015 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 *   This program is free software: you can redistribute it and/or modify it
 *   under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version. This program is distributed in the
 *   hope that it will be useful, but WITHOUT ANY WARRANTY; without
 *   even the implied warranty of MERCHANTABILITY or FITNESS FOR
 *   A PARTICULAR PURPOSE. See the GNU General Public License
 *   for more details. You should have received a copy of the GNU General
 *   Public License along with this program. If not, see http://www.gnu.org/licenses/
 *
 *   ====================================================================
 *
 *   Linking this library statically or dynamically with other modules is
 *   making a combined work based on this library. Thus, the terms and
 *   conditions of the GNU General Public License cover the whole combination.
 *
 *   As a special exception, the copyright holders of this library give you permission
 *   to link this library with independent modules to produce an executable, regardless
 *   of the license terms of these independent modules, and to copy and distribute
 *   the resulting executable under terms of your choice, provided that you also meet,
 *   for each linked independent module, the terms and conditions of the license of
 *   that module. An independent module is a module which is not derived from or
 *   based on this library. If you modify this library, you may extend this exception
 *   to your version of the library, but you are not obligated to do so. If you do not
 *   wish to do so, delete this exception statement from your version.
 */
package org.geosdi.geoplatform.connector;

import java.net.URL;
import org.geosdi.geoplatform.connector.api.GPConnectorStore;
import org.geosdi.geoplatform.connector.server.GPCatalogServerConnector;
import org.geosdi.geoplatform.connector.server.request.CatalogGetCapabilitiesRequest;
import org.geosdi.geoplatform.connector.server.request.CatalogGetRecordByIdRequest;
import org.geosdi.geoplatform.connector.server.request.CatalogGetRecordsRequest;
import org.geosdi.geoplatform.connector.server.security.GPSecurityConnector;
import org.geosdi.geoplatform.support.httpclient.proxy.HttpClientProxyConfiguration;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class GPCatalogConnectorStore
        extends GPConnectorStore<GPCatalogServerConnector>
        implements GeoPlatformCSWConnector {

    public GPCatalogConnectorStore(URL serverURL) {
        this(serverURL, null);
    }

    public GPCatalogConnectorStore(URL serverURL,
            GPCatalogVersion theVersion) {
        this(serverURL, null, theVersion);
    }

    public GPCatalogConnectorStore(URL serverURL,
            GPSecurityConnector security,
            GPCatalogVersion theVersion) {
        super(new GPCatalogServerConnector(serverURL, security, theVersion));
    }

    public GPCatalogConnectorStore(URL serverURL,
            GPSecurityConnector security,
            HttpClientProxyConfiguration proxyConfiguration,
            GPCatalogVersion theVersion) {
        super(new GPCatalogServerConnector(serverURL, security,
                proxyConfiguration, theVersion));
    }

    @Override
    public GPCatalogVersion getVersion() {
        return server.getVersion();
    }

    @Override
    public CatalogGetCapabilitiesRequest createGetCapabilitiesRequest() {
        return server.createGetCapabilitiesRequest();
    }

    @Override
    public CatalogGetRecordsRequest createGetRecordsRequest() {
        return server.createGetRecordsRequest();
    }

    @Override
    public CatalogGetRecordByIdRequest createGetRecordByIdRequest() {
        return server.createGetRecordByIdRequest();
    }
}
