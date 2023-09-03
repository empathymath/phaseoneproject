package com;
import java.util.*;

class FileManager {
    private List<String> fileNames;

    public FileManager() {
        this.fileNames = new ArrayList<>();
    }

    // Generic method to retrieve file names in ascending order
    public void retrieveFileNamesAscending() {
        Collections.sort(fileNames);
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }

    // Add a user-specified file
    public void addUserFile(String fileName) {
        fileNames.add(fileName);
        System.out.println("File '" + fileName + "' added successfully.");
    }

    // Delete a user-specified file
    public void deleteUserFile(String fileName) {
        if (fileNames.remove(fileName)) {
            System.out.println("File '" + fileName + "' deleted successfully.");
        } else {
            System.out.println("File '" + fileName + "' not found.");
        }
    }

    // Search for a user-specified file
    public void searchUserFile(String fileName) {
        if (fileNames.contains(fileName)) {
            System.out.println("File '" + fileName + "' found.");
        } else {
            System.out.println("File '" + fileName + "' not found.");
        }
    }
}

public class FileManagerApp {
    private static FileManagerService service;

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager();
        setService(new FileManagerService(fileManager));
        
        System.out.println("Welcome to LockedMe");
        System.out.println("Developed by Basou Efstathia");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Retrieve File Names (Ascending Order)");
            System.out.println("2. Add a File");
            System.out.println("3. Delete a File");
            System.out.println("4. Search for a File");
            System.out.println("5. Close Current Context");
            System.out.println("6. Close Application");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    fileManager.retrieveFileNamesAscending();
                    break;
                case 2:
                    System.out.print("Enter the file name to add: ");
                    String addFileName = scanner.nextLine();
                    fileManager.addUserFile(addFileName);
                    break;
                case 3:
                    System.out.print("Enter the file name to delete: ");
                    String deleteFileName = scanner.nextLine();
                    fileManager.deleteUserFile(deleteFileName);
                    break;
                case 4:
                    System.out.print("Enter the file name to search: ");
                    String searchFileName = scanner.nextLine();
                    fileManager.searchUserFile(searchFileName);
                    break;
                case 5:
                    // Option to close the current execution context (placeholder)
                    System.out.println("Closing current context.");
                    break;
                case 6:
                    System.out.println("Closing the application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

	public static FileManagerService getService() {
		return service;
	}

	public static void setService(FileManagerService service) {
		FileManagerApp.service = service;
	}
}
