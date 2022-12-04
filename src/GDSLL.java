import java.util.Iterator;

/**
 * Geneic Doubly-linked Sorted Linked List <br>
 * it is sorted in increasing order from head to tail <br>
 * according to compareTo method applied to type T objects
 *
 * @param <T> generic type
 */
public class GDSLL<T extends Comparable<? super T>> implements IGDSLL<T>
{
    private class Node
    {
        private T info;
        private Node next;
        private Node prev;

        Node(T info)
        {
            this.info = info;
            next = null;
            prev = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    public Node getHead()
    {
        return head;
    }


    private Node locateGreatestPredecessor(T tgt)
    {
        Node curr = head;
        boolean emptyList = true;
        while (curr != null && curr.info.compareTo(tgt) < 0)
        {
            curr = curr.next;
            emptyList = false;
        }
        if (curr == null && !emptyList)
            curr = tail;
        else if (curr != null)
            curr = curr.prev;
        return curr;
    }

    @Override
    public void insert(T value)
    {
        Node newNode = new Node(value);
        Node predecessor = locateGreatestPredecessor(value);
        if (predecessor == null) // new head
        {
            if (head != null)
            {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            else
            {
                head = tail = newNode;
            }
        }
        else
        {
            newNode.next = predecessor.next;
            if (newNode.next != null)
            {
                newNode.next.prev = newNode;
            }
            else
            {
                tail = newNode;
            }
            newNode.prev = predecessor;
            predecessor.next = newNode;
        }

    }

    @Override
    public boolean remove(T value)
    {
        boolean removed = false;
        if (head != null)
        {
            Node pred = locateGreatestPredecessor(value);
            if (pred == null)
            {
                if (head.info.equals(value))
                {
                    head = head.next;
                    if (head != null)
                        head.prev = null;
                    removed = true;
                }
            }
            else
            {
                if (pred.next != null && pred.next.info.equals(value))
                {
                    if(pred.next == tail)
                    {
                        pred.next = null;
                        tail = pred;
                    }
                    else
                    {
                        pred.next = pred.next.next;
                        if (pred.next.next != null)
                        {
                            pred.next.next.prev = pred;
                        }
                    }
                    removed = true;
                }
            }
        }
        return removed;
    }

    @Override
    public boolean contains(T value)
    {
        return false;
    }

    @Override
    public boolean isEmpty()
    {
        return head == null;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder("->");
        Node curr = head;
        while (curr != null)
        {
            str.append(curr.info.toString() + "<->");
            curr = curr.next;
        }
        return str.toString();
    }

    public Iterator<T> ascIterator()
    {
        return new Iterator<>()
        {
            Node curr = head;

            @Override
            public boolean hasNext()
            {
                return curr != null;
            } // yes, this is somewhat of a misnomer

            @Override
            public T next()
            {
                T value = curr.info;
                curr = curr.next;
                return value;
            }
        };
    }
    public Iterator<T> desIterator()
    {
        return new Iterator<>()
        {
            Node curr = tail;

            @Override
            public boolean hasNext()
            {
                return curr != null;
            }

            @Override
            public T next()
            {
                T value = curr.info;
                curr = curr.prev;
                return value;
            }
        };
    }
}

