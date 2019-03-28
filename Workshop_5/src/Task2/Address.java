package Task2;

import javax.crypto.Cipher;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Address {
    public String fname;
    public String lname;
    public String city;
    public String prov;
    public String postcode;

    public static int amount = 0;

    public Address() {
        this.fname = "";
        this.lname = "";
        this.city = "";
        this.prov = "";
        this.postcode = "";
    }

    public Address(String fname, String lname, String city, String prov, String postcode) {
        this.fname = fname;
        this.lname = lname;
        this.city = city;
        this.prov = prov;
        this.postcode = postcode;
    }

    public Address(byte[] arr) {

        String str = new String(arr);

        this.fname = str.substring(0, 9).replace(" ", "");
        this.lname = str.substring(10, 19).replace(" ", "");
        this.city = str.substring(20, 29).replace(" ", "");
        this.prov = str.substring(30, 32).replace(" ", "");
        this.postcode = str.substring(32, 39).replace(" ", "");
    }

    public static Address ReadAddress(int element) {
        byte[] bytesToRead = new byte[40];
        try {
            RandomAccessFile fileAF = new RandomAccessFile("src/Task2/data.txt", "r");
            int pos = 40 * (element - 1);
            fileAF.seek(pos);
            fileAF.read(bytesToRead);
            fileAF.close();
        } catch (IOException e) {
            System.out.println("Error::reading");
        }
        return new Address(bytesToRead);
    }

    public void WriteAddress(int element) {
        try {
            RandomAccessFile fileAF = new RandomAccessFile("src/Task2/data.txt", "rw");
            int pos = 40 * (element - 1);
            fileAF.seek(pos);
            String data = Convert();
            fileAF.write(data.getBytes());
            fileAF.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public String Convert() {
        String spaces = "          ";
        String ans = new String(fname + spaces.substring(0, 10 - fname.length()) + lname
                + spaces.substring(0, 10 - lname.length()) + city + spaces.substring(0, 10 - city.length()) + prov
                + spaces.substring(0, 2 - prov.length()) + postcode + spaces.substring(0, 8 - postcode.length()));
        System.out.println(ans);
        return ans;
    }

    public void Display() {
        System.out.println(fname + " " + lname + " " + city + " " + prov + " " + postcode);
    }

    public boolean isEmpty() {
        return fname == "" && lname == "" && city == "" && prov == "" && postcode == "";
    }

    public void Clear() {
        this.fname = "";
        this.lname = "";
        this.city = "";
        this.prov = "";
        this.postcode = "";
    }
}
