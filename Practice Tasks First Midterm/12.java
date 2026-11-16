// DeleteLastOccurrence
// Извор: Discord → ФИНКИ Хаб → АПС, ПАПС → #материјали · yourserbiangirl, 10.06.2021, 10:52 (message_4.txt)

// Дадена е еднострана поврзана листа и елемент кој треба да се избрише. Ваша задача е да го избришете последното појавување на елементот. Листата може да содржи дупликати. Дозволено е користење на ЕДНА поврзана листа.

// Забелешка: Даден е целосниот код на структурата која што треба да се користи. Потребно е да се направат дополнувања во main функцијата и да се имплементира функцијата void deleteDuplicates(SLL list1, int key). Притоа, бришењето треба да биде имплементирано како бришење на цел јазел. Промените не треба да се однесуваат на информациите во самите јазли, туку на врските помеѓу јазлите.

// Влез
// Во првиот ред е бројот на елементи N, во вториот ред елементите, во третиот ред елементот key кој треба да се избрише.

// Примери
// 6
// 1 2 3 5 2 10
// 2
// 1 2 3 5 10
// 10
// 9 3 3 8 6 2 9 3 5 9
// 3
// 9 3 3 8 6 2 9 5 9


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
             Integer el = scanner.nextInt();
             lista.insertLast(el);
         }
         int k = scanner.nextInt();
         SLLNode<Integer> curr = lista.getFirst();
         SLLNode<Integer> posleden = null;
         while(curr != null){
             if(curr.element.equals(k)){
                 posleden = curr;
             }
             curr = curr.succ;
         }

         lista.delete(posleden);
         System.out.println(lista);
     }
 }
