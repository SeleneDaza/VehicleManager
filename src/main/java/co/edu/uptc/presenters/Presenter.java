package co.edu.uptc.presenters;

import co.edu.uptc.interfaces.VehicleManagerInterface;
import co.edu.uptc.utilities.SimpleList;
import lombok.Getter;

@Getter
public class Presenter implements VehicleManagerInterface.Presenter{

    private VehicleManagerInterface.View view;
    private VehicleManagerInterface.Model model;

    @Override
    public void setView(VehicleManagerInterface.View view) {
        this.view = view;
    }

    @Override
    public void setModel(VehicleManagerInterface.Model model) {
      this.model = model;
    }

    @Override
    public void loadData() {
      model.loadData();
    }

    @Override
    public SimpleList<SimpleList> organizeState() {
      return model.organizeState();
    }

    @Override
    public SimpleList<SimpleList> organizeCounty() {
      return organizeCounty();
    }

    @Override
    public SimpleList<SimpleList> organizeCity() {
      return model.organizeCity();
    }

    @Override
    public SimpleList<SimpleList> organizeModel() {
      return model.organizeModel();
    }

    @Override
    public SimpleList<SimpleList> organizeMake() {
      return model.organizeMake();
    }

    @Override
    public SimpleList<SimpleList> organizeRange() {
      return model.organizeRange();
    }
    
}
