package menu.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CoachTest {

    @Nested
    class canEatTest {

        @Test
        void 못_먹는_메뉴면_false를_반환_한다() {
            // given
            Coach coach = new Coach("성열");
            coach.addNoMenu("두리안");

            // when
            boolean actual = coach.canEat("두리안");

            // then
            Assertions.assertFalse(actual);
        }

        @Test
        void 먹을_수_있는_메뉴는_true를_반환_한다() {
            // given
            Coach coach = new Coach("성열");
            coach.addNoMenu("두리안");

            // when
            boolean actual = coach.canEat("김치찌개");

            // then
            Assertions.assertTrue(actual);
        }
    }

    @Nested
    class addMenuTest {

        @Test
        void 먹을_수_없는_메뉴라면_추가하지_않는다() {
            // given
            Coach coach = new Coach("성열");
            coach.addNoMenu("두리안");
            coach.addMenu("식사1");
            coach.addMenu("식사2");
            coach.addMenu("식사3");
            coach.addMenu("식사4");
            coach.addMenu("두리안");

            // when
            String actual = coach.format();

            // then
            Assertions.assertEquals("[ 성열 | 메뉴가 유효하지 않습니다. ]", actual);
        }

        @Test
        void 이미_포함된_메뉴라면_추가하지_않는다() {
            // given
            Coach coach = new Coach("성열");
            coach.addMenu("식사1");
            coach.addMenu("식사2");
            coach.addMenu("식사3");
            coach.addMenu("식사4");
            coach.addMenu("식사1");

            // when
            String actual = coach.format();

            // then
            Assertions.assertEquals("[ 성열 | 메뉴가 유효하지 않습니다. ]", actual);
        }

        @Test
        void 메뉴를_정상적으로_추가한다() {
            // given
            Coach coach = new Coach("성열");
            coach.addMenu("식사1");
            coach.addMenu("식사2");
            coach.addMenu("식사3");
            coach.addMenu("식사4");
            coach.addMenu("식사5");

            // when
            String actual = coach.format();

            // then
            Assertions.assertEquals("[ 성열 | 식사1 | 식사2 | 식사3 | 식사4 | 식사5 ]", actual);
        }
    }

    @Nested
    class formatTest {

        @Test
        void 메뉴가_5개라면_정상_출력() {
            // given
            Coach coach = new Coach("성열");
            coach.addMenu("식사1");
            coach.addMenu("식사2");
            coach.addMenu("식사3");
            coach.addMenu("식사4");
            coach.addMenu("식사5");

            // when
            String actual = coach.format();

            // then
            Assertions.assertEquals("[ 성열 | 식사1 | 식사2 | 식사3 | 식사4 | 식사5 ]", actual);
        }

        @Test
        void 메뉴가_5개가_아니라면_비정상_문구_출력() {
            // given
            Coach coach = new Coach("성열");
            coach.addMenu("식사1");
            coach.addMenu("식사2");
            coach.addMenu("식사3");
            coach.addMenu("식사4");

            // when
            String actual = coach.format();

            // then
            Assertions.assertEquals("[ 성열 | 메뉴가 유효하지 않습니다. ]", actual);
        }
    }


}
