// Испит јануари 2026 · прв термин · влезна · Queue
// CallCenter
// Извор: Discord → ФИНКИ Хаб → АПС, ПАПС → #материјали · devi, 10.02.2026, 17:52

// Кол центар чува дневник од извршени повици и операторите кои ги извршиле повиците. Има n записи и m оператори. Записите се во формат:

// call (број на телефон) – додавање на повик во редицата на чекање.
// start (оператор) – операторот започнува со повик од редицата.
// end (оператор) – операторот завршува со повикот.
// status – да се испечати колку чекаат во редицата во моментот и колку оператори во моментот работат.
// Влез
// Во првиот ред се n (број на записи) и m (број на оператори). Во следните n редови е по еден запис.

// Пример
// 12 2
// call 123
// call 223
// call 345
// start op1
// call 456
// start op2
// status
// call 67
// end op 1
// status
// end op 2
// status
// status:
// busy operators: 2
// clients waiting: 2

// status:
// busy operators: 1
// clients waiting: 3

// status:
// busy operators: 0
// clients waiting: 3
// Текстот е напишан од студент по испитот, па форматот (на пр. „end op 1“ наместо „end op1“) можеби не е точен.

import java.util.NoSuchElementException;
import java.util.Scanner;

interface Queue<E> {
    // Elementi na redicata se objekti od proizvolen tip.
    // Metodi za pristap:
    public boolean isEmpty();
    // Vrakja true ako i samo ako redicata e prazena.

    public int size();
    // Ja vrakja dolzinata na redicata.

    public E peek();
    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

    // Metodi za transformacija:

    public void clear();
    // Ja prazni redicata.

    public void enqueue(E x);
    // Go dodava x na kraj od redicata.

    public E dequeue();
    // Go otstranuva i vrakja pochetniot element na redicata.
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}


class LinkedQueue<E> implements Queue<E> {

    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Elementite se zachuvuvaat vo jazli dod SLL
    // front i rear se linkovi do prviot i posledniot jazel soodvetno.
    SLLNode<E> front, rear;
    int length;

    // Konstruktor ...

    public LinkedQueue() {
        clear();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size() {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek() {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear() {
        // Ja prazni redicata.
        front = rear = null;
        length = 0;
    }

    public void enqueue(E x) {
        // Go dodava x na kraj od redicata.
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SLLNode<E> curr = front;
        while (curr != null) {
            sb.append(curr.element);
            if (curr.succ != null) {
                sb.append(" ");
            }
            curr = curr.succ;
        }
        return sb.toString();
    }

    public E dequeue() {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (front != null) {
            E frontmost = front.element;
            front = front.succ;
            if (front == null) rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedQueue<String> redica = new LinkedQueue<>();

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        int broj_na_zafateni = 0;

            for (int i = 0; i < n; i++) {
                String element = scanner.nextLine();
                String[] delovi = element.split(" ");
                String akcija = delovi[0];

                if (akcija.equals("call")) {
                    redica.enqueue(delovi[1]);
                } else if (akcija.equals("start") && !redica.isEmpty()) {
                    redica.dequeue();
                    broj_na_zafateni++;
                } else if (akcija.equals("end")) {
                    broj_na_zafateni--;
                } else if (akcija.equals("status")) {
                    System.out.println("Status:");
                    System.out.println("busy operators: " + broj_na_zafateni);
                    System.out.println("clients waiting: " + redica.size());
                    System.out.println();
                }
            }
        }
    }


