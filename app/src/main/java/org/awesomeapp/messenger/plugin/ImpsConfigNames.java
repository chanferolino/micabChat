/*
 * Copyright (C) 2008 Esmertec AG. Copyright (C) 2008 The Android Open Source
 * Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.awesomeapp.messenger.plugin;

/** Defines the configuration names for IMPS engine. */
public interface ImpsConfigNames extends ImConfigNames {

    /** The version of the protocol. */
    String VERSION = "imps.version";

    /** The data channel banding. */
    String DATA_CHANNEL = "imps.data-channel";

    /** The data channel encoding. */
    String DATA_ENCODING = "imps.data-encoding";

    /** The CIR channel banding. */
    String CIR_CHANNEL = "imps.cir-channel";

    /** The backup CIR channel used when the application is in background. */
    String BACKUP_CIR_CHANNEL = "imps.backup-cir-channel";

    /** The host of the IMPS server. */
    String HOST = "imps.host";

    /** The address for SMS binding. */
    String SMS_ADDR = "imps.sms.addr";

    /** The port number for SMS binding. */
    String SMS_PORT = "imps.sms.port";

    /** The address for the SMS CIR channel. */
    String SMS_CIR_ADDR = "imps.sms.cir.addr";

    /** The port number for SMS CIR channel. */
    String SMS_CIR_PORT = "imps.sms.cir.port";

    /** The client ID. */
    String CLIENT_ID = "imps.client-id";

    /** The MSISDN of the client. */
    String MSISDN = "imps.msisdn";

    /** Determines whether 4-way login is to be used. */
    String SECURE_LOGIN = "imps.secure-login";

    /** Determines whether to send authentication through sms or not. */
    String SMS_AUTH = "imps.sms-auth";

    /**
     * Determines whether only the basic presence will be fetched from the
     * server.
     */
    String BASIC_PA_ONLY = "imps.basic-pa-only";

    /**
     * Determines whether to poll presence from the server or use
     * subscribe/notify method.
     */
    String POLL_PRESENCE = "imps.poll-presence";

    /**
     * The presence polling interval in milliseconds. Only valid when
     * {@link #POLL_PRESENCE} is set to true.
     */
    String PRESENCE_POLLING_INTERVAL = "imps.presence-polling-interval";

    /**
     * The full name of the custom presence mapping is to be used. If not set,
     * the default one will be used.
     */
    String CUSTOM_PRESENCE_MAPPING = "imps.custom-presence-mapping";

    /**
     * The full name of the custom password digest method is to be used. If not
     * set, the default one will be used.
     */
    String CUSTOM_PASSWORD_DIGEST = "imps.custom-password-digest";

    /** Determines whether the provider support user-defined presence text. */
    String SUPPORT_USER_DEFINED_PRESENCE = "imps.support-user-defined-presence";
}
