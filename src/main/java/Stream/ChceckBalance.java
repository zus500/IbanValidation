package Stream;

import Bank.Bank;
import java.util.List;
import java.util.stream.Collectors;


public class ChceckBalance {



   static public List<Bank> ChceckBalance(List<Bank> bankList) {
       List<Bank> result = bankList.stream().filter(e -> e.getBalance() >= 0).collect(Collectors.toList());
       return result ;
   }
}
