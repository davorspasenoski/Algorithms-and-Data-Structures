// PutWordsTogether
// Дадена е еднострано поврзана листа од стрингови, така што секој јазел содржи по еден карактер. Всушност, кога ќе се погледне цела листа, се забележуваат зборови, одделени со запирка. Треба да се трансформира листата така што секој збор ќе стане посебен јазел, и дополнително ќе се избришат запирките.

// Забелешка 1: После буквите од последниот збор нема запирка.

// Забелешка 2: Не треба да се менува main функцијата, туку само во void putWordsTogether(SLL<String> list).

// Влез
// Карактерите (елементите на првичната листа) одделени со празно место во една линија.

// Излез
// Прво се печати оригиналната листа со стрингови од по еден карактер, па трансформираната листа од споени зборови, без запирките.

// Пример
// c a t , d o g , c o w
// c->a->t->,->d->o->g->,->c->o->w
// cat -> dog -> cow



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

         SLL<String> lista = new SLL<>();

         if (scanner.hasNextLine()) {
             String line = scanner.nextLine();
             String[] parts = line.split(" ");
             for (String el : parts) {
                 if (!el.isEmpty()) {
                     lista.insertLast(el);
                 }
             }
         }

         System.out.println(lista);
         SLL<String> lista1 = new SLL<>();


         SLLNode<String> curr = lista.getFirst();

         String zbor = "";
         while (curr != null){
             String el = curr.element;
             if (!el.equals(",") && !el.equals(" ")) {
                 zbor = zbor +  el;
             } else {
                 if (!zbor.isEmpty()) {
                     lista1.insertLast(zbor);
                     zbor = "";
                 }
             }
             curr = curr.succ;
         }
         if (!zbor.isEmpty()) {
             lista1.insertLast(zbor);
         }

         System.out.println(lista1);
     }
 }
