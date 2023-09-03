package com;

class FileManagerService {
    private FileManager fileManager;

    public FileManagerService(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void retrieveFileNamesAscending() {
        fileManager.retrieveFileNamesAscending();
    }

    public void addUserFile(String fileName) {
        fileManager.addUserFile(fileName);
    }

    public void deleteUserFile(String fileName) {
        fileManager.deleteUserFile(fileName);
    }

    public void searchUserFile(String fileName) {
        fileManager.searchUserFile(fileName);
    }
}



