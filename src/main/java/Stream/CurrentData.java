package Stream;

import Bank.Bank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CurrentData {

    static public List<Bank>  currentdata(List<Bank> bankList)  {

        List<Bank> result = bankList.stream().filter(e -> afterdate(e.getClosingDate())).collect(Collectors.toList());
        
        return result;
        }


        static public boolean afterdate(String date){

            LocalDate localDate = LocalDate.parse(date);
            if(localDate.isAfter(ChronoLocalDate.from(LocalDateTime.now()))) return true;
            else return false;
            
        }
}
