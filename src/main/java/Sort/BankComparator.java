package Sort;

import Bank.Bank;
import org.apache.commons.lang3.builder.CompareToBuilder;


import java.util.Comparator;


public class BankComparator  implements Comparator<Bank> {

    @Override
    public int compare(Bank o1, Bank o2) {
        return new CompareToBuilder().append(o1.getName() , o2.getName()).build();
    }

}
