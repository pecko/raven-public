package Controller.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import Controller.datastructures.RGraph;
import Controller.datastructures.RNode;
import Controller.datastructures.RVector;

public class CsvReader {

	private static final String COMPOSITION = "Composition";
	private static final String VECTOR = "Vector";
	private static final String LEVEL = "Level";
	private static final String RESISTANCE = "Resistance";
	private static final String TYPE = "Type";
	private static final String RIGHT_OVERHANG = "Right Overhang";
	private static final String LEFT_OVERHANG = "Left Overhang";
	private static final String LIBRARY = "Library";
	private static final String SEQUENCE = "Sequence";
	private static final String NAME = "Name";
	private final static String[] PROPERTIES = {
		LIBRARY, NAME , SEQUENCE ,LEFT_OVERHANG, RIGHT_OVERHANG, TYPE,
		RESISTANCE,LEVEL,VECTOR,COMPOSITION 
	};
	
	public ArrayList<RGraph> getRGraphs(File file) throws IOException {
		Reader in = null;
		ArrayList<RGraph> graphs = new ArrayList<>();
		try {
			in = new FileReader(file);
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
			int i = 0;
			for (CSVRecord record : records) {
			    // skip row 1 and 2
				if (i < 2) {
			    	i++;
			    	continue;
			    }
				int j=0;
				Map<String, String> entries =  new HashMap<>();
				for (String property:PROPERTIES) {
			    	String value = record.get(j++);
			    	entries.put(property, value);
			    }
				RGraph graph = getRGraph(entries);
				if (graph != null) {
					graphs.add(graph);
				}
			}
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					// ignore
				}
			}
		}
		return graphs;
	}

	private RGraph getRGraph(Map<String, String> entries) {
		String name = entries.get(NAME);
		if (entries == null || name == null || name.isEmpty()) {
			return null;
		}
		RNode node = new RNode();
		node.setName(name);
		String comp = entries.get(COMPOSITION);
		if (comp != null && !comp.isEmpty()) {
			ArrayList<String> composition = new ArrayList<>();
			String[] elements = comp.split(",");
			for (String element:elements) {
				composition.add(element);
			}
			node.setComposition(composition);
		}
		String lOverhang = entries.get(LEFT_OVERHANG);
		node.setLOverhang(lOverhang);
		String rOverhang = entries.get(RIGHT_OVERHANG);
		node.setROverhang(rOverhang);
		int level = 0;
		try {
			level = new Integer(entries.get(LEVEL)).intValue();
		} catch (NumberFormatException e) {
			// ignore level = 0
		}
		String vectorName = entries.get(VECTOR);
		if (vectorName != null && !vectorName.isEmpty()) {
			RVector vector = new RVector(lOverhang, rOverhang, level, name, null);
			String resistence = entries.get(RESISTANCE);
			if (resistence != null && !resistence.isEmpty()) {
				vector.setStringResistance(resistence);
			}
			node.setVector(vector);
		}
		
		// FIXME RNode has a few sequences (special, PCR, left, right)
		// I'm not sure what to add here
		//node.setSequence(entries.get(SEQUENCE));
		node.setPCRSeq(entries.get(SEQUENCE));
		RGraph graph = new RGraph(node);
		//graph.set
		return graph;
	}
}
