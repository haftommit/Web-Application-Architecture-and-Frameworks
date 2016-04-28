
package mum.cs545.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import mum.cs544.model.TeaBrand;
import mum.cs544.model.TeaExpert;

/**
 *
 * @author Haftom Alemayehu <Haftom Alemayehu>
 */

@Named
@SessionScoped
public class TeaExpertBean implements Serializable {

    private TeaExpert teaExpert = new TeaExpert();

    private String color = null;

    private String brand = null;
    private SelectItem[] brands;  //contains recommended brands to display in the listBrands.xhtml page

    public String findBrands() {
        SelectItem[] brandItems = new SelectItem[teaExpert.getBrands(color).size()];
        int position = 0;
        for (String brand : teaExpert.getBrands(color)) {
            brandItems[position++] = new SelectItem(brand);
        }
        brands = brandItems;
        return "listBrands";

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    TeaExpert teaBrand = null;
    
    public TeaBrand getTeaBrand(){
        return teaExpert.getTeaBrandByName(brand);
    }
    
    public void resetTeaBrand(){
        teaBrand = null;
        brand = null;
    }
    
    public void resetColor(){
        color = null;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public SelectItem[] getBrands() {
//        SelectItem[] brands = new SelectItem[teaExpert.getBrands(color).size()];
//        int position = 0;
//        for(String brand:teaExpert.getBrands(color)){
//            brands[position++] = new SelectItem(brand);
//        }
        return brands;
    }
    
    public SelectItem[] getTeaColors(){
        SelectItem[] colors = new SelectItem[teaExpert.getTeaColors().size()];
        int position = 0;
        for(String color:teaExpert.getTeaColors()){
            colors[position++] = new SelectItem(color);
        }
        return colors;
    }
    
    public String go2list(){
        return "listBrands";
    }
    

}
