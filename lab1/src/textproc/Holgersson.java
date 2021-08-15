package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.w3c.dom.Text;

public class Holgersson {

	public static final String[] REGIONS = {"nils", "norge", "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();

		List<TextProcessor> list = new ArrayList<>();
		list.add(new SingleWordCounter("nils"));
		list.add(new SingleWordCounter("norge"));
		
		MultiWordCounter multi = new MultiWordCounter(REGIONS);
		Set<String> stopwords = new HashSet<String>();

		Scanner s = new Scanner(new File("lab1/src/nilsholg.txt"));
		Scanner scan = new Scanner(new File("lab1/src/undantagsord.txt"));
		
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while(scan.hasNext()) {
			String putMe = scan.next().toLowerCase();
			stopwords.add(putMe);
		}
		scan.close();

		TextProcessor r = new GeneralWordCounter(stopwords);

			while (s.hasNext()) {
			String word = s.next().toLowerCase();
			//multi.process(word);
			r.process(word);
		} 

		s.close();
		r.report();
		long t1 = System.nanoTime();

		System.out.println("Tid: " + (t1 - t0) / 1000000.0 + " ms");
	//	multi.report();
	}
}