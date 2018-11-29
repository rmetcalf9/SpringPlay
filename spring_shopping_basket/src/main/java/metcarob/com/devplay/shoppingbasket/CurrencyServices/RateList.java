package metcarob.com.devplay.shoppingbasket.CurrencyServices;

import java.util.List;

public class RateList {

    String baseCurrencyCode = "";
    List<Rate> rates = null;

    public String getBaseCurrencyCode() {
        return baseCurrencyCode;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setBaseCurrencyCode(String baseCurrencyCode) {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public String displayString() {
        String s = "";
        s += "baseCurrencyCode:" + this.baseCurrencyCode + "\n";
        for (Rate r : this.rates) {
            double d = (double) r.getAmount()/1000000;
            s += String.format("  %s:%f",r.getCurrency(),d) + "\n";
        }
        return s;
    }

}
