package com.employeesystem.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static final List<String> all = new ArrayList();
    public static final List<String> id = new ArrayList();
    public static final List<String> first = new ArrayList();
    public static final List<String> last = new ArrayList();
    public static final List<String> hours = new ArrayList();
    public static final List<String> payment = new ArrayList();
    public static String login;

    public Data() {
    }

    public void addEmployee(String id, String first, String last, String hours, String payment) throws IOException, InterruptedException {
        String command = "python3 Data/Data.py -a " + id + " " + first + " " + last + " " + hours + " " + payment;
        System.out.println(command);
        Process proc = Runtime.getRuntime().exec(command);
        proc.waitFor();
    }

    public void editEmployee(String id, String column, String New) throws IOException, InterruptedException {
        String command = "python3 Data/Data.py -e " + id + " " + column + " " + New;
        System.out.println(command);
        Process proc = Runtime.getRuntime().exec(command);
        proc.waitFor();
    }

    public void deleteEmployee(String id) throws IOException, InterruptedException {
        String command = "python3 Data/Data.py -d " + id;
        System.out.println(command);
        Process proc = Runtime.getRuntime().exec(command);
        proc.waitFor();
    }

    public void printAll() throws IOException, InterruptedException {
        String command = "python3 Data/Data.py -p";
        System.out.println(command);
        Process proc = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line = "";

        while((line = reader.readLine()) != null) {
            all.add(line);
        }

        proc.waitFor();
    }

    public static void printID() throws InterruptedException, IOException {
        String command = "python3 Data/Data.py -sp id";
        System.out.println(command);
        Process proc = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line = "";

        while((line = reader.readLine()) != null) {
            id.add(line);
        }

        proc.waitFor();
    }

    public static void printFirst() throws InterruptedException, IOException {
        String command = "python3 Data/Data.py -sp first";
        System.out.println(command);
        Process proc = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line = "";

        while((line = reader.readLine()) != null) {
            first.add(line);
        }

        proc.waitFor();
    }

    public static void printLast() throws InterruptedException, IOException {
        String command = "python3 Data/Data.py -sp last";
        System.out.println(command);
        Process proc = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line = "";

        while((line = reader.readLine()) != null) {
            last.add(line);
        }

        proc.waitFor();
    }

    public static void printHours() throws InterruptedException, IOException {
        String command = "python3 Data/Data.py -sp hours";
        System.out.println(command);
        Process proc = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line = "";

        while((line = reader.readLine()) != null) {
            hours.add(line);
        }

        proc.waitFor();
    }

    public static void printPayment() throws InterruptedException, IOException {
        String command = "python3 Data/Data.py -sp payment";
        System.out.println(command);
        Process proc = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line = "";

        while((line = reader.readLine()) != null) {
            payment.add(line);
        }

        proc.waitFor();
    }

    public static void printLogin(String username, String password) throws InterruptedException, IOException {
        String command = "python3 Data/Data.py -lg " + username + " " + password;
        System.out.println(command);
        Process proc = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        for(String line = ""; (line = reader.readLine()) != null; login = line) {
        }

        proc.waitFor();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        printLogin("rooot", "admin");
    }
}
