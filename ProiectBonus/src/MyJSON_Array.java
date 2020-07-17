//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class MyJSON_Array {
//
//    private List<MyJSON_Object> list;
//
//    public MyJSON_Array() {
//        this.list = new ArrayList<>();
//    }
//
//    public void add(MyJSON_Object obj) {
//        this.list.add(obj);
//    }
//
//    public List<MyJSON_Object> getList() {
//        return this.list;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (!(o instanceof MyJSON_Array)) {
//            return false;
//        }
//        MyJSON_Array that = (MyJSON_Array) o;
//        return Objects.equals(this.list, that.list);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(this.list);
//    }
//
//    @Override
//    public String toString() {
//        return "JSON_Array";
//    }
//}
