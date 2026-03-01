package Pack;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;

public class SimpleScraper {

    public static void main(String[] args) throws Exception {

        String url = "https://webscraper.io/test-sites/e-commerce/static";
        Document doc = Jsoup.connect(url).get();

        Elements items = doc.select(".thumbnail");

        FileWriter file = new FileWriter("products.csv");
        file.write("Name,Price,Rating\n");

        for (Element item : items) {
            String name = item.select(".title").text();
            String price = item.select(".price").text();
            String rating = item.select(".ratings p").text();

            file.write(name + "," + price + "," + rating + "\n");
        }

        file.close();
        System.out.println("Saved to products.csv");
    }
}


