import java.util.ArrayList;

public class Proj6_1_SumOfElements {
    public static void main(String[] args) {
        ArrayList<Integer> myArrayList = new ArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        System.out.println("Sum is " + sumElements(myArrayList));
    }

    public static int sumElements(ArrayList<Integer> theArrayList){
        int sum = 0;
        for (Integer num : theArrayList) {
            sum += num;
        }
        return sum;
    }
}
