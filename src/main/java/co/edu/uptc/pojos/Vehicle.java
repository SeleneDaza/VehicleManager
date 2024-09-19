package co.edu.uptc.pojos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Vehicle {
    private String id;
    private String state;
    private String county;
    private String city;
    private String model;
    private String make;
    private String electricRange;

    public String getIf(String data){
        String dataReturn ="";
        switch (data) {
            case "state":
                dataReturn= this.state;
                break;
            case "county":
                dataReturn= this.county;
                break;
            case "city":
                dataReturn= this.city;
                break;
            case "model":
                dataReturn= this.model;
                break;
            case "make":
                dataReturn= this.make;
                break;
            case "range":
                dataReturn= this.electricRange;
                break;
            default:
            break;
        }
        return dataReturn;
    }
}


