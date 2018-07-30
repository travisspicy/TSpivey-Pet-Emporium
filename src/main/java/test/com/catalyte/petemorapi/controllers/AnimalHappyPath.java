package test.com.catalyte.petemorapi.controllers;

import com.catalyte.petemorapi.controllers.AnimalController;
import com.catalyte.petemorapi.models.Animal;
import com.catalyte.petemorapi.services.AnimalService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

/** 
* AnimalController Tester. 
* 
* @author <Tristan Spivey>
* @since <pre>Jul 30, 2018</pre> 
* @version 1.0 
*/ 
public class AnimalHappyPath {
    @InjectMocks
    AnimalController classToTest;
    @Mock
    AnimalService mockAnimalService;
    Animal mockAnimalA;
    Animal mockAnimalB;

    @Before
    public void before(){
        initMocks(this);
    }

    @After
    public void after(){}

    @Test
    public void testValidate_animalColor_Internal_State(){
        List<Animal> expected = new ArrayList<>();

        mockAnimalA = new Animal();
        mockAnimalA.setColor("Green");

        expected.add(mockAnimalA);

        doReturn(expected).when(mockAnimalService).findAll();

        List<Animal> actual = classToTest.findAll();

        assertEquals(actual, expected);
    }

    @Test
    public void testValidate_animalAge_Internal_State(){
        List<Animal> expected = new ArrayList<>();
        mockAnimalB = new Animal();
        mockAnimalB.setAge("12");
        expected.add(mockAnimalB);
        doReturn(expected).when(mockAnimalService).findAll();
        List<Animal> actual = classToTest.findAll();

        assertEquals(actual, expected);
    }


}