//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//
//public class MyJSON_Object {
//
//    private Map<String, Object> map;
//
//    public MyJSON_Object() {
//        this.map = new HashMap<>();
//    }
//
//    public Map<String, Object> getMap() {
//        return this.map;
//    }
//
//    public Object put(String key, Object value) {
//        return this.map.put(key, value);
//    }
//
//    public Object get(String key) {
//        if (this.map.containsKey(key)) {
//            return this.map.get(key);
//        }
//        return "KEY_NOT_FOUND";
//    }
//
//    public Object del(String key) {
//        return this.map.remove(key);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (!(o instanceof MyJSON_Object)) {
//            return false;
//        }
//        MyJSON_Object that = (MyJSON_Object) o;
//        return Objects.equals(this.map, that.map);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(this.map);
//    }
//
//    @Override
//    public String toString() {
//        return "JSON_Object";
//    }
//}
