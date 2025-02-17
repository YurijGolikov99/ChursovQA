package delivery_task;

public class DeliveryParameters {

    private int distance;
    private String dimensions;
    private boolean fragility;
    private String workload;


    public DeliveryParameters(Integer distance, String dimensions, Boolean fragility, String workload) {
        this.distance = distance;
        this.dimensions = dimensions;
        this.fragility = fragility;
        this.workload = workload;
    }

    public int getDistance() {
        return distance;
    }

    public String getDimensions() {
        return dimensions;
    }

    public boolean isFragility() {
        return fragility;
    }

    public String getWorkload() {
        return workload;
    }
}
