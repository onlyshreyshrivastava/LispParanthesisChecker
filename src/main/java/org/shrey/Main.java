package org.shrey;

//Coding exercise: You are tasked to write a checker that validates the parentheses of a LISP code. Write a program
//(in Java or JavaScript) which takes in a string as an input and returns true if all the parentheses in the string are
//properly closed and nested.
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String lispCode = "(defun queue-length (queue)\n" +
                "  \"Returns as two values the number of elements in the queue \n" +
                "   and the maximum number of elements the queue can hold.\"\n" +
                "  (check-type queue queue)\n" +
                "  (let ((length (length (queue-elements queue)))\n" +
                "        (delta (the fixnum (- (queue-put-ptr queue) \n" +
                "          (queue-get-ptr queue)))))\n" +
                "    (declare (fixnum length delta))\n" +
                "    ;; The maximum number of elements the queue can hold is \n" +
                "    ;; (1- LENGTH) because a queue is empty when put-ptr = \n" +
                "    ;; get-ptr.\n" +
                "    (values (mod delta length) (the fixnum (1- length)))))\n" +
                "\n" +
                "\n" +
                "(defun queue-empty-p (queue)\n" +
                "  \"Return T if QUEUE is empty.\"\n" +
                "  (check-type queue queue)\n" +
                "  (= (queue-put-ptr queue) (queue-get-ptr queue)))\n" +
                "\n" +
                "\n" +
                "(defun queue-full-p (queue)\n" +
                "  \"Return T if QUEUE is full.\"\n" +
                "  (check-type queue queue)\n" +
                "  (= (queue-get-ptr queue) \n" +
                "     (queue-next queue (queue-put-ptr queue))))\n" +
                "\n" +
                "\n" +
                ";; Create a queue. The :ELEMENTS keyword specifies a simple\n" +
                ";; vector to hold the elements of the queue. Note that the\n" +
                ";; maximum number of elements the queue can hold is one less than\n" +
                ";; the length of the vector.\n" +
                "(defun make-queue (&key (elements (make-array (1+ default-queue-size))))\n" +
                "  \"Create a queue.\"\n" +
                "  (check-type elements simple-vector)\n" +
                "  (create-queue :elements elements))";

        if (parenthesesAreClosedAndNested(lispCode)) {
            System.out.println("This is valid LISP code");
        } else {
            System.out.println("Invalid LISP code");
        }
    }

    private static boolean parenthesesAreClosedAndNested(String lispCode) {
        int curly = 0, square = 0, round = 0;
        for (int i = 0; i < lispCode.length(); i++) {
            char ch = lispCode.charAt(i);
            if (ch == '(') {
                round++;
            } else if (ch == ')') {
                round--;
            } else if (ch == '[') {
                square++;
            } else if (ch == ']') {
                square--;
            } else if (ch == '{') {
                curly++;
            } else if (ch == '}') {
                curly--;
            }
        }
        return curly == 0 && square == 0 && round == 0;
    }
}