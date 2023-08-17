package ke.co.safaricom.falcon.data;

public class IPCCWhitelistItem {
    private String mMsisdn;
    private String mServiceLine;
    private String mDnis;
    private String mAccountManager;

    public IPCCWhitelistItem(String mMsisdn, String mServiceLine, String mDnis, String mAccountManager) {
        this.mMsisdn = mMsisdn;
        this.mServiceLine = mServiceLine;
        this.mDnis = mDnis;
        this.mAccountManager = mAccountManager;
    }

    public String getMsisdn() {
        return mMsisdn;
    }

    public void setMsisdn(String mMsisdn) {
        this.mMsisdn = mMsisdn;
    }

    public String getServiceLine() {
        return mServiceLine;
    }

    public void setServiceLine(String mServiceLine) {
        this.mServiceLine = mServiceLine;
    }

    public String getDnis() {
        return mDnis;
    }

    public void setDnis(String mDnis) {
        this.mDnis = mDnis;
    }

    public String getAccountManager() {
        return mAccountManager;
    }

    public void setAccountManager(String mAccountManager) {
        this.mAccountManager = mAccountManager;
    }
}

