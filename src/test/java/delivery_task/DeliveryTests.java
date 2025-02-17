package delivery_task;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeliveryTests extends DeliveryBaseTest {


    @DisplayName("Расчет стоимости доставки с расcтоянием")
    @ParameterizedTest(name = "Расчет стоимости доставки с расcтоянием: {0}")
    @MethodSource("distanceDataProvider")
    @Tags({@Tag("Smoke"), @Tag("API"), @Tag("distance")})
    public void DeliveryCoastWithDifferentDistanceTest(int distance, String dimensions, boolean fragility, String workload){
        double calculatedCoast = DeliveryCalculation(distance, dimensions, fragility, workload);
        assertTrue(calculatedCoast >= 400, String.format("Стоимость доставки должна быть не менее %d рублей.", MIM_COAST));
    }

    public static Stream<Arguments> distanceDataProvider() {
        return Stream.of(
                Arguments.of(31, "большие", false, "очень высокая"),
                Arguments.of(30, "большие", false, "очень высокая"),
                Arguments.of(29, "большие", false, "очень высокая"),
                Arguments.of(10, "большие", false, "очень высокая"),
                Arguments.of(9, "большие", false, "очень высокая"),
                Arguments.of(2, "большие", false, "очень высокая"),
                Arguments.of(1, "большие", false, "очень высокая")
                );
    }

    @DisplayName("Расчет стоимости доставки с габаритами")
    @ParameterizedTest(name = "Расчет стоимости доставки с габаритом: {1}")
    @MethodSource("dimensionDataProvider")
    @Tags({@Tag("Smoke"), @Tag("API"), @Tag("dimensions")})
    public void DeliveryCoastWithDifferentDimensionTest(int distance, String dimensions, boolean fragility, String workload){
        double calculatedCoast = DeliveryCalculation(distance, dimensions, fragility, workload);
        assertTrue(calculatedCoast >= 400, String.format("Стоимость доставки должна быть не менее %d рублей.", MIM_COAST));
    }

    public static Stream<Arguments> dimensionDataProvider() {
        return Stream.of(
                Arguments.of(31, "большие", false, "очень высокая"),
                Arguments.of(30, "маленькие", false, "очень высокая"),
                Arguments.of(30, "огромные", false, "очень высокая")
        );
    }

    @DisplayName("Расчет стоимости доставки с учётом хрупкости")
    @ParameterizedTest(name = "Расчет стоимости доставки с учётом хрупкости: {2}")
    @MethodSource("fragilityDataProvider")
    @Tags({@Tag("Smoke"), @Tag("API"), @Tag("fragility")})
    public void DeliveryCoastWithDifferentFragilityTest(int distance, String dimensions, boolean fragility, String workload){
        double calculatedCoast = DeliveryCalculation(distance, dimensions, fragility, workload);
        SoftAssertions softly = new SoftAssertions();
        if (fragility){
            softly.assertThat(calculatedCoast >= 400)
                    .as(String.format("Стоимость доставки должна быть не менее %d рублей.", MIM_COAST))
                    .isTrue();
        } else {
            softly.assertThat(calculatedCoast >= 400)
                    .as(String.format("Стоимость доставки должна быть не менее %d рублей.", MIM_COAST))
                    .isFalse();
        }

    }

    public static Stream<Arguments> fragilityDataProvider() {
        return Stream.of(
                Arguments.of(31, "большие", false, "очень высокая"),
                Arguments.of(10, "большие", false, "очень высокая")
                );
    }



    @DisplayName("Расчет стоимости доставки с загруженностью")
    @ParameterizedTest(name = "Расчет стоимости доставки с загруженностью: {0}")
    @MethodSource("workloadDataProvider")
    @Tags({@Tag("Smoke"), @Tag("API"), @Tag("workload")})
    public void DeliveryCoastWithDifferentWorkloadTest(int distance, String dimensions, boolean fragility, String workload){
        double calculatedCoast = DeliveryCalculation(distance, dimensions, fragility, workload);
        assertTrue(calculatedCoast >= 400, String.format("Стоимость доставки должна быть не менее %d рублей.", MIM_COAST));
    }

    public static Stream<Arguments> workloadDataProvider() {
        return Stream.of(
                Arguments.of(31, "большие", false, "очень высокая"),
                Arguments.of(31, "большие", false, "высокая"),
                Arguments.of(31, "большие", false, "повышенная"),
                Arguments.of(31, "большие", false, "Обычная"),
                Arguments.of(31, "большие", false, "smale")
        );
    }



}
