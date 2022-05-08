import java.util.*;
import java.util.stream.Collectors;

public class HashTest {

    public static void main(String[] args) {
        System.out.println(containsCloseNums(new int[] {0, 1, 2, 3, 5, 2}, 2));
    }

    static boolean containsCloseNums(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1 || k == 0) {
            return false;
        }

        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        for (Map.Entry<Integer, LinkedList<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            int size = list.size();
            if (size > 1) {
                list.forEach(System.out::print);
                for (int i = 0; i < size - 1; i++) {
                    if ((list.get(size - 1) - list.get(i)) <= k) {
                        System.out.println("returning true for " + list.get(size-1) + " and " + list.get(i));
                        return true;
                    }
                }
                System.out.println();
            }
        }

        return false;
    }

    //    String[] strings = {"cat", "dog", "doggy"};
    //    String[] patterns = {"a", "b", "b"};
    //    System.out.println(areFollowingPatterns(strings, patterns));
    static boolean areFollowingPatterns(String[] strings, String[] patterns) {
        int length = strings.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (strings[i] == strings[j]) {
                    if (patterns[i] != patterns[j]) {
                        return false;
                    }
                } else {
                    if (patterns[i] == patterns[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /*
       String[][] dishes = {{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
            {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
            {"Quesadilla", "Chicken", "Cheese", "Sauce"},
            {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}};
        String[][] strings = groupingDishes2(dishes);
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string));
        }
     */
    static String[][] groupingDishes2(String[][] dishes) {
        Map<String, LinkedList<String>> map = new HashMap<>();
        for (String[] dish : dishes) {
            String dishName = dish[0];

            for (int i = 1; i < dish.length; i++) {
                if (map.containsKey(dish[i])) {
                    LinkedList<String> list = map.get(dish[i]);
                    for (int j = 0; j < list.size(); j++) {
                        if (dishName.compareTo(list.get(j)) <= 0) {
                            list.add(j, dishName);
                            break;
                        } else if (j == list.size() - 1) {
                            list.addLast(dishName);
                            break;
                        }
                    }
                } else {
                    LinkedList<String> dishList = new LinkedList<>();
                    map.put(dish[i], dishList);
                    dishList.add(dishName);
                }
            }
        }

        LinkedList<String[]> result = new LinkedList<>();

        for (Map.Entry<String, LinkedList<String>> entry : map.entrySet()) {
            LinkedList<String> value = entry.getValue();
            if (value.size() <= 1) {
                continue;
            }

            String key = entry.getKey();
            value.addFirst(key);

            if (result.isEmpty()) {
                result.add(value.toArray(new String[0]));
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (key.compareTo(result.get(i)[0]) <= 0) {
                        result.add(i, value.toArray(new String[0]));
                        break;
                    } else if (i == result.size() - 1) {
                        result.addLast(value.toArray(new String[0]));
                        break;
                    }
                }
            }
        }

        return result.toArray(new String[0][0]);
    }

    static String[][] groupingDishes1(String[][] dishes) {
        Map<String, LinkedList<String>> map = new TreeMap<>();
        for (String[] dish : dishes) {
            String dishName = dish[0];

            for (int i = 1; i < dish.length; i++) {
                if (map.containsKey(dish[i])) {
                    LinkedList<String> list = map.get(dish[i]);
                    for (int j = 0; j < list.size(); j++) {
                        if (dishName.compareTo(list.get(j)) <= 0) {
                            list.add(j, dishName);
                            break;
                        } else if (j == list.size() - 1) {
                            list.add(dishName);
                            break;
                        }
                    }
                } else {
                    LinkedList<String> dishList = new LinkedList<>();
                    map.put(dish[i], dishList);
                    dishList.add(dishName);
                }
            }
        }

        List<LinkedList<String>> collect = map.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .map(entry -> {
                    entry.getValue().addFirst(entry.getKey());
                    return entry.getValue();
                }).collect(Collectors.toList());

        String[][] dishByIngredientsArray = new String[collect.size()][];
        for (int i = 0; i < collect.size(); i++) {
            dishByIngredientsArray[i] = collect.get(i).toArray(new String[0]);
        }

        return dishByIngredientsArray;
    }
}
