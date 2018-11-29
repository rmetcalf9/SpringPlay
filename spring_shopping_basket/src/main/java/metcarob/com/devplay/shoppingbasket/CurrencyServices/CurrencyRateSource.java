package metcarob.com.devplay.shoppingbasket.CurrencyServices;

/*
Interface for a data source which provides currency rates
 */

public interface CurrencyRateSource {
    public RateList getRateLists() throws Exception;
}
