import java.util.Stack;

public class ToweOfHonoi {

    static Stack<Integer> one = new Stack<>();
    static Stack<Integer> two = new Stack<>();
    static Stack<Integer> three = new Stack<>();

    public static void main(String[] args) {

        one.push(3);
        one.push(2);
        one.push(1);

    }


    static class Tower{

        Stack<Integer> integers = new Stack<>();
        int index;

        public Tower(int index) {
            integers = new Stack<>();
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
        public void add(int d){
            if(!integers.empty() && integers.peek()<=d){

            }
            else {
                integers.push(d);
            }
        }

        public void moveTopto(Tower tower){
            Integer pop = integers.pop();
            tower.add(pop);
        }
    }


}
