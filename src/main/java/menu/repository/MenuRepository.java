package menu.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRepository {

    private final Map<Integer, List<String>> storage = new HashMap<>();

    public MenuRepository() {
        for (int i = 1; i <= 5; i++) {
            storage.put(i, new ArrayList<>());
        }
        saveAll(1, List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘",
            "오코노미야끼"));
        saveAll(2, List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        saveAll(3, List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        saveAll(4, List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        saveAll(5, List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    }

    public List<String> find(Integer key) {
        return new ArrayList<>(storage.get(key));
    }

    public List<String> getAllMenus() {
        List<String> allMenus = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            List<String> menus = storage.get(i);
            allMenus.addAll(menus);
        }
        return allMenus;
    }

    private void save(Integer key, String value) {
        storage.getOrDefault(key, new ArrayList<>()).add(value);
    }

    private void saveAll(Integer key, List<String> values) {
        for (String value : values) {
            save(key, value);
        }
    }
}
