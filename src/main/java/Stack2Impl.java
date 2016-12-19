import java.util.Scanner;
import java.util.Stack;

public class Stack2Impl {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        Stack<MyStack> strings = new Stack<>();

        MyStack myStack;
        String s = "";
        for (int i = 0; i < count; i++) {

            int instanceID = in.nextInt();
            switch (instanceID) {
                case 1:
                    myStack = new MyStack();
                    myStack.setOperation(1);
                    String next = in.next();
                    if (strings.size() > 0)
                        next = strings.peek().getString() + next;
                    myStack.setString(next);
                    strings.push(myStack);
                    s = next;
                    break;
                case 2:
                    myStack = new MyStack();
                    myStack.setOperation(2);
                    int instanceID1 = in.nextInt();
                    s = s.substring(0, s.length() - instanceID1);
                    myStack.setString(s);
                    strings.push(myStack);
                    break;
                case 3:
                    int instanceID2 = in.nextInt();
                    System.out.println("" + s.charAt(instanceID2 - 1));
                    break;
                case 4:
                    if (strings.size() > 0) {
                        strings.pop();
                        if (strings.size() > 0)
                            s = strings.peek().getString();
                        else s = "";
                    } else s = "";
            }


        }


    }

    public static class MyStack {

        int operation;
        String string;

        public int getOperation() {
            return operation;
        }

        public void setOperation(int operation) {
            this.operation = operation;
        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }
    }
}
