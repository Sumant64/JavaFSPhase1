package myPackage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MyLock {
	public static void main(String args[]) {
		
	}
	
	/**
     * Declation of static variables which will be used multiple times
     */
    static final String projectPath="C:\\Users\\NAWAL KISHOR\\Desktop\\MyProject\\Files";
    static final String errorMessage="Some error occured. Please contact LockedMe@admin";
    
    /**
     * It will generate the menu of options available for the user to choose from.
     */
    public static void menu(){
        System.out.println("===============================================================");
        System.out.println("\t\tWelcome to Company Lockers Pvt. Ltd");
        System.out.println("\t\tDeveloper details:- Sumant Shah");
        System.out.println("===============================================================");
        System.out.println("\t\tEnter the options you want to perform");
        System.out.println("\t\t1. Display the files\n\t\t2. Add File to the directory\n\t\t3. Delete File from the directory\n\t\t4. Search File in the directory\n\t\t5. Exit");
    }

    /**
     * It will display the files present in the directory.
     */
    public static void display(){
        File dir=new File(projectPath);
        String file[]=dir.list();

        if(file==null)
            System.out.println("File is not present in the directory");
        else{
            for(var l:file){
                System.out.println(l);
            }
        }
    }

	
}
