package example;

import java.util.ArrayList;
import java.util.List;

import org.carrot2.core.Cluster;
import org.carrot2.core.Document;

import cn.edu.hit.mitlab.cluster.Clusters;

public class example {
	public static void main(String[] args) {
		final ArrayList<Document> documents = new ArrayList<Document>();
		LoadTxt.load("corpus2", documents);
		Clusters test = new Clusters();
		List<Cluster> result = test.getClustersBySTCClusteringAlgorithm(documents, "");
		for(Cluster c: result){
			for(Document d: c.getAllDocuments()){
				System.out.print(d.getTitle() + " ");
			}
			System.out.println();
		}
	}
	public static void accuracy(){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void test(String[] args) {
		final String[][] data = new String[][]

		{
				{
						"http://en.wikipedia.org/wiki/Data_mining",
						"Data mining - Wikipedia, the free encyclopedia",
						"Article about knowledge-discovery in databases (KDD), the practice of automatically searching large stores of data for patterns." },

				{
						"http://www.ccsu.edu/datamining/resources.html",
						"CCSU - Data Mining",
						"A collection of Data Mining links edited by the Central Connecticut State University ... Graduate Certificate Program. Data Mining Resources. Resources. Groups ..." },

				{
						"http://www.kdnuggets.com/",
						"KDnuggets: Data Mining, Web Mining, and Knowledge Discovery",
						"Newsletter on the data mining and knowledge industries, offering information on data mining, knowledge discovery, text mining, and web mining software, courses, jobs, publications, and meetings." },

				{
						"http://en.wikipedia.org/wiki/Data-mining",
						"Data mining - Wikipedia, the free encyclopedia",
						"Data mining is considered a subfield within the Computer Science field of knowledge discovery. ... claim to perform \"data mining\" by automating the creation ..." },

				{
						"http://www.anderson.ucla.edu/faculty/jason.frand/teacher/technologies/palace/datamining.htm",
						"Data Mining: What is Data Mining?",
						"Outlines what knowledge discovery, the process of analyzing data from different perspectives and summarizing it into useful information, can do and how it works." }, };
		String[][] document = new String[][] {
				{ "Introduction yourSelf", "�Ϻ�" },// 0
				{ "KD Nuggets", "�й��Ϻ�" },// 1
				{ "The Data Mine", "�Ϻ�" },// 2
				{ "DMG", "�Ϻ��ֶ�" },// 3
				{ "Two Crows: Data mining glossary", "�й��Ϻ�" },// 4
				{ "�й��Ϻ��ֶ�",
						"http://www-db.stanford.edu/~ullman/mining/mining.html" },// 5
				{ "�й��Ϻ�", "http://www.thearling.com/" },// 6
				{ "�й��Ϻ�����",
						"http://www.eco.utexas.edu/~norman/BUS.FOR/course.mat/Alex" },// 7
				{ "CCSU - Data Mining", "�й��Ϻ��ֶ�" },// 8
				{
						"Data Mining: Practical Machine Learning Tools and Techniques",
						"�й��Ϻ�����" },// 19
				{ "Data Mining - Monografias.com", "�й��Ϻ�" } }; // 10
		final ArrayList<Document> documents = new ArrayList<Document>();
		for (String[] row : document) {
			documents.add(new Document(row[0], row[1]));
		}
		Clusters test = new Clusters();
//		System.out.println(test.getClustersByBisectingKMeansClusteringAlgorithm(documents,"data"));
		
	}
}
