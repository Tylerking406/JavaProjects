import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SubsequentBinaryRead {
    //Read subsequent 1s from a binary number
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());  //value from user
        String binary = Integer.toBinaryString(n); //111101
        String[] binaryArr = binary.split("");

        //count ones next to each other
        int i=0, count=0;
        while (Integer.parseInt(binaryArr[i]) != 0){
            count++;
            i++;

        }
        System.out.println(count);

        bufferedReader.close();
    }

}
