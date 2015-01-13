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
package org.geosdi.geoplatform.gui.client.action.baselayer;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.HasRpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.user.client.rpc.XsrfToken;
import org.geosdi.geoplatform.gui.client.i18n.MapModuleConstants;
import org.geosdi.geoplatform.gui.client.i18n.windows.WindowsConstants;
import org.geosdi.geoplatform.gui.client.service.MapRemote;
import org.geosdi.geoplatform.gui.client.service.MapRemoteAsync;
import org.geosdi.geoplatform.gui.client.widget.SearchStatus;
import org.geosdi.geoplatform.gui.client.widget.baselayer.BaseLayerWidget;
import org.geosdi.geoplatform.gui.configuration.action.GeoPlatformSecureAction;
import org.geosdi.geoplatform.gui.configuration.message.GeoPlatformMessage;
import org.geosdi.geoplatform.gui.configuration.users.options.member.UserSessionEnum;
import org.geosdi.geoplatform.gui.global.security.IGPAccountDetail;
import org.geosdi.geoplatform.gui.impl.view.LayoutManager;
import org.geosdi.geoplatform.gui.shared.GPTrustedLevel;

/**
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
 */
public class SaveBaseLayerAction extends GeoPlatformSecureAction<ComponentEvent> {

    private static final MapRemoteAsync mapRemote = MapRemote.Util.getInstance();
    //
    private final BaseLayerWidget widget;

    public SaveBaseLayerAction(GPTrustedLevel trustedLevel,
            BaseLayerWidget widget) {
        super(trustedLevel);
        this.widget = widget;
    }

    @Override
    public void componentSelected(ComponentEvent e) {
        IGPAccountDetail accountDetail = Registry.get(
                UserSessionEnum.ACCOUNT_DETAIL_IN_SESSION.name());
        final String baseLayer = accountDetail.getBaseLayer();

        xsrf.getNewXsrfToken(new AsyncCallback<XsrfToken>() {

            @Override
            public void onFailure(Throwable caught) {
                try {
                    throw caught;
                } catch (RpcTokenException e) {
                    // Can be thrown for several reasons:
                    //   - duplicate session cookie, which may be a sign of a cookie
                    //     overwrite attack
                    //   - XSRF token cannot be generated because session cookie isn't
                    //     present
                } catch (Throwable e) {
                    // unexpected
                }
            }

            @Override
            public void onSuccess(XsrfToken token) {
                ((HasRpcToken) mapRemote).setRpcToken(token);
                mapRemote.saveBaseLayer(baseLayer,
                        new AsyncCallback<Object>() {

                            @Override
                            public void onFailure(Throwable caught) {
                                GeoPlatformMessage.errorMessage(
                                        WindowsConstants.INSTANCE.errorSavingTitleText(),
                                        WindowsConstants.INSTANCE.errorMakingConnectionBodyText());
                                LayoutManager.getInstance().getStatusMap().setStatus(
                                        MapModuleConstants.INSTANCE.SaveBaseLayerAction_statusErrorSavingText(),
                                        SearchStatus.EnumSearchStatus.STATUS_NO_SEARCH.toString());
                                logger.warning(
                                        "Error saving the new base layer: " + caught.toString()
                                        + " data: " + caught.getMessage());
                            }

                            @Override
                            public void onSuccess(Object result) {
                                widget.hide();
                                LayoutManager.getInstance().getStatusMap().setStatus(
                                        MapModuleConstants.INSTANCE.SaveBaseLayerAction_statusSaveSuccesfullText(),
                                        SearchStatus.EnumSearchStatus.STATUS_SEARCH.toString());
                            }
                        });
            }
        });

    }
}
