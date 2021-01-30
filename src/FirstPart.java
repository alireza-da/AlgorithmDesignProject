import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FirstPart {
    public int[] findPoirotSection(char[][] field, int firingTime){
        ArrayList<ArrayList<Integer>> clearSections = new ArrayList<>();
        ArrayList<ArrayList<Integer>> burningSections = new ArrayList<>();
        int[] answer = new int[2];
        int m = field.length;
        int n = field[0].length;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                ArrayList<Integer> position = new ArrayList<>();
                position.add(i);
                position.add(j);
                clearSections.add(position);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] == 'f') {
                    ArrayList<Integer> position = new ArrayList<>();
                    position.add(i);
                    position.add(j);
                    clearSections.remove(position);
                    position.add(0); // starting time
                    burningSections.add(position);
                }
            }
        }
        if (burningSections.size() == 0){
            return answer;
        }
        while (clearSections.size() > 0) {
            for (int i = 0; i < burningSections.size(); i++) {
                ArrayList<Integer> position= new ArrayList<>();
                position.add(burningSections.get(i).get(0));
                position.add(burningSections.get(i).get(1));
                position.set(0,position.get(0) - 1);
                position.set(1,position.get(1) - 1);
                if (clearSections.contains(position)){
                    ArrayList<Integer> burningPosition = new ArrayList<>();
                    burningPosition.add(position.get(0));
                    burningPosition.add(position.get(1));
                    burningPosition.add(burningSections.get(i).get(2));
                    if (!burningSections.contains(burningPosition)) {
                        burningPosition.set(2,burningPosition.get(2)+firingTime);
                        burningSections.add(burningPosition);
                        clearSections.remove(position);
                    }
                }
                position.set(1,position.get(1) + 1);
                if (clearSections.contains(position)){
                    ArrayList<Integer> burningPosition = new ArrayList<>();
                    burningPosition.add(position.get(0));
                    burningPosition.add(position.get(1));
                    burningPosition.add(burningSections.get(i).get(2));
                    if (!burningSections.contains(burningPosition)) {
                        burningPosition.set(2,burningPosition.get(2)+firingTime);
                        burningSections.add(burningPosition);
                        clearSections.remove(position);
                    }
                }
                position.set(1,position.get(1) + 1);
                if (clearSections.contains(position)){
                    ArrayList<Integer> burningPosition = new ArrayList<>();
                    burningPosition.add(position.get(0));
                    burningPosition.add(position.get(1));
                    burningPosition.add(burningSections.get(i).get(2));
                    if (!burningSections.contains(burningPosition)) {
                        burningPosition.set(2,burningPosition.get(2)+firingTime);
                        burningSections.add(burningPosition);
                        clearSections.remove(position);
                    }
                }
                position.set(0,position.get(0)+ 1);
                position.set(1,position.get(1) - 2);
                if (clearSections.contains(position)){
                    ArrayList<Integer> burningPosition = new ArrayList<>();
                    burningPosition.add(position.get(0));
                    burningPosition.add(position.get(1));
                    burningPosition.add(burningSections.get(i).get(2));
                    if (!burningSections.contains(burningPosition)) {
                        burningPosition.set(2,burningPosition.get(2)+firingTime);
                        burningSections.add(burningPosition);
                        clearSections.remove(position);
                    }
                }
                position.set(1,position.get(1) + 2);
                if (clearSections.contains(position)){
                    ArrayList<Integer> burningPosition = new ArrayList<>();
                    burningPosition.add(position.get(0));
                    burningPosition.add(position.get(1));
                    burningPosition.add(burningSections.get(i).get(2));
                    if (!burningSections.contains(burningPosition)) {
                        burningPosition.set(2,burningPosition.get(2)+firingTime);
                        burningSections.add(burningPosition);
                        clearSections.remove(position);
                    }
                }
                position.set(0,position.get(0)+ 1);
                position.set(1,position.get(1) - 2);
                if (clearSections.contains(position)){
                    ArrayList<Integer> burningPosition = new ArrayList<>();
                    burningPosition.add(position.get(0));
                    burningPosition.add(position.get(1));
                    burningPosition.add(burningSections.get(i).get(2));
                    if (!burningSections.contains(burningPosition)) {
                        burningPosition.set(2,burningPosition.get(2)+firingTime);
                        burningSections.add(burningPosition);
                        clearSections.remove(position);
                    }
                }
                position.set(1,position.get(1) + 1);
                if (clearSections.contains(position)){
                    ArrayList<Integer> burningPosition = new ArrayList<>();
                    burningPosition.add(position.get(0));
                    burningPosition.add(position.get(1));
                    burningPosition.add(burningSections.get(i).get(2));
                    if (!burningSections.contains(burningPosition)) {
                        burningPosition.set(2,burningPosition.get(2)+firingTime);
                        burningSections.add(burningPosition);
                        clearSections.remove(position);
                    }
                }
                position.set(1,position.get(1) + 1);
                if (clearSections.contains(position)){
                    ArrayList<Integer> burningPosition = new ArrayList<>();
                    burningPosition.add(position.get(0));
                    burningPosition.add(position.get(1));
                    burningPosition.add(burningSections.get(i).get(2));
                    if (!burningSections.contains(burningPosition)) {
                        burningPosition.set(2,burningPosition.get(2)+firingTime);
                        burningSections.add(burningPosition);
                        clearSections.remove(position);
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> answers = new ArrayList<>();
        int longestClearTime = burningSections.get(n*m-1).get(2);
        for (ArrayList<Integer> burningSection : burningSections) {
            if (burningSection.get(2) == longestClearTime) {
                answers.add(burningSection);
            }
        }
        answer[0] = answers.get(0).get(0);
        answer[1] = answers.get(0).get(1);
        for (ArrayList<Integer> a:answers
             ) {
            if(a.get(0) < answer[0] || (a.get(0) == answer[0] && a.get(1) < answer[1])){
                answer[0] = a.get(0);
                answer[1] = a.get(1);
            }
        }
        return answer;
    }
    public ArrayList<HashMap<char[][],Integer>> getInput(String fileName){
        ArrayList<HashMap<char[][],Integer>> fields = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();
        try {
            File input = new File(fileName);
            if (input.canRead()) {
                Scanner fileObject = new Scanner(input);
                while (fileObject.hasNextLine()){
                    data.add(fileObject.nextLine());
                }
                fileObject.close();

            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int m = 0,n = 0,firingTime = 0;
        char[][]field = new char[m][n];
        for (int i = 0; i < data.size(); i++) {
            if(isNumeric(data.get(i).split(" ")[0])) {
                String[] fieldDimensions = data.get(i).split(" ");
                m = Integer.parseInt(fieldDimensions[0]);
                n = Integer.parseInt(fieldDimensions[1]);
                firingTime = Integer.parseInt(fieldDimensions[2]);
                field = new char[m][n];
            }
            else {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        switch (data.get(i).split("")[k]) {
                            case "-":
                                field[j][k] = '-';
                                break;
                            case "f":
                                field[j][k] = 'f';
                                break;
                            case "s":
                                field[j][k] = 's';
                                break;
                            case "t":
                                field[j][k] = 't';
                                break;
                        }
                    }
                    i++;
                }
                i--;
                HashMap<char[][],Integer> fieldDetail = new HashMap<>();
                fieldDetail.put(field,firingTime);
                fields.add(fieldDetail);
            }
        }
        return fields;
    }
    private boolean isNumeric(String s){
        try{
            int i = Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }
    public static void main(String[] args) {
        FirstPart firstPart = new FirstPart();
        ArrayList<HashMap<char[][], Integer>> data = firstPart.getInput(args[0]); // first argument of program is input file
        try {
            File output = new File(args[1]);
            if (output.createNewFile() || output.canRead()){
                FileWriter writer = new FileWriter(args[1]); // second argument of program is output file
                for (HashMap<char[][],Integer> entry : data) {
                    writer.write(firstPart.findPoirotSection(entry.keySet().iterator().next(),entry.get(entry.keySet().iterator().next()))[0]+" "
                            +firstPart.findPoirotSection(entry.keySet().iterator().next(),entry.get(entry.keySet().iterator().next()))[1]+'\n');
                }
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
