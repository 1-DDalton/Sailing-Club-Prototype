/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boatprototype;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author danka
 */
public class DataManipulation {
    public static void updateEvents(String eventName, String eventDate, String eventStartTime, int eventID){
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
            Statement statement = conn.createStatement();
            statement.execute("UPDATE Events\n SET Event_Name = '"+ eventName + "',\n Event_Date = '" + eventDate+ "',\n Event_Start_Time = '"+ eventStartTime+"' \nWHERE Event_ID = " + eventID  );
        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
        }
    }
    public static void addEvents(String eventName, String eventDate, String eventStartTime, int eventID){
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO Events Values(NULL,'"+eventName+"','"+eventDate+"','"+eventStartTime+"')");
        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
        }
        
    }    
    public static void deleteEvents(String eventName, String eventDate, String eventStartTime, int eventID){
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
            Statement statement = conn.createStatement();
            statement.execute("DELETE FROM Events WHERE Event_ID = " + eventID);
        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
    }
    }
    /*
    public static void updateEventsTable(String eventName, String eventDate, String eventStartTime, int eventID){
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
            Statement statement = conn.createStatement();
            statement.execute("SELECT * FROM Events");
        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
        }
        
    } 
    */
}