package delivery_task;

public class DeliveryWorkload implements CostCalculator {


    @Override
    public double calculate(int baseCost, DeliveryParameters params) {
        if (params.getWorkload().equals("очень высокая")){
            return baseCost * 1.6;
        } else if (params.getWorkload().equals("высокая")){
            return baseCost * 1.4;
        } else if (params.getWorkload().equals("повышенная")){
            return baseCost * 1.2;
        } else {
            return baseCost;
        }
    }
}
