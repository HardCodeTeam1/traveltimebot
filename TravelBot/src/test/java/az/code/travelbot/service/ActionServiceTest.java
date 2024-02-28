package az.code.travelbot.service;


import az.code.travelbot.models.Action;
import az.code.travelbot.repo.ActionRepo;
import az.code.travelbot.sevice.ActionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActionServiceTest {

    @Mock
    private ActionRepo actionRepo;

    @InjectMocks
    private ActionService actionService;

    @Test
    void getActionByNextQuestion_shouldReturnAction() {

        Action sampleAction = new Action();
        sampleAction.setNextQuestion("sampleNextQuestion");


        when(actionRepo.findByNextQuestion("sampleNextQuestion")).thenReturn(sampleAction);


        Action result = actionService.getActionByNextQuestion("sampleNextQuestion");

        assertEquals(sampleAction, result);
    }
}
