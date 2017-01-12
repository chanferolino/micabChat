/*
 * Copyright (C) 2007 Esmertec AG. Copyright (C) 2007 The Android Open Source
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

package org.awesomeapp.messenger.model;

import net.java.otr4j.session.SessionStatus;

import org.awesomeapp.messenger.crypto.OtrDataHandler.Transfer;

/**
 * Interface that allows for implementing classes to listen for new message.
 * Listeners are registered with ChatSession objects.
 */
public interface MessageListener {
    /**
     * Calls when a new message has arrived.
     *
     * @param ses the ChatSession.
     * @param msg the incoming message.
     *
     * @return true if the message was processed correctly, or false
     *   otherwise (e.g. decryption error)
     */
    boolean onIncomingMessage(ChatSession ses, Message msg);

    /**
     * Calls when an error occurs to send a message.
     *
     * @param ses the {@link ChatSession}.
     * @param msg the message which was sent.
     * @param error the error information.
     */
    void onSendMessageError(ChatSession ses, Message msg, ImErrorInfo error);

    /**
     * Called when a message was not transmitted.
     *
     * @param ses the {@link ChatSession}
     * @param id the message ID
     */
    void onMessagePostponed(ChatSession ses, String id);

    /**
     * Called when a message receipt was received.
     *
     * @param ses the {@link ChatSession}.
     * @param id the message ID.
     */
    void onIncomingReceipt(ChatSession ses, String id);

    /**
     * Called when we determine that the remote supports message delivery
     * receipts.
     *
     * <br>XEP-0184
     *
     * @param ses the {@link ChatSession}.
     */
    void onReceiptsExpected(ChatSession ses, boolean isExpected);

    /** Called when OTR status changes */
    void onStatusChanged(ChatSession session, SessionStatus status);

    void onIncomingDataRequest(ChatSession session, Message msg, byte[] value);

    void onIncomingDataResponse(ChatSession session, Message msg, byte[] value);

    void onIncomingTransferRequest(Transfer transfer);
}
