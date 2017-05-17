package org.cirdles.topsoil.app.plot;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import org.cirdles.topsoil.app.isotope.IsotopeType;
import org.cirdles.topsoil.plot.Plot;
import org.cirdles.topsoil.plot.base.BasePlotDefaultProperties;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.cirdles.topsoil.plot.base.BasePlotProperties.*;

/**
 * A panel that controls the {@code Control}s that manage the various plot properties and features.
 *
 * @author marottajb
 */
public class PlotPropertiesPanelController {

    //***********************
    // Attributes
    //***********************

    /**
     * A {@code ChoiceBox} allowing the user to select the {@code IsotopeType} of the table and plot.
     */
    @FXML private ChoiceBox<String> isotopeSystemChoiceBox;

    /**
     * A {@code TextField} for editing the title of the plot.
     */
    @FXML private TextField titleTextField;

    /**
     * A {@code TextField} for editing the title of the plot's X axis.
     */
    @FXML private TextField xAxisTextField;

    /**
     * A {@code TextField} for editing the title of the plot's X axis.
     */
    @FXML private TextField yAxisTextField;

    /**
     * A {@code CheckBox} for toggling the visibility of the data points in the plot.
     */
    @FXML private CheckBox pointsCheckBox;

    /**
     * A {@code CheckBox} for toggling the visibility of the uncertainty ellipses in the plot.
     */
    @FXML private CheckBox ellipsesCheckBox;

    /**
     * A {@code CheckBox} for toggling the visibility of the uncertainty crosses in the plot.
     */
    @FXML private CheckBox crossesCheckBox;

    /**
     * A {@code ColorPicker} for selecting the color of the data points in the plot.
     */
    @FXML private ColorPicker pointsColorPicker;

    /**
     * A {@code ColorPicker} for selecting the color of the uncertainty ellipses in the plot.
     */
    @FXML private ColorPicker ellipsesColorPicker;

    /**
     * A {@code ColorPicker} for selecting the color of the uncertainty crosses in the plot.
     */
    @FXML private ColorPicker crossesColorPicker;

    /**
     * A {@code GridPane} for organizing various additional plot features.
     */
    @FXML private GridPane featuresGridPane;

    /**
     * A {@code CheckBox} for toggling the visibility of the concordia line.
     */
    @FXML private CheckBox concordiaCheckBox;

    /**
     * A {@code Map} of {@code String}s to {@code IsotopeType}s for getting selections from isotopeSystemChoiceBox.
     */
    private static Map<String, IsotopeType> STRING_TO_ISOTOPE_TYPE;

    /**
     * A {@code Map} of plot properties that is constantly updated with values that can be applied to JavaScript plots.
     */
    private final ObservableMap<String, Object> PROPERTIES = FXCollections.observableMap(new BasePlotDefaultProperties());
    static {
        STRING_TO_ISOTOPE_TYPE = new LinkedHashMap<>();
        for (IsotopeType type : IsotopeType.ISOTOPE_TYPES) {
            STRING_TO_ISOTOPE_TYPE.put(type.getName(), type);
        }
    }

    /**
     * The {@code Plot} that this panel affects.
     */
    private Plot plot;

    //***********************
    // Properties
    //***********************

    /**
     * An {@code ObjectProperty} containing the {@code IsotopeType} of the table and plot.
     */
    private ObjectProperty<IsotopeType> isotopeType;
    public final ObjectProperty<IsotopeType> isotopeTypeObjectProperty() {
        if (isotopeType == null) {
            isotopeType = new SimpleObjectProperty<>(STRING_TO_ISOTOPE_TYPE.get(isotopeSystemChoiceBox
                                                                                        .getSelectionModel().getSelectedItem()));
        }
        return isotopeType;
    }
    public IsotopeType getIsotopeType() {
        return isotopeTypeObjectProperty().get();
    }
    public void setIsotopeType(IsotopeType isotopeType) {
        isotopeTypeObjectProperty().set(isotopeType);
    }

    /**
     * A {@code StringProperty} containing the title of the plot.
     */
    private StringProperty title;
    public final StringProperty titleProperty() {
        if (title == null) {
            title = new SimpleStringProperty(titleTextField.getText());
            title.bind(titleTextField.textProperty());
        }
        return title;
    }
    public String getTitle() {
        return titleProperty().get();
    }
    public void setTitle(String s) {
        titleTextField.setText(s);
    }

