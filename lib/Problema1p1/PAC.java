public class PAC implements TipoFrete {

    @Override
    public double calcularFrete(double peso) {
        if (peso <= 1)
            return 10.00;
        else if (peso <= 2)
            return 15.00;
        else if (peso <= 3)
            return 20.00;
        else if (peso <= 5)
            return 30.00;
        else
            throw new IllegalArgumentException("Peso excede o limite para a opção de frete");
    }

}
