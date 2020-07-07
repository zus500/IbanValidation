package Stream;

import Bank.Bank;

import java.util.List;
import java.util.stream.Collectors;


public class SeparateNoPLN {

       static public List<Bank> SeparateNoPLN(List<Bank> ListBank){


       List<Bank> result = ListBank.stream().filter( l -> l.getCurrency().startsWith("PLN")).collect(Collectors.toList());
        return  result;
    }
}