    /**
     * A {@code StringProperty} containing the title of the plot's X axis.
     */
    private StringProperty xAxisTitle;
    public final StringProperty xAxisTitleProperty() {
        if (xAxisTitle == null) {
            xAxisTitle = new SimpleStringProperty(xAxisTextField.getText());
            xAxisTitle.bind(xAxisTextField.textProperty());
        }
        return xAxisTitle;
    }
    public String getXAxisTitle() {
        return xAxisTitleProperty().get();
    }
    public void setxAxisTitle(String s) {
        xAxisTextField.setText(s);
    }

    /**
     * A {@code StringProperty} containing the title of the plot's Y axis.
     */
    private StringProperty yAxisTitle;
    public final StringProperty yAxisTitleProperty() {
        if (yAxisTitle == null) {
            yAxisTitle = new SimpleStringProperty(yAxisTextField.getText());
            yAxisTitle.bind(yAxisTextField.textProperty());
        }
        return yAxisTitle;
    }
    public String getYAxisTitle() {
        return yAxisTitleProperty().get();
    }
    public void setyAxisTitle(String s) {
        yAxisTextField.setText(s);
    }

    /**
     * A {@code BooleanProperty} tracking whether or not data points should be shown in the plot.
     */
    private BooleanProperty showPoints;
    public final BooleanProperty showPointsProperty() {
        if (showPoints == null) {
            showPoints = new SimpleBooleanProperty(pointsCheckBox.isSelected());
            showPoints.bind(pointsCheckBox.selectedProperty());
        }
        return showPoints;
    }
    public Boolean shouldShowPoints() {
        return showPointsProperty().get();
    }
    public void setShowPoints(Boolean b) {
        pointsCheckBox.setSelected(b);
    }

    /**
     * A {@code BooleanProperty} tracking whether or not uncertainty ellipses should be shown in the plot.
     */
    private BooleanProperty showEllipses;
    public final BooleanProperty showEllipsesProperty() {
        if (showEllipses == null) {
            showEllipses = new SimpleBooleanProperty(ellipsesCheckBox.isSelected());
            showEllipses.bind(ellipsesCheckBox.selectedProperty());
        }
        return showEllipses;
    }
    public Boolean shouldShowEllipses() {
        return showEllipsesProperty().get();
    }
    public void setshowEllipses(Boolean b) {
        ellipsesCheckBox.setSelected(b);
    }

    /**
     * A {@code BooleanProperty} tracking whether or not uncertainty crosses should be shown in the plot.
     */
    private BooleanProperty showCrosses;
    public final BooleanProperty showCrossesProperty() {
        if (showCrosses == null) {
            showCrosses = new SimpleBooleanProperty(crossesCheckBox.isSelected());
            showCrosses.bind(crossesCheckBox.selectedProperty());
        }
        return showCrosses;
    }
    public Boolean shouldShowCrosses() {
        return showCrossesProperty().get();
    }
    public void setshowCrosses(Boolean b) {
        crossesCheckBox.setSelected(b);
    }

    /**
     * An {@code ObjectProperty} containing the selected {@code Color} of the data points in the plot.
     */
    private ObjectProperty<Color> pointsColor;
    public final ObjectProperty<Color> pointsColorProperty() {
        if (pointsColor == null) {
            pointsColor = new SimpleObjectProperty<>(pointsColorPicker.getValue());
            pointsColor.bind(pointsColorPicker.valueProperty());
        }
        return pointsColor;
    }
    public Color getPointsColor() {
        return pointsColorProperty().get();
    }
    public void setPointsColor(Color c) {
        pointsColorPicker.setValue(c);
    }

    /**
     * An {@code ObjectProperty} containing the selected {@code Color} of the uncertainty ellipses in the plot.
     */
    private ObjectProperty<Color> ellipsesColor;
    public final ObjectProperty<Color> ellipsesColorProperty() {
        if (ellipsesColor == null) {
            ellipsesColor = new SimpleObjectProperty<>(ellipsesColorPicker.getValue());
            ellipsesColor.bind(ellipsesColorPicker.valueProperty());
        }
        return ellipsesColor;
    }
    public Color getEllipsesColor() {
        return ellipsesColorProperty().get();
    }
    public void setEllipsesColor(Color c) {
        ellipsesColorPicker.setValue(c);
    }

    /**
     * An {@code ObjectProperty} containing the selected {@code Color} of the uncertainty crosses in the plot.
     */
    private ObjectProperty<Color> crossesColor;
    public final ObjectProperty<Color> crossesColorProperty() {
        if (crossesColor == null) {
            crossesColor = new SimpleObjectProperty<>(crossesColorPicker.getValue());
            crossesColor.bind(crossesColorPicker.valueProperty());
        }
        return crossesColor;
    }
    public Color getCrossesColor() {
        return crossesColorProperty().get();
    }
    public void setCrossesColor(Color c) {
        crossesColorPicker.setValue(c);
    }

