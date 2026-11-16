// Испит септември 2022 · влезна · SLL
// ListTransformation
// Извор: Discord → ФИНКИ Хаб → АПС, ПАПС → #материјали · AeroZ, 26.08.2022, 15:14 („Влезна Задача Септември“, 2022.png)

// Дадена е единечно поврзана листа од цели броеви. Да се напише функцијата listTransformation која ќе ја подели оригиналната листа во две нови листи. Со трансформацијата, од оригиналната листа се одделуваат парните елементи во една листа и непарните елементи во друга листа. Новодобиените листи треба да го задржат редоследот на елементите од оригиналната листа.

// Напомена: Да не се користи алокација на нова меморија. Трансформацијата да се прави преку промена на врските меѓу јазлите во листата. Не смеете да менувате во main функцијата!

// Влез
// Во првиот ред е бројот на елементи N, а во вториот се елементите на листата.

// Излез
// Во првиот ред непарната листа, во вториот парната листа.

// Пример
// 14
// 1 5 2 3 0 6 4 3 7 9 1 4 6 8
// 1 -> 5 -> 3 -> 3 -> 7 -> 9 -> 1
// 2 -> 0 -> 6 -> 4 -> 4 -> 6 -> 8
// Тест-примерите (Input.txt во истата порака) имаат по 2–90 броеви, вклучително листа само со парни и листа само со непарни.


import java.util.NoSuchElementException;
import java.util.Scanner;

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

class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int size() {
        int listSize = 0;
        SLLNode<E> tmp = first;
        while (tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp.element;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += "->" + tmp.element;
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, null);
        ins.succ = first;
        //SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == before) {
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                tmp.succ = new SLLNode<E>(o, before);
                ;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = new SLLNode<E>(o, null);
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
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

    public void merge(SLL<E> in) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        } else {
            first = in.getFirst();
        }
    }

    public void mirror() {
        if (first != null) {
            //m=nextsucc, p=tmp,q=next
            SLLNode<E> tmp = first;
            SLLNode<E> newsucc = null;
            SLLNode<E> next;

            while (tmp != null) {
                next = tmp.succ;
                tmp.succ = newsucc;
                newsucc = tmp;
                tmp = next;
            }
            first = newsucc;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SLL<Integer> lista = new SLL<>();
        SLL<Integer> listaParni = new SLL<>();
        SLL<Integer> listaNeparni = new SLL<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int br = scanner.nextInt();
            lista.insertLast(br);
        }

        SLLNode<Integer> curr = lista.getFirst();
        while (curr != null) {
            if (curr.element % 2 == 0) {
                listaParni.insertLast(curr.element);
                lista.delete(curr);
            }
            curr = curr.succ;
        }


        SLLNode<Integer> curr1 = lista.getFirst();
        while (curr1 != null) {
            if (curr1.element % 2 != 0) {
                listaNeparni.insertLast(curr1.element);
                lista.delete(curr1);
            }
            curr1 = curr1.succ;
        }


        System.out.println(listaNeparni);
        System.out.println(listaParni);
    }
}
