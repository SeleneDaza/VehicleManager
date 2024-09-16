package co.edu.uptc.presenters;

import co.edu.uptc.interfaces.VehicleManagerInterface;
import co.edu.uptc.interfaces.VehicleManagerInterface.Model;
import co.edu.uptc.interfaces.VehicleManagerInterface.View;
import lombok.Getter;

@Getter
public class Presenter implements VehicleManagerInterface.Presenter{

    private VehicleManagerInterface.View view;
    private VehicleManagerInterface.Model model;

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void setModel(Model model) {
      this.model = model;
    }
    
}
