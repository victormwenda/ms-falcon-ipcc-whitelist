package ke.co.safaricom.falcon.entry.controllers.http.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import ke.co.safaricom.falcon.config.IPCCDefaults;
import ke.co.safaricom.falcon.config.ValidationPatterns;

public class WhitelistMSISDNRequest {

    @NotNull(message = "Phone number cannot be null")
    @NotEmpty(message = "Phone number cannot be empty")
    @JsonProperty("phone_number")
    @Pattern(regexp = ValidationPatterns.MSISDN, message = "Invalid Phone number length")
    private String mMsisdn;

    @NotNull
    @NotEmpty
    @Pattern(regexp = ValidationPatterns.IVR_LINE)
    @JsonProperty("ivr_line")
    private String mServiceLine;

    @JsonProperty("ivr_dnis")
    private String mDnis;

    @JsonProperty("source")
    private String mAccountManager;

    public String getMsisdn() {
        return mMsisdn;
    }

    public void setMsisdn(String mMsisdn) {
        this.mMsisdn = mMsisdn;
    }

    public String getServiceLine() {
        if (mServiceLine == null) {
            return IPCCDefaults.SERVICE_LINE;
        }
        return mServiceLine;
    }

    public void setServiceLine(String mServiceLine) {
        this.mServiceLine = mServiceLine;
    }

    public String getDnis() {
        if (mDnis == null) {
            // Return service line number without any Alphabets
            return mServiceLine.replaceAll("[A-Za-z]", "");
        }
        return mDnis;
    }

    public String getAccountManager() {
        if (mAccountManager == null) {
            return IPCCDefaults.ACCOUNT_MANAGER;
        }
        return mAccountManager;
    }
}
