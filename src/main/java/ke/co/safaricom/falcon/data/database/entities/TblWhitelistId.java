package ke.co.safaricom.falcon.data.database.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TblWhitelistId implements Serializable {
    @Column(name = "MSISDN")
    private String msisdn;
    @Column(name = "SERVICE_LINE")
    private String serviceLine;

    public TblWhitelistId(String msisdn, String serviceLine) {
        this.msisdn = msisdn;
        this.serviceLine = serviceLine;
    }

    public TblWhitelistId() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TblWhitelistId that)) return false;
        return Objects.equals(msisdn, that.msisdn) && Objects.equals(serviceLine, that.serviceLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msisdn, serviceLine);
    }
}
