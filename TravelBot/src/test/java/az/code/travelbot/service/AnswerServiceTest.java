package az.code.travelbot.service;

import az.code.travelbot.sevice.AnswerService;
import az.traveltime.traveltimebot.models.entity.Answer;
import az.traveltime.traveltimebot.repo.AnswerRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AnswerServiceTest {

    @Mock
    private AnswerRepo answerRepo;

    @InjectMocks
    private AnswerService answerService;

    @Test
    void getAllAnswer_shouldReturnAllAnswers() {

        Answer answer1 = new Answer();
        Answer answer2 = new Answer();
        

        when(answerRepo.getAll()).thenReturn(Arrays.asList(answer1, answer2));


        List<Answer> result = answerService.getAllAnswer();


        assertEquals(Arrays.asList(answer1, answer2), result);
    }

    @Test
    void getByRequestId_shouldReturnAnswer() {

        Answer sampleAnswer = new Answer();
        

        when(answerRepo.getByRequestId(1L)).thenReturn(sampleAnswer);


        Answer result = answerService.getByRequestId(1L);


        assertEquals(sampleAnswer, result);
    }
}
