import java.util.Stack;

public class HanoiTower {//решение из интернета. Пыталась разобраться,но всё равно не совсем поняла как работает рекурсия

        public static void main(String[] args) {
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            Stack<Integer> stack3 = new Stack<>();
            int n = 5;
            for (int i = n; i > 0; i--) {
                stack1.push(i);
            }
            moveRingRec(stack1, stack2, stack3, n);
        }

        public static void moveRingRec(Stack<Integer> stackFirst, Stack<Integer> stackSecond, Stack<Integer> stackThird,
                                       int numberOfRing) {//stackFirst, stackSecond, stackThird - стеки, на которых расположены кольца
            // (базовое состояние - все кольца на первом стеке),
            //numberOfRing - количество колец, которые нужно переместить.
            if (numberOfRing <= 0) return;//базовый случай. Выходим из рекурсии ,когда число колец равно нулю

            moveRingRec(stackFirst, stackThird, stackSecond, numberOfRing - 1);//В начале каждого запуска рекурсии осуществляется вызов функции
            //с параметрами вида (stackFirst, stackThird, second, numberOfRing - 1).
            //
            stackThird.push(stackFirst.pop());
            System.out.println("Move disc " + numberOfRing + " from stackFirst" + stackFirst + " to stackThird" + stackThird);
            //Эта функция перемещает numberOfRing-1 верхних колец со стэка
            //stackFirst на стэк stackThird, используя стэк stackSecond как временное хранилище.
            moveRingRec(stackSecond, stackFirst, stackThird, numberOfRing - 1);

            //функция перемещает
            // все колечки со стека stackThird на стек stackSecond, используя первый
            // стек как временное хранилище.После этого на стэк stackThird помещается самое большое кольцо со стека
            // stackFirst (кольцо с наибольшим диаметром).

        }
    }

