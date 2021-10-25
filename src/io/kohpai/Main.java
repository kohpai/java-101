package io.kohpai;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
//        hello();
//        data();
//        input();
//        intCalc();
//        condAndLoop();
//        loop();
//        array();
        byte[] bytes = {49, 50, 51, 52, 53, 54, 55, 56, 57};
        int numOfDots = bytes.length / 3;

        if (bytes.length % 3 == 0) {
            numOfDots = numOfDots - 1;
        }

        byte[] formatted = new byte[bytes.length + numOfDots];

        int count = 0, count2 = 0;
        for (int i = bytes.length - 1; i >= 0; i = i - 1) {
            formatted[count2] = bytes[i];
            count = count + 1;
            count2 = count2 + 1;
            if (count % 3 == 0 && i != 0) {
                formatted[count2] = '.';
                count2 = count2 + 1;
            }
        }

        for (int i = formatted.length - 1; i >= 0; i = i -1) {
            System.out.print((char) formatted[i]);
        }
        System.out.println();
    }

    private static void hello() {
        System.out.print("Guten Tag\nnewline\n");
        System.out.println("Guten Abend");
    }

    private static void data() {
        int i = 12;
        int i2 = 12 % 10; // modulation, or mod, for short
        // parenthesis ( )
        // bracket { }
        // square bracket [ ]
        System.out.println((i + 3) * 4 - 2 / 1); // precedence level
        System.out.println(i2);

        char c = 'a';
        int ic = 97 + 3;
        System.out.println(c);
        System.out.println((char) ic);

        boolean b = false;
        System.out.println(!b); // negation operation
        // &, ampersand
        // |, pipe
        System.out.println(b || true);

        double d = 5.6;
        int id = (int) 5.996; // floor, ceil, round
        float f = (float) 5.6;
        System.out.println(d);
        System.out.println(id);
        System.out.println(f);

        String s = "hello world";
        String s2 = new String("Hallo Welt");
        System.out.println(s.toUpperCase());
        System.out.println(s2.substring(1, 5));
        System.out.println(s + " Pai"); // concatenation
    }

    private static void input() throws IOException {
        System.out.print("10 + ");
        int fst = (System.in.read() - 48) * 10;
        int snd = System.in.read() - 48;
        int num = fst + snd;
        System.out.println("equals " + (num + 10));
    }

    private static void loop() {
        // for
        // while
        // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

        int prev = 0;
        int curr = 1;
        for (int i = 0; i < 15; i = i + 1) {
//            System.out.println(i * 2);
            System.out.println(curr);
            int tmp = curr;
            curr = curr + prev;
            prev = tmp;
        }

    }

    private static void condAndLoop() {
        boolean b1 = true; // dogs are animal
        boolean b2 = false; // cats like dogs

        boolean and = b1 && b2; // conjunction
        boolean or = b1 || b2; // disjunction
        boolean b3 = b1 && !b2;
        boolean b4 = !b1 || b2;
//        System.out.println("and: " + and);
//        System.out.println("or: " + or);
//        System.out.println("b3: " + b3);
//        System.out.println("b4: " + b4);

//        if (and) {
//            // statements
//            System.out.println("cats like dogs");
//        } else if (!b4) {
//            System.out.println("dogs love cats");
//        } else {
//            System.out.println("last else");
//        }

        System.out.println("Ending function");
    }

    private static void array() {
        int[] listOfInt = new int[11];

        listOfInt[5] = 11;
        listOfInt[8] = 34;
        System.out.println("length: " + listOfInt.length);
        System.out.println("list: " + Arrays.toString(listOfInt));

        System.out.println(listOfInt[listOfInt.length - 1]);
    }

    // parameters & arguments
    private static int asciiToInt(int a, int b) {
        int fst = (a - 48) * 10;
        int snd = (b - 48);
        return fst + snd;
    }

    private static int getNumInput() throws IOException {
        // user input is 5678<EOF>, len = 5
        int num = System.in.read() - 48; // num = 5, len = 4
        int len = System.in.available(); // len = 4
        for (int i = 0; i < (len - 1); ++i) {
            num = num * 10 + (System.in.read() - 48);
            // 5 * 10 + (6)
            // 56 * 10 + 7
            // 567 * 10 + 8
        }
        System.in.read(); // read junk <EOF>
        return num; // 5.678
    }

    private static int getNumInputArr() throws IOException {
        byte[] bytes = new byte[20];

        // 5678<EOF>
        int len = System.in.read(bytes) - 1;
        int num = 0;

        for (int i = 0; i < len; ++i) {
            num = num + (bytes[i] - 48) * (int) Math.pow(10, len - (i + 1));
        }

        return num;
    }

    private static void intCalc() throws IOException {
        int num1, num2;

        int c1, c2, c3;

        boolean isEnding;

        for (; true; ) {
            System.out.print("Enter operation [add, mul, div, ext]:> ");
            c1 = System.in.read();
            c2 = System.in.read();
            c3 = System.in.read();
            System.in.read();

            isEnding = c1 == 'e' && c2 == 'x' && c3 == 't';

            if (isEnding) {
                break;
            }

            System.out.print("Enter first number:> ");
            num1 = getNumInput();

            System.out.print("Enter second number:> ");
            num2 = getNumInput();

            if (c1 == 'a' && c2 == 'd' && c3 == 'd') {
                System.out.println("Sum = " + (num1 + num2));
            } else if (c1 == 'm' && c2 == 'u' && c3 == 'l') {
                System.out.println("Prod = " + (num1 * num2));
            } else if (c1 == 'd' && c2 == 'i' && c3 == 'v') {
                if (num2 == 0) {
                    System.out.println("Operation not allowed");
                } else {
                    System.out.println("Div = " + (num1 / num2));
                }
            }

        }
    }
}
