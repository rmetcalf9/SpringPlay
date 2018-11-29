package metcarob.com.devplay.shoppingbasket;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateFactory {
    private Date overrideDate = null;
    public Date getCurrentDate() {
        if (null!=overrideDate) return new Date(this.overrideDate.getTime());
        return new Date();
    }
    public void overrideDate(Date overrideDate) {
        this.overrideDate = overrideDate;
    }

    public DateFactory() {
    }
}
