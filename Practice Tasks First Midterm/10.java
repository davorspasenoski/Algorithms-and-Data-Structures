// ZigZag
// Извор: Discord → ФИНКИ Хаб → АПС, ПАПС → #материјали · Stefan0101, 19.01.2024, 16:51 (termin1.png)

// Дадена е еднострано поврзана листа од цели броеви. Истата треба да се трансформира за да ги задоволува условите да биде цик-цак секвенца. Односно, после секој позитивен број да следува негативен и обратно, и не треба да содржи нули. Ова треба да се направи со тоа што ќе се измени листата и за секој пар од последователни елементи ќе се направи следното:

// Доколку и двата елементи се позитивни, се брише вториот.
// Доколку и двата елементи се негативни, меѓу нив се вметнува нов елемент со вредност што ќе биде апсолутната вредност на првиот.
// Доколку било кој од елементите е 0, се брише истиот (доколку и 2та се 0, треба да се избришат и 2та елементи).
// Забелешка 1: Празна листа или листа од само 1 елемент сама по себе е цик-цак секвенца.

// Забелешка 2: Не треба да менувате во main функцијата, туку само во void makeZigZag(SLL<Integer> list).

// Влез
// Во првата линија е даден бројот на елементи во оригиналната листа, а потоа во следната линија се дадени самите елементи одделени со празно место.

// Излез
// Прво се печати оригиналната листа, па потоа трансформираната цик-цак листа.

// Пример
// 8
// 4 -3 -6 0 7 7 -2 5
// 4 -> -3 -> -6 -> 0 -> 7 -> 7 -> -2 -> 5
// 4 -> -3 -> 3 -> -6 -> 7 -> -2 -> 5


 import java.util.Scanner;


class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
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
            if(first==before){
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before && tmp.succ!=null)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                tmp.succ = new SLLNode<E>(o, before);;
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
            if(first == node) {
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

    public void merge (SLL<E> in){
        if (first != null) {
            SLLNode<E> tmp = first;
            while(tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        }
        else{
            first = in.getFirst();
        }
    }

    public void mirror() {
        if (first != null) {
            //m=nextsucc, p=tmp,q=next
            SLLNode<E> tmp = first;
            SLLNode<E> newsucc = null;
            SLLNode<E> next;

            while(tmp != null){
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
     static void main(String args[]) {
         Scanner scanner = new Scanner(System.in);

         SLL<Integer> lista = new SLL<>();

         int n = scanner.nextInt();

         for(int i = 0; i < n;i++){
             int el = scanner.nextInt();
             lista.insertLast(el);
         }

         System.out.println(lista);

         SLLNode<Integer> curr = lista.getFirst();

         while (curr != null && curr.succ!= null){
             if(curr.element > 0 && curr.succ.element > 0){
                 lista.delete(curr.succ);
             }else if(curr.element < 0 && curr.succ.element < 0){
                 lista.insertAfter(Math.abs(curr.element),curr);

             }else if(curr.element == 0 && curr.succ.element == 0) {
                 lista.delete(curr);
                 lista.delete(curr.succ);

             }else if(curr.element == 0){
                 lista.delete(curr);

             }else if(curr.succ.element == 0){
                 lista.delete(curr.succ);
             }
             curr = curr.succ;

         }
         System.out.println(lista);

     }
 }
