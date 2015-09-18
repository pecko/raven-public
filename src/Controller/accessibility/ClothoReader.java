package Controller.accessibility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import Controller.datastructures.Part;
import Controller.datastructures.RGraph;
import Controller.datastructures.RNode;
import Controller.datastructures.RVector;
import Controller.datastructures.Vector;

/**
 * 
 * Fake class to compile the project
 * 
 * @author snpe
 *
 */
public class ClothoReader {

	public static RVector vectorImportClotho(Vector vector) {
		// TODO Auto-generated method stub
		return null;
	}

	public static HashMap<String, RGraph> partImportClotho(ArrayList<Part> partLibrary, HashSet<String> discouraged,
			HashSet<String> recommended) {
		HashMap<String, RGraph> graphMap = new HashMap<>();
		// FIXME convert partLibrary
		return graphMap;
	}

	public static ArrayList<RNode> gpsToNodesClotho(HashSet<Part> gps) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	public static ArrayList<String> parseTags(ArrayList<String> searchTags, String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
