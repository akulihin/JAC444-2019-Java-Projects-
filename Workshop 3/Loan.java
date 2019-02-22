
public class Loan {
    public int loanBankID;
    public double loanAmount;

    private Helpers help = new Helpers(); // helper functions

    public Loan(int loanBankID) {
        var mes1 = "Amount: ";
        System.out.print(mes1);

        this.loanAmount = help.getDouble(mes1);
        this.loanBankID = loanBankID;
    }
}