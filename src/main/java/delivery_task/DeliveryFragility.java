package delivery_task;

public class DeliveryFragility implements CostCalculator{
    @Override
    public double calculate(int baseCost, DeliveryParameters params) {
        if (params.isFragility()){
            return baseCost + 300;
        }
        return baseCost;
    }
}
