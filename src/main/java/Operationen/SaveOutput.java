package Operationen;

import Bank.Bank;
import Bank.BankList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.File;

public class SaveOutput {


    static public void saveoutput (BankList bankList) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(BankList.class ,Bank.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(bankList, new File("output.xml"));
    }
}
