import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// This program accepts as input the name of a text file containing dates, one per line.
// If a date is composed entirely of odd digits (i.e., ONLY contains the digits 1, 3, 5, 7, and 9) then it will print it out, if not,
// it will compute and print the first subsequent date that is, along with the number of days until then.
public class Oddities {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in),file;
        System.out.println("Enter the name of the text file of dates:");
        String fileName = input.nextLine();
        File f = new File(fileName);
        file = new Scanner(f);

        while (file.hasNextLine()){
            String date = file.nextLine(); //1/1/1911
            String[] dateArr = date.split("/");
            int day = Integer.parseInt(dateArr[0]);
            int month = Integer.parseInt(dateArr[1]);
            int year = Integer.parseInt(dateArr[2]);
            int oldYear = year;
            int oldMonth = month;
            int oldDay = day;
            int curentYearDays=0;
            int newYear = 0;
            int count=0;

            if ((day%2==1) && (month%2==1) &&(year%2==1)){
                System.out.println("The date "+ day+"/"+month+"/"+year+" has all odd digits.");
            }
            else{
                 curentYearDays = calcNumOfMonth(month)+day;

                if (year%2 !=1){
                    year++;
                    month = 1;
                    day =1;
                }

                else if (month%2 !=1){
                    month++;
                    day=1;
                }
                else{
                    //check if month can be incremented first
                    int monthDay = monthDay(month);
                    if (day == monthDay){
                        month= month+2;
                        day=1;

                        if (month==13){
                            month=1;
                            year++;
                            count++;
                            if (year%2 !=1){
                                year++;
                                count++;
                            }
                        }
                    }else
                        day++;
                }

                //calc days

                if (oldYear == year)
                 newYear= calcNumOfMonth(month)+day;  //not if year is incremented
                else if (count ==2) {
                    newYear= calcNumOfMonth(month)+day+365*2;
                } else
                    newYear= calcNumOfMonth(month)+day+365;

                if ((oldYear% 4 == 0) ){
                    curentYearDays--;
                    if (oldMonth>2)
                        curentYearDays++;
                }
                int numDays = newYear - curentYearDays;
                String data = "days";
                if (numDays ==1)
                    data = "day";
                System.out.println("The first date after "+oldDay+"/"+oldMonth+"/"+oldYear+" with all odd digits is "+ day+"/"+month+"/"+year+" which is "+numDays+" "+data+" later.");

            }

        }
        System.out.println("Done");

    }
    public static int calcNumOfMonth(int m){//9
        int[] monthArr = {31,28,31,30,31,30,31,31,30,31,30,31};
        int sum=0;
        for (int i = 0; i < m-1; i++) {
            sum+= monthArr[i];
        }
        return sum;
    }

    public static int monthDay(int m){
        int[] monthArr = {31,28,31,30,31,30,31,31,30,31,30,31};
        return monthArr[m-1];
    }

}