    /**
     * A {@code BooleanProperty} tracking whether or not a concordia line should be shown in the plot.
     */
    private BooleanProperty showConcordia;
    public final BooleanProperty showConcordiaProperty() {
        if (showConcordia == null) {
            showConcordia = new SimpleBooleanProperty(concordiaCheckBox.isSelected());
            showConcordia.bind(concordiaCheckBox.selectedProperty());
        }
        return showConcordia;
    }
    public Boolean shouldShowConcordia() {
        return showConcordiaProperty().get();
    }
    public void setShowConcordia(Boolean b) {
        concordiaCheckBox.setSelected(b);
    }

    //***********************
    // Methods
    //***********************

    /** {@inheritDoc}
     */
    @FXML public void initialize() {
        // Populate isotope system choice box
        for (String s : STRING_TO_ISOTOPE_TYPE.keySet()) {
            isotopeSystemChoiceBox.getItems().add(s);
        }

        // Set default Base Plot properties.
        isotopeSystemChoiceBox.getSelectionModel().select(STRING_TO_ISOTOPE_TYPE.get((String) PROPERTIES.get(ISOTOPE_TYPE)).getName());

        titleTextField.setText((String) PROPERTIES.get(TITLE));
        xAxisTextField.setText((String) PROPERTIES.get(X_AXIS));
        yAxisTextField.setText((String) PROPERTIES.get(Y_AXIS));

        pointsCheckBox.setSelected((Boolean) PROPERTIES.get(POINTS));
        // TODO Enable point toggling
        pointsCheckBox.setDisable(true);
        ellipsesCheckBox.setSelected((Boolean) PROPERTIES.get(ELLIPSES));
//        crossesCheckBox.setSelected((Boolean) PROPERTIES.get(CROSSES));
        // TODO Implement Crosses
        crossesCheckBox.setVisible(false);

        pointsColorPicker.setValue(Color.valueOf((String) PROPERTIES.get(POINT_FILL_COLOR)));
        ellipsesColorPicker.setValue(Color.valueOf((String) PROPERTIES.get(ELLIPSE_FILL_COLOR)));
//        crossesColorPicker.setValue(Color.valueOf((String) PROPERTIES.get(CROSS_FILL_COLOR)));
        // TODO Implement Crosses
        crossesColorPicker.setVisible(false);

        concordiaCheckBox.setSelected((Boolean) PROPERTIES.get(CONCORDIA_LINE));
        switch (getIsotopeType()) {
            case Generic:
                concordiaCheckBox.setVisible(false);
                break;
            case UPb:
                concordiaCheckBox.setVisible(true);
                break;
            case UTh:
                concordiaCheckBox.setVisible(false);
                break;
            default:
                concordiaCheckBox.setVisible(false);
                break;
        }

        // Make sure properties are initialized
        isotopeSystemChoiceBox.getSelectionModel().selectedItemProperty().addListener(c -> {
            if (getIsotopeType() != STRING_TO_ISOTOPE_TYPE.get(isotopeSystemChoiceBox.getSelectionModel().getSelectedItem())) {
                isotopeTypeObjectProperty().set(STRING_TO_ISOTOPE_TYPE.get(isotopeSystemChoiceBox.getSelectionModel().getSelectedItem()));
            }
        });
        isotopeTypeObjectProperty().addListener(c -> {
            if (STRING_TO_ISOTOPE_TYPE.get(isotopeSystemChoiceBox.getSelectionModel().getSelectedItem()) != getIsotopeType()) {
                for (String s : isotopeSystemChoiceBox.getItems()) {
                    if (s.equals(isotopeType.get().getName())) {
                        isotopeSystemChoiceBox.getSelectionModel().select(s);
                        break;
                    }
                }
            }

            switch (getIsotopeType()) {
                case Generic:
                    concordiaCheckBox.setVisible(false);
                    break;
                case UPb:
                    concordiaCheckBox.setVisible(true);
                    break;
                case UTh:
                    concordiaCheckBox.setVisible(false);
                    break;
                default:
                    concordiaCheckBox.setVisible(false);
                    break;
            }
        });

        // Automatically adjust PROPERTIES
        isotopeTypeObjectProperty().addListener(c -> {
            PROPERTIES.put(ISOTOPE_TYPE, isotopeTypeObjectProperty().get().getName());
            updateProperties();
        });

        titleProperty().addListener(c -> {
            PROPERTIES.put(TITLE, titleProperty().get());
            updateProperties();
        });
        xAxisTitleProperty().addListener(c -> {
            PROPERTIES.put(X_AXIS, xAxisTitleProperty().get());
            updateProperties();
        });
        yAxisTitleProperty().addListener(c -> {
            PROPERTIES.put(Y_AXIS, yAxisTitleProperty().get());
            updateProperties();
        });

        showPointsProperty().addListener(c -> {
            PROPERTIES.put(POINTS, showPointsProperty().get());
            updateProperties();
        });
        showEllipsesProperty().addListener(c -> {
            PROPERTIES.put(ELLIPSES, showEllipsesProperty().get());
            updateProperties();
        });
//        showCrosses().addListener(c -> {
//            PROPERTIES.put(CROSSES, showCrossesProperty().get());
//            updateProperties();
//        });

        pointsColorProperty().addListener(c -> {
            PROPERTIES.put(POINT_FILL_COLOR, convertColor(pointsColorProperty().get()));
            updateProperties();
        });
        ellipsesColorProperty().addListener(c -> {
            PROPERTIES.put(ELLIPSE_FILL_COLOR, convertColor(ellipsesColorProperty().get()));
            updateProperties();
        });
//        crossesColor().addListener(c -> {
//            PROPERTIES.put(CROSS_FILL_COLOR, crossesColorProperty().get());
//            updateProperties();
//        });
        showConcordiaProperty().addListener(c -> {
            PROPERTIES.put(CONCORDIA_LINE, shouldShowConcordia());
            updateProperties();
        });

    }

