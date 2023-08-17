package ke.co.safaricom.falcon.data.database.dao;

import ke.co.safaricom.falcon.data.IPCCWhitelistItem;
import ke.co.safaricom.falcon.data.database.entities.TblWhitelistDto;
import ke.co.safaricom.falcon.data.database.repository.TblWhitelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TblWhitelistDao {

    @Autowired
    private TblWhitelistRepository mWhitelistRepo;

    /**
     * Checks if an MSISDN is whitelisted
     *
     * @param msisdn
     * @return
     */
    public boolean isWhitelisted(String msisdn, String serviceLine) {
        return mWhitelistRepo.existsByMsisdnAndServiceLine(msisdn, serviceLine);
    }

    /**
     * Whitelists MSISDN on IVR
     *
     * @return
     */
    public boolean whitelist(IPCCWhitelistItem whitelistItem) {
        boolean whitelisted = mWhitelistRepo
                .existsByMsisdnAndServiceLine(whitelistItem.getMsisdn(), whitelistItem.getServiceLine());
        if (whitelisted) {
            return true;
        }


        TblWhitelistDto mWhitelist = new TblWhitelistDto();
        mWhitelist.setMsisdn(whitelistItem.getMsisdn());
        mWhitelist.setServiceLine(whitelistItem.getServiceLine());
        mWhitelist.setDnis(whitelistItem.getDnis());
        mWhitelist.setAccountManager(whitelistItem.getAccountManager());
        try {
            mWhitelist = mWhitelistRepo.save(mWhitelist);
            return isWhitelisted(whitelistItem.getMsisdn(), whitelistItem.getServiceLine());
        } catch (Exception e) {
            e.printStackTrace();
            // Whitelist failed
        }

        return false;
    }

}
