package Task1;

import java.io.*;

public class Data {

    public static void Create_Data() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/Task1/account.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            for (int i = 0; i < 10; ++i) {
                out.writeObject(new Account(i + 1, "Fname_" + i, "Lname_" + i, 100));
            }

            out.close();
            fileOut.close();

            System.out.printf("Serialized data is saved in src/Task1/account.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void Print() {
        try {
            FileInputStream fileIn = new FileInputStream("src/Task1/account.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Account account;

            for (int i = 0; i < 10; ++i) {

                account = (Account) in.readObject();
                System.out.println("Id:" + account.getId());
                System.out.println("Full Name:" + account.getFullName());
                System.out.println("Balance:" + account.getBalance());
                System.out.println();
            }

            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Account class not found");
            c.printStackTrace();
            return;
        }
    }

    public static Account Check(int account_no) {
        try {
            FileInputStream fileIn = new FileInputStream("src/Task1/account.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Account account;

            for (int i = 0; i < 10; ++i) {

                account = (Account) in.readObject();
                if (account.getId() == account_no) {
                    return account;
                }
            }

            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Account class not found");
            c.printStackTrace();
        }
        return new Account();
    }

    public static void Update(Account account_recived) {

        Account[] account = new Account[10];

        try {
            FileInputStream fileIn = new FileInputStream("src/Task1/account.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Account take;

            for (int i = 0; i < 10; ++i) {
                take = (Account) in.readObject();
                if (take.getId() == account_recived.getId()) {
                    account[i] = account_recived;
                } else {
                    account[i] = take;
                }
            }

            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Account class not found");
            c.printStackTrace();
            return;
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("src/Task1/account.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.reset();

            for (int i = 0; i < 10; ++i) {
                out.writeObject(account[i]);
            }

            out.close();
            fileOut.close();

            System.out.printf("Serialized data is saved in src/Task1/account.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}
