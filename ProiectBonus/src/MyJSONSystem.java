//import java.io.*;
//
//public class MyJSONSystem {
//
//    private static MyJSON_Array jsonArr = new MyJSON_Array();
//
//    public static void main(String[] args) {
//
//        System.out.println("Enter the names of the 3 files (JSON file, input file, result file)");
//        try (BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
//             BufferedReader jsonFile = new BufferedReader(new FileReader(fileName.readLine()));
//             BufferedReader jinputFile = new BufferedReader(new FileReader(fileName.readLine()));
//             BufferedWriter outputFile = new BufferedWriter(new FileWriter(fileName.readLine()))
//        ) {
//            MyJSONSystem.readJsonFile(jsonFile);
//
//            String line = null;
//            while ((line = jinputFile.readLine()) != null) {
//                String[] arr = null;
//                if (line.startsWith("GET")) {
//                    arr = MyJSONSystem.splitElements(line);
//                    outputFile.write(MyJSONSystem.get(arr) + "\n");
//                } else if (line.startsWith("PUT")) {
//                    arr = MyJSONSystem.splitElements(line);
//                    MyJSONSystem.put(arr);
//                } else if (line.startsWith("DEL")) {
//                    arr = MyJSONSystem.splitElements(line);
//                    MyJSONSystem.del(arr);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // method creates a JSON_Array by reading data from a JSON file
//    private static void readJsonFile(BufferedReader jsonFile) throws IOException {
//        jsonFile.readLine();
//        String line = jsonFile.readLine();
//        while (line != null && !(line.trim()).equals("]")) {
//            MyJSON_Object jsonObj = new MyJSON_Object();
//            line = jsonFile.readLine();
//            while (line != null && !(line.trim()).equals("},") && !(line.trim()).equals("}")) {
//                String[] arr = line.split(":");
//                String key = arr[0];
//                String value = arr[1];
//                for (int i = 2; i < arr.length; i++) {
//                    value += ":" + arr[i];
//                }
//                key = key.trim();
//                value = value.trim();
//                if (value.charAt(value.length() - 1) == ',') {
//                    value = value.substring(0, value.length() - 1);
//                }
//                jsonObj.put(key, value);
//                line = jsonFile.readLine();
//            }
//            MyJSONSystem.jsonArr.add(jsonObj);
//            line = jsonFile.readLine();
//        }
//    }
//
//    // method returns the value of the last key in the key sequence
//    private static Object get(String[] arr) {
//        Object result = MyJSONSystem.getJSONObject(arr);
//        for (int i = 1; i < arr.length; i++) {
//            if (!(result instanceof MyJSON_Object)) {
//                return "ERROR_NOT_OBJECT";
//            }
//            result = ((MyJSON_Object) result).get(arr[i]);
//        }
//        return result;
//    }
//
//    // the method adds/modifies the last key-value pair
//    private static Object put(String[] arr) {
//        Object result = MyJSONSystem.getJSONObject(arr);
//        for (int i = 1; i < arr.length - 2; i++) {
//            result = ((MyJSON_Object) result).get(arr[i]);
//        }
//        String key = arr[arr.length - 2];
//        Object value = arr[arr.length - 1];
//        return ((MyJSON_Object) result).put(key, value);
//    }
//
//    // method removes the last key-value pair
//    private static Object del(String[] arr) {
//        Object result = MyJSONSystem.getJSONObject(arr);
//        for (int i = 1; i < arr.length; i++) {
//            result = ((MyJSON_Object) result).get(arr[i]);
//        }
//        String key = arr[arr.length - 1];
//        return ((MyJSON_Object) result).del(key);
//    }
//
//    // method splits each line of a queryFile and removes the first word(command)
//    private static String[] splitElements(String line) {
//        String[] arr = null;
//        StringBuilder sb = new StringBuilder(line);
//        sb.delete(0, 3);
//        arr = sb.toString().trim().split(" \"");
//        for (int i = 1; i < arr.length; i++) {
//            arr[i] = "\"" + arr[i];
//        }
//        return arr;
//    }
//
//    // method returns a JSON_Object from a required position in the JSON_Array
//    private static Object getJSONObject(String[] arr) {
//        int arrayIndex = Integer.parseInt(arr[0]);
//        if (arrayIndex >= MyJSONSystem.jsonArr.getList().size()) {
//            return "ERROR_INDEX_OUT_OF_RANGE";
//        }
//        return MyJSONSystem.jsonArr.getList().get(arrayIndex);
//    }
//
//}
