package Bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bank {

    @XmlAttribute
    private String iban;

    @XmlElement(name="name")
    private String name;

    @XmlElement(name="currency")
    private String currency;

    @XmlElement(name="balance")
    private Double balance;

    @XmlElement(name="closingDate")
    private String closingDate;


}
