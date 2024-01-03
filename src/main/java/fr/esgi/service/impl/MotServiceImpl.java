package fr.esgi.service.impl;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import fr.esgi.business.Mot;
import fr.esgi.service.MotService;

public class MotServiceImpl implements MotService {

	private static ArrayList<Mot> mots = new ArrayList<>();

	@Override
	public void importerMot() {
		try {
			CSVRecord csvRecord = null;
			@SuppressWarnings("deprecation")
			URL url = new URL("https://raw.githubusercontent.com/gverdier/motus/master/Console/Dictionnaire6.txt");

			Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()));

			CSVFormat csvFormat = CSVFormat.newFormat(',').builder().setHeader().setSkipHeaderRecord(true).build();

			CSVParser csvParser = new CSVParser(reader, csvFormat);

			while (csvParser.iterator().hasNext()) {

				csvRecord = csvParser.iterator().next();
				// On teste si la région est déjà présente dans l'ensemble des régions
				Mot mot = recupererMot(csvRecord.get(0));
				if (mot == null) {
					ajouterMot(mot);
				}

			}
		} catch (

		MalformedURLException e) {
			System.exit(-1);
		} catch (IOException e) {
			System.exit(-1);
		}
		try {
			CSVRecord csvRecord = null;
			@SuppressWarnings("deprecation")
			URL url = new URL("https://raw.githubusercontent.com/gverdier/motus/master/Console/Dictionnaire7.txt");

			Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()));

			CSVFormat csvFormat = CSVFormat.newFormat(',').builder().setHeader().setSkipHeaderRecord(true).build();

			CSVParser csvParser = new CSVParser(reader, csvFormat);

			while (csvParser.iterator().hasNext()) {

				csvRecord = csvParser.iterator().next();
				// On teste si la région est déjà présente dans l'ensemble des régions
				Mot mot = recupererMot(csvRecord.get(0));
				if (mot == null) {
					ajouterMot(mot);
				}

			}
		} catch (

		MalformedURLException e) {
			System.exit(-1);
		} catch (IOException e) {
			System.exit(-1);
		}
		try {
			CSVRecord csvRecord = null;
			@SuppressWarnings("deprecation")
			URL url = new URL("https://raw.githubusercontent.com/gverdier/motus/master/Console/Dictionnaire8.txt");

			Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()));

			CSVFormat csvFormat = CSVFormat.newFormat(',').builder().setHeader().setSkipHeaderRecord(true).build();

			CSVParser csvParser = new CSVParser(reader, csvFormat);

			while (csvParser.iterator().hasNext()) {

				csvRecord = csvParser.iterator().next();
				// On teste si la région est déjà présente dans l'ensemble des régions
				Mot mot = recupererMot(csvRecord.get(0));
				if (mot == null) {
					ajouterMot(mot);
				}

			}
		} catch (

		MalformedURLException e) {
			System.exit(-1);
		} catch (IOException e) {
			System.exit(-1);
		}

		System.out.println("Nombre de mot : " + mots.size());
	}

	@Override
	public Mot recupererMot(String nom) {
		return mots.stream().filter(mot -> mot != null && mot.getMot().equals(nom)).findFirst().orElse(null);
	}

	@Override
	public Mot ajouterMot(Mot mot) {
		mots.add(mot);
		return mot;
	}

}
