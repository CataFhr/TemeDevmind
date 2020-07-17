import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.Arrays;

public class JSONSystem {

    private static JSONArray jsonArr;

    public static void main(String[] args) {

        System.out.println("Enter the names of the 3 files (JSON file, input file, result file)");
        try (BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader jsonFile = new BufferedReader(new FileReader(fileName.readLine()));
             BufferedReader jinputFile = new BufferedReader(new FileReader(fileName.readLine()));
             BufferedWriter outputFile = new BufferedWriter(new FileWriter(fileName.readLine()))
        ) {

            String data = JSONSystem.readJsonFile(jsonFile);
            JSONSystem.jsonArr = new JSONArray(data);

            String line = null;
            while ((line = jinputFile.readLine()) != null) {
                String[] arr = null;
                if (line.startsWith("GET")) {
                    arr = JSONSystem.splitElements(line);
                    Object obj = JSONSystem.get(arr);
                    if (obj instanceof JSONArray) {
                        outputFile.write("JSON_ARRAY" + "\n");
                    } else if (obj instanceof JSONObject) {
                        outputFile.write("JSON_OBJECT" + "\n");
                    } else {
                        outputFile.write(obj + "\n");
                    }
                } else if (line.startsWith("PUT")) {
                    arr = JSONSystem.splitElements(line);
                    Object obj = JSONSystem.put(arr);
                    if (obj != null && obj.equals("ERROR")) {
                        outputFile.write("PUT_ERROR" + "\n");
                    }
                } else if (line.startsWith("DEL")) {
                    arr = JSONSystem.splitElements(line);
                    Object obj = JSONSystem.del(arr);
                    if (obj != null && obj.equals("ERROR")) {
                        outputFile.write("DEL_ERROR" + "\n");
                    }
                }
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    // method reads data from a file
    private static String readJsonFile(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line.trim());
        }
        return sb.toString();
    }

    // method splits each line of a queryFile and removes the first word(command)
    private static String[] splitElements(String line) {
        StringBuilder sb = new StringBuilder(line);
        sb.delete(0, 3);
        String[] result = JSONSystem.insertDelimiter(sb.toString()).split("/@/");
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i].replaceAll("\"", "");
        }
        return result;
    }

    // method inserts a delimiter between commands
    private static String insertDelimiter(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.trim().split("\\s+");
        sb.append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (JSONSystem.isNumber(arr[i]) || arr[i].startsWith("\"") || arr[i].equals("null") || arr[i].equals("true") || arr[i].equals("false")) {
                sb.append("/@/").append(arr[i]);
            } else {
                sb.append(" " + arr[i]);
            }
        }
        return sb.toString();
    }

    // method returns the value of the last key in the key sequence
    private static Object get(String[] cmd) throws JSONException {
        Object result = JSONSystem.jsonArr;
        for (int i = 0; i < cmd.length; i++) {
            if (JSONSystem.isNumber(cmd[i])) {
                if (!(result instanceof JSONArray)) {
                    return "GET_ERROR_NOT_ARRAY";
                } else {
                    int index = Integer.parseInt(cmd[i]);
                    if (index >= ((JSONArray) result).length()) {
                        return "GET_ERROR_INDEX_OUT_OF_RANGE";
                    }
                    result = ((JSONArray) result).getJSONObject(index);
                }
            } else {
                if (!(result instanceof JSONObject)) {
                    return "GET_ERROR_NOT_OBJECT";
                } else {
                    if (!((JSONObject) result).has(cmd[i])) {
                        return "GET_KEY_NOT_FOUND " + "\"" + cmd[i] + "\"";
                    }
                    result = ((JSONObject) result).get(cmd[i]);
                }
            }
        }
        if (result instanceof String) {
            return "\"" + result + "\"";
        }
        return result;
    }

    // the method adds/modifies the last key-value pair
    private static Object put(String[] cmd) throws JSONException {
        Object result = JSONSystem.get(Arrays.copyOf(cmd, cmd.length - 2));
        if (result instanceof JSONObject) {
            String key = cmd[cmd.length - 2];
            Object value = cmd[cmd.length - 1];
            if (JSONSystem.isNumber(String.valueOf(value))) {
                value = Long.parseLong((String) (value));
            } else if (JSONSystem.isBoolean(String.valueOf(value))) {
                value = Boolean.parseBoolean((String) value);
            }
            return ((JSONObject) result).put(key, value);
        }
        return "ERROR";
    }

    // method removes the last key-value pair
    private static Object del(String[] cmd) throws JSONException {
        Object result = JSONSystem.get(Arrays.copyOf(cmd, cmd.length - 1));
        if (result instanceof JSONObject) {
            String key = cmd[cmd.length - 1];
            return ((JSONObject) result).remove(key);
        } else if (result instanceof JSONArray) {
            int key = Integer.parseInt(cmd[cmd.length - 1]);
            return ((JSONArray) result).remove(key);
        }
        return "ERROR";
    }

    private static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (char ch : s.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBoolean(String s) {
        return s.equals("true") || s.equals("false");
    }

}

