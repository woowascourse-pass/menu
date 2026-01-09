package menu.service;

import java.util.List;
import menu.config.AppConfig;
import menu.domain.Coach;
import menu.repository.MenuRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MenuServiceTest {

    private final AppConfig appConfig = new AppConfig();
    private final MenuService menuService = appConfig.menuService();
    private final MenuRepository menuRepository = appConfig.menuRepository();

    @Nested
    class getAllMenusTest {

        @Test
        void menuRepository에_있는_모든_메뉴를_가져와야_한다() {
            // given
            List<String> allMenus = menuRepository.getAllMenus();

            // when
            List<String> actual = menuService.getAllMenus();

            // then
            for (int i = 0; i < allMenus.size(); i++) {
                Assertions.assertEquals(allMenus.get(i), actual.get(i));
            }
        }
    }

    @Nested
    class addNoMenusTest {

        @Test
        void 못_먹는_메뉴를_코치에게_저장_해야_한다() {
            // given
            Coach coach = new Coach("성열");
            List<String> noMenus = List.of("나시고렝", "탕수육");

            // when
            menuService.addNoMenus(coach, noMenus);

            // then
            Assertions.assertFalse(coach.canEat("나시고렝"));
            Assertions.assertFalse(coach.canEat("탕수육"));
        }
    }

    @Nested
    class convertCoachTest {

        @Test
        void 이름을_Coach_객체로_변경_해야_한다() {
            // given
            List<String> names = List.of("포비", "성열", "탕슉");

            // when
            List<Coach> actual = menuService.convertCoach(names);

            // then
            Assertions.assertEquals("포비", actual.get(0).getName());
            Assertions.assertEquals("성열", actual.get(1).getName());
            Assertions.assertEquals("탕슉", actual.get(2).getName());
        }
    }
}
