package ke.co.safaricom.falcon.services;

import ke.co.safaricom.falcon.business.IPCCWhitelistOperations;
import ke.co.safaricom.falcon.data.IPCCWhitelistItem;
import ke.co.safaricom.falcon.data.database.dao.TblWhitelistDao;
import ke.co.safaricom.falcon.entry.controllers.http.requests.WhitelistMSISDNRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IPCCWhitelistService implements IPCCWhitelistOperations {

    @Autowired
    private TblWhitelistDao mWhitelistDao;

    /**
     * Checks if a MSISDN is whitelisted on IPCC
     *
     * @param whitelistRequest phone number and service line
     * @return true if whitelisted, false otherwise
     */
    @Override
    public boolean isWhitelisted(WhitelistMSISDNRequest whitelistRequest) {
        return mWhitelistDao.isWhitelisted(whitelistRequest.getMsisdn(), whitelistRequest.getServiceLine());
    }

    /**
     * Whitelist a MSISDN to dial an IVR Service Line
     *
     * @param whitelistRequest phone number and service line
     * @return true if whitelisted, false otherwise
     */
    @Override
    public boolean whitelist(WhitelistMSISDNRequest whitelistRequest) {
        IPCCWhitelistItem whitelistItem = new IPCCWhitelistItem(
                whitelistRequest.getMsisdn(),
                whitelistRequest.getServiceLine(),
                whitelistRequest.getDnis(),
                whitelistRequest.getAccountManager()
        );
        return mWhitelistDao.whitelist(whitelistItem);
    }
}
