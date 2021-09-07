package tech.pdai.springboot2unit5.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tech.pdai.springboot2unit5.entity.User;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * This class is for xxxx.
 *
 * @version
 * @author pdai
 */
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

    @Mock
    private UserServiceImpl userService;

    @Test
    public void findAll() {
        //Given
        Mockito.when(userService.findAll()).thenReturn(
                Collections.singletonList(new User(1, "pdai.tech", "1221111")));

        //When
        List<User> userDtoList = userService.findAll();

        //Then
        assertFalse(userDtoList.isEmpty());
        verify(userService, times(1)).findAll();
    }
}