import java.util.*;

public class BrexSuspiciousActivityChallenge {

    static class Activity {
        String person;
        String location;
        String operation;

        public Activity(String person, String location, String operation) {
            this.person = person;
            this.location = location;
            this.operation = operation;
        }

        String getKey() {
            return person + location + operation;
        }

        boolean isSuspicious(Activity activity, int k) {
            int counter = 0;
            counter += this.person.equals(activity.person) ? 1 : 0;
            counter += this.location.equals(activity.location) ? 1 : 0;
            counter += this.operation.equals(activity.operation) ? 1 : 0;
            return counter >= k;
        }

    }

    public static void main(String[] args) {
        List<Activity> suspiciousList = Arrays.asList(
                new Activity("person1", "jpa", "withdraw"),
                new Activity("person2", "yvr", "deposit")
        );

        List<Activity> activityList = Arrays.asList(
                new Activity("person1", "jpa", "deposit"),
                new Activity("person3", "jpa", "withdraw")
        );

        int k = 2;

        Collection<Activity> suspicious = findSuspicious(suspiciousList, activityList, k);
        suspicious.forEach(a -> {
            System.out.printf("%s %s %s\n", a.person, a.location, a.operation);
        });

    }

    static Collection<Activity> findSuspicious(List<Activity> suspiciousList, List<Activity> activityList, int k) {

        Map<String, Activity> newSuspiciousMap = new HashMap<>();

        suspiciousList.forEach(suspicious -> {
            activityList.forEach(activity -> {
                if (suspicious.isSuspicious(activity, k)) {
                    newSuspiciousMap.put(activity.getKey(), activity);
                }
            });
        });

        activityList.forEach(activity -> {
            String key = activity.getKey();
            if (!newSuspiciousMap.containsKey(key)) {
                newSuspiciousMap.forEach((suspiciousKey, suspiciousValue) -> {
                    if (suspiciousValue.isSuspicious(activity, k)) {
                        newSuspiciousMap.put(key, activity);
                    }
                });
            }
        });

        return newSuspiciousMap.values();

    }



}
