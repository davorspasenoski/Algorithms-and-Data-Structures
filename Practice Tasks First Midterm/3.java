// 1. Прв максимум и последен минимум
// Најди го првото појавување на најголемиот елемент и последното појавување на најмалиот. Испечати ги елементите и нивните позиции (од 1), па замени им ги местата и испечати ја листата.

// Влез: 7
// 3 9 2 5 9 2 6
// Излез:
// 9 2
// 2 6
// 3<->2<->2<->5<->9<->9<->6



import java.util.Scanner;
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

    public boolean palindrom(){

        DLLNode<E> levo= this.getFirst();
        DLLNode<E> desno= this.getLast();

        while(levo!=desno && desno.succ!=levo){

            if(!levo.element.equals(desno.element)){  //ako se razlicni
                return false;  //vrati false, ne e palindrom
            }

            levo=levo.succ;
            desno=desno.pred;

        }

        return true;

    }

    public void mirror1(){

        DLLNode<E> previous=null;
        DLLNode<E> current=this.first;
        DLLNode<E> next=current.succ;
        last=first;

        while(current!=null){
            current.succ=previous; //prevrtuvanje na node
            current.pred=next;

            //tri cekori za pridvizuvanje kon napred
            previous=current;
            current=next;

            if(next!=null){
                next=next.succ;
            } else {
                first=previous;

            }

        }
    }
}
public class Main {
    public static void main(String args[]){

        Scanner in = new Scanner(System.in);

        int n=in.nextInt();
        DLL<Integer> lista= new DLL<Integer>();

        for(int i=0;i<n;i++){

            int br=in.nextInt();

            lista.insertLast(br);
        }

// Vasheto reshenie treba da bide implementirano tuka.
// Ne go menuvaj ostanatiod kod!

// Your solution should be implemented here
// Do not change the rest of the code!

        DLLNode<Integer> curr = lista.getFirst();

        int min = 10000;
        int max = 0;

        while(curr != null){
            if(curr.element > max){
                max = curr.element;
            }
            if(curr.element < min){
                min = curr.element;
            }
            curr = curr.succ;
        }

        DLLNode<Integer> curr1 = lista.getFirst();
        int br = 1;
        while(curr1!= null){
            if(curr1.element == max){
                System.out.println(max + " " + br);
                break;
            }
            br++;
            curr1 = curr1.succ;
        }

        DLLNode<Integer> curr2 = lista.getLast();
        int br2 = lista.getSize();
        while(curr2!= null){
            if(curr2.element == min){
                System.out.println(min + " " + br2);
                break;
            }
            br2--;
            curr2 = curr2.pred;
        }
        int tmp = curr1.element;
        curr1.element = curr2.element;
        curr2.element = tmp;

        System.out.println(lista);
    }

}
