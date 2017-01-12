package org.awesomeapp.messenger.plugin.xmpp;

/**
 * Created by kevinlorena on 04/08/16.
 */
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class TrustAllHostNameVerifier implements HostnameVerifier {

    public boolean verify(String hostname, SSLSession session) {
        return true;
    }

}
