import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline feline;

    private final String sex;
    private final boolean expectedHasMane;
    private final String expectedExceptionMessage;

    public LionTest(String sex, boolean expectedHasMane, String expectedExceptionMessage) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.expectedExceptionMessage = expectedExceptionMessage;
    }

    @Parameterized.Parameters
    public static Object[][] getDoesHaveManeResult() {
        return new Object[][] {
                {"Самец", true, ""},
                {"Самка", false, ""},
                {"Никто", true, "Используйте допустимые значения пола животного - самец или самка"}
        };
    }

    @Test
    public void getKittensReturnsOne() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedResult = 1;
        int actualResult = lion.getKittens();
        Assert.assertEquals("Возвращаемое значение должно быть: 1", expectedResult, actualResult);
    }

    @Test
    public void doesHaveManeReturnsCorrectManeValue() {
        try {
            Lion lion = new Lion(sex, feline);
            boolean actualResult = lion.doesHaveMane();
            Assert.assertEquals("Возвращает неверное значение hasMane", expectedHasMane, actualResult);
        }
        catch (Exception e) {
            Assert.assertEquals(e.getMessage(), expectedExceptionMessage);
        }
    }

    @Test
    public void getFoodReturnsPredatorList() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = lion.getFood();
        Assert.assertEquals("Возвращаемый список должен быть: [Животные, Птицы, Рыба]", expectedResult, actualResult);
    }
}