import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CustomerManagement {
    Map<String, Customer> customerMap = null;

    public CustomerManagement() {
        customerMap = new HashMap<>();
    }

    public CustomerManagement(Map<String, Customer> customerMap) {
        this.customerMap = customerMap;
    }
    public void add(Customer customer) {
        customerMap.put(customer.getCusId(), customer);
    }
    public void display(){
        Set<String> setCusId = customerMap.keySet();
    }
}
