import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int getKittensArg;
    private final int getKittensExpectedResult;

    public FelineTest (int getKittensArg, int getKittensExpectedResult) {
        this.getKittensArg = getKittensArg;
        this.getKittensExpectedResult = getKittensExpectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getGetKittensResult() {
        return new Object[][] {
                {1, 1},
                {0, 0},
                {15, 15}};
    }

    @Test
    public void eatMeatReturnsPredatorsList() throws Exception {
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Feline feline = new Feline();
        List<String> actualList = feline.eatMeat();
        Assert.assertEquals("Возвращаемый список должен быть: ['Животные', 'Птицы', 'Рыба'] ", expectedList, actualList);
    }

    @Test
    public void getFamilyReturnsFeline() {
        String expectedResult = "Кошачьи";
        Feline feline = new Feline();
        String actualResult = feline.getFamily();
        Assert.assertEquals("Возвращаемое значение должно быть: Кошачьи", expectedResult, actualResult);
    }

    @Test
    public void getKittensWithoutArgReturnsOne() {
        int expectedResult = 1;
        Feline feline = new Feline();
        int actualResult = feline.getKittens();
        Assert.assertEquals("Возвращаемое значение должно быть: 1", expectedResult, actualResult);
    }

    @Test
    public void getKittensWithArgReturnsArg() {
        Feline feline = new Feline();
        int actualResult = feline.getKittens(getKittensArg);
        Assert.assertEquals("Возвращаемое значение должно быть равно аргументу", getKittensExpectedResult, actualResult);
    }
}