import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class EveryCaseSwitchForPositiveIntegers {
    public static void main(String[] args) {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("public String numberToWords(int num) {\n");
            myWriter.write("\tswitch (num){\n");

            
            for(int i = 0; i <= 2147483647; i++){
                myWriter.write("\t\tcase: "+i+": return "+'"'+numberToWords(i)+'"'+";\n");
            }
            myWriter.write("\t\tdefault: return" +'"'+'"'+";\n");
            myWriter.write("\t}\n");
            myWriter.write("}\n");

            myWriter.close();
        } catch (IOException e) {

        }
        
    }
    
    public static String numberToWords(int num) {
        if (num==0){ return "Zero"; }
        return billions(num);
    }

    public static String billions(int num){
        int billion = num/1000000000;
        if (billion == 0){ return millions(num); }

        int million = num%1000000000;

        if (million != 0) { return hundreds(billion) + " Billion " + millions(million); }
        return hundreds(billion) + " Billion";
    }

    public static String millions(int num){
        int million = num/1000000;
        if (million == 0){ return thousands(num); }

        int thousand = num%1000000;

        if (thousand != 0) { return hundreds(million) + " Million " + thousands(thousand); }
        return hundreds(million) + " Million";
    }

    public static String thousands(int num){
        int thousand = num/1000;
        if (thousand == 0){ return hundreds(num); }

        int hundred = num%1000;
        if (hundred != 0) { return hundreds(thousand) + " Thousand " + hundreds(hundred); }
        return hundreds(thousand) + " Thousand";
    }

    public static String hundreds(int num){
        int hundred = num/100;
        if (hundred == 0){ return tens(num); }

        int ten = num%100;

        if (ten != 0) { return tens(hundred) + " Hundred" + " " + tens(ten); }
        return ones(hundred) + " Hundred";
    }

    public static String tens(int num){
        int ten = num/10;
        int one = num%10;
        String out = "";
        switch (ten){
            case 0:
                return ones(one);
            case 1:
                switch (one){
                    case 0: return "Ten";
                    case 1: return "Eleven";
                    case 2: return "Twelve";
                    case 3: return "Thirteen";
                    case 4: return "Fourteen";
                    case 5: return "Fifteen";
                    case 6: return "Sixteen";
                    case 7: return "Seventeen";
                    case 8: return "Eighteen";
                    case 9: return "Nineteen";
                    default:  return "";
                }
            case 2: out = "Twenty"; break;
            case 3: out = "Thirty"; break;
            case 4: out = "Forty"; break;
            case 5: out = "Fifty"; break;
            case 6: out = "Sixty"; break;
            case 7: out = "Seventy"; break;
            case 8: out = "Eighty"; break;
            case 9: out = "Ninety"; break;
            default: out = "";
        }
        if(one!=0){ return out + " " + ones(one); }
        return out;
    }

    public static String ones(int num){
        switch (num){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: return "";
        }
    }
}