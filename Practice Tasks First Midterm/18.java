// Испит јуни 2026 · прва група · влезна · Queue
// TicketOffice
// Извор: Discord → ФИНКИ Хаб → АПС, ПАПС → #материјали · tedi, 15.06.2026, 18:20

// Има ticket office со 2 редици: VIP и Regular. Оние кои чекаат во VIP редицата секогаш се услужуваат пред оние во Regular, во редоследот по кој се дојдени. Во првиот ред се внесува број N кој означува колку вкупно команди се внесуваат.

// Команди
// arrive <id> REG – доаѓа човек со ID <id> во Regular редицата.
// arrive <id> VIP – доаѓа човек со ID <id> во VIP редицата.
// status – покажува кои луѓе чекаат за услуга, по редослед како ќе бидат услужени, во формат Waiting: <id1> <id2> .... Ако нема никој, печати Waiting: empty.
// serve – го услужува првиот кој е на ред и печати Serving: <id>. Ако нема никој, печати Serving: empty.
// Пример
// 9
// arrive 101 REG
// arrive 102 VIP
// arrive 103 REG
// status
// serve
// arrive 104 VIP
// status
// serve
// serve
// Waiting: 102 101 103
// Serving: 102
// Waiting: 104 101 103
// Serving: 104
// Serving: 101


import com.sun.source.tree.WhileLoopTree;

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

        LinkedQueue<String> redicareg = new LinkedQueue<>();
        LinkedQueue<String> redicavip = new LinkedQueue<>();

        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String vlezen = scanner.nextLine();
            String[] delovi = vlezen.split(" ");
            String akcija = delovi[0];

            if (akcija.equals("arrive")) {
                if (delovi[2].equals("VIP")) {
                    redicavip.enqueue(delovi[1]);
                } else if (delovi[2].equals("REG")) {
                    redicareg.enqueue(delovi[1]);
                }
            } else if (akcija.equals("serve")) {
                if (!redicavip.isEmpty()) {
                    System.out.println("Serving: " + redicavip.dequeue());
                } else if (!redicareg.isEmpty()) {
                    System.out.println("Serving: " + redicareg.dequeue());
                } else {
                    System.out.println("Serving: empty");
                }
            } else if (akcija.equals("status")) {
                if (redicavip.isEmpty() && redicareg.isEmpty()) {
                    System.out.println("Waiting: empty");
                } else {
                    System.out.print("Waiting:");

                    SLLNode<String> curr = redicavip.front;
                    while (curr != null) {
                        System.out.print(" " + curr.element);
                        curr = curr.succ;
                    }
                    curr = redicareg.front;
                    while (curr != null) {
                        System.out.print(curr.element);
                        curr = curr.succ;
                    }
                    System.out.println();
                }
            }
        }
    }
}
