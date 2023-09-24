package lb1;

public class Main{
    public static void main(String[] args){
        //масив для першого завдання
        int[] data = {3, 4, 5, 7, 9};
        System.out.println(checkIfIncreasing(data));
        fizzBuzz();
        //масив для третього завдання
        int[] dataT3 = {2, 3, 6, 4, 7,};
        System.out.println(sumOfSplitArray(data));
        System.out.println(sumOfSplitArray(dataT3));
    }

    //Task1
    public static boolean checkIfIncreasing(int[] data){
        if (data.length < 2){
            return false;
        }
        for(int i = 1; i < data.length; i++){
            if(data[i] < data[i-1]){
                return false;
            }
        }
        return true;
    }

    //Task2
    public static void fizzBuzz(){
        for(int i = 1; i <= 100; i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            }
            else if(i % 3 == 0 ){
                System.out.println("Fizz");
            }
            else if(i % 5 == 0){
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }
    }

    //Task3
    public static boolean sumOfSplitArray(int[] data){
        int totalSum = 0;
        for (int num : data) {
            totalSum += num;
        }

        //перевіряємо чи сума всіх чисел парна
        if(totalSum % 2 != 0){
            return false;
        }

        int leftSideSum = totalSum / 2;
        int currentSum = 0;

        for(int num : data){
            currentSum += num;
            if(currentSum == leftSideSum){
                return true;
            }
        }
        return false;
    }
}