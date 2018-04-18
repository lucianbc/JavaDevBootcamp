package org.bootcamp;


@SuppressWarnings({"squid:S3358", "squid:S106"})
public class MainApp {

    public static void main(String[] args) {
        final Vehicle joesCar = new Car(5, 200000, true, "auto");
        final Vehicle stevesBus = new Bus(3, 100000, true, 31);
        final Vehicle petersTipper = new Tipper(6, 80000, false, 15);

        final int joesPaycheck = 100 * joesCar.getAge()
                + (joesCar.isDiesel() ? 500 : 0)
                + (joesCar.getNumberOfMiles() > 200000 ? 500 : 0);

        final int stevesPaycheck = 200 * stevesBus.getAge()
                + (stevesBus.isDiesel() ? 1000 : 0)
                + (stevesBus.getNumberOfMiles() > 200000
                    ? 1000
                    : stevesBus.getNumberOfMiles() > 100000
                    ? 500
                    : 0);

        final int petersPaycheck = 300 * petersTipper.getAge()
                + (petersTipper.getNumberOfMiles() > 80000 ? 700 : 0);

        System.out.println("Joe's policy cost is " + joesPaycheck);
        System.out.println("Steve's policy cost is " + stevesPaycheck);
        System.out.println("Peter's policy cost is " + petersPaycheck);
    }
}
