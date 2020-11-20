/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcfs;

import java.text.ParseException; 
import java.util.*;
public class Fcfs {

    /**
     * @param args the command line arguments
     */
    
    // Function to find the waiting time for all  
    // processes  
    static void findWaitingTime(int processes[], int n, int at[],
        int bt[], int wt[]) { 
        // waiting time for first process is 0  
        wt[0] = 0; 
        int[] serv_time = new int[n];
        
        // calculating waiting time  
        for (int i = 1; i < n; i++) { 
            //Add service time for previous process
            serv_time[i]= serv_time[i-1]+bt[i-1];
            wt[i] = serv_time[i] - at[i]; 
        } 
    } 
  
    // Function to calculate turn around time  
    static void findTurnAroundTime(int processes[], int n, int at[],
            int bt[], int wt[], int tat[]) { 
        // calculating turnaround time by adding  
        // bt[i] + wt[i]  
        for (int i = 0; i < n; i++) { 
            tat[i] = bt[i] + wt[i]; 
        } 
    } 
  
    //Function to calculate average time  
    static void findavgTime(int processes[], int n, int at[], int bt[]) { 
        int wt[] = new int[n], tat[] = new int[n]; 
        int total_wt = 0, total_tat = 0; 
  
        //Function to find waiting time of all processes  
        findWaitingTime(processes, n, at, bt, wt); 
  
        //Function to find turn around time for all processes  
        findTurnAroundTime(processes, n, at, bt, wt, tat); 
  
        //Display processes along with all details  
        System.out.printf("Processes  Arrival time  Burst time  Waiting time"
                       +" Turn around time\n"); 
  
        // Calculate total waiting time and total turn  
        // around time  
        for (int i = 0; i < n; i++) { 
            total_wt = total_wt + wt[i]; 
            total_tat = total_tat + tat[i]; 
            System.out.printf("     %d    ", (i + 1)); 
            System.out.printf("     %d    ", at[i]);
            System.out.printf("     %d  \t  ", bt[i]); 
            System.out.printf("     %d \t ", wt[i]); 
            System.out.printf("     %d    \n", tat[i]); 
        } 
        float s = (float)total_wt /(float) n; 
        int t = total_tat / n; 
        System.out.printf("First come first serve:- \n");
        System.out.printf("Average waiting time = %f", s); 
        System.out.printf("\n"); 
        System.out.printf("Average turn around time = %d \n ", t); 
    } 
    
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc = new Scanner(System.in);
        System.out.println("Number of Processes:");
        int n = sc.nextInt();
        System.out.println("Number of Processes:" + n);
        //System.out.println("\n\nFirst Come First Serve:\n");        
        
        //process id's  
        int[] processes = new int[n]; 
        //int n = processes.length; 
        int burst_time[] = new int[n];
        int arr_time[] = new int [n];
        //Burst time of all processes
        for(int i = 0; i<n; i++){
            int a = i+1;
           
            System.out.println("Arrival Time of Processes "+a+" :");
            arr_time[i] = sc.nextInt();
            System.out.println("Burst Time of Processe "+a+" :");
            burst_time[i] = sc.nextInt();
        }
        //int burst_time[] = {10, 2, 5, 9, 7}; 
        
        findavgTime(processes, n,arr_time, burst_time); 
        
    
    }
    
}


 
