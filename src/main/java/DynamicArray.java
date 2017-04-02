public class DynamicArray {

    static int stackSize = 300;
    static int indexUsed = 0;
    static int[] stackPointer = {-1, -1, -1};
    static StackNode[] buffer = new StackNode[stackSize * 3];

    public static void main(String[] args) {


        push(0, 0);
        push(0, 1);
        push(0, 2);
        push(0, 3);
        push(1, 53);push(1, 34);push(1, 33);push(1, 32);


    }


    static void push(int stackNum, int value) {
        int lastIndex = stackPointer[stackNum];
        stackPointer[stackNum] = indexUsed;
        indexUsed++;
        buffer[stackPointer[stackNum]] = new StackNode(lastIndex, value);

    }


    int pop(int stackNum) {
        int value = buffer[stackPointer[stackNum]].value;
        int lastIndex = stackPointer[stackNum];
        stackPointer[stackNum] = buffer[stackPointer[stackNum]].previous;
        buffer[lastIndex] = null;
        indexUsed--;
        return value;

    }


    int peek(int stack) {
        return buffer[stackPointer[stack]].value;
    }


    boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }


    static class StackNode {

        public int previous;
        public int value;


        public StackNode(int p, int v) {
            value = v;
            previous = p;

        }

    }
}
