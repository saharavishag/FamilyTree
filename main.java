
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class main {

    private static void scanForChild(List<Node> roots, List<Node> nodes) {
        if (nodes.isEmpty())
            return;
        Iterator itrRoots = roots.iterator();
        while(itrRoots.hasNext()){
            Node r = (Node)itrRoots.next();
            Iterator itrNodes = nodes.iterator();
            while (itrNodes.hasNext()){
                Node n = (Node)itrNodes.next();
                if(r.id == n.pid){
                    r.children.add(n);
                    itrNodes.remove();
                }
            }
            scanForChild(r.children, nodes);
        }
    }

    private static void printTree(List<Node> roots, int i){

        if(roots.isEmpty())
            return;
        for (Node r : roots){
            for(int j = 0; j < i ; j++){
                System.out.print("--");
            }
            System.out.println(r.id + " " + r.name);
            int k = i + 1;
            printTree(r.children, k);
        }
    }

    static private List<Node> FromJson(){

        ArrayList<Node> nodes = new ArrayList<Node>();
        JSONParser parser = new JSONParser();
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Programming\\Training\\pidExample.json"));
            for (Object o : a)
            {
                JSONObject data = (JSONObject) o;

                Long id = (Long) data.get("pid");
                Long pid = (Long) data.get("ppid");
                String name = (String) data.get("name");

                Node n = new Node(id, pid, name);
                nodes.add(n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return nodes;
    }

    public static void main(String[] args) {

        List<Node> nodes = FromJson();
        List<Node> roots = new ArrayList<Node>();
        Iterator itr = nodes.iterator();
        // set up roots
        while (itr.hasNext()){
            Node n = (Node)itr.next();
            if(n.isRoot()){
                roots.add(n);
                itr.remove();
            }
        }
        // scan for childs
        scanForChild(roots, nodes);
        // print childs
        printTree(roots, 0);

    }


}

