package lb10_1;

interface DataStructure<T> {
    void add(T data);
    void remove(T data);
    Iterator<T> iterator();
}