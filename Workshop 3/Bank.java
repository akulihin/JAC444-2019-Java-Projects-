
public class Bank {

    public int bankID;
    public Loan[] bankLoan;
    public double balance;
    public boolean isSafe;

    private Helpers help = new Helpers(); // helper functions

    public Bank(Bank[] allBanks) {
        System.out.println("______________________");
        var mes = "Bank # ";
        var flag = false;

        // check for unique id
        do {
            flag = false;
            System.out.print(mes);
            var id = (int) help.getDouble(mes);

            for (var i = 0; i < allBanks.length; i++) {
                if (allBanks[i] != null)
                    if (allBanks[i].bankID == id) {
                        flag = true;
                        System.out.println("This id alredy taken, try another one");
                    }
            }
            if (!flag)
                this.bankID = id;
        } while (flag);

        mes = "Balance: ";
        System.out.print(mes);

        this.isSafe = true;

        this.balance = help.getDouble(mes);
    }

    public void setBankLoan(Bank[] allBanks) {
        var mes = "Number of banks Loaned: ";
        System.out.print(mes);

        this.bankLoan = new Loan[(int) help.getDouble(mes)];/////////////

        for (int i = 0; i < bankLoan.length; i++) {
            mes = "Bank ID: ";
            var flag = true;
            var anotherBankID = 0;
            do {
                System.out.print(mes);
                anotherBankID = (int) help.getDouble(mes);

                if (anotherBankID == this.bankID) {
                    System.out.println("you cant borrow from yourself!");
                }  else {
                    flag = false;
                }
            } while (flag);

            bankLoan[i] = new Loan(anotherBankID);
        }

        System.out.println("______________________");
    }

    public double getTotalAsset() {
        var r = balance;

        for (var i = 0; i < bankLoan.length; i++) {
            r += bankLoan[i].loanAmount;
        }

        return r;
    }
}