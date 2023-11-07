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
        String[] binaryArr = binary.split("0");
        int count=0, temp=0,ans=0;
        for (int i = 0; i < binaryArr.length ; i++) {
            String[] subElement = binaryArr[i].split("");
            count = subElement.length;
            ans = Math.max(temp,count);
            temp=ans;
            count=0;

        }
        System.out.println(ans);
        bufferedReader.close();
    }


}
