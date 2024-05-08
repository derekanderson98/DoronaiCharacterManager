package models.species;

import java.util.ArrayList;

public class SpeciesIndex {
    private ArrayList<SpeciesInfo> speciesList;

    public SpeciesInfo getSpecies(String speciesName) {
        for (SpeciesInfo species : speciesList) {
            if (species.getSpeciesName().equals(speciesName)) return species;
        }
        return null;
    }

    public SpeciesIndex(ArrayList<SpeciesInfo> speciesList) {
        this.speciesList = speciesList;
    }

    public ArrayList<SpeciesInfo> getSpeciesList() {
        return speciesList;
    }

    public ArrayList<String> getSpeciesNames() {
        ArrayList<String> names = new ArrayList<>();

        for (SpeciesInfo species : speciesList) {
            names.add(species.getSpeciesName());
        }

        return names;
    }

    public void setSpeciesList(ArrayList<SpeciesInfo> speciesList) {
        this.speciesList = speciesList;
    }
}