    /**
     * Sets the plot that this panel manages to the specified {@code Plot}.
     *
     * @param plot  the new Plot
     */
    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    /**
     * Sets the plot that this panel manages to null.
     */
    public void removePlot() {
        this.plot = null;
    }

    /**
     * If a {@code Plot} is being managed by this panel, this method updates the properties of the plot.
     */
    private void updateProperties() {
        if (plot != null) {
            plot.setProperties(PROPERTIES);
        }
    }

    /**
     * Converts a Java {@code Color} into a {@code String} format that can be read by D3.js.
     * <p>
     * This is done by dropping the last two chars (which represent opacity), and replacing '0x' with '#'. For example,
     * 0x123456ff would be converted to #123456.
     *
     * @param c a Java Color
     * @return  a String color with format #000000
     */
    private String convertColor(Color c) {
        String s = c.toString();
        return s.substring(0, s.length() - 2).replaceAll("0x", "#");
    }

    /**
     * Returns {@link #PROPERTIES} as an {@code ObservableMap}.
     *
     * @return  an ObservableMap of properties
     */
    public ObservableMap<String, Object> getProperties() {
        return PROPERTIES;
    }

    /**
     * Sets all of the properties in the panel to the values specified by the supplied {@code Map}.
     *
     * @param plotProperties    a Map containing new property values
     */
    public void setProperties(Map<String, Object> plotProperties) {
        if (plotProperties.containsKey(TITLE)) setTitle((String) plotProperties.get(TITLE));
        if (plotProperties.containsKey(X_AXIS)) setxAxisTitle((String) plotProperties.get(X_AXIS));
        if (plotProperties.containsKey(Y_AXIS)) setyAxisTitle((String) plotProperties.get(Y_AXIS));
        if (plotProperties.containsKey(POINTS)) setShowPoints((Boolean) plotProperties.get(POINTS));
        if (plotProperties.containsKey(ELLIPSES)) setshowEllipses((Boolean) plotProperties.get(ELLIPSES));
//        if (plotProperties.containsKey(CROSSES)) setShowCrosses((Boolean) plotProperties.get(CROSSES));
        if (plotProperties.containsKey(POINT_FILL_COLOR)) setPointsColor(Color.valueOf((String) plotProperties.get(POINT_FILL_COLOR)));
        if (plotProperties.containsKey(ELLIPSE_FILL_COLOR)) setEllipsesColor(Color.valueOf((String) plotProperties.get(ELLIPSE_FILL_COLOR)));
//        if (plotProperties.containsKey(CROSS_FILL_COLOR)) setCrossesColor(Color.valueOf((String) plotProperties.get(CROSS_FILL_COLOR)));
        if (plotProperties.containsKey(ISOTOPE_TYPE)) setIsotopeType(STRING_TO_ISOTOPE_TYPE.get((String) plotProperties.get(ISOTOPE_TYPE)));
        if (plotProperties.containsKey(CONCORDIA_LINE)) setShowConcordia((Boolean) PROPERTIES.get(CONCORDIA_LINE));
    }

}
