package aoc.days.aoc_2015;

import aoc.days.Day;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Day19a extends Day {

    private List<Pair<String, String>> replacements = new ArrayList<>();
    private String molecule;

    public Day19a() {
        super();
        prepareMoleculeInput();
    }

    @Override
    public void resolve() {

        Set<String> keys = replacements.stream().map(Pair::getLeft).collect(Collectors.toSet());
        List<String> moleculeTokens = tokenizeMolecule(keys, molecule);
        Set<String> newMolecules = prepareNewMolecules(keys, moleculeTokens);

        setResult(newMolecules.size());
    }

    protected Set<String> prepareNewMolecules(Set<String> keys, List<String> moleculeTokens) {
        Set<String> newMolecules = new HashSet<>();
        for (int i = 0; i < moleculeTokens.size(); i++) {
            String currentMolecule = moleculeTokens.get(i);
            if (keys.contains(currentMolecule)) {
                String firstPart = String.join("", moleculeTokens.subList(0, i));
                String secondPart = String.join("", moleculeTokens.subList(i + 1, moleculeTokens.size()));
                replacements.stream().filter(r -> r.getLeft().equals(currentMolecule)).forEach(r -> {
                    newMolecules.add(firstPart + r.getRight() + secondPart);
                });
            }
        }
        return newMolecules;
    }

    protected List<String> tokenizeMolecule(Set<String> keys, String testMolecule) {
        List<String> moleculeTokens = new ArrayList<>();
        while (!testMolecule.isBlank()) {
            if (testMolecule.length() > 1 && keys.contains(testMolecule.substring(0, 2))) {
                moleculeTokens.add(testMolecule.substring(0, 2));
                testMolecule = testMolecule.substring(2);
            } else {
                moleculeTokens.add(testMolecule.substring(0, 1));
                testMolecule = testMolecule.substring(1);
            }
        }
        return moleculeTokens;
    }

    protected void prepareMoleculeInput() {
        for (String line : getInput()) {
            if (line.isBlank()) {
                break;
            }
            String[] ins = line.split(" => ");
            replacements.add(new ImmutablePair<>(ins[0], ins[1]));
        }

        molecule = getInput().get(getInput().size() - 1);
    }

    public List<Pair<String, String>> getReplacements() {
        return replacements;
    }

    public void setReplacements(List<Pair<String, String>> replacements) {
        this.replacements = replacements;
    }

    public String getMolecule() {
        return molecule;
    }

    public void setMolecule(String molecule) {
        this.molecule = molecule;
    }
}

