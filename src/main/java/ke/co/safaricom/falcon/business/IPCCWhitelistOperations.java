package ke.co.safaricom.falcon.business;

import ke.co.safaricom.falcon.entry.controllers.http.requests.WhitelistMSISDNRequest;

public interface IPCCWhitelistOperations {

    /**
     * Checks if a MSISDN is whitelisted on IPCC
     *
     * @param whitelistRequest phone number and ivr line
     * @return true if whitelisted, false otherwise
     */
    boolean isWhitelisted(WhitelistMSISDNRequest whitelistRequest);

    /**
     * Whitelist a MSISDN on IPCC
     *
     * @param whitelistRequest phone number and ivr line
     * @return true if whitelisted, false otherwise
     */
    boolean whitelist(WhitelistMSISDNRequest whitelistRequest);
}
