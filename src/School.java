import java.util.*;
public class School
{
    static Scanner sc=new Scanner(System.in);
    int a[]={1,2,3,4,5,6,7,8,9,10};
    String b[]={"Arjun Mehta","Bhavna Agarwal","Dhirendra Gogoi","Debasmita Borah","Jyotismoye Deka","Keshabh Agarwal","Mintu Borah","Nisha Boruah","Seema Jain","Sunil Borah"};
    String c[]={"Nisha Mehta","Seema Agarwal","Neema Gogoi","Nirma Borah","Emon Deka","Bharti Agarwal","Monti Borah","Sangita Boruah","Sneha Jain","Manali Borah"};
    String d[]={"Rajiv Mehta","Sunil Agarwal","Raktim Gogoi","Sumon Borah","Mintu Kumar Deka","Sanjiv Agarwal","Ojha Borah","Dhiren Boruah","Niresh Jain","Ashok Borah"};
    int e[]={12304,25374,67823,54732,86238,27829,71826,74692,23864,87354};
    int f=10;
    char ch='A';
    static int c1,c2,c4,c3,c5,c6,c7,r;
    public School()
    {
        c1=0;
        c2=0;
        c3=0;
        c4=0;
        c5=0;
        c6=0;
        c7=0;
        r=0;
    }
    public void appinfo()
    {
            System.out.println("\t THIS APPLICATION IS MADE BY BJ LTD");
            System.out.println();
            System.out.println("Frist released on : 1st of Jannuary , 2020");
            System.out.println();
            System.out.println("Frist update on  : 4th of September , 2020");
    }
    public void entertherollno()
    {
        rock:for(;;)
        {
        System.out.println("\t Enter the Roll Number of your Child");
             r=sc.nextInt();
               if(r==1 || r==2 || r==3 || r==4 || r==5 || r==6 || r==7 || r==8 || r==9 || r==10)
               {
               for(int i=1;i<=10;i++)
               {
                    if(r==i)
                    {
                        System.out.println();
                        System.out.println("NAME : "+b[i-1]);
                        System.out.println("SCHOOL : CARMEL SCHOOL - JORHAT");
                        System.out.println("CLASS : "+f);
                        System.out.println("SECTION : "+ch);
                        System.out.println("ROLL NUMBER : "+a[i-1]);
                        System.out.println("MOTHER'S NAME : "+c[i-1]);
                        System.out.println("FATHER'S NAME : "+d[i-1]);
                        System.out.println("ADMISSION NUMBER : "+e[i-1]);
                        System.out.println();
                        break rock;
                    }
                }
            }
            else
            {
                System.out.println();
                System.out.println("The entered choice is wrong");
                System.out.println();
                System.out.println("Please enter the choic again");
                System.out.println();
            }
        }
    }
    public void noticeboard()
    {
                            System.out.println("\t WELCOME TO THE NOTICE BOARD");
                            System.out.println();
                            System.out.println("Note : Notices will have time limit and the time limit will be displayed below .");
                            System.out.println("\t So , the students and the parents are requested to see the NOTICE BOAD .");
                            System.out.println("\t Notice Board daily . THANK YOU .");
                            System.out.println();
                            System.out.println("\t NOTICE :");
                            System.out.println();
                            System.out.println("\tThe second installment of fees have been started . \nKindly pay the fees within the following days . \nPlease pay the fees between 1st of September and 16th of September . \nYou are requested to pay the fees online because to \nprevent the spread of COVID-19(CORONA VIRUS) . Also , follow the \nprotocols as instructed by the bank . Stay Safe Stay Home .");
                            System.out.println();
                            System.out.println("\t \t THANK YOU");
                            System.out.println();
                            System.out.println("TIME LIMIT : 16/9/2020");
                            System.out.println();
    }
    public void feepayment()
    {
        if(r==1)
        {
            System.out.println();
            System.out.println("The last payment of fees was done 4 months ago.");
            System.out.println("Date : 14th of May,2020");
            System.out.println("\n If you did not paid the fees of the first installment , then an amount of Rs.50 will be charged \nfrom you as instructed by the school authority . Also , check the NOTICE BOARD for more information . You \nare requested to pay the fees online , as it will be safer than to pay the fees offline , it is \nsuggested to prevent the spread of COVID-19(CORONA VIRUS) . Also , please follow the COVID-19 protocol as \ninstructed by the bank . Stay Home Stay Safe .");
            System.out.println("\t \t THANK YOU");
            System.out.println();
        }
        if(r==2)
        {
            System.out.println();
            System.out.println("The last payment of fees was done 4 months ago.");
            System.out.println("Date : 22nd of May,2020");
            System.out.println("\n If you did not paid the fees of the first installment , then an amount of Rs.50 will be charged \nfrom you as instructed by the school authority . Also , check the NOTICE BOARD for more information . You \nare requested to pay the fees online , as it will be safer than to pay the fees offline , it is \nsuggested to prevent the spread of COVID-19(CORONA VIRUS) . Also , please follow the COVID-19 protocol as \ninstructed by the bank . Stay Home Stay Safe .");
            System.out.println("\t \t THANK YOU");
            System.out.println();
        }
        if(r==3)
        {
            System.out.println();
            System.out.println("The last payment of fees was done this month.");
            System.out.println("Date : 1st of September,2020");
            System.out.println("\n If you did not paid the fees of the first installment , then an amount of Rs.50 will be charged \nfrom you as instructed by the school authority . Also , check the NOTICE BOARD for more information . You \nare requested to pay the fees online , as it will be safer than to pay the fees offline , it is \nsuggested to prevent the spread of COVID-19(CORONA VIRUS) . Also , please follow the COVID-19 protocol as \ninstructed by the bank . Stay Home Stay Safe .");
            System.out.println("\t \t THANK YOU");
            System.out.println();
        }
        if(r==4)
        {
            System.out.println();
            System.out.println("The last payment of fees was done 4 months ago.");
            System.out.println("Date : 21st of May,2020");
            System.out.println("\n If you did not paid the fees of the first installment , then an amount of Rs.50 will be charged \nfrom you as instructed by the school authority . Also , check the NOTICE BOARD for more information . You \nare requested to pay the fees online , as it will be safer than to pay the fees offline , it is \nsuggested to prevent the spread of COVID-19(CORONA VIRUS) . Also , please follow the COVID-19 protocol as \ninstructed by the bank . Stay Home Stay Safe .");
            System.out.println("\t \t THANK YOU");
            System.out.println();
        }
        if(r==5)
        {
            System.out.println();
            System.out.println("The last payment of fees was done 4 months ago.");
            System.out.println("Date : 16th of May,2020");
            System.out.println("\n If you did not paid the fees of the first installment , then an amount of Rs.50 will be charged \nfrom you as instructed by the school authority . Also , check the NOTICE BOARD for more information . You \nare requested to pay the fees online , as it will be safer than to pay the fees offline , it is \nsuggested to prevent the spread of COVID-19(CORONA VIRUS) . Also , please follow the COVID-19 protocol as \ninstructed by the bank . Stay Home Stay Safe .");
            System.out.println("\t \t THANK YOU");
            System.out.println();
        }
        if(r==6)
        {
            System.out.println();
            System.out.println("The last payment of fees was done this month.");
            System.out.println("Date : 1st of September,2020");
            System.out.println("\n If you did not paid the fees of the first installment , then an amount of Rs.50 will be charged \nfrom you as instructed by the school authority . Also , check the NOTICE BOARD for more information . You \nare requested to pay the fees online , as it will be safer than to pay the fees offline , it is \nsuggested to prevent the spread of COVID-19(CORONA VIRUS) . Also , please follow the COVID-19 protocol as \ninstructed by the bank . Stay Home Stay Safe .");
            System.out.println("\t \t THANK YOU");
            System.out.println();
        }
        if(r==7)
        {
            System.out.println();
            System.out.println("The last payment of fees was done this month.");
            System.out.println("Date : 2nd of September,2020");
            System.out.println("\n If you did not paid the fees of the first installment , then an amount of Rs.50 will be charged \nfrom you as instructed by the school authority . Also , check the NOTICE BOARD for more information . You \nare requested to pay the fees online , as it will be safer than to pay the fees offline , it is \nsuggested to prevent the spread of COVID-19(CORONA VIRUS) . Also , please follow the COVID-19 protocol as \ninstructed by the bank . Stay Home Stay Safe .");
            System.out.println("\t \t THANK YOU");
            System.out.println();
        }
        if(r==8)
        {
            System.out.println();
            System.out.println("The last payment of fees was done 4 months ago.");
            System.out.println("Date : 20th of May,2020");
            System.out.println("\n If you did not paid the fees of the first installment , then an amount of Rs.50 will be charged \nfrom you as instructed by the school authority . Also , check the NOTICE BOARD for more information . You \nare requested to pay the fees online , as it will be safer than to pay the fees offline , it is \nsuggested to prevent the spread of COVID-19(CORONA VIRUS) . Also , please follow the COVID-19 protocol as \ninstructed by the bank . Stay Home Stay Safe .");
            System.out.println("\t \t THANK YOU");
            System.out.println();
        }
        if(r==9)
        {
            System.out.println();
            System.out.println("The last payment of fees was done 4 months ago.");
            System.out.println("Date : 23rd of May,2020");
            System.out.println("\n If you did not paid the fees of the first installment , then an amount of Rs.50 will be charged \nfrom you as instructed by the school authority . Also , check the NOTICE BOARD for more information . You \nare requested to pay the fees online , as it will be safer than to pay the fees offline , it is \nsuggested to prevent the spread of COVID-19(CORONA VIRUS) . Also , please follow the COVID-19 protocol as \ninstructed by the bank . Stay Home Stay Safe .");
            System.out.println("\t \t THANK YOU");
            System.out.println();
        }
        if(r==10)
        {
            System.out.println();
            System.out.println("The last payment of fees was done this month.");
            System.out.println("Date : 4th of September,2020");
            System.out.println("\n If you did not paid the fees of the first installment , then an amount of Rs.50 will be charged \nfrom you as instructed by the school authority . Also , check the NOTICE BOARD for more information . You \nare requested to pay the fees online , as it will be safer than to pay the fees offline , it is \nsuggested to prevent the spread of COVID-19(CORONA VIRUS) . Also , please follow the COVID-19 protocol as \ninstructed by the bank . Stay Home Stay Safe .");
            System.out.println("\t \t THANK YOU");
            System.out.println();
        }
    }
    public void test()
    {
         System.out.println();
                    System.out.println("No test available at the moment");
                    System.out.println();
                    System.out.println("Please check the NOTICE BOARD for any upcoming test");
                    System.out.println();
                    System.out.println("\t \t THANK YOU");
                    System.out.println();
    }
    public void marks()
    {
        int phy[]={21,34,33,40,23,34,35,37,35,11};
        int chem[]={40,32,35,36,35,40,34,21,23,10};
        int bio[]={34,23,28,37,34,24,35,16,11,12};
        int his[]={23,34,26,37,29,10,30,40,26,27};
        int eng[]={35,40,36,12,23,26,27,40,38,13};
        int en[]={24,23,30,20,20,39,32,34,23,32};
        int comp[]={13,24,23,26,29,34,};
        int eco[]={23,34,12,34};
        int hin[]={39,23,24,26};
        int ass[]={23,22,34,12,22,33};
        int geo[]={23,32,34,33,40,34,23,23,32,23};
        int math[]={23,33,34,40,23,34,25,35,45,34};
        System.out.println();
                if(r==1)
                {
                    System.out.println("English Literature : "+eng[0]);
                    System.out.println("English Language : "+en[0]);
                    System.out.println("Mathematics : "+math[0]);
                    System.out.println("Biology : "+bio[0]);
                    System.out.println("Physics : "+phy[0]);
                    System.out.println("Chemistry : "+chem[0]);
                    System.out.println("Geography : "+geo[0]);
                    System.out.println("History and Civics : "+his[0]);
                    System.out.println("Hindi : "+hin[0]);
                    System.out.println("Computer : "+comp[0]);
                }
                if(r==2)
                {
                    System.out.println("English Literature : "+eng[1]);
                    System.out.println("English Language : "+en[1]);
                    System.out.println("Mathematics : "+math[1]);
                    System.out.println("Biology : "+bio[1]);
                    System.out.println("Physics : "+phy[1]);
                    System.out.println("Chemistry : "+chem[1]);
                    System.out.println("Geography : "+geo[1]);
                    System.out.println("History and Civics : "+his[1]);
                    System.out.println("Hindi : "+hin[1]);
                    System.out.println("Computer : "+comp[1]);
                }
                if(r==3)
                {
                    System.out.println("English Literature : "+eng[2]);
                    System.out.println("English Language : "+en[2]);
                    System.out.println("Mathematics : "+math[2]);
                    System.out.println("Biology : "+bio[2]);
                    System.out.println("Physics : "+phy[2]);
                    System.out.println("Chemistry : "+chem[2]);
                    System.out.println("Geography : "+geo[2]);
                    System.out.println("History and Civics : "+his[2]);
                    System.out.println("Assamese : "+ass[0]);
                    System.out.println("Economics : "+eco[0]);
                }
                if(r==4)
                {
                    System.out.println("English Literature : "+eng[3]);
                    System.out.println("English Language : "+en[3]);
                    System.out.println("Mathematics : "+math[3]);
                    System.out.println("Biology : "+bio[3]);
                    System.out.println("Physics : "+phy[3]);
                    System.out.println("Chemistry : "+chem[3]);
                    System.out.println("Geography : "+geo[3]);
                    System.out.println("History and Civics : "+his[3]);
                    System.out.println("Assamese : "+ass[1]);
                    System.out.println("Computer : "+comp[2]);
                }
                if(r==5)
                {
                    System.out.println("English Literature : "+eng[4]);
                    System.out.println("English Language : "+en[4]);
                    System.out.println("Mathematics : "+math[4]);
                    System.out.println("Biology : "+bio[4]);
                    System.out.println("Physics : "+phy[4]);
                    System.out.println("Chemistry : "+chem[4]);
                    System.out.println("Geography : "+geo[4]);
                    System.out.println("History and Civics : "+his[4]);
                    System.out.println("Assamese : "+ass[2]);
                    System.out.println("Economics : "+eco[1]);
                }
                if(r==6)
                {
                    System.out.println("English Literature : "+eng[5]);
                    System.out.println("English Language : "+en[5]);
                    System.out.println("Mathematics : "+math[5]);
                    System.out.println("Biology : "+bio[5]);
                    System.out.println("Physics : "+phy[5]);
                    System.out.println("Chemistry : "+chem[5]);
                    System.out.println("Geography : "+geo[5]);
                    System.out.println("History and Civics : "+his[5]);
                    System.out.println("Hindi : "+hin[2]);
                    System.out.println("Economics : "+eco[2]);
                }
                if(r==7)
                {
                    System.out.println("English Literature : "+eng[6]);
                    System.out.println("English Language : "+en[6]);
                    System.out.println("Mathematics : "+math[6]);
                    System.out.println("Biology : "+bio[6]);
                    System.out.println("Physics : "+phy[6]);
                    System.out.println("Chemistry : "+chem[6]);
                    System.out.println("Geography : "+geo[6]);
                    System.out.println("History and Civics : "+his[6]);
                    System.out.println("Assamese : "+ass[3]);
                    System.out.println("Computer : "+comp[3]);
                }
                if(r==8)
                {
                    System.out.println("English Literature : "+eng[7]);
                    System.out.println("English Language : "+en[7]);
                    System.out.println("Mathematics : "+math[7]);
                    System.out.println("Biology : "+bio[7]);
                    System.out.println("Physics : "+phy[7]);
                    System.out.println("Chemistry : "+chem[7]);
                    System.out.println("Geography : "+geo[7]);
                    System.out.println("History and Civics : "+his[7]);
                    System.out.println("Assamese : "+ass[4]);
                    System.out.println("Computer : "+comp[4]);
                }
                if(r==9)
                {
                    System.out.println("English Literature : "+eng[8]);
                    System.out.println("English Language : "+en[8]);
                    System.out.println("Mathematics : "+math[8]);
                    System.out.println("Biology : "+bio[8]);
                    System.out.println("Physics : "+phy[8]);
                    System.out.println("Chemistry : "+chem[8]);
                    System.out.println("Geography : "+geo[8]);
                    System.out.println("History and Civics : "+his[8]);
                    System.out.println("Hindi : "+hin[3]);
                    System.out.println("Computer : "+comp[5]);
                }
                if(r==10)
                {
                    System.out.println("English Literature : "+eng[9]);
                    System.out.println("English Language : "+en[9]);
                    System.out.println("Mathematics : "+math[9]);
                    System.out.println("Biology : "+bio[9]);
                    System.out.println("Physics : "+phy[9]);
                    System.out.println("Chemistry : "+chem[9]);
                    System.out.println("Geography : "+geo[9]);
                    System.out.println("History and Civics : "+his[9]);
                    System.out.println("Assamese : "+ass[5]);
                    System.out.println("Economics : "+eco[3]);
                }
    }
    public void creatorinfo()
    {
            System.out.println("\t THIS APPLICATION IS MADE BY BJ LTD");
            System.out.println();
            System.out.println("Frist released on : 1st of January,2020");
            System.out.println();
            System.out.println("Frist update on : 4th of September,2020");
    }
    public void timetable()
    {
        System.out.println();
        System.out.println("\t \t THE TIME TABLE FOR CLASS X (A)");
        System.out.println();
        System.out.println("Monday :    |||Geography          | Chemistry      | Economics/Computer | Mathematics ||BREAK TIME|| Physics            | English   | Hindi/Assamese     | Games          |||");
        System.out.println("Tuesday :   |||Geography          | Hindi/Assamese | History and civics | English     ||BREAK TIME|| Economics/Computer | Biology   | Mathematics        | SUPW           |||");
        System.out.println("Wednesday : |||P.T.               | Physics        | Library            | Mathematics ||BREAK TIME|| Biology            | English   | Economics/Computer | Hindi/Assamese |||");
        System.out.println("Thursday :  |||History and civics | Biology        | Hindi/Assamese     | Mathematics ||BREAK TIME|| Chemistry          | V.E.D.    | Mathematics        | English        |||");
        System.out.println("Friday :    |||Geography          | Hindi/Assamese | English            | Mathematics ||BREAK TIME|| V.E.D.             | Chemistry | Physics            | History        |||");
    }
    public static void main(String args[])
    {
        School ob=new School();
        System.out.println();
        System.out.println("\t WELCOME TO THE SCHOOL APP");
        System.out.println();
        System.out.println("CARMEL SCHOOL - JORHAT");
        System.out.println();
        see:for(;;)
        {
        System.out.println("\t Enter the choice \n 1. To enter the roll number of your child to see his/her profile \n 2. To see the creator's info \n 3. To exit the app");
        c1=sc.nextInt();
        System.out.println();
            if(c1==1)
            {
                ob.entertherollno();
                label:for(;;)
                {
                System.out.println("\t Enter the choice \n 1. Fee payment \n 2. To see the result of your Child \n 3. To see the Notice Board \n 4. To see the Time Table \n 5. To take online test \n 6. To return to the previous menu \n 7. To exit the app");
                c2=sc.nextInt();
                if(c2==1)
                {
                    ob.feepayment();
                    System.out.println();
                    rudriger:for(;;)
                    {
                         System.out.println("\tEnter the choice \n 1. To return to the previous menu \n 2. To exit the app");
                         c4=sc.nextInt();
                          if(c4==1)
                        {
                            System.out.println();
                            continue label;
                        }
                        else if(c4==2)
                        {
                            System.out.println();
                System.out.println("\t Thank you for choosing THE SCHOOL APP - We think the betterment of every child");
                System.out.println();
                           System.exit(0); 
                        }
                        else
                        {
                             System.out.println("Entered a wrong choice");
                        System.out.println();
                        System.out.println("Enter the choice again");
                        System.out.println();
                        continue rudriger;
                        }
                    }
                }
                if(c2==2)
                {
                    ob.marks();
                    System.out.println();
                    lindelof:for(;;)
                    {
                        System.out.println("\t Enter the choice \n 1. To return to the previous menu \n 2. To exit the app");
                        c6=sc.nextInt();
                        if(c6==1)
                        {
                            System.out.println();
                            continue label;
                        }
                        else if(c6==2)
                        {
                            System.out.println();
                System.out.println("\t Thank you for choosing THE SCHOOL APP - We think the betterment of every child");
                System.out.println();
                           System.exit(0); 
                        }
                        else
                        {
                             System.out.println("Entered a wrong choice");
                        System.out.println();
                        System.out.println("Enter the choice again");
                        System.out.println();
                        continue lindelof;
                        }
                    }
                }
                if(c2==3)
                {
                    ob.noticeboard();
                    System.out.println();
                    sokratis:for(;;)
                    {
                        System.out.println("\t Enter the choice \n 1. To retuen to the previous menu \n 2. To exit the app");
                        c5=sc.nextInt();
                        if(c5==1)
                        {
                            System.out.println();
                            continue label;
                        }
                        else if(c5==2)
                        {
                            System.out.println();
                System.out.println("\t Thank you for choosing THE SCHOOL APP - We think the betterment of every child");
                System.out.println();
                            System.exit(0);
                        }
                        else
                        {
                            System.out.println("Entered a wrong choice");
                        System.out.println();
                        System.out.println("Enter the choice again");
                        System.out.println();
                        continue sokratis;
                    }  
                        
                    }
                }
                if(c2==4)
                {
                    ob.timetable();
                    System.out.println();
                mass:for(;;)
                {
                    System.out.println("\t Enter the choice \n 1. To return to the previous menu \n 2. To exit the app");
                    c3=sc.nextInt();
                    if(c3==1)
                    {
                        System.out.println();
                        continue label;
                    }
                    else if(c3==2)
                    {
                        System.out.println();
                System.out.println("\t Thank you for choosing THE SCHOOL APP - We think the betterment of every child");
                System.out.println();
                        System.exit(0);
                    }
                    else
                    {
                        System.out.println();
                        System.out.println("Entered a wrong choice");
                        System.out.println();
                        System.out.println("Enter the choice again");
                        System.out.println();
                        continue mass;
                    }
                }
                }
                else if(c2==6)
                {
                    System.out.println();
                    continue see;
                }
                else if(c2==7)
                {
                    System.out.println();
                System.out.println("\t Thank you for choosing THE SCHOOL APP - We think the betterment of every child");
                System.out.println();
                    System.exit(0);
                }
                else if(c2==5)
                {
                    ob.test();
                    System.out.println();
                    same:for(;;)
                    {
                        System.out.println("\t Enter the choice \n 1. To return to the previous menu \n 2. To exit the app");
                        int fg=sc.nextInt();
                        if(fg==1)
                        {
                            System.out.println();
                            continue label;
                        }
                        else if(fg==2)
                        {
                            System.out.println();
                System.out.println("\t Thank you for choosing THE SCHOOL APP - We think the betterment of every child");
                System.out.println();
                            System.exit(0);
                        }
                        else
                        {
                            System.out.println();
                            System.out.println("Entered choice is wrong");
                            System.out.println();
                            System.out.println("PLease enter the choice");
                            System.out.println();
                            continue same;
                        }
                    }
                }
                else
                {
                    System.out.println();
                    System.out.println("Entered a wrong choice");
                    System.out.println();
                                        System.out.println("Please enter the choice again");
                    System.out.println();
                }
                
            }
            }
            else if(c1==2)
            {

                ob.creatorinfo();
                System.out.println();
                back:for(;;)
                {
                System.out.println("\t Enter the choice \n 1. To return to the previous menu \n 2. To exit the app");
                c7=sc.nextInt();
                 if(c7==1)
                        {
                            System.out.println();
                            continue see;
                        }
                        else if(c7==2)
                        {
                            System.out.println();
                System.out.println("\t Thank you for choosing THE SCHOOL APP - We think the betterment of every child");
                System.out.println();
                           System.exit(0); 
                        }
                        else
                        {
                            System.out.println();
                             System.out.println("Entered a wrong choice");
                        System.out.println();
                        System.out.println("Enter the choice again");
                        System.out.println();
                        continue back;
                        }
                    }
            }
            else if(c1==3)
            {
                System.out.println();
                System.out.println("\t Thank you for choosing THE SCHOOL APP - We think the betterment of every child");
                System.out.println();
                System.exit(0);
            }
            else
            {
                System.out.println();
                System.out.println("Entered a wrong choice ");
                System.out.println();
                System.out.println("Enter the choice again");
                System.out.println();
            }
        }
    }
}