public class Sedex implements TipoFrete {

    @Override
    public double calcularFrete(double peso) {
        if (peso <= 0.5) {
            return 12.50;
        } else if (peso <= 0.75) {
            return 20.00;
        } else if (peso <= 1.2) {
            return 30.00;
        } else if (peso <= 2.0) {
            return 45.00;
        } else {
            double extraPeso = peso - 2.0;
            double adicional = Math.ceil(extraPeso * 10) * 1.50;
            return 46.50 + adicional;
        }
    }

}
