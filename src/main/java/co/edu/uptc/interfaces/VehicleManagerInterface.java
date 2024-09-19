package co.edu.uptc.interfaces;

import co.edu.uptc.utilities.SimpleList;

public interface VehicleManagerInterface {

    public interface Model {
        public void setPresenter(Presenter presenter);

        public void loadData();

        public SimpleList<SimpleList> organizeState();

        public SimpleList<SimpleList> organizeCounty();

        public SimpleList<SimpleList> organizeCity();

        public SimpleList<SimpleList> organizeModel();

        public SimpleList<SimpleList> organizeMake();

        public SimpleList<SimpleList> organizeRange();

        public void resetData();
    }

    public interface View {
        public void setPresenter(Presenter presenter);

        public void begin();
    }

    public interface Presenter {
        public void setView(View view);

        public void setModel(Model model);

        public void loadData();
        
        public SimpleList<SimpleList> organizeState();

        public SimpleList<SimpleList> organizeCounty();

        public SimpleList<SimpleList> organizeCity();

        public SimpleList<SimpleList> organizeModel();

        public SimpleList<SimpleList> organizeMake();

        public SimpleList<SimpleList> organizeRange();

        public void resetData();
        
    }

}
