// Heroes
// Извор: Discord → ФИНКИ Хаб → АПС, ПАПС → #материјали · Ace, 16.06.2022, 09:52 („1kol“, vleznaZadacha.png)

// Во една игра со карти се користат специјални карти, т.ш. за секоја карта се важни податоците за: id на херојот на картата (int id), моќта на херојот (int power), како и бројот на напади кои тој може да ги направи (int numAttacks).

// Така, за секоја една карта може да се пресмета колку таа карта е значајна, според тоа колку штета може да нанесе херојот на картата, односно како производ на моќта на херојот и бројот на напади кои може да ги направи.

// Двајца пријатели решаваат да ја играат оваа игра, т.ш. во две еднострано поврзани листи се чуваат податоците за картите кои им се доделени. Во првата листа се чуваат картите доделени на првиот пријател, а во втората податоците за картите доделени на вториот пријател. И двајцата играчи на почеток имаат точно 6 карти.

// На самиот почеток на играта, правилата налагаат првиот играч да ја предаде својата најдобра карта на другиот играч, т.ш. кога вториот играч ќе ја земе картата, истата треба да ја постави во средина на своите карти. Тоа значи дека потребно е од листата која ги чува картите на првиот пријател да се отстрани (избрише) најдобрата карта и таа карта да се додаде на средина на листата каде што се чуваат картите на вториот пријател.

// Влез
// Во секој ред се дадени податоци за една карта, одделени со празно место, во формат id power numAttacks. Прво се дадени картите на првиот пријател, по што следуваат картите на вториот пријател.

// Излез
// Во првиот ред id на сите карти на првиот пријател. Во вториот ред id на сите карти на вториот пријател.

// Внимавајте
// Даден е целосниот код на структурата и тест класата Heroes.java, со целосно имплементиран input и output. Се менува само функцијата void startHeroesGame(SLL<Card> firstFriendCards, SLL<Card> secondFriendCards).
// Бришењето треба да биде бришење на цел јазол, а додавањето додавање на цел јазол. Промените не треба да се однесуваат на информациите во самите јазли, туку на врските помеѓу јазлите.
// Не смее да менувате во main функцијата!
// Пример
// 84 44 87
// 79 9 67
// 26 2 81
// 57 91 59
// 45 92 8
// 55 97 80
// 10 99 4
// 13 84 28
// 64 6 90
// 93 57 23
// 14 49 36
// 50 65 12
// 84 79 26 57 45
// 10 13 64 55 93 14 50


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
      
      // VASIOT KOD TUKA!
      // YOUR CODE HERE!
        SLL<Integer> lista1 = new SLL<>();
        SLL<Integer> lista2 = new SLL<>();

        for (int i = 0; i < 6; i++) {
            int id = scanner.nextInt();
            int moknost = scanner.nextInt();
            int brnapaganja = scanner.nextInt();

            lista1.insertLast(id);
            lista1.insertLast(moknost);
            lista1.insertLast(brnapaganja);

        }


        for (int j = 0; j < 6; j++) {
            int id1 = scanner.nextInt();
            int moknost1 = scanner.nextInt();
            int brnapaganja1 = scanner.nextInt();


            lista2.insertLast(id1);
            lista2.insertLast(moknost1);
            lista2.insertLast(brnapaganja1);
        }


        SLLNode<Integer> curr = lista1.getFirst();
        int najgolmrez = -1;
        SLLNode<Integer> najdobaridnod = null;
        SLLNode<Integer> najdobarmoknod = null;
        SLLNode<Integer> najdobarnapadnod = null;

        while (curr != null) {
            SLLNode<Integer> idNode = curr;
            SLLNode<Integer> mokNode = curr.succ;
            SLLNode<Integer> napNode = curr.succ.succ;

            int pomnozeno = mokNode.element * napNode.element;

            if (pomnozeno > najgolmrez) {
                najgolmrez = pomnozeno;
                najdobaridnod = idNode;
                najdobarmoknod = mokNode;
                najdobarnapadnod = napNode;
            }

            curr = curr.succ.succ.succ;
        }
        int najjakid = najdobaridnod.element;
        int najakamok = najdobarmoknod.element;
        int najakonapaganje = najdobarnapadnod.element;

        lista1.delete(najdobaridnod);
        lista1.delete(najdobarmoknod);
        lista1.delete(najdobarnapadnod);


        int size2 = lista2.size();
        int sredenelement = (size2 / 2) - 1;
        SLLNode<Integer> el = lista2.getFirst();
        for (int i = 0; i < sredenelement && el != null; i++) {
            el = el.succ;
        }
            lista2.insertAfter(najakonapaganje, el);
            lista2.insertAfter(najakamok, el);
            lista2.insertAfter(najjakid, el);

        SLLNode<Integer> p1 = lista1.getFirst();
        while (p1 != null) {
            System.out.print(p1.element + " ");
            p1 = p1.succ.succ.succ;
        }
        System.out.println();

        SLLNode<Integer> p2 = lista2.getFirst();
        while (p2 != null) {
            System.out.print(p2.element + " ");
            p2 = p2.succ.succ.succ;
        }
        System.out.println();
    }
}


  
