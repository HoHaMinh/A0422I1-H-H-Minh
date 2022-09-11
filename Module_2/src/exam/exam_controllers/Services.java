package exam.exam_controllers;

import exam.exam_exception.NotFoundException;
import exam.exam_exception.UserException;
import exam.exam_validate.Validator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Services {
    public static List<NoteInvestement> noteInvestementList = new ArrayList<>();
    public static List<Customer> customerList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    static {
        customerList.add(new Customer(1, "Truong Tan Hai", new Date(12 / 12 / 1998), "Nam", "0123456789", "Quảng Nam"));
        customerList.add(new Customer(2, "Doan Phuoc Trung", new Date(12 / 12 / 1998), "Nam", "0123456789", "Đà Nẵng"));
        customerList.add(new Customer(3, "Abc", new Date(12 / 12 / 1998), "Nam", "0123456789", "Huế"));
    }

    public void addNew() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("1. Add new long term investment note");
            System.out.println("2. Add new short term investment");
            System.out.println("3. Add new no term investment");
            System.out.println("4. Back to menu");
            System.out.println("For long term, pls choose 1 \n,for short term, pls choose 2 or 3: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addLongTermNote();
                    break;
                case 2:
                    addShortTermNote();
                    break;
                case 3:
                    addNoTermNote();
                    break;
                case 4:
                    choice = 0;
                    break;
                default:
                    System.out.println("Wrong input. Input must be 1-4. Please choose again!\n");
            }
        }
    }

    public void addLongTermNote() {
        NoteInvestement noteInput = inputInformation();
        int longTerm;
        do {
            System.out.println("Pls enter long term invest: ");
            longTerm = Integer.parseInt(scanner.nextLine());
            try {
                Validator.validateLongTerm(longTerm);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        System.out.println("Pls enter bonus for long term invest: ");
        String bonus = scanner.nextLine();
        NoteInvestement noteLongTerm = new NoteLongTerm(noteInput.getIdNote(),
                noteInput.getCustomer(), noteInput.getCreateNoteDate(),
                noteInput.getStartInvestDate(), noteInput.getMoneyInvestment(),
                noteInput.getRateInvestment(), longTerm, bonus) {
        };
        noteInvestementList.add(noteLongTerm);
        try {
            FileWriter writer = new FileWriter("longTerm.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Add success!");
    }

    public void addShortTermNote() {
        NoteInvestement noteInput = inputInformation();
        int shortTerm;
        do {
            System.out.println("Pls enter short term invest: ");
            shortTerm = Integer.parseInt(scanner.nextLine());
            try {
                Validator.validateShortTerm(shortTerm);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        NoteInvestement noteShortTerm = new NoteShortTerm(noteInput.getIdNote(),
                noteInput.getCustomer(), noteInput.getCreateNoteDate(),
                noteInput.getStartInvestDate(), noteInput.getMoneyInvestment(),
                noteInput.getRateInvestment(), shortTerm) {
        };
        noteInvestementList.add(noteShortTerm);
        try {
            FileWriter writer = new FileWriter("shortTerm.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (NoteInvestement term : noteInvestementList) {
                String temp = term.getIdNote() + "," + "";
                bufferedWriter.write(temp);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Add success!");
    }

    public void addNoTermNote() {
        NoteInvestement noteNoTerm = inputInformation();
        noteInvestementList.add(noteNoTerm);
        try {
            FileWriter writer = new FileWriter("shortTerm.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Add success!");
    }

    public void deleteNote() {
        int length = noteInvestementList.size();
        String idNote;
        boolean idChecking = true;
        do {
            if (length == 0) {
                System.out.println("Note list is empty. Pls add new note!");
                System.out.println();
                break;
            }
            System.out.println("Pls enter id of note need to be delete: ");
            idNote = scanner.nextLine();
            for (int i = 0; i < length; i++) {
                if (noteInvestementList.get(i).getIdNote().equals(idNote)) {
                    int choice = -1;
                    while (choice != 0) {
                        System.out.println("1.Yes: delete note");
                        System.out.println("2.No: Cancel");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                noteInvestementList.remove(i);
                                display();
                                idChecking = false;
                                break;
                            case 2:
                                choice = 0;
                                break;
                            default:
                                System.out.println("Wrong input. Input must be 1-2. Please choose again!\n");
                        }
                        break;
                    }
                } else if (i == length - 1) {
                    try {
                        Validator.validate();
                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        while (idChecking);
    }

    public void display() {
        if (noteInvestementList.size() == 0) {
            System.out.println("Note list is empty. Pls add new note!");
            System.out.println();
            return;
        }
        for (NoteInvestement list : noteInvestementList
        ) {
            System.out.println(noteInvestementList.toString());
        }
    }

    public NoteInvestement inputInformation() {
        String idNote;
        do {
            System.out.println("Pls enter id of note: ");
            idNote = scanner.nextLine();
            try {
                Validator.validateIdNote(idNote);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        Customer customer = chooseCustomer();

        Date createNoteDate;
        do {
            System.out.println("Pls enter date of create note: ");
            String dateAsString = scanner.nextLine();
            try {
                createNoteDate = Validator.validateDate(dateAsString);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        Date startInvestDate;
        do {
            System.out.println("Pls enter date of start invest: ");
            String dateAsString = scanner.nextLine();
            try {
                startInvestDate = Validator.validateDate(dateAsString);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        double moneyInvestment;
        do {
            System.out.println("Pls enter money invest: ");
            moneyInvestment = Double.parseDouble(scanner.nextLine());
            try {
                Validator.validateMoney(moneyInvestment);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        System.out.println("Pls enter rate of invest: ");
        double rateInvestment = Double.parseDouble(scanner.nextLine());

        NoteInvestement noteInput = new NoteInvestement(idNote, customer, createNoteDate, startInvestDate, moneyInvestment, rateInvestment) {
        };
        return noteInput;
    }

    public static Customer chooseCustomer() {
        System.out.println("List of customers: ");
        for (Customer customer : customerList
        ) {
            System.out.println(customer.toString());
        }
        System.out.println("Input id customer: ");
        boolean check = true;
        int id = Integer.parseInt(scanner.nextLine());
        while (check) {
            for (Customer customer : customerList
            ) {
                if (id == customer.getIdCustomer()) {
                    check = false;
                    return customer;
                }
            }
            if (check) {
                System.out.println("Id customer input is wrong, pls input again: ");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        return null;
    }
}
