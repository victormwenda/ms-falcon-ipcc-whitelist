package ke.co.safaricom.falcon.entry.controllers.http.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WhitelistMSISDNResponse {

    @JsonProperty("response_code")
    private int responseCode;

    @JsonProperty("response_message")
    private String responseMessage;
}
