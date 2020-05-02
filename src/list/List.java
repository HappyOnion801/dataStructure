package list;

/**
 * @ Author: MaCode
 * @ Date: 2020-05-02
 * @ Github: HappyOnion801
 */
public interface List {
    void add(Integer date);

    boolean add(int index, Integer date);

    boolean delete(int index);

    boolean set(int index, Integer date);

    Integer get(int index);

    Integer getLast(int index);

    int size();
}
