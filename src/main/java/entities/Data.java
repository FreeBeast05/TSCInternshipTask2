package entities;

import java.util.Comparator;
import java.util.Objects;

public class Data implements Comparable<Data> {
    private long number;
    private String value;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Data(long number, String value) {
        this.number = number;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Data{" +
                "number=" + number +
                ", value='" + value + '\'' +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(number, value);
    }


    @Override
    public int compareTo(Data o) {
        return Comparator.comparing(Data::getNumber)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return number == data.number;
    }


//    @Override
//    public int compareTo(Data o){
//        long diff = this.getNumber()-o.getNumber();
//        if (diff == 0){
//            return this.getValue().compareTo(o.getValue());
//        }
//        else if(diff>0){
//            return 1;
//        }
//        else return -1;
//    }


}
