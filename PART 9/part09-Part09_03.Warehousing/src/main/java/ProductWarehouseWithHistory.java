/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class ProductWarehouseWithHistory extends ProductWarehouse{
    
    private ChangeHistory history;
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName,capacity);
        history=new ChangeHistory();
        super.addToWarehouse(initialBalance);
        history.add(initialBalance);
    }
    public String history(){
        return history.toString();
    }
    public void addToWarehouse(double amount){
        
        super.addToWarehouse(amount);
        
        history.add(getBalance());
    }
    public double takeFromWarehouse(double amount){
        double val= super.takeFromWarehouse(amount);
        history.add(getBalance());
        return val;
    }
     public void printAnalysis(){
        System.out.println("Product: "+super.getName());
        System.out.println("History: "+history.toString());
        System.out.println("Largest amount of product: "+history.maxValue());
        System.out.println("Smallest amount of product: "+history.minValue());
        System.out.println("Average: "+history.average());
    }
}
