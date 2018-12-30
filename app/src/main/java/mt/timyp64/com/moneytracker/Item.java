package mt.timyp64.com.moneytracker;

public class Item {

    public static final String TYPE_UNKNOW = "unknow";
    public static final String TYPE_INCOMES = "incomes";
    public static final String TYPE_EXPENSES = "expenses";

    public int id;
    public int price;
    public String title;
    private String type;

    public Item(int price, String title, String type) {
        this.price = price;
        this.title = title;
        this.title = type;
    }

}
