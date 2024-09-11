import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import models.ListId;

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

            // while ther eis a next line of content
            while ((inputLine = br.readLine()) != null) {
                // remove all the excess char to prepare to split the string
                String newIString = inputLine.replaceAll("[^0-9,]", "");
                // check for any lines that do not have usable data
                if (newIString.length() > 1) {
                    // create String array that will be used for each object
                    String[] stringList = newIString.split(",", 4);
                    // put each string array into my object and add them to the arraylist
                    ids.add(new ListId(Integer.parseInt(stringList[0]), Integer.parseInt(stringList[1]),
                            stringList[2]));
                }

            }

            br.close();

        }
        // catch url errors
        catch (IOException e) {
            e.printStackTrace();
        }

        // System.out.println("Enter any key then 'Enter' to display sorted Id List");

        // String ans = scan.nextLine();

        // if (ans == "Enter") {

        ids.removeIf(n -> (((ListId) n).getName() == null || ((ListId) n).getName().isBlank()));

        // sort arrayList by ListId id value
        Collections.sort(ids, new Comparator<ListId>() {
            public int compare(ListId o1, ListId o2) {
                if (o1.getListId() == o2.getListId()) {
                    return o1.getName().compareTo(o2.getName());
                } else
                    return o1.getListId() < o2.getListId() ? -1 : 1;
            }
        });

        // Print all lines of the ArrayList of Obj to the terminal
        @SuppressWarnings("rawtypes")
        Iterator iterator = ids.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
        // }

    }

}