package JDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class javaExample {
    static Connection minConnection;
    static Statement stmt;
    static BufferedReader inLine;


    public static void fadPåLager() {
        try {
// indlæsning
            System.out.println("Vi vil nu lægge et fad på lager");
            System.out.println("Indtast fadId (fadId skal være oprettet på forhånd)");
            String fadId = inLine.readLine();
            System.out.println("Indtast hylde nr. (hylde nr. skal være oprettet på forhånd)");
            String hyldeNr = inLine.readLine();
// sender insert'en til db-serveren
            String sql = "update fad set hyldeID = '" + hyldeNr + "' where fadID = '" + fadId + "'";
            stmt.execute(sql);
// pænt svar til brugeren
            System.out.println("Fadet er nu lagt på lager");
            if (!minConnection.isClosed()) minConnection.close();
        } catch (SQLException e) {
            switch (e.getErrorCode())
            // fejl-kode 547 svarer til en foreign key fejl
            {
                case 547: {
                    if (e.getMessage().contains("hyldeforeign"))
                        System.out.println("hylden er ikke oprettet");
                    else
                        System.out.println("ukendt fremmednøglefejl");
                    break;
                }
                default:
                    System.out.println("fejlSQL: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }

    public static void opretDestillering() {
        try {
// indlæsning
            System.out.println("Opret ny destillering");

            //Antal liter
            System.out.println("Indtast antal liter");
            String antalLiter = inLine.readLine();

            //Alkoholprocent
            System.out.println("Indtast alkoholprocent");
            double alkoholProcent = Double.parseDouble(inLine.readLine());


            //Init
            System.out.println("Indtast initialer på medarbejder");
            String init = inLine.readLine();

// sender insert'en til db-serveren
            String sql = "insert into destillering values (?,?,?)";
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();
            prestmt.setString(1, antalLiter);
            prestmt.setDouble(2, alkoholProcent);
            prestmt.setString(3, init);
            prestmt.execute();

// pænt svar til brugeren
            System.out.println("Destillering er nu oprettet");
            if (!minConnection.isClosed()) minConnection.close();
        } catch (SQLException e) {
            switch (e.getErrorCode())
            // fejl-kode 547 svarer til en foreign key fejl
            {
                case 547: {
                    if (e.getMessage().contains("initforeign"))
                        System.out.println("Medarbejder er ikke oprettet");
                    else if (e.getMessage().contains("alkoholCheck"))
                        System.out.println(" Alkoholen er ikke inden for den given mængde");
                    else
                        System.out.println("ukendt fremmednøglefejl");
                    break;
                }
                default:
                    System.out.println("fejlSQL: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }

    public static void oversigtMedarbejder() {
        try {
            // Indlæser søgestreng
            System.out.println("Indtast initialer for den givende medarbejder");
            String inString = inLine.readLine();
            // Laver sql-sætning og får den udført
            String sql = "select count(newMakeNr),sum(antalLiter)from destillering where init like '" + inString + "%'";
            System.out.println("SQL-streng er " + sql);
            ResultSet res = stmt.executeQuery(sql);
            //gennemløber svaret
            while (res.next()) {
                System.out.println(res.getString(1) + "    " + res.getString(2));
            }
            // pæn lukning
            if (!minConnection.isClosed()) minConnection.close();
        } catch (SQLException e) {
            switch (e.getErrorCode())
            // fejl-kode 547 svarer til en foreign key fejl
            {
                case 547: {
                    if (e.getMessage().contains("initforeign"))
                        System.out.println("Medarbejder er ikke oprettet");
                    else
                        System.out.println("ukendt fremmednøglefejl");
                    break;
                }
                default:
                    System.out.println("Fejl SQL: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }


    public static void main(String[] args) {
// TODO Auto-generated method stub
        try {
            inLine = new BufferedReader(new InputStreamReader(System.in));
//generel opsætning
//via native driver
            String server = "localhost"; //virker måske hos dig
            //virker det ikke - prøv kun med localhost
            String dbnavn = "sallWhiskyDB";            //virker måske hos dig
            String login = "sa";                     //skal ikke ændres
            String password = "jens1234";            //skal ændres
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            minConnection =
                    DriverManager.getConnection("jdbc:sqlserver://" + server + ";databaseName=" + dbnavn +
                            ";user=" + login + ";password=" + password + ";");
//minConnection =
//            DriverManager.getConnection("jdbc:sqlserver://localhost\\ SQLEXPRESS;databaseName=eksempeldb;user=sa;password=torben07;");
            stmt = minConnection.createStatement();
//Indlæsning og kald af den rigtige metode
            System.out.println("Indtast  ");
            System.out.println("m for at finde information om en medarbejder ");
            System.out.println("f for at lægge et fad på plads ");
            System.out.println("d for at oprette en destillering ");
            String in = inLine.readLine();
            switch (in) {
                case "m": {
                    oversigtMedarbejder();
                    break;
                }
                case "f": {
                    fadPåLager();
                    break;
                }
                case "d": {
                    opretDestillering();
                    break;
                }
                default:
                    System.out.println("ukendt indtastning");
            }
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }
}
