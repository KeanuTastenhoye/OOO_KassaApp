package view;

import controller.ArtikelController;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import jxl.read.biff.BiffException;

import domain.Artikel;
import model.observer.Observer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class KlantTab extends GridPane implements Observer {
    private TableView table;
    private HBox hbox;
    private ArtikelController artikelController;
    private String artikelNr, artikelNaam, artikelGroep, artikelPrijs, artikelVoorraad;

    public KlantTab(ArtikelController controller) throws BiffException, IOException {
        this.artikelController = controller;
        //artikelController.registerObserver(this);
        this.setPadding(new Insets(5,5,5,5));
        this.setVgap(5);
        this.setHgap(5);

        Label totaalLabel = new Label("Totaal: ");
        Label bedragLabel = new Label("");

        TableColumn artikelNaam = new TableColumn<>("Naam");
        TableColumn artikelAantal = new TableColumn<>("Aantal");
        TableColumn artikelPrijs = new TableColumn<>("Prijs");

        artikelNaam.setCellValueFactory(new PropertyValueFactory("artikelNaam"));
        artikelAantal.setCellValueFactory(new PropertyValueFactory("artikelAantal"));
        artikelPrijs.setCellValueFactory(new PropertyValueFactory("artikelPrijs"));

        table = new TableView<String>();

        hbox = new HBox(totaalLabel, bedragLabel);

        table.setPrefWidth(REMAINING);
        table.getColumns().addAll(artikelNaam, artikelAantal, artikelPrijs);

        this.add(table, 0, 4, 2, 2);
        this.add(hbox, 0, 2, 1, 1);
    }

    @Override
    public void update(String artikelNr, String artikelNaam, String artikelGroep, String artikelPrijs, String artikelVoorraad) {
        this.artikelNr = artikelNr;
        this.artikelNaam = artikelNaam;
        this.artikelGroep = artikelGroep;
        this.artikelPrijs = artikelPrijs;
        this.artikelVoorraad = artikelVoorraad;
    }
}