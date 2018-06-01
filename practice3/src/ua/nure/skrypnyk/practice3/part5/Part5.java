package ua.nure.skrypnyk.practice3.part5;

public class Part5 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100 ; i++) {
            System.out.println(i + " ====> " + decimal2Roman(i) + " ====> " + roman2Decimal(decimal2Roman(i)));
        }
    }

    public static String decimal2Roman(int decimalNumber){
        StringBuilder sb = new StringBuilder();
        if (decimalNumber > 100 || decimalNumber < 1){
            return "Wrong value. Input value from 1 till 100";
        }else{
            while (decimalNumber >= 100) {
                sb.append("C");
                decimalNumber -= 100;
            }
            while (decimalNumber >= 90) {
                sb.append("XC");
                decimalNumber -= 90;
            }
            while (decimalNumber >= 50) {
                sb.append("L");
                decimalNumber -= 50;
            }
            while (decimalNumber >= 40) {
                sb.append("XL");
                decimalNumber -= 40;
            }
            while (decimalNumber >= 10) {
                sb.append("X");
                decimalNumber -= 10;
            }
            while (decimalNumber >= 9) {
                sb.append("IX");
                decimalNumber -= 9;
            }
            while (decimalNumber >= 5) {
                sb.append("V");
                decimalNumber -= 5;
            }
            while (decimalNumber >= 4) {
                sb.append("IV");
                decimalNumber -= 4;
            }
            while (decimalNumber >= 1) {
                sb.append("I");
                decimalNumber -= 1;
            }

            return sb.toString();
        }
    }

    public static int roman2Decimal(String romanNumber){
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase();
        /* operation to be performed on upper cases even if user
           enters roman values in lower case chars */
        for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
       return decimal;
    }

    public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }
}
