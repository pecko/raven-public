package Controller.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import Controller.algorithms.nonmodasm.RGibson;
import Controller.datastructures.Collector;
import Controller.datastructures.Part;
import Controller.datastructures.RGraph;
import Controller.datastructures.Vector;

public class RMain {
	public static void main(String[] args) {

		// create list RGraph objects
		
		// try to predict input parameters
		
		if (args.length != 1) {
			System.err.println("Usage: RMain <csv_file>");
			return;
		}

		File file = new File(args[0]);
		if (!file.isFile()) {
			System.err.println("Invalid csv_file " + args[1]);
			return;
		}
		
		try {
			ArrayList<RGraph> graphs = new CsvReader().getRGraphs(file);
			showGraphs(graphs);
		} catch (IOException e) {
			System.err.println("Invalid csv_file " + args[1]);
			e.printStackTrace();
			return;
		}
		
//		Part part = Part.generateBasic("Demo Part","ATCG",null);
//		ArrayList<Part> partLibrary = new ArrayList<>();
//		partLibrary.add(part);
//		
//		HashSet<Part> gps = new HashSet<>();
//		gps.add(part);
//		
//		HashSet<String> required = new HashSet<>();
//		HashSet<String> recommended = new HashSet<>();
//		HashMap<Integer, Double> efficiencies = new HashMap<>();
//		HashMap<Integer, Vector> stageVectors = new HashMap<>();
//		ArrayList<Double> costs = new ArrayList<>();
//		Integer minCloneLength = new Integer(0);
//		Collector collector = new Collector();
//		HashSet<String> forbidden = new HashSet<>();
//		HashSet<String> discouraged = new HashSet<>();
//		
//		// call RGibson().gibsonClothoWrapper()
//		try {
//			ArrayList<RGraph> graphs = new RGibson().gibsonClothoWrapper(gps, required, recommended, 
//					forbidden, discouraged, partLibrary,
//					efficiencies, stageVectors, costs, minCloneLength, collector);
//			// show something
//			showGraphs(graphs);
//		} catch (Exception e) {
//			// TODO inform user
//			e.printStackTrace();
//		}
	}

	private static void showGraphs(ArrayList<RGraph> graphs) {
		// TODO just print names for now
		for (RGraph graph:graphs) {
			System.out.println(graph.getRootNode().getName());
		}
	}
}
