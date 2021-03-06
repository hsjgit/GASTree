package com.hsj;


import com.hsj.bean.AllDetinationBook;
import com.hsj.entity.Video;
import com.hsj.mapper.AllDetinationBookMapper;
import com.hsj.servier.impl.AllDetinationBookImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.uniroma1.dis.wsngroup.gexf4j.core.EdgeType;
import it.uniroma1.dis.wsngroup.gexf4j.core.Gexf;
import it.uniroma1.dis.wsngroup.gexf4j.core.Graph;
import it.uniroma1.dis.wsngroup.gexf4j.core.Mode;
import it.uniroma1.dis.wsngroup.gexf4j.core.Node;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.Attribute;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeClass;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeList;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeType;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.GexfImpl;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.StaxGraphWriter;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.data.AttributeListImpl;
import java.io.*;
import java.util.Calendar;

import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgorithmwebApplicationTests {
	@Autowired
	private AllDetinationBookImpl bookMapper;
	@Autowired
	private Video video;
	@Test
	public void a() throws Exception {
		Gexf gexf = new GexfImpl();
		Calendar date = Calendar.getInstance();

		gexf.getMetadata()
				.setLastModified(date.getTime())
				.setCreator("Gephi.org")
				.setDescription("A Web network");
		gexf.setVisualization(true);

		Graph graph = gexf.getGraph();
		graph.setDefaultEdgeType(EdgeType.UNDIRECTED).setMode(Mode.STATIC);

		AttributeList attrList = new AttributeListImpl(AttributeClass.NODE);
		graph.getAttributeLists().add(attrList);

		Attribute attUrl = attrList.createAttribute("class", AttributeType.INTEGER, "Class");
		Attribute attIndegree = attrList.createAttribute("pageranks", AttributeType.DOUBLE, "PageRank");



		Node gephi = graph.createNode("0");
		gephi
				.setLabel("郝大通")
				.getAttributeValues()
				.addValue(attUrl, "3")
				.addValue(attIndegree, "0.14658");


		Node webatlas = graph.createNode("1");
		webatlas
				.setLabel("郝大通")
				.getAttributeValues()
				.addValue(attUrl, "3")
				.addValue(attIndegree, "0.14658");

		gephi.connectTo("0", webatlas).setWeight(0.8f);

		StaxGraphWriter graphWriter = new StaxGraphWriter();
		File f = new File("static_graph_sample.gexf");
		Writer out;
		try {
			out =  new FileWriter(f, false);
			graphWriter.writeToStream(gexf, out, "UTF-8");
			System.out.println(f.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void b() {
		System.out.println(video.getvideopath("![](D:\\intelliJ\\java_idea\\agorithmweb\\src\\main\\resources\\resources\\video\\\\6f67bf83-bab5-4202-90cd-2caec3cd50be2019-05-11.mp4)"));

	}
}
