package menu.repository;

import menu.domain.menu.Category;
import menu.domain.menu.Menu;
import menu.util.Parser;
import menu.util.ResourceReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private static final int FIELD_SIZE = 2;
    private static final String DEFAULT_PATH = "menu.md";

    public MenuRepository() {
    }

    public List<Menu> findAll() {
        List<Menu> menus = new ArrayList<>();
        try (BufferedReader bufferedReader = ResourceReader.getBufferedReader(DEFAULT_PATH)) {
            bufferedReader.readLine(); // header skip
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(!line.trim().isBlank()) {
                    menus.add(parseLine(line));
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("[ERROR] 파일 읽는 중 오류 발생: " + DEFAULT_PATH, e);
        }
        return menus;
    }

    private Menu parseLine(String line) {
        List<String> parts = Parser.parseByDelimiter(line);

        if (parts.size() != FIELD_SIZE) {
            throw new IllegalStateException("[ERROR] 파일 형식 오류");
        }

        return new Menu(parts.get(0), Category.fromKorean(parts.get(1)));
    }
}
