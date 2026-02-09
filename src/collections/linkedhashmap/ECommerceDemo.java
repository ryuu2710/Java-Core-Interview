package collections.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

class ProductHistoryCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public ProductHistoryCache(int initialCapacity) {
        super(initialCapacity, 0.75f, true);
        this.capacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > capacity;
    }
}

public class ECommerceDemo {
    public static void main(String[] args) {
        ProductHistoryCache<Integer, String> productHistory = new ProductHistoryCache<>(3);

        productHistory.put(1, "Iphone 15");
        productHistory.put(2, "Iphone 16");
        productHistory.put(3, "Iphone 17");

        System.out.println("Lần 1 (Vừa thêm 3 cái): " + productHistory);

        productHistory.get(1);
        System.out.println("Lần 2 (Vừa xem lại iPhone): " + productHistory);

        productHistory.put(4, "Iphone 18");
        productHistory.get(4);

        System.out.println("Lần 3 (Vừa xem lại iPhone): " + productHistory);
    }
}
