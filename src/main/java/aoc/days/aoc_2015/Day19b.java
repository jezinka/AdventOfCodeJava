package aoc.days.aoc_2015;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public class Day19b extends Day19a {

    public Day19b() {
        super();
    }

    @Override
    public void resolve() {

        StringBuilder molecule = new StringBuilder(getMolecule());

        Set<String> keys = getReplacements().stream().map(Pair::getRight).collect(Collectors.toSet());
        int counter = 0;
        StringBuilder leftovers = new StringBuilder();

        while (!molecule.toString().equals("e")) {

            StringBuilder finalMolecule = molecule;
            Optional<String> lastToken = keys.stream().filter(k -> finalMolecule.toString().endsWith(k)).findFirst();
            if (lastToken.isPresent()) {
                molecule = new StringBuilder(molecule.substring(0, molecule.lastIndexOf(lastToken.get())));
                Optional<Pair<String, String>> replacement = getReplacements().stream().filter(r -> r.getRight().equals(lastToken.get())).findFirst();
                if (replacement.isPresent()) {
                    molecule.append(replacement.get().getLeft());
                    counter++;

                    if (!leftovers.isEmpty()) {
                        molecule.append(leftovers);
                        leftovers = new StringBuilder();
                    }
                }
            } else {
                leftovers.insert(0, molecule.substring(molecule.length() - 1));
                molecule = new StringBuilder(molecule.substring(0, molecule.length() - 1));
            }

        }

        setResult(counter);
    }
}

