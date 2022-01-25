package myPackage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MyLock {
	public static void main(String args[]) {
		 Scanner sc=new Scanner(System.in);
	       int n;
	       do{ 
	       menu();
	       System.out.println("Enter the option");
	       n=sc.nextInt();
	       
	       switch(n){
           case 1: display();
           break;
           case 2: System.out.println("\t\tEnter the operation to perform.\n\t\t1. Add File\n\t\t2. Delete File\n\t\t3. Search File");
                   int op=sc.nextInt();
                   switch(op){
                       case 1: addFile();
                       break;
                       case 2: deleteFile();
                       break;
                       case 3: searchFile();
                       break;
                       default: System.out.println("Invalid Input");
                       break;
                   }
                   continue;
           case 3: System.exit(0);
           break;
           default: System.out.println("Invalid Input");
           break;
	        }
	    }while(n>0);
	    sc.close();
	}
	
	/**
     * Declaration of static variables which will be used multiple times
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
        System.out.println("\t\t1. Display the files\n\t\t2. Perform Operation (Add, Delete, Search)\n\t\t3. Exit");
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

    /**
     * It will add the file in the present directory.
     */
    public static void addFile(){
    
        try{
            Scanner obj=new Scanner(System.in);
            System.out.println("Enter the file name");
            String add=obj.nextLine();
            File myObj = new File(projectPath+"\\"+add+".txt");
            myObj.createNewFile();
            
            System.out.println("Enter number of line to write");
            int l=obj.nextInt();
            obj.nextLine();
            String line=obj.nextLine();
            for(int i=1;i<=l;i++){
                FileWriter fw=new  FileWriter(myObj, true);
                System.out.println("Enter line");
                line=obj.nextLine();
                fw.write(line+ "\n");
                fw.close();
            }
            
        }
        catch(Exception ex){
            System.out.println(errorMessage);
        }
    }
    
    /**
     * It will delete the file present in the directory
     */
    public static void deleteFile(){
        try{
            Scanner obj=new Scanner(System.in);
            System.out.println("Enter the file to delete");
            String delnam=obj.nextLine();
            File dir=new File(projectPath+"\\"+delnam+".txt");
            
            if(dir.delete())
                System.out.println("File got deleted");
            else
                System.out.println("Filed to delete the file");
            
        }
        catch(Exception ex){
            System.out.println(errorMessage);
        }
    }
    
    /**
     * It will search for the file in the directory.
     */
    public static void searchFile(){
        try{
            Scanner obj=new Scanner(System.in);
            System.out.println("Enter the filename to search");
            String name=obj.nextLine();
            File dir=new File(projectPath);
            String file[]=dir.list();
            int pos=0;

            if(file==null)
                System.out.println("File is not present in the directory");
            else{
                for (int i = 0; i < file.length; i++) {
                    String filename = file[i];
                    if (filename.equalsIgnoreCase(name+".txt")) {
                        System.out.println(filename + " found");
                        pos = 1;
                    }
                }

                }
            if (pos == 0) {
                System.out.println("File Not Found");
            }
           
        }
        catch(Exception ex){
            System.out.println(errorMessage);
        }
    }
}
