package cn.edu.hit.mitlab.cluster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.carrot2.clustering.kmeans.BisectingKMeansClusteringAlgorithm;
import org.carrot2.clustering.kmeans.BisectingKMeansClusteringAlgorithmDescriptor;
import org.carrot2.clustering.lingo.LingoClusteringAlgorithm;
import org.carrot2.clustering.lingo.LingoClusteringAlgorithmDescriptor;
import org.carrot2.clustering.stc.STCClusteringAlgorithm;
import org.carrot2.clustering.stc.STCClusteringAlgorithmDescriptor;
import org.carrot2.clustering.synthetic.ByUrlClusteringAlgorithm;
import org.carrot2.core.Cluster;
import org.carrot2.core.Controller;
import org.carrot2.core.ControllerFactory;
import org.carrot2.core.Document;
import org.carrot2.core.ProcessingResult;
import org.carrot2.text.vsm.TermDocumentMatrixReducerDescriptor;
import org.xml.sax.HandlerBase;

/**
 * @author yk 2015.4.7
 * @version 1.0
 */
public class Clusters {
	private final Controller controller = ControllerFactory.createSimple();
	private final Map<String, Object> attributes = new HashMap<String, Object>();
	
	public Clusters() {
	}

	public void setDesiredClusterCountBase(int desiredClusterCountBase){
		LingoClusteringAlgorithmDescriptor.attributeBuilder(attributes).desiredClusterCountBase(desiredClusterCountBase);
	}
	
	/**
	 * @param documents
	 */
	public List<Cluster> getClustersByUrlClusteringAlgorithm(
			ArrayList<Document> documents) {

		final ProcessingResult byDomainClusters = controller.process(documents,
				null, ByUrlClusteringAlgorithm.class);
		final List<Cluster> clustersByDomain = byDomainClusters.getClusters();

		return clustersByDomain;
	}

	/**
	 * @param documents
	 * @param queryHint
	 */
	public List<Cluster> getClustersByLingoClusteringAlgorithm(
			ArrayList<Document> documents, String queryHint) {
		LingoClusteringAlgorithmDescriptor.attributeBuilder(attributes).desiredClusterCountBase(10);
		LingoClusteringAlgorithmDescriptor.attributeBuilder(attributes).documents(documents);
		TermDocumentMatrixReducerDescriptor.attributeBuilder(attributes).factorizationFactory(org.carrot2.matrix.factorization.LocalNonnegativeMatrixFactorizationFactory.class);
		final ProcessingResult byTopicClusters = controller.process(attributes, LingoClusteringAlgorithm.class);
		final List<Cluster> clustersByTopic = byTopicClusters.getClusters();

		return clustersByTopic;
	}
	
	/**
	 * @param documents
	 * @param queryHint
	 */
	public List<Cluster> getClustersBySTCClusteringAlgorithm(
			ArrayList<Document> documents, String queryHint) {
		STCClusteringAlgorithmDescriptor.attributeBuilder(attributes).maxClusters(10);
		STCClusteringAlgorithmDescriptor.attributeBuilder(attributes).documents(documents);
		TermDocumentMatrixReducerDescriptor.attributeBuilder(attributes).factorizationFactory(org.carrot2.matrix.factorization.LocalNonnegativeMatrixFactorizationFactory.class);
		final ProcessingResult byTopicClusters = controller.process(attributes, STCClusteringAlgorithm.class);
		final List<Cluster> clustersByTopic = byTopicClusters.getClusters();

		return clustersByTopic;
	}
	/**
	 * @param documents
	 * @param queryHint
	 */
	public List<Cluster> getClustersByBisectingKMeansClusteringAlgorithm(
			ArrayList<Document> documents, int clusterCount) {
		
		final Map<String, Object> attributes = new HashMap<String, Object>();
		BisectingKMeansClusteringAlgorithmDescriptor.attributeBuilder(attributes).clusterCount(clusterCount);
		BisectingKMeansClusteringAlgorithmDescriptor.attributeBuilder(attributes).labelCount(6);
		BisectingKMeansClusteringAlgorithmDescriptor.attributeBuilder(attributes).documents(documents);
		BisectingKMeansClusteringAlgorithmDescriptor.attributeBuilder(attributes).useDimensionalityReduction(true);
		TermDocumentMatrixReducerDescriptor.attributeBuilder(attributes).factorizationFactory(org.carrot2.matrix.factorization.LocalNonnegativeMatrixFactorizationFactory.class);
		final ProcessingResult byTopicClusters = controller.process(attributes, BisectingKMeansClusteringAlgorithm.class);
		
		final List<Cluster> clustersByTopic = byTopicClusters.getClusters();
		
		return clustersByTopic;
	}
}
