package dao;


import entity.Price;
import java.util.ArrayList;

public interface PriceDAO {
    public boolean insertPrice(Price price);
    public boolean updatePrice(Price pricer);
    public boolean deletePrice(int pid);
    public Price getPrice(int pid);
    public ArrayList<Price> getPrice();
}
