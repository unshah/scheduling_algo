/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srt;

import java.util.Scanner;

public class Srt {

    static void findWaitingTime(int proc[], int n, int at[],
        int bt[], int wt[]) 
    { 
    int rt[] = new int[n]; 
       
        // Copy the burst time into rt[] 
        for (int i = 0; i < n; i++) 
            rt[i] = bt[i]; 
       
        int complete = 0, t = 0, minm = Integer.MAX_VALUE; 
        int shortest = 0, finish_time; 
        boolean check = false; 
       
        // Process until all processes gets 
        // completed 
        while (complete != n) { 
       
            // Find process with minimum 
            // remaining time among the 
            // processes that arrives till the 
            // current time` 
            for (int j = 0; j < n; j++)  
            { 
                if ((at[j] <= t) && 
                  (rt[j] < minm) && rt[j] > 0) { 
                    minm = rt[j]; 
                    shortest = j; 
                    check = true; 
                } 
            } 
       
            if (check == false) { 
                t++; 
                continue; 
            } 
       
            // Reduce remaining time by one 
            rt[shortest]--; 
       
            // Update minimum 
            minm = rt[shortest]; 
            if (minm == 0) 
                minm = Integer.MAX_VALUE; 
       
            // If a process gets completely 
            // executed 
            if (rt[shortest] == 0) { 
       
                // Increment complete 
                complete++; 
                check = false; 
       
                // Find finish time of current 
                // process 
                finish_time = t + 1; 
       
                // Calculate waiting time 
                wt[shortest] = finish_time - 
                             bt[shortest] - 
                             at[shortest]; 
       
                if (wt[shortest] < 0) 
                    wt[shortest] = 0; 
            } 
            // Increment time 
            t++; 
        } 
    } 
       
    // Method to calculate turn around time 
    static void findTurnAroundTime(int proc[], int n,int at[], int bt[],
                            int wt[], int tat[]) 
    { 
        // calculating turnaround time by adding 
        // bt[i] + wt[i] 
        for (int i = 0; i < n; i++) 
            tat[i] = bt[i] + wt[i]; 
    } 
       
    // Method to calculate average time 
    static void findavgTime(int proc[], int n, int at[], int bt[]) 
    { 
        int wt[] = new int[n], tat[] = new int[n]; 
        int  total_wt = 0, total_tat = 0; 
       
        // Function to find waiting time of all 
        // processes 
        findWaitingTime(proc, n, at, bt, wt); 
       
        // Function to find turn around time for 
        // all processes 
        findTurnAroundTime(proc, n, at, bt, wt, tat); 
       
        // Display processes along with all 
        // details 
        System.out.println("Processes " + 
                           "Arrival time"+
                           " Burst time " + 
                           " Waiting time " + 
                           " Turn around time"); 
       
        // Calculate total waiting time and 
        // total turnaround time 
        for (int i = 0; i < n; i++) { 
            total_wt = total_wt + wt[i]; 
            total_tat = total_tat + tat[i]; 
            System.out.println(" " + (i+1) + "\t\t"+at[i]+"\t"
                             + bt[i] + "\t\t " + wt[i] 
                             + "\t\t" + tat[i]); 
        } 
        System.out.println("Shortest Remaining time:-");
       
        System.out.println("Average waiting time = " + 
                          (float)total_wt / (float)n); 
        System.out.println("Average turn around time = " + 
                           (float)total_tat / (float)n); 
    } 
      
    // Driver Method 
    public static void main(String[] args) 
    { 
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of Processes:");
        int n = sc.nextInt();
        System.out.println("Number of Processes Entered= " + n); 
        
        int[] proc= new int[n];
        int burst_time[] = new int[n];
        int arr_time[] = new int [n];
        //int n = processes.lengt
        for (int i=0; i<n; i++){
           int a = i+1;
          
           System.out.println("Arrival Time of Processes "+a+" :");
           arr_time[i] = sc.nextInt();
           System.out.println("Burst Time of Processe "+a+" :");
           burst_time[i] = sc.nextInt();
        }
         
         findavgTime(proc, n, arr_time, burst_time); 
    } 
}
