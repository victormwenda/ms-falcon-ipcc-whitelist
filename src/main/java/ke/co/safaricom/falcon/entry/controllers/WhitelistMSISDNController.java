package ke.co.safaricom.falcon.entry.controllers;

import io.netty.handler.codec.http.HttpResponseStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import ke.co.safaricom.falcon.config.Messages;
import ke.co.safaricom.falcon.config.ValidationPatterns;
import ke.co.safaricom.falcon.entry.controllers.http.requests.WhitelistMSISDNRequest;
import ke.co.safaricom.falcon.entry.controllers.http.responses.WhitelistMSISDNResponse;
import ke.co.safaricom.falcon.services.IPCCWhitelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/ipcc", produces = "application/json")
public class WhitelistMSISDNController {

    @Autowired
    private IPCCWhitelistService mIpccWhitelistService;

    @GetMapping("/is-whitelisted")
    public ResponseEntity<WhitelistMSISDNResponse> isMsisdnWhitelisted(
            @RequestParam(name = "phone_number") @Valid @Pattern(regexp = ValidationPatterns.MSISDN, message = "Invalid Phone number length")
            String msisdn,
            @RequestParam(name = "ivr_line") @Valid @Pattern(regexp = ValidationPatterns.IVR_LINE, message = "Invalid IVR Line")
            String serviceLine) {

        WhitelistMSISDNRequest whitelistMSISDNRequest = new WhitelistMSISDNRequest();
        whitelistMSISDNRequest.setMsisdn(msisdn);
        whitelistMSISDNRequest.setServiceLine(serviceLine);

        boolean whitelisted = mIpccWhitelistService.isWhitelisted(whitelistMSISDNRequest);
        WhitelistMSISDNResponse response = new WhitelistMSISDNResponse();

        if (whitelisted) {
            response.setResponseCode(HttpResponseStatus.OK.code());
            response.setResponseMessage(Messages.MSISDN_WHITELISTED);
        } else {
            response.setResponseCode(HttpResponseStatus.NOT_FOUND.code());
            response.setResponseMessage(Messages.MSISDN_NOT_WHITELISTED);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/whitelist")
    public ResponseEntity<WhitelistMSISDNResponse> whitelistMsisdn(@Valid @RequestBody WhitelistMSISDNRequest whitelistMSISDNRequest) {
        boolean whitelisted = mIpccWhitelistService.whitelist(whitelistMSISDNRequest);
        WhitelistMSISDNResponse response = new WhitelistMSISDNResponse();

        if (whitelisted) {
            response.setResponseCode(HttpResponseStatus.OK.code());
            response.setResponseMessage(Messages.MSISDN_WHITELISTED);
        } else {
            response.setResponseCode(HttpResponseStatus.OK.code());
            response.setResponseMessage(Messages.MSISDN_NOT_WHITELISTED);
        }

        return ResponseEntity.ok(response);
    }
}
