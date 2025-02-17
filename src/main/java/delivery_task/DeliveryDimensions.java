package delivery_task;

public class DeliveryDimensions implements CostCalculator{

    @Override
    public double calculate(int baseCost, DeliveryParameters params) {
        if (params.getDimensions().equals("большие")){
            return baseCost + 200;
        } else {
            return baseCost + 200;
        }
    }
}
