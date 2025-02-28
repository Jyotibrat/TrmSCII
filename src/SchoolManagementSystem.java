import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.stream.*;

/**
 * Enhanced School Management System
 * A modernized version of the original School application with improved architecture,
 * additional features, and better user experience.
 */
public class SchoolManagementSystem {
    // Database classes
    static class Student {
        private int rollNumber;
        private String name;
        private String motherName;
        private String fatherName;
        private int admissionNumber;
        private Map<String, Integer> marks;
        private List<FeePayment> feePayments;
        
        public Student(int rollNumber, String name, String motherName, String fatherName, int admissionNumber) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.motherName = motherName;
            this.fatherName = fatherName;
            this.admissionNumber = admissionNumber;
            this.marks = new HashMap<>();
            this.feePayments = new ArrayList<>();
        }
        
        // Getters and setters
        public int getRollNumber() { return rollNumber; }
        public String getName() { return name; }
        public String getMotherName() { return motherName; }
        public String getFatherName() { return fatherName; }
        public int getAdmissionNumber() { return admissionNumber; }
        
        public void addMarks(String subject, int mark) {
            marks.put(subject, mark);
        }
        
        public Map<String, Integer> getMarks() {
            return marks;
        }
        
        public void addFeePayment(FeePayment payment) {
            feePayments.add(payment);
        }
        
        public FeePayment getLastFeePayment() {
            if (feePayments.isEmpty()) {
                return null;
            }
            return feePayments.stream()
                .max(Comparator.comparing(FeePayment::getPaymentDate))
                .orElse(null);
        }
        
