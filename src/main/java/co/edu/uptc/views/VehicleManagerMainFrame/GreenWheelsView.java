package co.edu.uptc.views.VehicleManagerMainFrame;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import co.edu.uptc.interfaces.VehicleManagerInterface;
import co.edu.uptc.interfaces.VehicleManagerInterface.Presenter;
import co.edu.uptc.utilities.DesignButton;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;

@Getter
public class GreenWheelsView extends JFrame implements VehicleManagerInterface.View {

    private VehicleManagerInterface.Presenter presenter;
    private GridBagConstraints gbc;
    private JPanel buttonsPanel;
    private Container contentJPanel;
    private InitialPanel menuJPanel;
    private JPanel vehicJPanel;
    private JPanel geographicJPanel;
    private DesignButton loadDataButton;
    private DesignButton toMenu;
    private DesignButton toVehicle;
    private DesignButton toGeo;

    public GreenWheelsView() {
        initFrame();
        createButtonsPanel();
        createContentJPanel();
        createMenuPanel();
        createVehicJPanel();
        createGeographicJPanel();
        createButtons();
    }

    @Override
    public void begin() {
        this.setVisible(true);
    }

    private void initFrame() {
        this.setTitle("GreenWheels Manager");
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        gbc = new GridBagConstraints();
    }

    public void createButtonsPanel() {
        buttonsPanel = new ButtonsPanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.25;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(buttonsPanel, gbc);
        buttonsPanel.setVisible(false);
    }

    public void createContentJPanel() {
        contentJPanel = new JPanel(new CardLayout());
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.75;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(contentJPanel, gbc);
    }

    public void createMenuPanel() {
        menuJPanel = new InitialPanel(this);
        contentJPanel.add(menuJPanel, "Menu");
    }

    public void createVehicJPanel() {
        vehicJPanel = new VehiclePanel(this);
        contentJPanel.add(vehicJPanel, "Vehicle");
    }

    public void createGeographicJPanel() {
        geographicJPanel = new GeographicPanel(this);
        contentJPanel.add(geographicJPanel, "geo");
    }

    public void createButtons() {
        loadDataButton = new DesignButton("Load Data", true);
        loadDataButton.setForeground(GlobalView.PRIMARY_BTN_TEXT);
        loadDataButton.setBounds(60, 430, 350, 50);
        loadDataButton.addActionListener(e -> showPanel("Vehicle"));
        loadDataButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadDataButton.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        menuJPanel.addToAside(loadDataButton);

        toMenu = new DesignButton("Log Out",false);
        toMenu.setForeground(GlobalView.PRIMARY_BTN_TEXT);
        toMenu.setBounds(15, 600, 200, 50);
        toMenu.addActionListener(e -> showPanel("Menu"));
        buttonsPanel.add(toMenu);

        toVehicle = new DesignButton("Vehicle Data Analisis",true);
        toVehicle.setForeground(GlobalView.PRIMARY_BTN_TEXT);
        toVehicle.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        toVehicle.setBounds(56, 260, 200, 50);
        toVehicle.addActionListener(e -> showPanel("Vehicle"));
        buttonsPanel.add(toVehicle);

        toGeo = new DesignButton("Geographic Analisis",true);
        toGeo.setForeground(GlobalView.PRIMARY_BTN_TEXT);
        toGeo.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        toGeo.setBounds(55, 330, 200, 50);
        toGeo.addActionListener(e -> showPanel("geo"));
        buttonsPanel.add(toGeo);
        contentJPanel.setVisible(true);
    }

    private void showPanel(String panelName) {
        CardLayout cardLayout = (CardLayout) contentJPanel.getLayout();
        cardLayout.show(contentJPanel, panelName);
        buttonsPanel.setVisible(!panelName.equals("Menu"));
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

}
