package delivery_task;

public class DeliveryBaseTest {

    protected final int MIM_COAST = 400;

    protected DeliveryDistance deliveryDistance = new DeliveryDistance();
    protected DeliveryDimensions deliveryDimensions = new DeliveryDimensions();
    protected DeliveryFragility deliveryFragility = new DeliveryFragility();
    protected DeliveryWorkload deliveryWorkload = new DeliveryWorkload();

    public double DeliveryCalculation(int distance, String dimensions, boolean fragility, String workload){
        DeliveryParameters deliveryParameters = new DeliveryParameters(distance, dimensions, fragility, workload);
        int baseCost = 0;
        baseCost = (int) deliveryDistance.calculate(baseCost, deliveryParameters);
        baseCost = (int) deliveryDimensions.calculate(baseCost, deliveryParameters);
        baseCost = (int) deliveryFragility.calculate(baseCost, deliveryParameters);
        double totalCost = deliveryWorkload.calculate(baseCost, deliveryParameters);
        totalCost = Math.max(totalCost, 400);

        System.out.println("Стоимость доставки: " + totalCost + " руб.");
        return totalCost;
    }

}
