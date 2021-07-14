package pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/13-15:36
 */


public class Cart {

    private Map<Integer,CartItem> items=new LinkedHashMap<>();


    public void addItem(CartItem cartItem){
        CartItem item=items.get(cartItem.getId());
        if(item!=null){
            item.setCount(item.getCount()+1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
        else{
            items.put(cartItem.getId(),cartItem);
        }
    }

    public void deleteItem(Integer id){
        items.remove(id);
    }

    public void clear(){
        items.clear();
    }


    public void updateCount(Integer id,Integer count){
        CartItem item = items.get(id);
        if(item!=null){
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }


    public Integer getTotalCount(){
        Integer totalCount=0;
        for (Map.Entry<Integer,CartItem>entry:items.entrySet()){
            totalCount+=entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer,CartItem>entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
