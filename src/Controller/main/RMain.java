package Controller.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Controller.algorithms.nonmodasm.RGibson;
import Controller.datastructures.Collector;
import Controller.datastructures.Part;
import Controller.datastructures.RGraph;
import Controller.datastructures.Vector;

public class RMain {
	public static void main(String[] args) {

		// create list RGraph objects
		// try to predict input parameters

		HashSet<Part> gps = new HashSet<>();
		HashSet<String> required = new HashSet<>();
		HashSet<String> recommended = new HashSet<>();
		HashMap<Integer, Double> efficiencies = new HashMap<>();
		HashMap<Integer, Vector> stageVectors = new HashMap<>();
		ArrayList<Double> costs = new ArrayList<>();
		Integer minCloneLength = new Integer(0);
		Collector collector = new Collector();
		HashSet<String> forbidden = new HashSet<>();
		HashSet<String> discouraged = new HashSet<>();
		ArrayList<Part> partLibrary = new ArrayList<>();
		try {
			ArrayList<RGraph> graphs = new RGibson().gibsonClothoWrapper(gps, required, recommended, 
					forbidden, discouraged, partLibrary,
					efficiencies, stageVectors, costs, minCloneLength, collector);
			showGraphs(graphs);
		} catch (Exception e) {
			// TODO inform user
			e.printStackTrace();
		}
	}

	private static void showGraphs(ArrayList<RGraph> graphs) {
		// TODO show graph to user in some way
	}
}
