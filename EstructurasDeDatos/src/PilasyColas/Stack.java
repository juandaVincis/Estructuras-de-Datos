package PilasyColas;

/**
 * Created by ivanc on 26/08/2017.
 */
public interface Stack <T>{
    boolean isEmpty();
    T peek ();
    void push (T theObject);
    T pop();
}
