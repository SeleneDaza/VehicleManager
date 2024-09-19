package co.edu.uptc.models;

import co.edu.uptc.interfaces.VehicleManagerInterface;
import co.edu.uptc.pojos.Vehicle;
import co.edu.uptc.utilities.MySort;
import co.edu.uptc.utilities.SimpleList;
import co.edu.uptc.utilities.VehicleComparator;
import co.edu.uptc.utilities.VehicleReader;
import lombok.Getter;

@Getter
public class VehicleManagerModel implements VehicleManagerInterface.Model {

    private VehicleManagerInterface.Presenter presenter;
    private SimpleList<Vehicle> dataList;
    private MySort<Integer> mySort;
    MySort<String> countySort;
    private SimpleList<SimpleList> showStateInfo;
    private SimpleList<SimpleList> showCountyInfo;
    private SimpleList<SimpleList> showCityInfo;
    private SimpleList<SimpleList> showModelInfo;
    private SimpleList<SimpleList> showMakeInfo;
    private SimpleList<SimpleList> showRangeInfo;

    public VehicleManagerModel() {
        mySort = new MySort<Integer>();
        countySort = new MySort<String>();
    }

    @Override
    public void setPresenter(VehicleManagerInterface.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadData() {
        VehicleReader reader = new VehicleReader();
        dataList = reader.readData(); 
    }

    public SimpleList<Vehicle> getDataList() {
        if (dataList == null) {
            loadData();
        }
        return dataList;
    }

    @Override
    public SimpleList<SimpleList> organizeState() {
        showStateInfo = this.countInfo("state");
        mySort.sortData(showStateInfo, VehicleComparator.countComparator);
        return showStateInfo;
    }

    //TODO: Arreglar county
    @Override
    public SimpleList<SimpleList> organizeCounty() {
        SimpleList<SimpleList> aux = this.countInfo("county");
        countySort.sortCountyData(aux, VehicleComparator.stateComparator);
        for (int i = 0; i < aux.size; i++) {
            System.out.println(aux.get(0).get(i)+"___"+aux.get(1).get(i)+"___"+aux.get(2).get(i));
        }
        return null;
    }

    @Override
    public SimpleList<SimpleList> organizeCity() {
        SimpleList<SimpleList> aux = this.countInfo("city");
        mySort.sortData(aux, VehicleComparator.countComparator);
        int count = 0;
        SimpleList<String> city = new SimpleList<String>();
        SimpleList<String> total = new SimpleList<String>();
    
        int maxRecords = Integer.parseInt(aux.get(1).get(0).toString());
    
        while (count < aux.get(1).size() && Integer.parseInt(aux.get(1).get(count).toString()) == maxRecords) {
            city.add(aux.get(0).get(count).toString());
            total.add(aux.get(1).get(count).toString());
            count++;
        }
    
        showCityInfo = new SimpleList<>();
        showCityInfo.add(city);
        showCityInfo.add(total);
        return showCityInfo;
    }

    @Override
    public SimpleList<SimpleList> organizeModel() {
        showModelInfo = this.countInfo("model");
        return showModelInfo;
    }

    @Override
    public SimpleList<SimpleList> organizeMake() {
        showMakeInfo = this.countInfo("make");
        return showMakeInfo;
    }

    @Override
    public SimpleList<SimpleList> organizeRange() {
        showRangeInfo = this.countInfo("range");
        return showRangeInfo;
    }

    public SimpleList<SimpleList> countInfo(String select){
        SimpleList<String> info = new SimpleList<String>();
        SimpleList<Integer> count = new SimpleList<Integer>();
        SimpleList<String> state = new SimpleList<>();
        String place;
        for (int i = 0; i < getDataList().size; i++) {
            place = getDataList().get(i).getIf(select);
            boolean add =true;
            for (int j = 0; j < info.size(); j++) {
                if(info.get(j).equals(place)){
                    count.set(j, (count.get(j)+1));
                    add=false;
                }
            }
            if (add) {
                info.add(place);
                count.add(1);
                if(select.equals("county")){state.add(dataList.get(i).getState());}
            }
        }
        SimpleList<SimpleList> countData = new SimpleList<>();
        if(select.equals("county")){countData.add(state);}
        countData.add(info);
        countData.add(count);
        return countData;
    }

    @Override
    public void resetData() {
        getDataList().clear();
    }

}
