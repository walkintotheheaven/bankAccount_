package newPackage.BankBank.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class MainBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> myId = new ArrayList<>();
        ArrayList<String> myName = new ArrayList<>();
        ArrayList<Double> mySaldo = new ArrayList<>();
        ArrayList<BankAccount> myAccount = new ArrayList<>();

        int opsiMenu;

        do {
            System.out.println("===========================");
            System.out.println("WELCOME TO SATUBANK");
            System.out.println("1. Buat Akun Bank");
            System.out.println("2. Setor Uang");
            System.out.println("3. Tarik Saldo");
            System.out.println("4. Tampilkan Informasi");
            System.out.println("5. Keluar");
            System.out.println("===========================");
            System.out.println();

            System.out.print("Pilih (1-5): ");
            int select = sc.nextInt();

            switch (select) {

                case 1:
                    System.out.println("== Menu Buat Akun ==");

                    String id = String.format("REK-%03d", myId.size() + 1);

                    System.out.print("Input Nama: ");
                    String nama = sc.next();
                    sc.nextLine();

                    if (nama.equalsIgnoreCase("null")) {
                        nama = null;
                    }

                    System.out.print("Input Saldo Awal: ");
                    double saldo = sc.nextDouble();

                    try {
                        BankAccount ACC = new BankAccount(id, nama, saldo);

                        myId.add(ACC.getAccountNumber());
                        myName.add(ACC.getOwnerName());
                        mySaldo.add(ACC.getInitialBalance());
                        myAccount.add(ACC);

                        System.out.println();
                        System.out.println("Akun berhasil dibuat!");
                        System.out.println("=======================================");
                        System.out.println("ID Rekening: " + myId.get(myId.size() - 1));
                        System.out.println("Nama Pemilik: " + myName.get(myName.size() - 1));
                        System.out.println("Saldo: " + mySaldo.get(mySaldo.size() - 1));
                        System.out.println("=======================================");

                    } catch (IllegalArgumentException e) {
                        System.out.println("Gagal membuat akun: " + e.getMessage());
                    }

                    break;

                case 2:
                    System.out.println("== Deposit Uang ==");

                    System.out.print("Input ID Rekening: ");
                    String inputId = sc.next();

                    int indexDoang = myId.indexOf(inputId);

                    if (indexDoang != -1) {

                        System.out.print("Jumlah deposit: ");
                        double jumlah = sc.nextDouble();

                        myAccount.get(indexDoang).deposit(jumlah);

                        mySaldo.set(
                                indexDoang,
                                myAccount.get(indexDoang).getInitialBalance()
                        );

                    } else {
                        System.out.println("Akun rekening tidak ditemukan");
                    }

                    break;

                case 3:
                    System.out.println("== Tarik Saldo ==");

                    System.out.print("Input ID Rekening: ");
                    String idNarik = sc.next();

                    int indexNarik = myId.indexOf(idNarik);

                    if (indexNarik != -1) {

                        System.out.print("Jumlah penarikan: ");
                        double jumlah = sc.nextDouble();

                        myAccount.get(indexNarik).withdraw(jumlah);

                        mySaldo.set(
                                indexNarik,
                                myAccount.get(indexNarik).getInitialBalance()
                        );

                    } else {
                        System.out.println("Akun rekening tidak ditemukan");
                    }

                    break;

                case 4:
                    System.out.println("== Tampilkan Informasi ==");

                    System.out.print("Input ID Rekening: ");
                    String idInfokan = sc.next();

                    int indexInfo = myId.indexOf(idInfokan);

                    if (indexInfo != -1) {

                        System.out.println("===========================");
                        System.out.println("ID Rekening: " + myId.get(indexInfo));
                        System.out.println("Nama Pemilik: " + myName.get(indexInfo));
                        System.out.println("Saldo: " + mySaldo.get(indexInfo));
                        System.out.println("===========================");

                    } else {
                        System.out.println("Akun rekening tidak ditemukan!");
                    }

                    break;

                case 5:
                    System.out.println("Terima kasih telah menggunakan SatuBank!");
                    break;
            }
            System.out.println("Pilih 1 untuk lanjut, pilih 0 untuk keluar.");
            opsiMenu = sc.nextInt();

        } while (opsiMenu == 1);
    }
}