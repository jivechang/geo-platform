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
package org.geosdi.geoplatform.support.jackson.property;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.ConfigFeature;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public enum GPJacksonSupportEnum implements JacksonSupportConfigFeature {

    UNWRAP_ROOT_VALUE_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public DeserializationFeature getFeature() {
                    return DeserializationFeature.UNWRAP_ROOT_VALUE;
                }

            },
    UNWRAP_ROOT_VALUE_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public DeserializationFeature getFeature() {
                    return DeserializationFeature.UNWRAP_ROOT_VALUE;
                }

            },
    FAIL_ON_IGNORED_PROPERTIES_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public DeserializationFeature getFeature() {
                    return DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES;
                }

            },
    FAIL_ON_IGNORED_PROPERTIES_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public DeserializationFeature getFeature() {
                    return DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES;
                }

            },
    FAIL_ON_UNKNOW_PROPERTIES_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public DeserializationFeature getFeature() {
                    return DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
                }

            },
    FAIL_ON_UNKNOW_PROPERTIES_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public DeserializationFeature getFeature() {
                    return DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
                }

            },
    FAIL_ON_NULL_FOR_PRIMITIVES_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public DeserializationFeature getFeature() {
                    return DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
                }

            },
    FAIL_ON_NULL_FOR_PRIMITIVES_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public DeserializationFeature getFeature() {
                    return DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
                }

            },
    ACCEPT_SINGLE_VALUE_AS_ARRAY_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public DeserializationFeature getFeature() {
                    return DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY;
                }

            },
    ACCEPT_SINGLE_VALUE_AS_ARRAY_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public DeserializationFeature getFeature() {
                    return DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY;
                }

            },
    WRAP_ROOT_VALUE_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public SerializationFeature getFeature() {
                    return SerializationFeature.WRAP_ROOT_VALUE;
                }

            },
    WRAP_ROOT_VALUE_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public SerializationFeature getFeature() {
                    return SerializationFeature.WRAP_ROOT_VALUE;
                }

            },
    INDENT_OUTPUT_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public SerializationFeature getFeature() {
                    return SerializationFeature.INDENT_OUTPUT;
                }

            },
    INDENT_OUTPUT_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public SerializationFeature getFeature() {
                    return SerializationFeature.INDENT_OUTPUT;
                }

            },
    USE_WRAPPER_NAME_AS_PROPERTY_NAME_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public MapperFeature getFeature() {
                    return MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME;
                }

            },
    USE_WRAPPER_NAME_AS_PROPERTY_NAME_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public MapperFeature getFeature() {
                    return MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME;
                }

            };

    public abstract <F extends ConfigFeature> F getFeature();

    @Override
    public Boolean getValue() {
        return Boolean.FALSE;
    }

}
