// Во една листа за чекање во административна служба, за секоја странка што чека се знае името и бројот на барања.
// Кога странката ќе дојде на ред (на почеток на листата), се решава само едно нејзино барање. Ако има уште барања, 
// странката оди на крајот на листата за да чека да биде услужена за новото барање. Напиши го редоследот по кој ќе бидат решени (завршени) сите барања на странките.  
  
// Пример влез: 
  
// Slave 2
// Nenad 1
// Martin 2
// Milan 3
// Jana 1

// Пример излез:
// Jana
// Slave
// Martin
// Milan

  
import java.util.Scanner;
import java.util.*;
import java.util.NoSuchElementException;

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

    SLLNode<E> front, rear;
    int length;

    public LinkedQueue() {
        clear();
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    @Override
    public boolean contains(Object o) { return false; }

    @Override
    public Iterator<E> iterator() { return null; }

    @Override
    public Object[] toArray() { return new Object[0]; }

    @Override
    public <T> T[] toArray(T[] a) { return null; }

    public int size() {
        return length;
    }

    @Override
    public boolean add(E e) {
        enqueue(e);
        return true;
    }

    @Override
    public boolean remove(Object o) { return false; }

    @Override
    public boolean containsAll(Collection<?> c) { return false; }

    @Override
    public boolean addAll(Collection<? extends E> c) { return false; }

    @Override
    public boolean removeAll(Collection<?> c) { return false; }

    @Override
    public boolean retainAll(Collection<?> c) { return false; }

    @Override
    public boolean offer(E e) {
        enqueue(e);
        return true;
    }

    @Override
    public E remove() {
        return dequeue();
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        return dequeue();
    }

    @Override
    public E element() {
        return peek();
    }

    public E peek() {
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear() {
        front = rear = null;
        length = 0;
    }

    public void enqueue(E x) {
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }
    public E dequeue() {
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
        LinkedQueue<String> lista = new LinkedQueue<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String ime = scanner.next();
            int vreme = scanner.nextInt();
            lista.enqueue(ime + " " + vreme);
        }
        while(!lista.isEmpty()){
            String element = lista.dequeue();
            String[] del = element.split(" ");
            String ime = del[0];
            int vreme = Integer.parseInt(del[1]);
            if (vreme > 0) {
                vreme = vreme - 1;
                lista.enqueue(ime + " " + vreme);
            } else {
                     System.out.println(ime);
            }
        }
    }
}
