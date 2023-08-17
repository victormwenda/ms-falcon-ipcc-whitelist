package ke.co.safaricom.falcon.data.database.repository;

import ke.co.safaricom.falcon.data.database.entities.TblWhitelistDto;
import ke.co.safaricom.falcon.data.database.entities.TblWhitelistId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblWhitelistRepository extends JpaRepository<TblWhitelistDto, TblWhitelistId> {

    /**
     * Checks if MSISDN is whitelisted to call an IVR Line
     *
     * @param msisdn
     * @param serviceLine
     * @return
     */
    boolean existsByMsisdnAndServiceLine(String msisdn, String serviceLine);

}
