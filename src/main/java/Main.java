
import Operationen.SaveOutput;
import Sort.BankComparator;
import Stream.*;
import Operationen.ReadInput;
import Bank.BankList;


import javax.xml.bind.JAXBException;
import java.util.Collections;


public class Main {

    public static void main(String[] args) throws JAXBException {

        BankList bankList = new BankList(ReadInput.RetunListBank());
        bankList.setListbank(SeparateNoPLN.SeparateNoPLN(bankList.getListbank()));
        bankList.setListbank(ChceckBalance.ChceckBalance(bankList.getListbank()));
        bankList.setListbank(CurrentData.currentdata(bankList.getListbank()));
        bankList.setListbank(CountIban.countiban(bankList.getListbank()));
        Collections.sort(bankList.getListbank() , new BankComparator());
        SaveOutput.saveoutput(bankList);
    }
}
