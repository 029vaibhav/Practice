import java.util.ArrayList;
import java.util.List;

public class Chemical {

    public static void main(String[] args) {

        String chemical = "(((ab)2c3)5)";
        int a = 1, b = 2, c = 3;
        char[] chars = chemical.toCharArray();
        Stack stack = new Stack();
        for (char c1 : chars) {
            stack.push(c1);
        }
        System.out.println(stack.value);
    }

    public static int getValue(char c) {
        if (c == 'a') return 1;
        else if (c == 'b') return 2;
        else return 3;
    }

    public static class Stack {

        public List<Character> s = new ArrayList<>();
        public List<Character> eval = new ArrayList<>();
        public int value = 0;


        public void push(char s1) {
            s.add(s1);
            evaluate();
        }

        private void evaluate() {

            Character character = s.get(s.size() - 1);
            if (character == ')') {

                for (int i = 0; i < s.size(); i++) {
                    if (s.get(i) == ')') {
                        pop();
                        calculate();


                        break;
                    }
                    pop();
                }
            }

        }

        private void calculate() {

            for (int i = 0; i < eval.size(); i++) {

                if (i + 1 < eval.size() - 1) {

                    if (!Character.isDigit(eval.get(i)) && !Character.isDigit(eval.get(i + 1))) {
                        value = value + getValue(eval.get(i)) + getValue(eval.get(i + 1));
                        i++;
                    } else if (Character.isDigit(eval.get(i)) && Character.isDigit(eval.get(i + 1))) {
                        value = value + (Integer.parseInt("" + eval.get(i)) * Integer.parseInt("" + eval.get(i + 1)));
                        i++;
                    } else if (Character.isDigit(eval.get(i)) && !Character.isDigit(eval.get(i + 1))) {
                        value = value + (Integer.parseInt("" + eval.get(i)) * getValue(eval.get(i + 1)));
                        i++;
                    } else if (!Character.isDigit(eval.get(i)) && Character.isDigit(eval.get(i + 1))) {
                        value = value + getValue(eval.get(i));
                    }


                }
            }
        }

        public void pop() {
            Character remove = s.remove(s.size() - 1);
            if (remove != ')')
                eval.add(remove);
        }


    }
}
