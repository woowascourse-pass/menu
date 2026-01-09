package menu.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRepository {

    private final Map<Integer, List<String>> storage = new HashMap<>();

    public MenuRepository() {
        storage.put(1, new ArrayList<>());
        List<String> menus = List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘",
            "오코노미야끼");
        for (String menu : menus) {
            storage.get(1).add(menu);
        }

        storage.put(2, new ArrayList<>());
        menus = List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
        for (String menu : menus) {
            storage.get(2).add(menu);
        }

        storage.put(3, new ArrayList<>());
        menus = List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
        for (String menu : menus) {
            storage.get(3).add(menu);
        }

        storage.put(4, new ArrayList<>());
        menus = List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
        for (String menu : menus) {
            storage.get(4).add(menu);
        }

        storage.put(5, new ArrayList<>());
        menus = List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");
        for (String menu : menus) {
            storage.get(5).add(menu);
        }
    }

    public List<String> find(Integer key) {
        return new ArrayList<>(storage.get(key));
    }

    public Map<Integer, List<String>> findAll() {
        return new HashMap<>(storage);
    }

    public void save(Integer key, String value) {
        storage.get(key).add(value);
    }

    public void clear() {
        storage.clear();
    }

    public List<String> getAllMenus() {
        List<String> allMenus = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            List<String> menus = storage.get(i);
            allMenus.addAll(menus);
        }
        return allMenus;
    }

}