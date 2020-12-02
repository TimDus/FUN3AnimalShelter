package GUI;

import Animals.*;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.*;

public class Gui {
    public Button btreserveAnimal;
    public Button btnSave;
    public Button btnLoad;
    public TextField txtFieldName;
    public TextField txtFieldReservorName;
    public ComboBox comboBoxSpecies;
    public RadioButton radioButtonMale;
    public RadioButton radioButtonFemale;
    public ToggleGroup genderGroup = new ToggleGroup();
    public TextField txtFieldHabit;
    public ListView listViewAnimals;
    private Reservation reservation = new Reservation();

    public void initialize() {
        ObservableList<String> species = FXCollections.observableArrayList("Cat", "Dog");
        comboBoxSpecies.setItems(species);

        radioButtonFemale.setToggleGroup(genderGroup);
        radioButtonMale.setToggleGroup(genderGroup);
    }

    public void addAnimal(ActionEvent actionEvent) {
        if (comboBoxSpecies.getValue() != null) {
            if (!txtFieldName.getText().equals("")) {
                RadioButton rBtn = (RadioButton) genderGroup.getSelectedToggle();

                if (comboBoxSpecies.getValue() == "Dog") {
                    reservation.newDog(txtFieldName.getText(), rBtn.getText().equals("Male") ? Gender.Male : Gender.Female);
                } else {
                    reservation.newCat(txtFieldName.getText(), rBtn.getText().equals("Male") ? Gender.Male : Gender.Female, !txtFieldHabit.getText().equals("") ? txtFieldHabit.getText() : "");
                }
                updateTextArea();
            } else {
                System.out.println("Please give the " + comboBoxSpecies.getValue() + " a name!");
            }
        } else {
            System.out.println("Please select a species!");
        }
    }

    public void reserveAnimal(ActionEvent actionEvent) {
        String[] split = listViewAnimals.getSelectionModel().getSelectedItem().toString().split(" ");
        for (Animal animal : reservation.getAnimals()) {
            if (((animal instanceof Dog && split[0].equals("Dog")) || (animal instanceof Cat && split[0].equals("Cat"))) && animal.getName().equals(split[1])) {
                if (!txtFieldReservorName.getText().equals("")) {
                    animal.Reserve(txtFieldReservorName.getText());
                    updateTextArea();
                }
            }
        }
    }

    private void updateTextArea() {
        listViewAnimals.getItems().clear();
        for (Animal animal : reservation.getAnimals()) {
            String specie = animal instanceof Dog ? "Dog" : "Cat";
            String animalInList = specie + " " + animal.getName() + " " + animal.getGender() + " " + animal.getPrice() + " ";
            if (animal.getReservedBy() != null) {
                animalInList += " Reserved by " + animal.getReservedBy().toString();
            }
            listViewAnimals.getItems().add(animalInList);
        }
    }

    public void saveList() {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("Files/Shelter");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(reservation);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void loadList() {
        try {
            FileInputStream fileIn = new FileInputStream("Files/Shelter");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            reservation = (Reservation) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return;
        }

        updateTextArea();
    }
}
