/**
* OWASP Benchmark Project
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project For details, please see
* <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Dave Wichers
* @created 2015
*/

package org.owasp.benchmark.score.report;

import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

@SuppressWarnings("serial")
public class LegendXYItemLabelGenerator extends StandardXYItemLabelGenerator
		implements XYItemLabelGenerator, Cloneable, PublicCloneable {

	private LegendItemCollection legendItems;

	public LegendXYItemLabelGenerator(LegendItemCollection legendItems) {
		super();
		this.legendItems = legendItems;
	}

	@Override
	public String generateLabel(XYDataset dataset, int series, int item) {
		LegendItem legendItem = legendItems.get(item);
		return legendItem.getLabel();
	}
}