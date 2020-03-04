package lv.itlat.helloweb.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SimpleCalculator {
    private double value1;
    private double value2;
    private double result;

    public void add(){
        result=value1+value2;
    }
    public void sub(){
        result=value1-value2;
    }
    public void multiply(){
        result=value1*value2;
    }
    public void divide(){
        result=value1/value2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getValue1() {
        return value1;
    }
    public void setValue1(double value1) {
        this.value1 = value1;
    }
    public double getValue2() {
        return value2;
    }
    public void setValue2(double value2) {
        this.value2 = value2;
    }
}
