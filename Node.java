import java.util.ArrayList;
import java.util.List;

public class Node {

    public Long id;
    public Long pid;
    public String name;
    public List<Node> children;

    public Node(Long id, Long pid, String name){
        this.id = id;
        this.pid = pid;
        this.name = name;
        children = new ArrayList<Node>();
    }

    public Node(Node node){
        this.id = node.id;
        this.pid = node.pid;
        this.name = node.name;
        children = new ArrayList<Node>();
    }

    public boolean isRoot(){
        return (pid == null);
    }

}
