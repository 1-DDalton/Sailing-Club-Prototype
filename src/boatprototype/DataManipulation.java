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
import java.sql.ResultSet;

/**
 *
 * @author danka
 */
public class DataManipulation {
    public static void updateEvents(String eventId, String eventName, String eventDate, String eventStartTime){
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
            Statement statement = conn.createStatement();
            statement.execute("UPDATE Events\n SET Event_Name = '"+ eventName + "',\n Event_Date = '" + eventDate+ "',\n Event_Start_Time = '"+ eventStartTime+"' \nWHERE Event_ID = '" + eventId +"'");
        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
        }
    }
    public static void addEvents(String eventId, String eventName, String eventDate, String eventStartTime){
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO Events Values('"+ eventId +"','"+eventName+"','"+eventDate+"','"+eventStartTime+"')");
        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
        }
        
    }    
    public static void deleteEvents(String eventId, String eventName, String eventDate, String eventStartTime){
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
            Statement statement = conn.createStatement();
            statement.execute("DELETE FROM Events WHERE Event_ID = '" + eventId +"'");
        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
    }
    }

    
    public static void addMember(String memberId, String memberName, String memberDOB, String memberAddress1, String memberAddress2, String memberTown, String memberPostcode, String memberEmail, String memberPhone, String memberOccupation, String membershipType, String memberFamily_ID){
        
        
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
        Statement statement = conn.createStatement();
        statement.execute("INSERT INTO Address Values('"+ memberFamily_ID +"','"+memberAddress1+"','"+memberAddress2+"','"+memberTown+"','"+memberPostcode+"')");
        statement.execute("INSERT INTO Members Values('"+ memberId +"','"+memberName+"','"+memberDOB+"','"+memberEmail+"','"+memberOccupation+"','"+membershipType+"','"+memberPhone+"','"+memberFamily_ID+"')");


    } catch (SQLException ex) {
        System.out.println("errorMessage"+ ex);
    }
        
    } 
    public static void deleteMember(String memberId){
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
            Statement statement = conn.createStatement();
            statement.execute("DELETE FROM Members WHERE Membership_ID = '" + memberId +"'");
        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
    }
    }
    public static void updateMember(String memberId, String memberName, String memberDOB, String memberAddress1, String memberAddress2, String memberTown, String memberPostcode, String memberEmail, String memberPhone, String memberOccupation, String membershipType, String memberFamily_ID){
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
            Statement statement = conn.createStatement();
//            statement.execute("UPDATE Members SET Membership_ID = '" + memberId +"', Full_Name = '"+memberName+"', DOB = '"+memberDOB+"', Email = '"+memberEmail+"', Occupation = '"+memberOccupation+"', Membership_Type = '"+membershipType+"',Phone_Number = '"+memberPhone+"', Family_ID = '"+memberFamily_ID+"'");
//            statement.execute("UPDATE Address SET Family_ID = '"+ memberFamily_ID +"', Address_Line_1  = '"+memberAddress1+"', Address_Line_2 = '"+memberAddress2+"', Town = '"+memberTown+"', Postcode = '"+memberPostcode+"'");
            statement.execute("UPDATE Members SET Full_Name = '"+memberName+"', DOB = '"+memberDOB+"', Email = '"+memberEmail+"', Occupation = '"+memberOccupation+"', Membership_Type = '"+membershipType+"',Phone_Number = '"+memberPhone+"' WHERE Membership_ID = '" + memberId +"'");
            statement.execute("UPDATE Address SET Address_Line_1  = '"+memberAddress1+"', Address_Line_2 = '"+memberAddress2+"', Town = '"+memberTown+"', Postcode = '"+memberPostcode+"' WHERE Family_ID = '"+ memberFamily_ID +"'");

        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
        }
    }
    
    
    public static void addBoat(String boatID,String boatName,String boatClass,String boatSailNumber,String boatType,String memberID){
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO Boat Values('"+ boatID +"','"+boatType+"','"+boatName+"','"+boatClass+"','"+boatSailNumber+"','"+memberID+"')");
        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
        }
        
    } 
    
    
    
    public static void updateBoat(String boatID,String boatName,String boatClass,String boatSailNumber,String boatType,String memberID){
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
            Statement statement = conn.createStatement();
            statement.execute("UPDATE Boat SET Boat_Type = '"+boatType+"', Boat_Name = '"+ boatName + "', Class = '" + boatClass+ "', Sail_Number = '"+ boatSailNumber+"', Membership_ID = '"+memberID+"' WHERE Boat_ID = '" + boatID +"'");
        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
        }   
    }
    
    public static void deleteBoat(String boatID, String boatName,String boatClass,String boatSailNumber,String boatType,String memberID){
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
            Statement statement = conn.createStatement();
            statement.execute("DELETE FROM Boat WHERE Boat_ID = '" + boatID +"'");
        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
        }
    }

    
    public static void addDuty(String selectedDuty, String selectedEvent, String membershipId){
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO Duty_Sign_In (Duty_Name, Event_ID, Membership_ID) Values('"+selectedDuty+"','"+selectedEvent+"','"+membershipId+"')");
        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
        }
    }
        
    
    public static void deleteDuty(String selectedDuty , String selectedEvent, String membershipId){
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
            Statement statement = conn.createStatement();
            statement.execute("DELETE FROM Duty_Sign_In WHERE Membership_ID = '"+membershipId+"' AND Event_ID = '"+selectedEvent+"' AND Duty_Name = '"+selectedDuty+"'");
        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
        }
    }

    /*public static void updateDuty(String selectedDuty , String selectedEvent, String membershipId, String dutyId){
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
            Statement statement = conn.createStatement();
            statement.execute("UPDATE Events SET Membership_ID = '"+ membershipId + "', Event_ID = '" + selectedEvent+ "', Duty_Name = '"+ selectedDuty+"' WHERE Duty_ID = '" + dutyId +"'");
        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
        }
    }
*/
    public static void addRacer(String fullName, String selectedEvent, String Class, String sailNumber){
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8")){
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO Race_Sign_In (Full_Name, Event_ID, Class, Sail_Number) Values('"+fullName+"','"+selectedEvent+"','"+Class+"','"+sailNumber+"')");
        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
        }
    }
    
}