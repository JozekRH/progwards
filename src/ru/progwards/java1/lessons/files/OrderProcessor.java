package ru.progwards.java1.lessons.files;

import java.io.File;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;

public class OrderProcessor {

    File startDir;
    List<Order> orders = new ArrayList<>();
    
    public OrderProcessor(String startPath) {
        startDir = new File(startPath);
    }
    
    public int loadOrders(LocalDate start, LocalDate finish, String shopId){
        int errCount = 0;
        
        for (String fileName : allFiles(startDir, start, finish)){
            if (shopId != null){
                String[] info = infoFromFileName(fileName);
                if (info == null){
                    errCount++;
                    continue;
                }
                if (!info[0].equals(shopId)) continue;
            }

            
            Order o = getOrder(fileName);
            if (o == null){
                errCount++;
                continue;
            }
            orders.add(o);
        }
        
        return 10;
    }
    
    public List<Order> process(String shopId){
        List<Order> result = new ArrayList<>();
        if (shopId != null){
            for (Order o : orders){
                if (o.shopId.equals(shopId)) result.add(o);
            }
        }else result.addAll(orders);
        
        Collections.sort(result, new Comparator<Order>() {
            public int compare(Order o1, Order o2) {
                return o1.datetime.compareTo(o2.datetime);
            }
        });        
        return result;
    }
    
    public Map<String, Double> statisticsByShop(){
        Map<String, Double> result = new TreeMap<>();
        for (Order o : orders){
            if (result.containsKey(o.shopId)) result.put(o.shopId, result.get(o.shopId) + o.sum);
            else result.put(o.shopId, o.sum);
        }
        return result;
    }
    
    public Map<String, Double> statisticsByGoods(){
        Map<String, Double> result = new HashMap<>();
        for (Order o : orders){
            for (OrderItem oi : o.items){
                if (result.containsKey(oi.googsName)) result.put(oi.googsName, result.get(oi.googsName) + (oi.price * oi.count));
                else result.put(oi.googsName, (oi.price * oi.count));
            }
        }
        
        return result;
    }
    
    public Map<LocalDate, Double> statisticsByDay(){
        Map<LocalDate, Double> result = new HashMap<>();
        for (Order o : orders){
            if (result.containsKey(o.datetime.toLocalDate())) result.put(o.datetime.toLocalDate(), result.get(o.datetime.toLocalDate()) + o.sum);
            else result.put(o.datetime.toLocalDate(), o.sum);
        }
        return result;
    }
    
    private Set<String> allFiles(File dir, LocalDate start, LocalDate finish){
        Set<String> result = new HashSet<>();
        for (String s : dir.list())
        {
            File f = new File(dir + "/" + s);
            if (f.isDirectory()) result.addAll(allFiles(f, start, finish));
            else if (f.getName().endsWith(".csv")){
                if (start != null && f.lastModified() < start.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()) continue;
                if (finish != null && f.lastModified() > finish.atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()) continue;

                result.add(f.getAbsolutePath());
            }
        }
        return result;
    }
    
    private String[] infoFromFileName(String fileName){
        try{
            String name = new File(fileName).getName().split("\\.")[0];
            String[] result = name.split("-");
            if (result.length == 3 && result[0].length() == 3 && result[1].length() == 6 && result[2].length() == 4) return result;
        }catch (Exception e){}
        
        return null;
    }
    
    private Order getOrder(String fileName){
        try{
            String[] info = infoFromFileName(fileName);
            if (info == null) return null;
            
            File f = new File(fileName);
            String content = FileUtils.readFileToString(f);
            List<String[]> strings = getStrings(content);
            if (strings == null) return null;
            
            Order o = new Order();
            o.datetime = LocalDateTime.from(Instant.ofEpochMilli(f.lastModified()).atZone(ZoneId.systemDefault()).toLocalDateTime());
            o.orderId = info[1];
            o.customerId = info[2];
            o.shopId = info[0];
            o.items = new ArrayList<>();
            o.sum = 0D;
            
            for (String[] sa : strings){
                OrderItem oi = new OrderItem();
                oi.googsName = sa[0];
                oi.count = Integer.parseInt(sa[1]);
                oi.price = Integer.parseInt(sa[2]);
                o.items.add(oi);
                o.sum += oi.price * oi.count;
            }
            
            if (o.items.isEmpty()) return null;

            Collections.sort(o.items, new Comparator<OrderItem>() {
                public int compare(OrderItem oi1, OrderItem oi2) {
                    return oi1.googsName.compareTo(oi2.googsName);
                }
            });        
            
            return o;
        }catch (Exception e){}
        
        
        return null;
    }
    
    private List<String[]> getStrings(String content){
        
        List<String[]> result = new ArrayList<>();
        
        for (String line : content.split("\n")){
            if (!line.contains(",")) return null;
            String[] fields = line.split(",");
            if (fields.length != 3) return null;
            
            for (int i = 0; i < 3; i++){
                if (i == 1){
                    try{
                        Integer.parseInt(fields[i].trim());
                    }catch (Exception e){
                        return null;
                    }
                }
                if (i == 2){
                    try{
                        Double.parseDouble(fields[i].trim());
                    }catch (Exception e){
                        return null;
                    }
                }
                fields[i] = fields[i].trim(); 
            }
            result.add(fields);
        }
        return result;
    }
    


}
