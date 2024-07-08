import com.company.constant.Policy;
import com.company.service.cacheService;

public class Main {
    public static void main(String[] args) {

        cacheService cache= cacheService.getInstance();
        cache.init(10,Policy.LRU.toString());
        cache.put(1,"kumawat");
        cache.put(2,"srijan");
        cache.put(3,"synder");
        cache.put(2,"rhythum");

//        cache.delete(3);
        cache.clear();
        cache.delete(2);
        System.out.println(cache.get(2));


    }
}