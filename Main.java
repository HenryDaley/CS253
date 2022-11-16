// Henry Daley
// 
// Prof. Zlatareva
//
// Main HMWK File



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Main {

	private static void fileCreator(String type, int length, int id  ) throws Exception {
		int trac1 = 0;
		int trac2 = length - 1;
		Random rand = new Random();
		try {
		    File file = new File(type + id +".txt");
			FileWriter fileOut = new FileWriter(file);
			for(int index = 0; index < length; index++  ) {
				if(type == "PrtOrderedFwrd") {
				   fileOut.write(trac1 + "\n");
				   trac1++;
				}
				if(type == "PrtOrderedBkwd") {
					fileOut.write(trac2 + "\n");
					trac2--;
				}
				if(type == "PrtRandom" ) {
					int ran = rand.nextInt(length);
					fileOut.write(ran + "\n");
				}
				if(type == "LrgOrderedFwrd") {
					fileOut.write(trac1 + "\n");
					trac1++;
				}
				if(type == "LrgOrderedBkwd") {
				    fileOut.write(trac2 + "\n");
					trac2--;
				}
		 		if(type == "LrgRandom" ) {
				    int ran = rand.nextInt(length);
					fileOut.write(ran + "\n");
				}
			}
			fileOut.close();
		}
		catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		catch (NoSuchFileException error) {
			error.printStackTrace();
		}
		catch (IOException Error) {
			Error.printStackTrace();
		}
			
			
	}
	
	public static int[] readMe(String type, int length, int id) throws Exception{
		int[] array = new int[length];
		// To make this work with your files simple replace the path up until type and ID then run my filecreator to make sure 
		//That names and ID's match
	    File input = new File("C:\\Users\\Henry\\eclipse-workspace\\CS-253\\" + type + id + ".txt");
		Scanner scan = new Scanner(input);
		for(int index = 0; index < array.length; index++) {
			String line = scan.nextLine();
		    array[index] = Integer.parseInt(line);
		    }
		    scan.close();
		return array;
	}
	
	
	public static void main(String[] args) throws Exception {
	
		// Create integer arrays via file creator method for all 6 types of data
		/*
		//Prototype files
		fileCreator("PrtOrderedFwrd", 16, 1);
		fileCreator("PrtOrderedBkwd", 16, 1);
		fileCreator("PrtRandom", 16, 1);
		fileCreator("PrtRandom", 16, 2);
		
		//Large Files
		fileCreator("LrgOrderedFwrd", 2001, 1);
		fileCreator("LrgOrderedBkwd", 2001, 1);
		fileCreator("LrgRandom", 2001, 1);
		fileCreator("LrgRandom", 2001, 2);
		*/
		
		
		//Prototype Dataset Arrays
		
		int[] PrtOrderedFwrd = readMe("PrtOrderedFwrd", 16, 1);
		int[] PrtOrderedBkwd = readMe("PrtOrderedBkwd", 16, 1);
		
		int[] PrtRandom1 = readMe("PrtRandom", 16, 1);
		int[] PrtRandom2 = readMe("PrtRandom", 16, 2);
		
		
		// Large Dataset Arrays
		
		int[] LrgOrderedFwrd = readMe("LrgOrderedFwrd", 2001, 1);
		int[] LrgOrderedBkwd = readMe("LrgOrderedBkwd", 2001, 1);
		
		int[] LrgRandom1 = readMe("LrgRandom", 2001, 1);
		int[] LrgRandom2 = readMe("LrgRandom", 2001, 2);
		
	
		/*
		To test a sort with a desired dataset simple name the sort and send it desired array
		
		Sort names:
		
		bubbleSort()
		insertionSort()
		selectionSort()
		
        */
	
				
		
		printMe(quickSort(LrgOrderedFwrd, 0, LrgOrderedFwrd.length -1));
	
		
	}
	
	
	
	public static void selectionSort(int[] array) {
		 int temp, min, exchanges = 0, comparisons = 0;
		 int numberOfItems = array.length;
		 for (int pass = 0; pass != numberOfItems - 1; pass++) { 
			 min = pass;
		    for (int index = pass+1; index != numberOfItems; index++) { 
		         comparisons++;
		         if (array[index] < array[min])
		            min = index;
		    } // end inner loop
		    temp = array[min];
		    array[min] = array[pass];
		    array[pass] = temp;
		    exchanges++;
		  } // end outer loop
		  System.out.println("Selection Sort: Number of Exchanges: " + 
		  exchanges);
		  System.out.println("Selection Sort: Number of Comparisons: " + 
		  comparisons);
		  System.out.println ("Sorted file:");
		  for (int i= 0; i < array.length; i++)
		  System.out.print (array[i] + " ");
		  System.out.println (); 
		  } // end selection sort
	
	
	 
    public static void bubbleSort(int[] array) {
			   int exchanges = 0;
			   int comparisons = 0;
			   int temp;
			   int numberOfItems = array.length;
		       boolean cont = true;     
			   for (int pass=1; pass != numberOfItems; pass++)	{ 
		           if (cont) {    
		              cont = false;  
		              for (int index=0; index != numberOfItems-pass; index++) {
		            	   comparisons++;
				           if (array[index] > array[index + 1]) {
				             temp = array[index];
				             array[index] = array[index+1];
				             array[index+1] = temp;
				             exchanges++;
		                     cont = true;
				 }  // end inner if              
			         }  // end inner for            
		            }
		           else
		              break;  // end outer if
			   } 
			   System.out.println("Bubble Sort: Number of Exchanges: " + 
						 exchanges);
						  System.out.println("Bubble Sort: Number of Comparisons: " + 
						 comparisons);
						  System.out.println ("Sorted file:");
						  for (int index1= 0; index1 < array.length; index1++)
						  System.out.print (array[index1] + " ");
						  System.out.println (); 
		}
		   
		   
		   
		   
		   public static void insertionSort(int[] array) {
			   int comparisons = 0;
			   int exchanges = 0;
			   for (int outer = 1; outer < array.length; outer++) {  
		           int key = array[outer];  
		           int inner = outer-1; 
		           while ((inner > -1) && ( array [inner] > key ) ) { 
		               comparisons++;
		               exchanges++;
		               array [inner+1] = array [inner];  
		               inner--;  
		            }  
		            array[inner+1] = key;  
			 }
			   System.out.println("Insertion Sort: Number of Exchanges: " + 
						 exchanges);
			   System.out.println("Insertion Sort: Number of Comparisons: " + 
						 comparisons);
			   System.out.println ("Sorted file:");
			   for (int index1= 0; index1 < array.length; index1++)
				   System.out.print (array[index1] + " ");
				   System.out.println ();  
			   }
		   

	
	
	public static int comparisons;
	public static int exchanges;
	
	public static void   segmentedInsertionSort(int[] array, int length, int height) {
		
		   for (int outer = height ; outer <length; outer++) {  
	           int key = array[outer];  
	           int inner = outer; 
	           while ((inner > height-1) && ( array [inner - height] > key ) ) { 
	               comparisons++;
	               
	               array [inner] = array [inner - height];  
	               inner = inner - height;  
	               exchanges++;
	            }  
	            array[inner] = key;  
		 }
		  
		  
	}
	
	
	public static void shellSort(int[] array, int n) {
		
		int height = 3 * (n + 1);
		 while(height > 0) {
			 segmentedInsertionSort( array, n, height);
			 height = height / 2;
			 }
		 
	   System.out.println("Insertion Sort: Number of Exchanges: " + 
				 exchanges);
	   System.out.println("Insertion Sort: Number of Comparisons: " + 
				 comparisons);
	   System.out.println ("Sorted file:");
	   for (int index1= 0; index1 < array.length; index1++)
		   System.out.print (array[index1] + " ");
		   System.out.println ();  
		   
		   
		 }
	
	
	public static void merge(int[] source,int[] destination,int lower,int mid, int upper) {
        
        int s1 = lower;
        int s2 = mid + 1;
        int d = lower;
        while (s1 <= mid && s2 <= upper) {
            if (source[s1] <= source[s2]) {
                destination[d] = source[s1];
                s1 ++;
            } else {
                destination[d] = source[s2];
                s2 ++;
            }
            d ++;
        }
        if (s1 > mid) {
            while (s2 <= upper) {
                destination[d] = source[s2];
                s2 += 1;
                d += 1;
            }
        } else {
            while (s1 <= mid) {
                destination[d] = source[s1];
                s1 ++;
                d ++;
            }
        }
        

    }
	
	public static void mergeSort(int[] source, int[] destination, int lower, int upper) {
		if(lower != upper) {
			int mid = (lower + upper) / 2;
			mergeSort(source, destination, lower, mid);
			mergeSort(source, destination, mid + 1, upper);
			merge(source, destination, lower, mid, upper);
			
		}
	}
	
	
	public static void sort(int[] array, int N) {
		
		int[] destination = new int[N];
		mergeSort(array, destination, 1, N);
		System.out.println("Insertion Sort: Number of Exchanges: " + 
					 exchanges);
		System.out.println("Insertion Sort: Number of Comparisons: " + 
					 comparisons);
		System.out.println ("Sorted file:");
		for (int index1= 0; index1 < array.length; index1++)
			 System.out.print (array[index1] + " ");
			 System.out.println ();  
	}
	
	
	public static int partition(int[] A, int lo, int hi) {
		int pivot = A[lo];
        while (lo < hi) {
            while (pivot < A[hi] && lo < hi) {
                comparisons++;
                hi = hi - 1;
            }
            if (hi != lo) {
                exchanges++;
                A[lo] = A[hi];
                lo++;
            }
            while (A[lo] < pivot && lo < hi) {
                comparisons++;
                lo++;
            }
            if (hi != lo) {
                exchanges++;
                A[hi] = A[lo];
                hi--;
            }
        }
        A[hi] = pivot;
        int pivotPoint = hi;
        return pivotPoint;
	}
	
	public static void swap(int[] array, int index, int j) {
		int temp = array[index];
		array[index] = array[j];
		array[j] = temp;
		exchanges++;
	}
	
	 public static int[] quickSort(int[] array, int low, int high) {
		 
		 if(low < high) {
			 int partition = partition(array, low, high);
			 quickSort(array, low, partition -1);
			 quickSort(array, partition + 1, high);
			 
		 }
		 return array;
		 
		
	    
		
	 }
	  public static void printMe(int[] array) {
		  System.out.println("quickSort Sort: Number of Exchanges: " + 
					 exchanges);
		   System.out.println("quickSort Sort: Number of Comparisons: " + 
					 comparisons);
		   System.out.println ("Sorted file:");
		   for (int index1= 0; index1 < array.length; index1++)
			   System.out.print (array[index1] + " ");
			   System.out.println ();  
	  }
	
	
		
	}
	
	
	


