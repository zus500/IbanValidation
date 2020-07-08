package Stream;

        import Bank.Bank;

        import java.math.BigInteger;
        import java.util.List;
        import java.util.stream.Collectors;

public class CountIban {

    static final private String PL = "PL";
    static final private String ConvertPl = "2521";
    static final private String denominator = "97" ;


    static  public List<Bank> countiban (List<Bank> bankList){



        List<Bank>  result = bankList.stream().filter(e -> {
            if(e.getIban().length() == 28) {
                return true;
            }
            else return false;
        } ).filter(e -> {
            if(e.getIban().startsWith(PL)) return true;
            else return false;
        })
            .filter(e -> {
                String lenght = e.getIban().substring( 2 , e.getIban().length());
                if(isNumeric(lenght))return  true;
                else return false;
            })
//                .filter(e -> {
//                if(countIBAN(e))
//                    return  true;   <-------- Funkcja licząca zgodność z numerem IBAN FIXME
//                else
//                    return false; })
                .collect(Collectors.toList());

        return result;
    }

    static  public Boolean countIBAN(Bank bank){

        String replace;
        bank.setIban(bank.getIban().replace(PL , ConvertPl));
        replace = bank.getIban().substring(0 , 6);
        bank.setIban(bank.getIban().replace(replace , ""));
        bank.setIban(bank.getIban() + replace);
        BigInteger iban = new BigInteger(bank.getIban());
        BigInteger divider = new BigInteger(denominator);
        BigInteger rest = iban.remainder(divider);
        if(rest.equals(1))
            return true;
        else
            return false;
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
