// Дадена е двострано поврзана листа од цели броеви. Дополнително, даден е и уште еден природен број k. Потребно е првите k елементи од листата да се преместат на крај, во истиот редослед.

// Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните следниот ред самите елементи одделени со празно место. На крај, во последниот ред даден е и природниот број k. (k<=N)

// Излез: На излез треба да се испечати листата пред и после промената.

//import java.util.NoSuchElementException;
import java.util.Scanner;
////class SLLNode<E> {
////    protected E element;
////    protected SLLNode<E> succ;
////
////    public SLLNode(E elem, SLLNode<E> succ) {
////        this.element = elem;
////        this.succ = succ;
////    }
////
////    @Override
////    public String toString() {
////        return element.toString();
////    }
////}
////
////class LinkedStack<E> implements Stack<E> {
////    // top e link do prviot jazol ednostrano-povrzanata lista koja sodrzi gi elementite na stekot .
////    private SLLNode<E> top;
////    int size;
////
////    public LinkedStack() {
////        // Konstrukcija na nov, prazen stek.
////        top = null;
////        size = 0;
////    }
////
////    public String toString() {
////        SLLNode<E> current = top;
////        StringBuilder s = new StringBuilder();
////        while (current != null) {
////            s.append(current.element);
////            s.append(" ");
////            current = current.succ;
////        }
////        return s.toString();
////    }
////
////    public boolean isEmpty() {
////        // Vrakja true ako i samo ako stekot e prazen.
////        return (top == null);
////    }
////
////    public void clear() {
////        // Go prazni stekot.
////        top = null;
////        size = 0;
////    }
////
////    public E peek() {
////        // Go vrakja elementot na vrvot od stekot.
////        if (top == null)
////            throw new NoSuchElementException();
////        return top.element;
////    }
////
////    public void push(E x) {
////        // Go dodava x na vrvot na stekot.
////        top = new SLLNode<E>(x, top);
////        size++;
////    }
////
////    public int size() {
////        // Ja vrakja dolzinata na stekot.
////        return size;
////    }
////
////    public E pop() {
////        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
////        if (top == null)
////            throw new NoSuchElementException();
////        E topElem = top.element;
////        size--;
////        top = top.succ;
////        return topElem;
////    }
////
////}
//// interface Queue<E> {
////    // Elementi na redicata se objekti od proizvolen tip.
////    // Metodi za pristap:
////    public boolean isEmpty();
////    // Vrakja true ako i samo ako redicata e prazena.
////
////    public int size();
////    // Ja vrakja dolzinata na redicata.
////
////    public E peek();
////    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
////
////    // Metodi za transformacija:
////
////    public void clear();
////    // Ja prazni redicata.
////
////     public void enqueue(E x);    // Go dodava x na kraj od redicata.
////
////    public E dequeue();
////    // Go otstranuva i vrakja pochetniot element na redicata.
////}
//// class LinkedQueue<E> implements Queue<E> {
////
////    // Redicata e pretstavena na sledniot nacin:
////    // length go sodrzi brojot na elementi.
////    // Elementite se zachuvuvaat vo jazli dod SLL
////    // front i rear se linkovi do prviot i posledniot jazel soodvetno.
////    SLLNode<E> front;
////     SLLNode<E> rear;
////    int length;
////
////    // Konstruktor ...
////
////    public LinkedQueue () {
////        clear();
////    }
////
////    public boolean isEmpty () {
////        // Vrakja true ako i samo ako redicata e prazena.
////        return (length == 0);
////    }
////
////    public int size () {
////        // Ja vrakja dolzinata na redicata.
////        return length;
////    }
////
////     @Override
////     public E peek () { // Правилниот peek метод што го бара интерфејсот
////         if (front == null)
////             throw new NoSuchElementException();
////         return front.element;
////     }
////
////
////
////     public E peek (SLLNode element) {
////        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
////        if (front == null)
////            throw new NoSuchElementException();
////        return front.element;
////    }
////
////    public void clear () {
////        // Ja prazni redicata.
////        front = rear = null;
////        length = 0;
////    }
////
////     public void enqueue(E x){
////        // Go dodava x na kraj od redicata.
////        SLLNode<E> latest = new SLLNode<E>(x, null);
////        if (rear != null) {
////            rear.succ = latest;
////            rear = latest;
////        } else
////            front = rear = latest;
////        length++;
////    }
////
////    public E dequeue () {
////        // Go otstranuva i vrakja pochetniot element na redicata.
////        if (front != null) {
////            E frontmost = front.element;
////            front = front.succ;
////            if (front == null)  rear = null;
////            length--;
////            return frontmost;
////        } else
////            throw new NoSuchElementException();
////    }
////
////}
////
////
////
////interface Stack<E> {
////    // Elementi na stekot se objekti od proizvolen tip.
////    // Metodi za pristap:
////
////    public boolean isEmpty();
////    // Vrakja true ako i samo ako stekot e prazen.
////
////    public E peek();
////    // Go vrakja elementot na vrvot od stekot.
////
////    // Metodi za transformacija:
////    public void clear();
////    // Go prazni stekot.
////
////    public void push(E x);
////    // Go dodava x na vrvot na stekot.
////
////    public E pop();
////    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
////
////    public int size();
////    // Ja vrakja dolzinata na stekot.
////}
////public class Main {
////    public static void main(String[] args) {
//////        Scanner sc = new Scanner(System.in);
//////
//////        LinkedQueue<String> vip = new LinkedQueue<>();
//////        LinkedQueue<String> reg = new LinkedQueue<>();
//////
//////        int n = Integer.parseInt(sc.nextLine());
//////                  sc.next();
//////
//////        for(int i=0; i<n; i++){
//////            String komandi = sc.nextLine();
//////            String[] delovi = komandi.split(" ");
//////
//////            if(delovi[0].equals("arrive")){
//////                if(delovi[2].equals("VIP")){
//////                    vip.enqueue(delovi[1]);
//////                }else{
//////                    reg.enqueue(delovi[1]);
//////                }
//////            }
//////
//////            if(delovi[0].equals("status")){
//////                LinkedQueue<String> vip_temp = new LinkedQueue<>();
//////                LinkedQueue<String> reg_temp = new LinkedQueue<>();
//////
//////                if(vip.isEmpty() && reg.isEmpty()){
//////                    System.out.println("Waiting order: empty");
//////                    continue;
//////                }
//////
//////                while(!vip.isEmpty()) {
//////                    System.out.println(vip.peek());
//////                    vip_temp.enqueue(vip.dequeue());
//////                }
//////                vip = vip_temp;
//////                while(!reg.isEmpty()) {
//////                    System.out.println(reg.peek());
//////                    reg_temp.enqueue(reg.dequeue());
//////                }
//////                reg = reg_temp;
//////            }
//////
//////            if(delovi[0].equals("serve")){
//////                if(!vip.isEmpty()) {
//////                    vip.dequeue();
//////                }else if(!reg.isEmpty()) {
//////                    reg.dequeue();
//////                }
//////            }
//////        }
////
//////        Scanner scanner = new Scanner(System.in);
//////
//////        LinkedQueue<String> redica = new LinkedQueue<>();
//////        LinkedStack<String> stek = new LinkedStack<>();
//////
//////        int n = scanner.nextInt();
//////        int t = scanner.nextInt();
//////        int m = scanner.nextInt();
//////        scanner.nextLine();
//////
//////
//////        for (int i = 0; i < n; i++) {
//////            String linija = scanner.nextLine();
//////            redica.enqueue(linija);
//////        }
//////
//////
//////        int brkrug = 0;
//////        int redenbr = 1;
//////        //baranje 1 i 2
//////
//////        while (!redica.isEmpty()) {
//////            String element = redica.dequeue();
//////            String[] delovi = element.split(" ");
//////            String ime = delovi[0];
//////            int broj = Integer.parseInt(delovi[1]);
//////            brkrug++;
//////            if (broj > t) {
//////                broj = broj - t;
//////                stek.push(ime + " " + broj);
//////
//////                //baranje 3
//////            } else {
//////                System.out.println(redenbr + " " + delovi[0]);
//////                redenbr++;
//////            }
//////
//////
//////            //baranje 4
//////
//////              if(brkrug % m == 0 && !stek.isEmpty()){
//////                  while(!stek.isEmpty()){
//////                      redica.enqueue(stek.pop());
//////                  }
//////               }
//////        }
//////        while (!stek.isEmpty()){
//////            redica.enqueue(stek.pop());
//////        }
//////
//////    }
//////}
////
//////        Scanner scanner = new Scanner(System.in);
//////
//////        LinkedQueue<String> redica = new LinkedQueue<>();
//////        LinkedStack<String> stek = new LinkedStack<>();
//////
//////        int n = scanner.nextInt();
//////        int t = scanner.nextInt();
//////        int k = scanner.nextInt();
//////        scanner.nextLine();
//////
//////        for (int i = 0; i < n; i++) {
//////            String linija = scanner.nextLine();
//////            redica.enqueue(linija);
//////        }
//////
//////        int brkrug = 0;
//////        int br = 1;
//////
//////        while (!redica.isEmpty()) {
//////            String element = redica.dequeue();
//////            String[] delovi = element.split(" ");
//////
//////            String ime = delovi[0];
//////            int vreme = Integer.parseInt(delovi[1]);
//////            brkrug++;
//////            if (vreme > t) {
//////                vreme = vreme - t;
//////                stek.push(ime + " " + vreme);
//////            }else{
//////                System.out.println(br + " " + ime);
//////                br++;
//////            }
//////
//////
//////            if(brkrug % k == 0){
//////                while(!stek.isEmpty()){
//////                    redica.enqueue(stek.pop());
//////                }
//////            }
//////
//////        }
//////
//////            while(!stek.isEmpty()){
//////            redica.enqueue(stek.pop());
//////        }
//////
//////    }
//////}
//////
//////
//////
//////        Scanner scanner = new Scanner(System.in);
//////
//////        LinkedQueue<String> lista = new LinkedQueue<>();
//////        LinkedStack<String> stek = new LinkedStack<>();
//////
//////
//////        int n = scanner.nextInt();
//////        int t = scanner.nextInt();
//////
//////        scanner.nextLine();
//////
//////        for (int i = 0; i < n; i++) {
//////            String red = scanner.nextLine();
//////            lista.enqueue(red);
//////        }
//////
//////        int br = 1;
//////        int brkrug = 0;
//////
//////        while (!lista.isEmpty()) {
//////            String element = lista.dequeue();
//////            String[] podelena = element.split(" ");
//////
//////            String ime = podelena[0];
//////            int vreme = Integer.parseInt(podelena[1]);
//////            brkrug++;
//////
//////            if(vreme > t){
//////                vreme = vreme - t;
//////                stek.push(ime + " " + vreme);
//////            }else{
//////                System.out.println(br + " " + ime);
//////                br++;
//////            }
//////
//////            if(lista.isEmpty()){
//////                while(!stek.isEmpty()){
//////                    lista.enqueue(stek.pop());
//////                }
//////            }
//////        }
//////    }
//////}
//////
//////
//////
//////        interface Queue<E> {
//////            boolean isEmpty();
//////            int size();
//////            E peek();
//////            void clear();
//////            void enqueue(E x);
//////            E dequeue();
//////        }
//////
//////        class SLLNode<E> {
//////            protected E element;
//////            protected SLLNode<E> succ;
//////
//////            public SLLNode(E elem, SLLNode<E> succ) {
//////                this.element = elem;
//////                this.succ = succ;
//////            }
//////
//////            @Override
//////            public String toString() {
//////                return element.toString();
//////            }
//////        }
//////
//////        class LinkedQueue<E> implements Queue<E> {
//////
//////            SLLNode<E> front, rear;
//////            int length;
//////
//////            public LinkedQueue() {
//////                clear();
//////            }
//////
//////            public boolean isEmpty() {
//////                return (length == 0);
//////            }
//////
//////            public int size() {
//////                return length;
//////            }
//////
//////            public E peek() {
//////                if (front == null)
//////                    throw new NoSuchElementException();
//////                return front.element;
//////            }
//////
//////            public void clear() {
//////                front = rear = null;
//////                length = 0;
//////            }
//////
//////            public void enqueue(E x) {
//////                SLLNode<E> latest = new SLLNode<E>(x, null);
//////                if (rear != null) {
//////                    rear.succ = latest;
//////                    rear = latest;
//////                } else
//////                    front = rear = latest;
//////                length++;
//////            }
//////
//////            public E dequeue() {
//////                if (front != null) {
//////                    E frontmost = front.element;
//////                    front = front.succ;
//////                    if (front == null) rear = null;
//////                    length--;
//////                    return frontmost;
//////                } else
//////                    throw new NoSuchElementException();
//////            }
//////        }
//////
//////
//////                Scanner scanner = new Scanner(System.in);
//////                int n = scanner.nextInt();
//////                int t = scanner.nextInt();
//////                Queue<String> iminja = new LinkedQueue<>();
//////                Queue<Integer> vreminja = new LinkedQueue<>();
//////
//////                for (int i = 0; i < n; i++) {
//////                    iminja.enqueue(scanner.next());
//////                    vreminja.enqueue(scanner.nextInt());
//////                }
//////                int order = 1;
//////                while (!iminja.isEmpty()) {
//////                    String ime = iminja.dequeue();
//////                    int vreme = vreminja.dequeue();
//////                    if (vreme > t) {
//////                        vreme = vreme - t;
//////                        iminja.enqueue(ime);
//////                        vreminja.enqueue(vreme);
//////                    } else {
//////                        System.out.println(order + ". " + ime);
//////                        order++;
//////                    }
//////                }
//////            }
//////        }
//////
//////
//////
//////
////
//
// class SLL<E> {
//    private SLLNode<E> first;
//
//    public SLL() {
//        // Construct an empty SLL
//        this.first = null;
//    }
//
//    public void deleteList() {
//        first = null;
//    }
//
//    public int size() {
//        int listSize = 0;
//        SLLNode<E> tmp = first;
//        while(tmp != null) {
//            listSize++;
//            tmp = tmp.succ;
//        }
//        return listSize;
//    }
//
//    @Override
//    public String toString() {
//        String ret = new String();
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            ret += tmp.element;
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret += "," + tmp.element;
//            }
//        } else
//            ret = "Prazna lista!!!";
//        return ret;
//    }
//
//    public void insertFirst(E o) {
//        SLLNode<E> ins = new SLLNode<E>(o, null);
//        ins.succ = first;
//        //SLLNode<E> ins = new SLLNode<E>(o, first);
//        first = ins;
//    }
//
//    public void insertAfter(E o, SLLNode<E> node) {
//        if (node != null) {
//            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
//            node.succ = ins;
//        } else {
//            System.out.println("Dadenot jazol e null");
//        }
//    }
//    public void insertBefore(E o, SLLNode<E> before) {
//
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            if(first==before){
//                this.insertFirst(o);
//                return;
//            }
//            //ako first!=before
//            while (tmp.succ != before && tmp.succ!=null)
//                tmp = tmp.succ;
//            if (tmp.succ == before) {
//                tmp.succ = new SLLNode<E>(o, before);;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//            }
//        } else {
//            System.out.println("Listata e prazna");
//        }
//    }
//
//    public void insertLast(E o) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while (tmp.succ != null)
//                tmp = tmp.succ;
//            tmp.succ = new SLLNode<E>(o, null);
//        } else {
//            insertFirst(o);
//        }
//    }
//
//    public E deleteFirst() {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            first = first.succ;
//            return tmp.element;
//        } else {
//            System.out.println("Listata e prazna");
//            return null;
//        }
//    }
//
//    public E delete(SLLNode<E> node) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            if(first == node) {
//                return this.deleteFirst();
//            }
//            while (tmp.succ != node && tmp.succ.succ != null)
//                tmp = tmp.succ;
//            if (tmp.succ == node) {
//                tmp.succ = tmp.succ.succ;
//                return node.element;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//                return null;
//            }
//        } else {
//            System.out.println("Listata e prazna");
//            return null;
//        }
//
//    }
//
//    public SLLNode<E> getFirst() {
//        return first;
//    }
//
//    public SLLNode<E> find(E o) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while (!tmp.element.equals(o) && tmp.succ != null)
//                tmp = tmp.succ;
//            if (tmp.element.equals(o)) {
//                return tmp;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//            }
//        } else {
//            System.out.println("Listata e prazna");
//        }
//        return null;
//    }
//
//    public void merge (SLL<E> in){
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while(tmp.succ != null)
//                tmp = tmp.succ;
//            tmp.succ = in.getFirst();
//        }
//        else{
//            first = in.getFirst();
//        }
//    }
//
//    public void mirror() {
//        if (first != null) {
//            //m=nextsucc, p=tmp,q=next
//            SLLNode<E> tmp = first;
//            SLLNode<E> newsucc = null;
//            SLLNode<E> next;
//
//            while(tmp != null){
//                next = tmp.succ;
//                tmp.succ = newsucc;
//                newsucc = tmp;
//                tmp = next;
//            }
//            first = newsucc;
//        }
//    }
//}
//
//class SLLNode<E> {
//    protected E element;
//    protected SLLNode<E> succ;
//
//    public SLLNode(E elem, SLLNode<E> succ) {
//        this.element = elem;
//        this.succ = succ;
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        SLL<Integer> lista = new SLL<>();
//        int n = scanner.nextInt();
//        int suma = 0;
//
//        for (int i = 0; i < n; i++) {
//            int element = scanner.nextInt();
//            lista.insertLast(element);
//            suma = suma + element;
//        }
//        System.out.println("{" + lista + "}");
//        SLLNode<Integer> tmp = lista.getFirst();
//        double rez = (double) suma / n;
//        while (tmp != null) {
//            SLLNode<Integer> sledenjazol = tmp.succ;
//            if (tmp.element < rez) {
//                lista.delete(tmp);
//                tmp = sledenjazol;
//            }
//            tmp = sledenjazol;
//        }
//        System.out.println("{" + lista + "}");
//    }
//}
//
//

 class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;
    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}