        public String displayProfile() {
            StringBuilder profile = new StringBuilder();
            profile.append("\nNAME: " + name);
            profile.append("\nSCHOOL: CARMEL SCHOOL - JORHAT");
            profile.append("\nCLASS: 10");
            profile.append("\nSECTION: A");
            profile.append("\nROLL NUMBER: " + rollNumber);
            profile.append("\nMOTHER'S NAME: " + motherName);
            profile.append("\nFATHER'S NAME: " + fatherName);
            profile.append("\nADMISSION NUMBER: " + admissionNumber);
            return profile.toString();
        }
    }
    
    static class FeePayment {
        private double amount;
        private LocalDate paymentDate;
        private String paymentMethod;
        private String receiptNumber;
        
        public FeePayment(double amount, LocalDate paymentDate, String paymentMethod, String receiptNumber) {
            this.amount = amount;
            this.paymentDate = paymentDate;
            this.paymentMethod = paymentMethod;
            this.receiptNumber = receiptNumber;
        }
        
        public double getAmount() { return amount; }
        public LocalDate getPaymentDate() { return paymentDate; }
        public String getPaymentMethod() { return paymentMethod; }
        public String getReceiptNumber() { return receiptNumber; }
        
        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            return String.format("Payment of Rs. %.2f made on %s via %s (Receipt: %s)", 
                    amount, paymentDate.format(formatter), paymentMethod, receiptNumber);
        }
    }
    
    static class Notice {
        private String title;
        private String content;
        private LocalDate postDate;
        private LocalDate expiryDate;
        
        public Notice(String title, String content, LocalDate postDate, LocalDate expiryDate) {
            this.title = title;
            this.content = content;
            this.postDate = postDate;
            this.expiryDate = expiryDate;
        }
        
        public String getTitle() { return title; }
        public String getContent() { return content; }
        public LocalDate getPostDate() { return postDate; }
        public LocalDate getExpiryDate() { return expiryDate; }
        
        public boolean isActive() {
            return LocalDate.now().isBefore(expiryDate) || LocalDate.now().isEqual(expiryDate);
        }
        
        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            StringBuilder sb = new StringBuilder();
            sb.append("\n-----------------------------------------\n");
            sb.append("TITLE: " + title + "\n");
            sb.append("POSTED: " + postDate.format(formatter) + "\n");
            sb.append("EXPIRES: " + expiryDate.format(formatter) + "\n\n");
            sb.append(content);
            sb.append("\n-----------------------------------------\n");
            return sb.toString();
        }
    }
    
    static class Test {
        private String subject;
        private String description;
        private LocalDate testDate;
        private String syllabus;
        private int maxMarks;
        
        public Test(String subject, String description, LocalDate testDate, String syllabus, int maxMarks) {
            this.subject = subject;
            this.description = description;
            this.testDate = testDate;
            this.syllabus = syllabus;
            this.maxMarks = maxMarks;
        }
        
        public String getSubject() { return subject; }
        public String getDescription() { return description; }
        public LocalDate getTestDate() { return testDate; }
        public String getSyllabus() { return syllabus; }
        public int getMaxMarks() { return maxMarks; }
        
        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            StringBuilder sb = new StringBuilder();
            sb.append("\n-----------------------------------------\n");
            sb.append("SUBJECT: " + subject + "\n");
            sb.append("DESCRIPTION: " + description + "\n");
            sb.append("DATE: " + testDate.format(formatter) + "\n");
            sb.append("MAX MARKS: " + maxMarks + "\n");
            sb.append("SYLLABUS: " + syllabus + "\n");
            sb.append("-----------------------------------------\n");
            return sb.toString();
        }
    }
    
    // Main database
    private Map<Integer, Student> students;
    private List<Notice> notices;
    private List<Test> upcomingTests;
    private Map<String, Map<String, String>> timeTable;
    
    private static final Scanner scanner = new Scanner(System.in);
    private Student currentStudent = null;
    
    public SchoolManagementSystem() {
        this.students = new HashMap<>();
        this.notices = new ArrayList<>();
        this.upcomingTests = new ArrayList<>();
        this.timeTable = new HashMap<>();
        
        // Initialize data
        initializeData();
    }
    
    private void initializeData() {
        // Initialize students
        String[] names = {"Arjun Mehta", "Bhavna Agarwal", "Dhirendra Gogoi", "Debasmita Borah", 
                          "Jyotismoye Deka", "Keshabh Agarwal", "Mintu Borah", "Nisha Boruah", 
                          "Seema Jain", "Sunil Borah"};
        String[] mothers = {"Nisha Mehta", "Seema Agarwal", "Neema Gogoi", "Nirma Borah", 
                            "Emon Deka", "Bharti Agarwal", "Monti Borah", "Sangita Boruah", 
                            "Sneha Jain", "Manali Borah"};
        String[] fathers = {"Rajiv Mehta", "Sunil Agarwal", "Raktim Gogoi", "Sumon Borah", 
                            "Mintu Kumar Deka", "Sanjiv Agarwal", "Ojha Borah", "Dhiren Boruah", 
                            "Niresh Jain", "Ashok Borah"};
        int[] admNums = {12304, 25374, 67823, 54732, 86238, 27829, 71826, 74692, 23864, 87354};
        
        for (int i = 0; i < 10; i++) {
            Student student = new Student(i+1, names[i], mothers[i], fathers[i], admNums[i]);
            students.put(i+1, student);
            
            // Add marks for each student
            addMarksForStudent(student, i);
            
            // Add fee payments
            addFeePaymentsForStudent(student, i);
        }
        
        // Initialize notices
        notices.add(new Notice(
            "Fee Payment Reminder",
            "The second installment of fees has started. Kindly pay the fees between 1st of September and 16th of September. " +
            "You are requested to pay the fees online to prevent the spread of COVID-19. " +
            "Also, follow the protocols as instructed by the bank. Stay Safe, Stay Home.",
            LocalDate.of(2025, 2, 1),
            LocalDate.of(2025, 3, 16)
        ));
        
        notices.add(new Notice(
            "Annual Sports Meet Announcement",
            "The Annual Sports Meet will be held from March 15-20, 2025. " +
            "All students are encouraged to participate. Registration forms are available online. " +
            "Last date for registration is March 5, 2025.",
            LocalDate.of(2025, 2, 15),
            LocalDate.of(2025, 3, 5)
        ));
        
        // Initialize upcoming tests
        upcomingTests.add(new Test(
            "Mathematics",
            "Unit Test - Trigonometry and Statistics",
            LocalDate.of(2025, 3, 10),
            "Chapter 8 (Trigonometry) and Chapter 9 (Statistics) from the textbook",
            50
        ));
        
        upcomingTests.add(new Test(
            "Science",
            "Practical Examination - Physics and Chemistry",
            LocalDate.of(2025, 3, 15),
            "Physics: Ohm's Law and Resistance, Chemistry: Acid-Base Titration",
            25
        ));
        
        // Initialize time table
        initializeTimeTable();
    }
    
    private void addMarksForStudent(Student student, int index) {
        int[][] marks = {
            {35, 24, 23, 34, 40, 21}, // Student 1
            {40, 23, 33, 23, 32, 34}, // Student 2
            {36, 30, 34, 28, 35, 33}, // Student 3
            {12, 20, 40, 37, 36, 40}, // Student 4
            {23, 20, 23, 34, 35, 23}, // Student 5
            {26, 39, 34, 24, 40, 34}, // Student 6
            {27, 32, 25, 35, 34, 35}, // Student 7
            {40, 34, 35, 16, 21, 37}, // Student 8
            {38, 23, 45, 11, 23, 35}, // Student 9
            {13, 32, 34, 12, 10, 11}  // Student 10
        };
        
        String[] subjects = {"English Literature", "English Language", "Mathematics", "Biology", 
                            "Chemistry", "Physics", "Geography", "History and Civics"};
        
        // Add common subjects for all students
        for (int i = 0; i < 6; i++) {
            student.addMarks(subjects[i], marks[index][i]);
        }
        
        // Add Geography and History marks
        student.addMarks("Geography", 20 + (int)(Math.random() * 20));
        student.addMarks("History and Civics", 20 + (int)(Math.random() * 20));
        
        // Add either Hindi or Assamese and either Computer or Economics
        if (index % 2 == 0) {
            student.addMarks("Hindi", 20 + (int)(Math.random() * 20));
        } else {
            student.addMarks("Assamese", 20 + (int)(Math.random() * 20));
        }
        
        if (index % 3 == 0) {
            student.addMarks("Computer", 20 + (int)(Math.random() * 20));
        } else {
            student.addMarks("Economics", 20 + (int)(Math.random() * 20));
        }
    }
    
    private void addFeePaymentsForStudent(Student student, int index) {
        // Add a payment from last term (May 2024)
        if (index != 2 && index != 5 && index != 6 && index != 9) {
            // Students who paid in May
            int day = 14 + index;
            student.addFeePayment(new FeePayment(
                5000.00,
                LocalDate.of(2024, 5, day),
                "Online Transfer",
                "RCT" + (10000 + index)
            ));
        } else {
            // Students who paid in September
            int day = 1 + index % 4;
            student.addFeePayment(new FeePayment(
                5000.00,
                LocalDate.of(2025, 2, day),
                "Online Transfer",
                "RCT" + (20000 + index)
            ));
        }
    }
    
    private void initializeTimeTable() {
        Map<String, String> monday = new HashMap<>();
        monday.put("1", "Geography");
        monday.put("2", "Chemistry");
        monday.put("3", "Economics/Computer");
        monday.put("4", "Mathematics");
        monday.put("5", "BREAK");
        monday.put("6", "Physics");
        monday.put("7", "English");
        monday.put("8", "Hindi/Assamese");
        monday.put("9", "Games");
        
        Map<String, String> tuesday = new HashMap<>();
        tuesday.put("1", "Geography");
        tuesday.put("2", "Hindi/Assamese");
        tuesday.put("3", "History and Civics");
        tuesday.put("4", "English");
        tuesday.put("5", "BREAK");
        tuesday.put("6", "Economics/Computer");
        tuesday.put("7", "Biology");
        tuesday.put("8", "Mathematics");
        tuesday.put("9", "SUPW");
        
        // Add more days...
        timeTable.put("Monday", monday);
        timeTable.put("Tuesday", tuesday);
        // Add more days to the timetable similarly
    }
    
    // Main menu methods
    public void displayMainMenu() {
        System.out.println("\n\t WELCOME TO THE SCHOOL MANAGEMENT SYSTEM");
        System.out.println("\n\tCARMEL SCHOOL - JORHAT");
        System.out.println("\n1. Login with student roll number");
        System.out.println("2. About the application");
        System.out.println("3. Exit");
        System.out.print("\nEnter your choice: ");
    }
    
    public void displayStudentMenu() {
        System.out.println("\n\tSTUDENT PORTAL - " + currentStudent.getName());
        System.out.println("\n1. View Profile");
        System.out.println("2. View Fee Payment History");
        System.out.println("3. View Academic Performance");
        System.out.println("4. View Notice Board");
        System.out.println("5. View Time Table");
        System.out.println("6. View Upcoming Tests");
        System.out.println("7. Return to Main Menu");
        System.out.println("8. Exit");
        System.out.print("\nEnter your choice: ");
    }
    
    // Student authentication
    public boolean authenticateStudent(int rollNumber) {
        if (students.containsKey(rollNumber)) {
            currentStudent = students.get(rollNumber);
            return true;
        }
        return false;
    }
    
    // Student portal methods
    public void displayStudentProfile() {
        System.out.println(currentStudent.displayProfile());
    }
    
    public void displayFeePaymentHistory() {
        FeePayment lastPayment = currentStudent.getLastFeePayment();
        
        if (lastPayment == null) {
            System.out.println("\nNo fee payment history found.");
            return;
        }
        
        System.out.println("\n\tFEE PAYMENT HISTORY");
        System.out.println("\nLast Payment: " + lastPayment);
        
        // Calculate days since last payment
        long daysSinceLastPayment = ChronoUnit.DAYS.between(lastPayment.getPaymentDate(), LocalDate.now());
        System.out.println("Days since last payment: " + daysSinceLastPayment);
        
        // Display next payment information
        System.out.println("\nNext Payment Due:");
        System.out.println("The second installment of fees is due between September 1-16, 2025.");
        System.out.println("Amount: Rs. 5000.00");
        
        // Additional information
        System.out.println("\nNOTE: If you have not paid the fees for the current installment, an amount of Rs.50 will be charged as a late fee penalty.");
        System.out.println("Please pay online to prevent the spread of COVID-19 and follow the bank's safety protocols.");
    }
    
    public void displayAcademicPerformance() {
        System.out.println("\n\tACADEMIC PERFORMANCE - " + currentStudent.getName());
        
        Map<String, Integer> marks = currentStudent.getMarks();
        int totalMarks = 0;
        int subjects = 0;
        
        System.out.println("\nSubject-wise Performance:");
        System.out.println("---------------------------");
        
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            String subject = entry.getKey();
            int mark = entry.getValue();
            
            System.out.printf("%-20s: %d/40\n", subject, mark);
            
            totalMarks += mark;
            subjects++;
        }
        
        // Calculate performance metrics
        double averageMark = (double) totalMarks / subjects;
        double percentage = (double) totalMarks / (subjects * 40) * 100;
        
        System.out.println("\nPerformance Summary:");
        System.out.println("---------------------------");
        System.out.printf("Total Marks: %d/%d\n", totalMarks, subjects * 40);
        System.out.printf("Average Mark: %.2f/40\n", averageMark);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        
        // Display grade and comments
        String grade;
        String comments;
        
        if (percentage >= 90) {
            grade = "A+";
            comments = "Excellent performance! Keep up the outstanding work.";
        } else if (percentage >= 80) {
            grade = "A";
            comments = "Very good performance. Continue your dedication.";
        } else if (percentage >= 70) {
            grade = "B+";
            comments = "Good performance with room for improvement.";
        } else if (percentage >= 60) {
            grade = "B";
            comments = "Satisfactory performance. Work on weaker subjects.";
        } else if (percentage >= 50) {
            grade = "C";
            comments = "Average performance. Needs improvement in several areas.";
        } else if (percentage >= 40) {
            grade = "D";
            comments = "Below average performance. Requires significant improvement.";
        } else {
            grade = "F";
            comments = "Unsatisfactory performance. Immediate attention required.";
        }
        
        System.out.println("Overall Grade: " + grade);
        System.out.println("Comments: " + comments);
    }
    
    public void displayNoticeBoard() {
        System.out.println("\n\tNOTICE BOARD");
        System.out.println("\nActive Notices:");
        
        List<Notice> activeNotices = notices.stream()
            .filter(Notice::isActive)
            .collect(Collectors.toList());
            
        if (activeNotices.isEmpty()) {
            System.out.println("\nNo active notices at the moment.");
        } else {
            for (Notice notice : activeNotices) {
                System.out.println(notice);
            }
        }
    }
    
    public void displayTimeTable() {
        System.out.println("\n\tTIME TABLE - CLASS 10A");
        
        System.out.println("\nCurrent Date: " + LocalDate.now());
        String today = LocalDate.now().getDayOfWeek().toString().toLowerCase();
        today = today.substring(0, 1).toUpperCase() + today.substring(1);
        
        System.out.println("\nToday's Schedule (" + today + "):");
        Map<String, String> todaySchedule = timeTable.get(today);
        
        if (todaySchedule != null) {
            System.out.println("---------------------------");
            System.out.printf("%-5s | %-20s\n", "Period", "Subject");
            System.out.println("---------------------------");
            
            for (int i = 1; i <= 9; i++) {
                String period = String.valueOf(i);
                String subject = todaySchedule.getOrDefault(period, "N/A");
                System.out.printf("%-5s | %-20s\n", period, subject);
            }
        } else {
            System.out.println("\nNo schedule available for today.");
        }
        
        // Improved weekly schedule with better column widths
        System.out.println("\nWeekly Schedule:");
        
        // Define column widths based on the longest content in each column
        // Ensure each column is wide enough for its longest possible content
        int dayWidth = 10;
        int[] periodWidths = {20, 15, 20, 14, 8, 20, 14, 20, 14};
        // Increased Period 8 width to accommodate "Economics/Computer"
        
        // Calculate total width for the divider
        int totalWidth = dayWidth;
        for (int width : periodWidths) {
            totalWidth += width + 3; // +3 for " | "
        }
        
        // Create and print the divider
        String divider = "-".repeat(totalWidth);
        System.out.println(divider);
        
        // Print header
        System.out.printf("%-" + dayWidth + "s", "DAY");
        for (int i = 0; i < 9; i++) {
            System.out.printf(" | %-" + periodWidths[i] + "s", "Period " + (i+1));
        }
        System.out.println();
        
        System.out.println(divider);
        
        // Define the weekly schedule
        String[][] weeklySchedule = {
            {"Monday", "Geography", "Chemistry", "Economics/Computer", "Mathematics", "BREAK", "Physics", "English", "Hindi/Assamese", "Games"},
            {"Tuesday", "Geography", "Hindi/Assamese", "History and Civics", "English", "BREAK", "Economics/Computer", "Biology", "Mathematics", "SUPW"},
            {"Wednesday", "P.T.", "Physics", "Library", "Mathematics", "BREAK", "Biology", "English", "Economics/Computer", "Hindi/Assamese"},
            {"Thursday", "History and Civics", "Biology", "Hindi/Assamese", "Mathematics", "BREAK", "Chemistry", "V.E.D.", "Mathematics", "English"},
            {"Friday", "Geography", "Hindi/Assamese", "English", "Mathematics", "BREAK", "V.E.D.", "Chemistry", "Physics", "History"}
        };
        
        // Print each day's schedule
        for (String[] daySchedule : weeklySchedule) {
            System.out.printf("%-" + dayWidth + "s", daySchedule[0]);
            for (int i = 0; i < 9; i++) {
                System.out.printf(" | %-" + periodWidths[i] + "s", daySchedule[i+1]);
            }
            System.out.println();
        }
        
        System.out.println(divider);
    }
    
    public void displayUpcomingTests() {
        System.out.println("\n\tUPCOMING TESTS");
        
        if (upcomingTests.isEmpty()) {
            System.out.println("\nNo upcoming tests at the moment.");
            System.out.println("\nPlease check the Notice Board regularly for updates on examination schedules.");
        } else {
            for (Test test : upcomingTests) {
                System.out.println(test);
            }
        }
    }
    
    public void displayAboutApp() {
        System.out.println("\n\tABOUT THE APPLICATION");
        System.out.println("\nSchool Management System v2.0");
        System.out.println("Original release: January 1, 2020");
        System.out.println("First update: September 4, 2020");
        System.out.println("Latest update: February 28, 2025");
        System.out.println("\nDeveloped by: J.B. Ltd (Enhanced for SWOC 2025)");
        System.out.println("\nFeatures:");
        System.out.println("- Student Information Management");
        System.out.println("- Fee Payment Tracking");
        System.out.println("- Academic Performance Analysis");
        System.out.println("- Notice Board");
        System.out.println("- Time Table Management");
        System.out.println("- Test Schedule Tracking");
    }
    
    // Main execution method
    public void run() {
        boolean running = true;
        
        while (running) {
            displayMainMenu();
            int choice = getValidIntInput(1, 3);
            
            switch (choice) {
                case 1:
                    System.out.print("\nEnter Student Roll Number (1-10): ");
                    int rollNumber = getValidIntInput(1, 10);
                    
                    if (authenticateStudent(rollNumber)) {
                        System.out.println("\nLogin successful. Welcome, " + currentStudent.getName() + "!");
                        runStudentPortal();
                    } else {
                        System.out.println("\nInvalid roll number. Please try again.");
                    }
                    break;
                    
                case 2:
                    displayAboutApp();
                    continuePrompt();
                    break;
                    
                case 3:
                    System.out.println("\n\tThank you for using the School Management System!");
                    System.out.println("\tWe are committed to the betterment of every child.");
                    running = false;
                    break;
            }
        }
    }
    
    private void runStudentPortal() {
        boolean inStudentPortal = true;
        
        while (inStudentPortal) {
            displayStudentMenu();
            int choice = getValidIntInput(1, 8);
            
            switch (choice) {
                case 1:
                    displayStudentProfile();
                    continuePrompt();
                    break;
                    
                case 2:
                    displayFeePaymentHistory();
                    continuePrompt();
                    break;
                    
                case 3:
                    displayAcademicPerformance();
                    continuePrompt();
                    break;
                    
                case 4:
                    displayNoticeBoard();
                    continuePrompt();
                    break;
                    
                case 5:
                    displayTimeTable();
                    continuePrompt();
                    break;
                    
                case 6:
                    displayUpcomingTests();
                    continuePrompt();
                    break;
                    
                case 7:
                    inStudentPortal = false;
                    currentStudent = null;
                    System.out.println("\nLogged out successfully.");
                    break;
                    
                case 8:
                    System.out.println("\n\tThank you for using the School Management System!");
                    System.out.println("\tWe are committed to the betterment of every child.");
                    System.exit(0);
                    break;
            }
        }
    }
    
    // Utility methods
    private int getValidIntInput(int min, int max) {
        int input;
        
        while (true) {
            try {
                input = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.print("\nPlease enter a number between " + min + " and " + max + ": ");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Clear buffer
                System.out.print("\nInvalid input. Please enter a number: ");
            }
        }
    }
    
    private void continuePrompt() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
    
    // Main method
    public static void main(String[] args) {
        SchoolManagementSystem system = new SchoolManagementSystem();
        system.run();
    }
}
