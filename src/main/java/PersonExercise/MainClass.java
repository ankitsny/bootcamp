package PersonExercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;




public class MainClass
{

    public static void main(String[] args) {

        try {
            ShanFamilyTreeBuilder.build();
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (args.length < 1 )
        {
            throw new RuntimeException("No arguments passed");
        }

        Command executor = CommandManager.getInstanceByName(args[0]);

        System.out.println(executor.execute(Arrays.copyOfRange(args,1,args.length)));
    }
}


class CommandManager{
    private static HashMap<String, Command> map =new HashMap<String, Command>();
    static {
        try {
            map.put("GET_RELATIONSHIP", new GetRelationship());
            map.put("ADD_SPOUSE", new AddSpouse());
            map.put("ADD_CHILD", new AddChild());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Command getInstanceByName(String commandName)
    {
        if(!map.containsKey(commandName))
        {
            throw new RuntimeException("Command not found");
        }
        return  map.get(commandName);
    }
}

abstract class Command{

    HashMap<String,Person> familyTree = new HashMap<>();

    abstract  String execute(String... args);

    Command() {
        buildFamilyTree(ShanFamilyTreeBuilder.KING_SHAN);
        
    }
    
    private void buildFamilyTree(Person parent) {
        familyTree.put(parent.getName(),parent);
        for (Person child:parent.getChildren()) {
            buildFamilyTree(child);
        }
    }

    public boolean isPersonMemberOfFamilyTree(String name){
        return familyTree.containsKey(name);
    }
}
class GetRelationship extends Command{

    private boolean isValidArgs(String[] args) {
        if(args.length != 2) {
            return false;
        }
        return  true;
    }

    @Override
    public String execute(String... args) {
        if(
                isValidArgs(args) &&
                isPersonMemberOfFamilyTree(args[0])
        ){
            return familyTree
                    .get(args[0])
                    .getMaternalUncles()
                    .stream()
                    .map(p -> p.getName())
                    .collect(Collectors.joining(","));
        }
        return "";
    }
}

class AddSpouse extends Command{

    private boolean isValidArgs(String[] args) {
        if(args.length != 2) {
            return false;
        }
        return  true;
    }

    @Override
    public String execute(String... args) {
        if(isValidArgs(args)){

        }
        return null;
    }
}

class AddChild extends Command{

    private boolean isValidArgs(String[] args) {
        if(args.length != 2) {
            return false;
        }
        return  true;
    }

    @Override
    public String execute(String... args) {
        if(isValidArgs(args)){

        }
        return null;
    }
}