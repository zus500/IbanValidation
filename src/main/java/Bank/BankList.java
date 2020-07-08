package Bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.xml.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@XmlRootElement(name = "accounts")
@XmlAccessorType(XmlAccessType.FIELD)

public class BankList {

    @XmlElements(@XmlElement(name="account"))
    private List<Bank> listbank ;

}
