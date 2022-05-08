import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GraphTest {

    public static void main(String[] args) {
        Map<String, LinkedList<String>> map = new HashMap<>();

        map.put("you", Stream.of("clarice", "bob", "alice").collect(Collectors.toCollection(LinkedList::new)));
        map.put("bob", Stream.of("anuj", "peggy").collect(Collectors.toCollection(LinkedList::new)));
        map.put("clarice", Stream.of("thom", "jonny").collect(Collectors.toCollection(LinkedList::new)));
        map.put("alice", Stream.of("peggy").collect(Collectors.toCollection(LinkedList::new)));
        map.put("anuj", new LinkedList<>());
        map.put("peggy", new LinkedList<>());
        map.put("thom", new LinkedList<>());
        map.put("jonny", new LinkedList<>());

        Queue<String> queue = new PriorityQueue<>();
        queue.addAll(map.get("you"));

        Set<String> searched = new HashSet<>();

        while (!queue.isEmpty()) {
            String person = queue.remove();
            if (searched.contains(person)) {
                queue.remove(person);
                continue;
            }
            if (sellsMango(person)) {
                System.out.println(person + " sells mango");
                return;
            } else {
                searched.add(person);
                queue.addAll(map.get(person));
            }
        }
        System.out.println("no one sells mango");
    }

    static boolean sellsMango(String person) {
        return 'm' == person.charAt(person.length()- 1);
    }

    static class Graph {
        Queue<Node> queue = new PriorityQueue<>();
        public Node node;

//        public Graph(Node node) {
//            this.node = node;
//        }

        boolean sellsMango(String name) {
            return Objects.equals(name.charAt(name.length() - 1),'m');
        }
    }

    static class Node {
        List<Node> friends;
        String name;
        boolean searched;

        public Node(String name, List<Node> friends) {
            this.name = name;
            this.friends = friends;
        }
    }

}
