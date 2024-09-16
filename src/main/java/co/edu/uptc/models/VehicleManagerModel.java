package co.edu.uptc.models;

import co.edu.uptc.interfaces.VehicleManagerInterface;
import co.edu.uptc.interfaces.VehicleManagerInterface.Presenter;
import lombok.Getter;

@Getter
public class VehicleManagerModel implements VehicleManagerInterface.Model{

    private VehicleManagerInterface.Presenter presenter;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

}
