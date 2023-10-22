interface OldTariffSystem {
    double calculateOldTariff();
}
interface NewTariffSystem {
    double calculateNewTariff();
}
class OldTariffSystemImpl implements OldTariffSystem {
    @Override
    public double calculateOldTariff() {
        return 50.0;
    }
}
class NewTariffSystemImpl implements NewTariffSystem {
    @Override
    public double calculateNewTariff() {
        return 75.0;
    }
}
class TariffSystemAdapter implements NewTariffSystem {
    private OldTariffSystem oldSystem;

    public TariffSystemAdapter(OldTariffSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    @Override
    public double calculateNewTariff() {
        double oldTariff = oldSystem.calculateOldTariff();
        double newTariff = oldTariff * 1.5;
        return newTariff;
    }
}

public class Main {
    public static void main(String[] args) {
        OldTariffSystem oldSystem = new OldTariffSystemImpl();
        NewTariffSystem newSystem = new NewTariffSystemImpl();

        System.out.println("New Tariff: " + newSystem.calculateNewTariff());

        TariffSystemAdapter adapter = new TariffSystemAdapter(oldSystem);
        System.out.println("Adapted Old Tariff: " + adapter.calculateNewTariff());
    }
}
