package newPackage.BankBank.practice;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double initialBalance;

//    CONSTRUCTOR UTAMA
    public BankAccount(String accountNumber, String ownerName, double initialBalance){
        if (accountNumber == null || accountNumber.trim().isEmpty()){
            throw new IllegalArgumentException("Nomor tidak boleh kosong");
        } else if (ownerName == null || ownerName.trim().isEmpty()){
            throw new IllegalArgumentException("Nama pemilik tidak boleh kosong");
        } else if (initialBalance < 0){
            throw new IllegalArgumentException("Saldo awal tidak boleh kosong / kurang dari 0");
        } else {
            this.accountNumber = accountNumber;
            this.ownerName = ownerName;
            this.initialBalance = initialBalance;
        }

    }

//    CONSTRUCTOR 2
    public BankAccount(String accountNumber, String ownerName){
        this(accountNumber, ownerName, 0.0);
    }

    public  String getAccountNumber(){
        return this.accountNumber;
    }

    public String getOwnerName(){
        return this.ownerName;
    }

    public double getInitialBalance(){
        return this.initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.initialBalance += amount;
            System.out.println("Setoran berhasil, saldo saat ini: " + this.initialBalance);
        } else {System.out.println("Gagal, Setoran harus lebih besar dari 0");
        }
    }

    public void withdraw(double amount){
        if (amount > 0 && initialBalance >= amount){
            this.initialBalance -= amount;
            System.out.println("Penarikan Uang berhasil, saldo saat ini: " + this.initialBalance);
        } else {
            System.out.println("Saldo tidak mencukupi");
        }
    }
}
