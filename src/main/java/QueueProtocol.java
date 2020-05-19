public interface QueueProtocol {
    public boolean add(Object e);
    public boolean remove(Object e);
    public boolean pop(Object e);
    public int size();
}
