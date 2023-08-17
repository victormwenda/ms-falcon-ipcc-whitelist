package ke.co.safaricom.falcon.data.database.entities;

import jakarta.persistence.*;

@Entity
@IdClass(TblWhitelistId.class)
@Table(name = "TBL_WHITELIST", schema = "TIBUSR")
public class TblWhitelistDto {
    @Id
    @Column(name = "MSISDN")
    private String msisdn;
    @Id
    @Column(name = "SERVICE_LINE")
    private String serviceLine;
    @Column(name = "DNIS")
    private String dnis;
    @Column(name = "ACCOUNT_MANAGER")
    private String accountManager;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String mMsisdn) {
        this.msisdn = mMsisdn;
    }

    public String getServiceLine() {
        return serviceLine;
    }

    public void setServiceLine(String mServiceLine) {
        this.serviceLine = mServiceLine;
    }

    public String getDnis() {
        return dnis;
    }

    public void setDnis(String mDnis) {
        this.dnis = mDnis;
    }

    public String getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(String mAccountManager) {
        this.accountManager = mAccountManager;
    }
}
