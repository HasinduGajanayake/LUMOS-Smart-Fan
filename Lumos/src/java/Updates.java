
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class  Updates {
    private final HashMap<String,HashMap<String,String>>fan = new HashMap<>();
    
    
    public synchronized String updates(String location,String id,String autoMode,String speed,String r,String g,String b){
        if(location.equals("0")){
            
            for(String key:fan.keySet()){
                changeAll(key, autoMode, speed, r, g, b);
            }
            
        }else if(fan.containsKey(location)){
            
            if(id.equals("0")){
                
                changeAll(location, autoMode, speed, r, g, b);
                
            }else{
                
            HashMap<String,String> in = fan.get(location);
            in.put(id,autoMode+","+speed+","+r+","+g+","+b);
            
            }
            
        }else{
            
            HashMap<String,String> in = new HashMap<>();
            in.put(id,autoMode+","+speed+","+r+","+g+","+b);
            fan.put(location, in);
            
        }
        return "Updated";
    }
    
    final synchronized String getUpdates(String location,String id){
        if(fan.containsKey(location)){
            if(fan.get(location).containsKey(id)){
                return fan.get(location).get(id);
            }
        }
        return "Wrong Query";
    }
    
    public synchronized void changeAll(String location,String autoMode,String speed,String r,String g,String b){
        for(String key:fan.get(location).keySet()){
            fan.get(location).put(key,autoMode+","+speed+","+r+","+g+","+b);
        }
    }
    
}
