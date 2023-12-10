package BICYCLE_MANAGEMENT;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatMoney {
    private double money;
    public FormatMoney(double money) {
        this.money = money;
    }

    String format(){
        Locale localeVN = new Locale("vi","VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String result = currencyVN.format(this.money);
        return result;
    }
}
