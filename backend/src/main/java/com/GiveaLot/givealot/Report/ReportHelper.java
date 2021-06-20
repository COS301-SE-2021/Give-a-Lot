package com.GiveaLot.givealot.Report;

import com.GiveaLot.givealot.Organisation.exceptions.OrgException;
import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Report.exceptions.ReportException;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReportHelper {

    //Create report

    public ReportHelper(){}
    public File createReportFile(Report report) throws Exception{
        if (report.getOrgId()==null){
            throw new ReportException("Exception: Report data is null");
        }
        try {

            /** Create file **/

            String reportName = "report" + report.getId();
            reportName = reportName.replaceAll("[^a-zA-Z0-9]", "");
            File file = new File(reportName + ".txt");
            if (file.createNewFile()) {
            } else {
                throw new ReportException("Exception: File already exists");
            }

            /** Write to file **/

            String id = report.getId().toString();
            String date = report.getDate().toString();
            FileWriter writer = new FileWriter(reportName + ".txt");

            writer.write("ID: ");
            writer.write(id);
            writer.write("\n");
            writer.write("Date: ");
            writer.write(date);
            writer.write("\n");
            writer.write("Reporter email: ");
//            writer.write(report.getReporterEmail());
            writer.write("\n");
            writer.write("Organisation ID: ");
            writer.write(report.getOrgId());
            writer.write("\n");
            writer.write("Type: ");
            writer.write(report.getReportType());
            writer.write("\n");
            writer.write("Description: ");
            writer.write(report.getReportDescription());
            writer.write("\n");

            writer.close();

            /** Update database **/

            try {

                String serverName = "hansken.db.elephantsql.com";
                String mydatabase = "Givealot";
                String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/iqvyaozz";

                String username = "iqvyaozz";
                String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";
                System.out.println("Success");
                //Setup connection
                Connection connection = DriverManager.getConnection(url, username, password);

                //Create statement
                Statement state = connection.createStatement();

                //organisations is a table
                //String query = "create database newDB;";
                String query1 = "select \"numberOfReports\" from public.\"OrganisationInfo\" where \"orgId\" ='" + report.getOrgId() + "';";
                //System.out.println(query1);
                ResultSet rs = state.executeQuery(query1);

                //System.out.println("Success");

                int reports = 0;

                while (rs.next()){
                    reports = rs.getInt("numberOfReports");
                }

                reports++;

                String query2 = "update public.\"OrganisationInfo\" set \"numberOfReports\" = '"+ reports +"' where \"orgId\" = '" + report.getOrgId() + "';";
                //System.out.println(query2);

                //execute the query
                state.executeUpdate(query2);

                rs = state.executeQuery(query1);

                //System.out.println("Success");

                int reportsConfirm = 0;

                while (rs.next()){
                    reportsConfirm = rs.getInt("numberOfReports");
                }

                reportsConfirm++;

                /** Confirm ID exists **/

                if (reports == reportsConfirm) {
                    System.out.println("Non Existent");
                    throw new ReportException();
                }

                System.out.println("Successfully Executed Update");
            }
            catch (Exception e){
                throw new SQLException("Exception: ID is not present in the database");
            }

            return file;
        }
        catch (Exception e) {
            throw new ReportException("Exception: ID is not present in the database");
        }
    }

    public static void main(String[] args) throws Exception {

        Report report = new Report("0b5d9a449f7d4c99ca9bd41def84b659","They provided incorrect addresses and contact information", "Incorrect Profile Info", "CoolUser57@gmail.com");

        ReportHelper help = new ReportHelper();
        File reportFile = help.createReportFile(report);
        System.out.println(reportFile);
        Scanner reader = new Scanner(reportFile);
        while (reader.hasNextLine()){
            String data = reader.nextLine();
            System.out.println(data);
        }
        reader.close();

    }
}
