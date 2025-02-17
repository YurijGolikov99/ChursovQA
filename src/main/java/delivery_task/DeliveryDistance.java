package delivery_task;

public class DeliveryDistance implements CostCalculator{

    @Override
    public double calculate(int baseCost, DeliveryParameters params) {
        if (params.getDistance() > 30){
            if (params.isFragility()) {
                throw new IllegalArgumentException("Хрупкие грузы не могут быть доставлены на расстояние более 30 км");
            }
            return baseCost + 300;
        } else if (params.getDistance() > 10){
            return baseCost + 200;
        } else if (params.getDistance() > 2){
            return baseCost + 100;
        } else {
            return baseCost + 50;
        }
    }
}
