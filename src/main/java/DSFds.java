import java.util.Scanner;

class DSFds {


    public static void main(String args[]) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/

        //Scanner
        Scanner s = new Scanner(System.in);
        int monkSetLength = s.nextInt();
        int iMonkSetLength = s.nextInt();

        int[] monkSet = new int[monkSetLength];
        for (int i = 0; i < monkSetLength; i++) {
            monkSet[i] = s.nextInt();
        }

        int[] iMonkSet = new int[iMonkSetLength];
        for (int i = 0; i < iMonkSetLength; i++) {
            iMonkSet[i] = s.nextInt();
        }

        int[]  monkSmallList =new int[monkSetLength];
        int[]  monkBigList = new int[monkSetLength];

        int[] iMonkSmallList = new int[iMonkSetLength];
        int[] iMonkBigList = new int[iMonkSetLength];

        int monkScore = 0;
        int iMonkScore = 0;
        for (int i1 = 0; i1 < monkSet.length; i1++) {
            int monkSmall = 0, monkBig = 0;
            int i = monkSet[i1];
            int i2 = iMonkSet[i1];
            for (int k : iMonkSet) {
                if (i < k) {
                    monkSmall++;

                } else if (i > k) {
                    monkBig++;
                }
            }

            int imonkSmall = 0, imonkBig = 0;
            for (int k : monkSet) {
                if (i2 < k) {
                    imonkSmall++;
                } else if (i > k) {
                    imonkBig++;
                }
            }


            monkSmallList[i1] = (monkSmall);
            monkBigList[i1] = (monkBig);
            iMonkSmallList[i1] = (imonkSmall);
            iMonkBigList[i1] = (imonkBig);
            monkScore = monkScore + (monkSmallList[i] * monkBigList[i]);
            iMonkScore = iMonkScore + (iMonkSmallList[i] * iMonkBigList[i]);
        }


        if (monkScore > iMonkScore) {
            System.out.println("Monk " + (monkScore - iMonkScore));
        } else if (monkScore < iMonkScore) {
            System.out.println("!Monk " + (iMonkScore - monkScore));
        } else {
            System.out.println("Tie");
        }
    }

}
