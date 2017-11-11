import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/*
Brandon Dalton
University of Southern California
Institute for Creative Technologies
Mass-IG Research Project

Definition: The centroid is the average position of
all points in (R^n) .

Motivation: k-means

 */
public class Centroid {
    private static ArrayList<Data> data = new ArrayList<Data>();
    public static void main(String[] args){
        //First we need to import the file.
        try{
            //For this example we will use a csv file in R^2 containing floating pt data.
            BufferedReader br = new BufferedReader(new FileReader("data.csv"));
            String line = "";
            while((line = br.readLine()) != null){
                //Now we need to separate the data
                int commaPos = line.indexOf(',');
                String first = line.substring(0, commaPos);
                String last = line.substring(commaPos+1, line.length());
                data.add(new Data(Double.parseDouble(first), Double.parseDouble(last)));
            }

            //Compute the average.
            double xAv = 0.0;
            double yAv = 0.0;
            for(Data d : data){
                xAv+=d.getA();
                yAv+=d.getB();
            }

            xAv = xAv/data.size();
            yAv = yAv/data.size();

            //Print out the result.
            System.out.println(xAv + ", " + yAv);
        } catch (IOException e){
            System.out.println("Issue! " + e.toString());
        }


    }
}


class Data {
    private double a, b;
    public Data(double a, double b){
        this.a = a;
        this.b = b;
    }

    public double getA(){
        return this.a;
    }

    public double getB(){
        return this.b;
    }

    public String toString(){
        return this.a + ", " + this.b;
    }
}
