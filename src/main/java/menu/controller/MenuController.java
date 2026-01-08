package menu.controller;

import menu.domain.Coach.Coach;
import menu.domain.Coach.Coaches;
import menu.dto.request.CoachNamesRequest;
import menu.dto.response.RecommendationResultResponse;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static menu.view.OutputView.PREFIX_ERROR;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public MenuController(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }

    public void run() {
        // 안내문 출력
        outputView.printGuide();
        // 코치 이름 입력
        CoachNamesRequest coachNamesRequest = readCoachNamesUntilValid();
        // 못먹는 메뉴 입력
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNamesRequest.coachNames()) {
            coaches.add(readAllergyMenu(coachName));
        }
        Coaches allergyByCoach = new Coaches(coaches);
        // 점메추
        RecommendationResultResponse result = menuService.recommendation(allergyByCoach);
        // 메뉴 추천 결과 출력
        outputView.printResult(result);
    }

    private Coach readAllergyMenu(String coachName) {
        while (true) {
            try {
                List<String> allergyMenuNames = inputView.readAllergy(coachName);
                return new Coach(coachName, allergyMenuNames);
            } catch (IllegalArgumentException e) {
                outputView.printError(PREFIX_ERROR + e.getMessage());
            }
        }
    }

    private CoachNamesRequest readCoachNamesUntilValid() {
        while (true) {
            try {
                return inputView.readCoachNames();
            } catch (IllegalArgumentException e) {
                outputView.printError(PREFIX_ERROR + e.getMessage());
            }
        }
    }
}