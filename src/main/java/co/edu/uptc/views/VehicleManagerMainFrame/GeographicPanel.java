package co.edu.uptc.views.VehicleManagerMainFrame;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import co.edu.uptc.utilities.DesignButton;
import co.edu.uptc.utilities.SimpleList;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;

import javax.swing.JScrollPane;

@Getter
public class GeographicPanel extends JPanel {
    

    private GreenWheelsView greenWheelsView;
    private DesignButton byState;
    private DesignButton byCounty;
    private DesignButton byMore;
    private JTable stateTable;
    private JTable countyTable;
    private JTable cityTable;
    private DefaultTableModel stateTableModel;
    private DefaultTableModel countyTableModel;
    private DefaultTableModel cityTableModel;
    private JScrollPane stateScrollPane;
    private JScrollPane countyScrollPane;
    private JScrollPane cityScrollPane;

    public GeographicPanel(GreenWheelsView greenWheelsView) {
        this.greenWheelsView = greenWheelsView;
        setBackground(GlobalView.BODY_BACKGROUND);
        setLayout(null);
        initializeButtons();
        initStateTable();
        initCountyTable();
        initCityTable();
        showStateTable();
    }

    private void initializeButtons() {
        byState = new DesignButton("Records by state", true);
        byState.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        byState.setForeground(GlobalView.SECUNDARY_BTN_TEXT);
        byState.setBounds(50, 60, 300, 35);
        byState.addActionListener(e -> showStateTable());
        add(byState);

        byCounty = new DesignButton("Records by county", true);
        byCounty.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        byCounty.setForeground(GlobalView.SECUNDARY_BTN_TEXT);
        byCounty.setBounds(395, 60, 300, 35);
        byCounty.addActionListener(e -> showCountyTable());
        add(byCounty);

        byMore = new DesignButton("City with more vehicles", true);
        byMore.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        byMore.setForeground(GlobalView.SECUNDARY_BTN_TEXT);
        byMore.setBounds(735, 60, 300, 35);
        byMore.addActionListener(e -> showCityTable());
        add(byMore);
    }

    public void initStateTable() {
        String[] stateColumnNames = {"State", "Number of Records"};
        stateTableModel = new DefaultTableModel(stateColumnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        stateTable = new JTable(stateTableModel);
        stateScrollPane = new JScrollPane(stateTable);
        stateScrollPane.setBounds(50, 110, 990, 500);
        add(stateScrollPane);
        stateScrollPane.setVisible(false); 
    }

    public void loadStateData() {
        
        SimpleList<SimpleList> stateData = greenWheelsView.getPresenter().organizeState();
        stateTableModel.setRowCount(0);
    
        SimpleList<String> states = stateData.get(0);   
        SimpleList<Integer> counts = stateData.get(1);
    
        for (int i = 0; i < states.size(); i++) {
            Object[] rowData = { states.get(i), counts.get(i) }; 
            stateTableModel.addRow(rowData);  
        }
    }

    public void loadCountyData(){
        SimpleList<SimpleList> countyData = greenWheelsView.getPresenter().organizeCounty();
        countyTableModel.setRowCount(0);

        SimpleList<String> states = countyData.get(0);
        SimpleList<String> countys = countyData.get(1);
        SimpleList<Integer> counts = countyData.get(2);

        for (int i = 0; i < countys.size; i++) {
            Object[] rowData = {states.get(i), countys.get(i), counts.get(i)};
            countyTableModel.addRow(rowData);
        }
    }

    public void loadCityData(){
        SimpleList<SimpleList> cityData = greenWheelsView.getPresenter().organizeCity();
        cityTableModel.setRowCount(0);

        SimpleList<String> citys = cityData.get(0);
        SimpleList<Integer> counts = cityData.get(1);

        for (int i = 0; i < citys.size; i++) {
            Object[] rowData = {citys.get(i), counts.get(i)};
            cityTableModel.addRow(rowData);
        }
    }
    
    public void initCountyTable() {
        String[] countyColumnNames = {"State", "County", "Number of Records"};
        countyTableModel = new DefaultTableModel(countyColumnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        countyTable = new JTable(countyTableModel);
        countyScrollPane = new JScrollPane(countyTable);
        countyScrollPane.setBounds(50, 110, 990, 500);
        add(countyScrollPane);
        countyScrollPane.setVisible(false);
    }

    public void initCityTable() {
        String[] cityColumnNames = {"City", "Number of Vehicles"};
        cityTableModel = new DefaultTableModel(cityColumnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        cityTable = new JTable(cityTableModel);
        cityScrollPane = new JScrollPane(cityTable);
        cityScrollPane.setBounds(50, 110, 990, 500);
        add(cityScrollPane);
        cityScrollPane.setVisible(false); 
    }

    private void showStateTable() {
        stateScrollPane.setVisible(true);
        countyScrollPane.setVisible(false);
        cityScrollPane.setVisible(false);
        revalidate();
        repaint();
    }

    private void showCityTable() {
        stateScrollPane.setVisible(false);
        countyScrollPane.setVisible(false);
        cityScrollPane.setVisible(true);
        revalidate();
        repaint();
    }

    private void showCountyTable() {
        stateScrollPane.setVisible(false);
        countyScrollPane.setVisible(true);
        cityScrollPane.setVisible(false);
        revalidate();
        repaint();
    }
}
