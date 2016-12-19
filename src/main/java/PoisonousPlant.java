import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


public class PoisonousPlant {

    int[] a = new int[]{};

    public static void main(String[] args) throws IOException {

        int a = 22;
        int b = 87;
        int c = b & a;
        int d = a & b;

        Scan scan = new Scan();
        int count = scan.scanInt();


        List<Integer> integerList = new ArrayList<>();
        integerList.add(scan.scanInt());

        int lastNo = -1;
        for (int i = 0; i < count - 1; i++) {


            int instanceID = scan.scanInt();
//            integers.add(instanceID);
            if(lastNo==-1)
                integerList.add(instanceID);
            else if (instanceID <= integerList.get(integerList.size() - 1) || lastNo >= instanceID)
                integerList.add(instanceID);
            lastNo = instanceID;
//            if (instanceID <= integers.peek())
//            integerList
//            else {
//                integers2.push(instanceID);
//            }
        }

        int max_days = 0;
        int modifiedSize = 0;
        int lastSize = -1;
        List<Integer> integerList1 = new ArrayList<>();
        while (lastSize != modifiedSize) {

            max_days++;
            lastSize = integerList.size();
            for (int i = integerList.size() - 1; i >= 1; i--) {
                Integer current = integerList.get(i);
                Integer previous = integerList.get(i - 1);
                if (current > previous) {
                    integerList1.add(i);
                    integerList.remove(i);
                }

            }
//            for (int k : integerList1) {
//                integerList.set(k, -1);
//            }
//            for (int i = integerList.size() - 1; i >= 0; i--) {
//                int k = integerList.get(i);
//                if (k == -1)
//                    integerList.remove(i);
//
//            }
//
//            integerList1.clear();
            modifiedSize = integerList.size();

        }


        System.out.println("" + (max_days - 1));


    }

    public static int rc2(List<Integer> integerList, int i, int days, int temp) {


        return days;
    }

    public static int rc(List<Integer> integerList, int i, int days, int temp) {

        if (i > integerList.size() - 1)
            return days;

        Integer current = integerList.get(i);
        Integer previous = integerList.get(i - 1);
        if (current >= temp && temp != -1) {
            temp = integerList.remove(i);
            days = rc(integerList, i, days, temp);
        } else if (current > previous) {
            temp = integerList.remove(i);
            days++;
            days = rc(integerList, i, days, temp);

        }
        return days;
    }

    static class Scan {
        private byte[] buf = new byte[1024];    //Buffer of Bytes
        private int index;
        private InputStream in;
        private int total;

        public Scan() {
            in = System.in;
        }

        public int scan() throws IOException    //Scan method used to scan buf
        {
            if (total < 0)
                throw new InputMismatchException();
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0)
                    return -1;
            }
            return buf[index++];
        }

        public int scanInt() throws IOException {
            int integer = 0;
            int n = scan();
            while (isWhiteSpace(n))    //Removing starting whitespaces
                n = scan();
            int neg = 1;
            if (n == '-')                //If Negative Sign encounters
            {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                } else throw new InputMismatchException();
            }
            return neg * integer;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
                return true;
            return false;
        }
    }
}
