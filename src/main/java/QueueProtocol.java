public interface QueueProtocol {
    public <E> boolean add(E e);
    public <E> boolean remove(E e);
    public <E> boolean pop(E e);
    public int size();
}
