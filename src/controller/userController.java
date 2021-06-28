package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class userController {
    private static String filePath = "localDatabase\\login.txt";
    public static void writingMethod(String AddNewUserDetail) {
        BufferedWriter buffer = null;
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                file.createNewFile();
                new IOException("File is not found!");
            }

            FileWriter fw = new FileWriter(file, true);
            buffer = new BufferedWriter(fw);
            buffer.write(AddNewUserDetail);
            buffer.newLine();

        } catch (IOException ioe) {
            System.out.println(ioe);
            ioe.printStackTrace();
        } finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            } catch (Exception ex)

            {
                System.out.println(ex);
            }
        }
    }

    public static void viewLoginDetails(JTable loginViewTable) {
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel) loginViewTable.getModel();
            model.setRowCount(0);
            Object[] tableLines = br.lines().toArray();
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                model.addRow(dataRow);
            }
            br.close();

        } catch (Exception ex) {
        }
    }

    public static void deleteUser(Login deleteObj) {
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<Login> loginObjList = new ArrayList<Login>();
            Login currAppObj;
            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
            }

            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            int deleteIndexNo = 0;
            loginObjList.remove(deleteIndexNo);
            deleteIndexNo = 0;
            for (Login loopObj : loginObjList) {
                writingMethod(loopObj.toString());
            }
            br.close();

        } catch (Exception ex) {

        }

    }

    public static void updateUser(int delRowNum, String updatedString) {

        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<Login> lineObjList = new ArrayList<Login>();
            Login currAppObj;
            Login updatedObj = new Login();
            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                currAppObj = new Login();
                lineObjList.add(currAppObj);
            }

            lineObjList.set(delRowNum, updatedObj);
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();

            for (Login loopObj : lineObjList) {

                writingMethod(loopObj.toString());

            }
            br.close();
        } catch (Exception ex) {
        }
    }

    public static void updatePasswordByUser(String userName, String newPass) {

        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<Login> lineObjList = new ArrayList<Login>();
            Login appObj;
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();

            for (Login loopObj : lineObjList) {
                writingMethod(loopObj.toString());
            }
            br.close();
        } catch (Exception ex) {

        }

    }

    public static void createNewLog(String AddNewUserDetail) {
        String filePath = "localDatabase\\loginLog.txt";
        BufferedWriter buffer = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                new IOException("File is not found!");
            }

            FileWriter fw = new FileWriter(file, true);
            buffer = new BufferedWriter(fw);
            buffer.write(AddNewUserDetail);
            buffer.newLine();

        } catch (IOException ioe) {
            System.out.println(ioe);
            ioe.printStackTrace();
        } finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public static void passResetPaitient(String rowString) {
        String[] PatientUserName = rowString.split(",");
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<Login> lineObjList = new ArrayList<Login>();
            Login currAppObj;
            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
            }

            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();

            for (Login loopObj : lineObjList) {
                writingMethod(loopObj.toString());
            }
            br.close();
        } catch (Exception ex) {
        }
    }
}