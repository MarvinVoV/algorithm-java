package algorithm.topics.unclassified;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author marvin
 * @version JsonCompare.java, v 0.1 2022/04/13 22:06 Exp $
 */
public class JsonCompare {

    public static void main(String[] args) {
        JSONObject left = new JSONObject();
        left.put("a", 1);
        JSONObject right = new JSONObject();
        right.put("a", 2);
        DiffResult diffResult = compareJson(left, right);
        System.out.println(diffResult.diffJson);
        System.out.println(diffResult.missingJson);
    }

    public static DiffResult compareJson(JSONObject left, JSONObject right) {
        Map<String, Object> leftMap = new HashMap<>();
        Map<String, Object> rightMap = new HashMap<>();

        Map<String, Object> diffMap = new HashMap<>();
        Map<String, Object> missingMap = new HashMap<>();

        convertJsonToMap(left, "", leftMap);
        convertJsonToMap(right, "", rightMap);
        diff(leftMap, rightMap, diffMap, missingMap);

        DiffResult diffResult = new DiffResult();
        if (diffMap.isEmpty() && missingMap.isEmpty()) {
            diffResult.success = true;
        } else {
            diffResult.success = false;
            if (!diffMap.isEmpty()) {
                diffResult.diffMap = diffMap;
                diffResult.diffJson = JSON.toJSONString(diffMap, SerializerFeature.WriteMapNullValue,
                        SerializerFeature.MapSortField);

            }
            if (!missingMap.isEmpty()) {
                diffResult.missingMap = missingMap;
                diffResult.missingJson = JSON.toJSONString(missingMap, SerializerFeature.WriteMapNullValue,
                        SerializerFeature.MapSortField);
            }
        }
        return diffResult;
    }

    public static class DiffResult {
        public boolean success;
        public Map<String, Object> diffMap;
        public Map<String, Object> missingMap;
        public String diffJson;
        public String missingJson;
    }

    public static void convertJsonToMap(JSON json, String root, Map<String, Object> resultMap) {
        if (json instanceof JSONObject) {
            JSONObject jsonObject = ((JSONObject) json);
            jsonObject.forEach((key, value) -> {
                String path = "".equals(root) ? key + "" : root + "." + key;
                if (value != null && JSON.class.isAssignableFrom(value.getClass())) {
                    convertJsonToMap((JSON) value, path, resultMap);
                } else {
                    resultMap.put(path, value);
                }
            });
        } else if (json instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) json;
            for (int i = 0; i < jsonArray.size(); i++) {
                Object value = jsonArray.get(i);
                String path = "".equals(root) ? "[" + i + "]" : root + ".[" + i + "]";
                if (value != null && JSON.class.isAssignableFrom(value.getClass())) {
                    convertJsonToMap((JSON) value, path, resultMap);
                } else {
                    resultMap.put(path, value);
                }
            }
        }
    }

    public static void diff(Map<String, Object> leftMap, Map<String, Object> rightMap, Map<String, Object> diffMap,
                            Map<String, Object> missingMap) {
        leftMap.forEach((key, leftVal) -> {
            if (rightMap.containsKey(key)) {
                Object rightVal = rightMap.get(key);
                if (!Objects.equals(leftVal, rightVal)) {
                    Map<String, Object> diffContent = new HashMap<>();
                    diffContent.put("L", leftVal);
                    diffContent.put("R", rightVal);
                    diffMap.put(key, diffContent);
                }
                rightMap.remove(key);
            } else {
                missingMap.put(key, "R");
            }
        });
        if (!rightMap.isEmpty()) {
            rightMap.forEach((key, rightVal) -> {
                missingMap.put(key, "L");
            });
        }
    }

}
