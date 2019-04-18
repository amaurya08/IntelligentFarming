package com.kuldeep.intelligent_farming.Pojo_classes;

/**
 * Created by kuldeep on 28-10-2017.
 */

public class mysensorsPojo {
    private String sensor_image,sensor_name,sensor_value;

    public mysensorsPojo(String sensor_image, String sensor_name, String sensor_value) {
        this.sensor_image = sensor_image;
        this.sensor_name = sensor_name;
        this.sensor_value = sensor_value;
    }

    @Override
    public String toString() {
        return "mysensorsPojo{" +
                "sensor_image='" + sensor_image + '\'' +
                ", sensor_name='" + sensor_name + '\'' +
                ", sensor_value='" + sensor_value + '\'' +
                '}';
    }

    public String getSensor_image() {
        return sensor_image;
    }

    public String getSensor_name() {
        return sensor_name;
    }

    public String getSensor_value() {
        return sensor_value;
    }

    public void setSensor_image(String sensor_image) {
        this.sensor_image = sensor_image;
    }

    public void setSensor_name(String sensor_name) {
        this.sensor_name = sensor_name;
    }

    public void setSensor_value(String sensor_value) {
        this.sensor_value = sensor_value;
    }
}
