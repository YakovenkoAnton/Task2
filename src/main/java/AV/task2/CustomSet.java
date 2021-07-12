package AV.task2;

import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@Slf4j
public class CustomSet implements Set<String> {

    //public static Logger log = LoggerFactory.getLogger(CustomSet.class);

    public static final int DEFAULT_CAPACITY = 12;
    private String[] content = new String[DEFAULT_CAPACITY];
    private int size = 0;

    @Override
    public boolean add(String s) {
        log.info("Adding new element {}", s);
        if (contains(s)) return false;
        if (size >= content.length) {
            content = Arrays.copyOf(content, (size + 1) * 2);
        }
        content[size++] = s;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        try {
            find(o);
            return true;
        } catch (CustomSetObjectNotFoundException e) {
            return false;
        }
    }

    private int find(Object o) throws CustomSetObjectNotFoundException {
        for (int i = 0; i < size; i++) {
            if (o.equals(content[i])) return i;
        }
        throw new CustomSetObjectNotFoundException();
        //return -1;
    }


    @Override
    public boolean remove(Object o) {
        if (!contains(o)) return false;
        try {
            int findIndex = find(o);
            if (findIndex != content.length - 1) {
                for (int i = findIndex; i < size; i++) {
                    content[i] = content[i + 1];
                }
            }
            size--;
        } catch (CustomSetObjectNotFoundException ex) {
            //not possible situation
        }

        return true;
    }

    @Override
    public void clear() {
        //if (size==0) throw new
        content = new String[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<String> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
}
