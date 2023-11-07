
// This program convert user's entered time to English language


import java.util.Scanner;
public class Convertor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String time = "";
        while (true) {
            System.out.println("Enter a time or 'quit':");
            time = input.nextLine();   // 8:10
            if (time.equals("quit")) {
                System.out.println("Done");
                System.exit(0);
            }

            String[] timeArr = time.split(":");
            int m = Integer.parseInt(timeArr[1]);
            int h = Integer.parseInt(timeArr[0]);

            //Rounding minutes to nearest 5
            int rounded_m = 0;
            rounded_m= RoundMinutes(m);
            if (rounded_m > 30)
                h = h + 1;
            String minutes = MinutesToWord(rounded_m);
            String hours = HourToWord(h);

            //O'clock
            if (m == 0) {
                System.out.println(hours + " " + minutes);
            } else {
               // String prefix = "";
                if (m % 5 != 0) {
                    if (rounded_m == 0 || rounded_m==60)
                        System.out.println("about" + " " + hours + " " + minutes);
                    else
                     System.out.println("about" + " " + minutes + " " + hours);
                }
                else
                    System.out.println(minutes + " " + hours);

            }
        }
    }


    public static  String HourToWord(int h){ //8
        String[] hours = {"one","two","three","four","five","six","seven",
                            "eight","nine","ten","eleven","twelve","one"};
        return  hours[h-1];
    }

    public static String MinutesToWord(int m){
        String[] minutes = {"o'clock","five past","ten past","quarter past","twenty past","twenty five past","half past",
                            "twenty five to","twenty to","quarter to","ten to","five to","o'clock"};
        return minutes[m/5];
    }
    public static int RoundMinutes (int m){
        if (m<10){
            if (m>=8)
                return 10;
            else if (m>=3) {
                return 5;
            }
            else return 0;
        }
        int unit=m%10;
        int tenth=m/10;

        if (unit >= 3 && unit< 8)
            tenth= tenth*10 +5;
        else if (unit >= 8) {
            tenth= tenth*10 +10;
        } else
            tenth= tenth*10;
        return  tenth;
    }
}
