package pl.camp.it.car.rent;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.car.rent.model.Car;

public class TestClass {
    public static void main(String[] args) {
        String password = "admin%&95qbt4LPsqKt41eW!5XfzR#y7sw$wf";

        String hash = DigestUtils.md5Hex(password);

        System.out.println(hash);

        System.out.println("------------------------");
        Car car = new Car("BMW", "3", 2015, 300, "KR11");
        System.out.println(car.toCSV());
    }


    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());

        return sb.toString();
    }
}
