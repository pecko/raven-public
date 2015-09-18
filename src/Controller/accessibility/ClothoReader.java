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
		return vector == null ? null : new RVector(vector.getLeftOverhang(), vector.getRightOverhang(), 
				vector.getLevel(), vector.getName(), vector.getUUID());
	}

	public static HashMap<String, RGraph> partImportClotho(ArrayList<Part> partLibrary, 
			HashSet<String> discouraged,
			HashSet<String> recommended) {
		HashMap<String, RGraph> graphMap = new HashMap<>();
		for (Part part:partLibrary) {
			String name = part.getName();
			boolean d = discouraged.contains(name);
			boolean r = recommended.contains(name);
			RNode node = getNode(part, d, r);
			RGraph graph = new RGraph(node);
			graphMap.put(name, graph);
		}
		return graphMap;
	}

	private static RNode getNode(Part part, boolean discouraged,
			boolean recommended) {
		RNode node = new RNode();
		String name = part.getName();
		node.setName(name);
		node.setDiscouraged(discouraged);
		node.setRecommended(recommended);
		return node;
	}

	public static ArrayList<RNode> gpsToNodesClotho(HashSet<Part> gps) {
		ArrayList<RNode> nodes = new ArrayList<>();
		for (Part part:gps) {
			RNode node = getNode(part, false, false);
			nodes.add(node);
		}
		return nodes;
	}

	public static ArrayList<String> parseTags(ArrayList<String> searchTags, String string) {
		ArrayList<String> list = new ArrayList<>();
		if (searchTags != null && searchTags.contains(string)) {
			list.add(string);
		}
		return list;
	}

}
