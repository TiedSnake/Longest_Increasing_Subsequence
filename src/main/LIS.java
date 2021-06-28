package main;

import java.util.Random;

/**
 *
 * @author m-w-n
 */
public class LIS
{

    static int array[] = new int[100];                              //Declaring an empty array of 100 numbers.
    public static final String ANSI_RESET = "\u001B[0m";    //Reseting colors for the output.
    public static final String ANSI_RED = "\u001B[31m";     //Setting red color for the output.

    public static int randomNumber(int lower_bound, int upper_bound)    //Method for generating random numbers between two values.
    {
        Random r = new Random();
        int randomNumber = (r.nextInt(upper_bound - lower_bound) + lower_bound);
        return randomNumber;
    }

    public static int[] RandomArray(int[] array)                //Method for filling any array with random numbers.
    {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = randomNumber(0, 100);
        }
        return array;
    }

    public static void printArray(int[] array)          //Method for printing array.
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
    }

    public static void LongestIncreasingSequence(int[] array)       //Method for finding the Longest Increasing sequence in any array.
    {
        int[] subsequence = new int[array.length];
        int counter = 0, longest_occurences = 0, second_index = 0;
        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i] < array[i + 1])
            {
                counter++;
            }
            if (longest_occurences < counter)
            {
                longest_occurences = counter;
                second_index = i + 1;
            }
            if (array[i] >= array[i + 1])
            {
                counter = 0;
            }
        }
        if (longest_occurences > 0)
        {
            for (int i = 0; i < array.length; i++)
            {
                if (i == (second_index - longest_occurences))
                {
                    for (int j = i; j <= second_index; j++)
                    {
                        System.out.print(ANSI_RED + array[j] + " " + ANSI_RESET);
                        i=j;
                    }
                } else
                {
                    System.out.print(array[i] + " ");
                }
            }
            System.out.println("");
            System.out.print("The longest increasing subsequence is: ");
            System.out.println(longest_occurences + 1 + " ");
            System.out.println("Starting from index " + (second_index - longest_occurences) + " in the array");
            for (int i = second_index - longest_occurences; i <= second_index; i++)
            {
                System.out.print(array[i] + " ");
            }
        } else
        {
            System.out.println("There is no increasing subsequence in given values: ");
        }
    }

    public static void main(String[] args)
    {
        RandomArray(array);     //Initilizing the static array with random valus.
        LongestIncreasingSequence(array);   //Finding the longest increasing sequence in the static array.
//        int[] b = {1, 5, 4, 0, 3, 2, 7, 8, 9, 10, 11};
//        System.out.println("\n");
//        LongestIncreasingSequence(b);
    }
}
