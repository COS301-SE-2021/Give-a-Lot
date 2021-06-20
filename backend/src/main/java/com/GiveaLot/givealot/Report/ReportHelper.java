package com.GiveaLot.givealot.Report;

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
    public File createReportFile(Report report) throws Exception
    {
        try {

            String reportName = "report" + report.getId();
            reportName = reportName.replaceAll("[^a-zA-Z0-9]", "");
            File file = new File(reportName + ".txt");
            if(file.createNewFile())
            {

            }
            else
            {
                throw new ReportException("Exception: File already exists");
            }
            String id = report.getId().toString();
            String date = report.getDate().toString();
            FileWriter writer = new FileWriter(reportName + ".txt");

            writer.write("ID: ");
            writer.write(id);
            writer.write("\n");
            writer.write("Date: ");
            writer.write(date);
            writer.write("\n");
            writer.write("User email: ");
            writer.write(report.getReporterEmail());
            writer.write("\n");
            writer.write("Organisation: ");
            writer.write(report.getOrgName());
            writer.write("\n");
            writer.write("Type: ");
            writer.write(report.getReportType());
            writer.write("\n");
            writer.write("Description: ");
            writer.write(report.getReportDescription());
            writer.write("\n");

            writer.close();

            try
            {
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

                System.out.println("Successfully Executed Update");
            }
            catch (Exception e){
                throw new SQLException("Exception: Insert into database could not be fulfilled");
            }

            return file;
        }
        catch (Exception e) {
            throw new ReportException("Exception: Problem creating Report");
        }
    }

    public static void main(String[] args) throws Exception {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Report report = new Report("0b5d9a449f7d4c99ca9bd41def84b659","The Swindlers","They provided incorrect addresses and contact information", "Incorrect Profile Info", "CoolUser57", timestamp);

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
