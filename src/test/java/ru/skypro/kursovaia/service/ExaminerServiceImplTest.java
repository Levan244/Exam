package ru.skypro.kursovaia.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.kursovaia.exeption.IncorrectQuestionAmountException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;
import static ru.skypro.kursovaia.service.TestConstants.*;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    public QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

@Test
    public void shouldTrowIncorrectQuestionsAmountException() {
        when(questionService.getAll()).thenReturn(MOCK_QUESTION);

        assertThatExceptionOfType(IncorrectQuestionAmountException.class)
                .isThrownBy(() -> examinerService.getQuestion(-1));
        assertThatExceptionOfType(IncorrectQuestionAmountException.class)
                .isThrownBy(() -> examinerService.getQuestion(MOCK_QUESTION.size()+ 1));

    }

    @Test
    public void shouldReturnQuestions() {
        when(questionService.getAll()).thenReturn(MOCK_QUESTION);
        when(questionService.getRandomQuestion()).thenReturn(
                QUESTION_1,
                QUESTION_2,
                QUESTION_3,
                QUESTION_4
        );
        int questAmount = MOCK_QUESTION.size() - 2;
        assertThat(examinerService.getQuestion(questAmount))
                .hasSize(questAmount);
    }

}