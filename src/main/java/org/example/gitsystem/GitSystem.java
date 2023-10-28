package org.example.gitsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GitSystem {
    private List<String> files;
    private List<String> stagedFiles;
    private List<String> committedFiles;

    public GitSystem() {
        files = new ArrayList<>();
        stagedFiles = new ArrayList<>();
        committedFiles = new ArrayList<>();
    }

    public void displayStatus() {
        System.out.println("Modified files:");
        for (String file : files) {
            System.out.println(file);
        }

        System.out.println("\nStaged files:");
        for (String file : stagedFiles) {
            System.out.println(file);
        }

        System.out.println("\nCommitted files:");
        for (String file : committedFiles) {
            System.out.println(file);
        }
    }

    public void addFile(String file) {
        if (!files.contains(file)) {
            files.add(file);
            System.out.println("Added file: " + file);
        } else {
            System.out.println("File already exists: " + file);
        }
    }

    public void stageFile(String file) {
        if (files.contains(file)) {
            if (!stagedFiles.contains(file)) {
                stagedFiles.add(file);
                System.out.println("Staged file: " + file);
            } else {
                System.out.println("File already staged: " + file);
            }
        } else {
            System.out.println("File does not exist: " + file);
        }
    }

    public void commitChanges(String message) {
        if (!stagedFiles.isEmpty()) {
            committedFiles.addAll(stagedFiles);
            stagedFiles.clear();
            System.out.println("Changes committed with message: " + message);
        } else {
            System.out.println("No changes to commit.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GitSystem git = new GitSystem();

        System.out.println("Git System");

        while (true) {
            System.out.println("\nAvailable commands: status, add, stage, commit, exit");
            System.out.print("Enter a command: ");
            String command = scanner.nextLine();

            if (command.equals("status")) {
                git.displayStatus();
            } else if (command.equals("add")) {
                System.out.print("Enter file name: ");
                String file = scanner.nextLine();
                git.addFile(file);
            } else if (command.equals("stage")) {
                System.out.print("Enter file name: ");
                String file = scanner.nextLine();
                git.stageFile(file);
            } else if (command.equals("commit")) {
                System.out.print("Enter commit message: ");
                String message = scanner.nextLine();
                git.commitChanges(message);
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }

        System.out.println("Exiting Git System.");
    }
}