class DLL<E> {
    private DLLNode<E> first, last;

    public DLL() {
        // Construct an empty SLL
        this.first = null;
        this.last = null;
    }

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<E>(o, null, first);
        if (first == null)
            last = ins;
        else
            first.pred = ins;
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if (after == last) {
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null)
                last = null;
            return tmp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        } else
            return null;
    }

    public E delete(DLLNode<E> node) {
        if (node == first) {
            return deleteFirst();
        }
        if (node == last) {
            return deleteLast();
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;

    }

    public DLLNode<E> find(E o) {
        if (first != null) {
            DLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int getSize() {
        int listSize = 0;
        DLLNode<E> tmp = first;
        while(tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            DLLNode<E> tmp = first;
            ret += tmp.toString();
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public String toStringR() {
        String ret = new String();
        if (last != null) {
            DLLNode<E> tmp = last;
            ret += tmp.toString();
            while (tmp.pred != null) {
                tmp = tmp.pred;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {

        return last;
    }

    public void mirror() {

        DLLNode<E> tmp = null;
        DLLNode<E> current = first;
        last = first;
        while(current!=null) {
            tmp = current.pred;
            current.pred = current.succ;
            current.succ = tmp;
            current = current.pred;
        }

        if(tmp!=null && tmp.pred!=null) {
            first=tmp.pred;
        }
    }

    public void merge(DLL<E> in) {
        if (in.first == null) return;
        if (first == null) {
            first = in.first;
            last = in.last;
        } else {
            last.succ = in.first;
            in.first.pred = last;
            last = in.last;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DLL<Integer> lista = new DLL<>();
        DLL<Integer> lista2 = new DLL<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            lista.insertLast(scanner.nextInt());
        }

        int k = scanner.nextInt();
        System.out.println(lista);
        DLLNode<Integer> curr = lista.getFirst();
        for (int i = 0; i < k; i++) {
            DLLNode<Integer> sleden = curr.succ;
            lista2.insertLast(curr.element);
            lista.delete(curr);
            curr = sleden;

        }
        lista.merge(lista2);
        System.out.println(lista);
    }
}
