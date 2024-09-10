import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    // create new arraylist to store the objects
    static ArrayList ids = new ArrayList<ListId>();

    // open Scanner
    public static Scanner scan = new Scanner(System.in);

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // fetch the Url here
        try {
            // create a String for the URL
            String u = "https://fetch-hiring.s3.amazonaws.com/hiring.json";
            URL url = new URL(u);

            // Open Url stream and read the URL content
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            // String to store each line of content
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                String newIString = inputLine.replaceAll("[^0-9,]", "");
                String[] stringList = newIString.split(",");
                System.out.println(stringList[1]);
            }

            br.close();

        }
        // catch url errors
        catch (IOException e) {
            e.printStackTrace();
        }

        // create ListId from scanned Strings
        // add ListId objects to ArrayList
        ListId first = new ListId(2, 17, "mark");
        ListId second = new ListId(4, 100, "nolan");
        ListId third = new ListId(3, 45, "debbie");
        ListId fourth = new ListId(0, 0, null);

        ids.add(first);
        ids.add(second);
        ids.add(third);
        ids.add(fourth);

        // take the Array, [0], [1], [2], create the new object
        // push object to ids.

        System.out.println("Enter 1 to display Id List");
        System.out.println("Enter 2 to display Sorted by Id List");
        System.out.println("Enter 3 to display Sorted by name List");
        System.out.println("Enter 4 to display List without blank names");

        String ans = scan.nextLine();

        // Switch 1, 2, 0r 3
        switch (ans) {
            case "1":
                // Run 1: display the ArrayList of LisID
                break;
            case "2":
                // run 2: sort arrayList by ListId id value
                Collections.sort(ids, new Comparator<ListId>() {
                    public int compare(ListId o1, ListId o2) {
                        return o1.listId < o2.listId ? -1 : 1;
                    }
                });
                break;
            case "3":
                // run 3: sort arrayList by ListId name
                Collections.sort(ids, new Comparator<ListId>() {
                    public int compare(ListId o1, ListId o2) {
                        return o1.getName().compareTo(o2.getName());
                    }

                });
                break;

            case "4":
                // run 4: eliminate ListId's containing null and display arraylist
                ids.removeIf(n -> (((ListId) n).getName() == null || ((ListId) n).getName().isBlank()));
                break;
        }

        System.out.println(ids.toString());

    }

}
