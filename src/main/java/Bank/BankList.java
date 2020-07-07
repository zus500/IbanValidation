package Bank;

import lombok.Data;


import javax.xml.bind.annotation.*;

import java.util.List;

@Data
@XmlRootElement(name = "accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankList {
    @XmlElements(@XmlElement(name="account"))
    private List<Bank> listbank ;


    public BankList(List<Bank> listbank) {
        this.listbank = listbank;
    }
    public BankList() { }

}
