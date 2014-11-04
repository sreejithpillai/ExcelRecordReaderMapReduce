/*
 * Copyright 2014 Sreejith Pillai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sreejithpillai.excel.mapreduce;
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelMapper extends
		Mapper<LongWritable, Text, Text, Text> {

	private static Logger LOG = LoggerFactory.getLogger(ExcelMapper.class);
	 /**
     * Excel Spreadsheet is supplied in string form to the mapper.
     * We are simply emitting them for viewing on HDFS.
     */
	public void map(LongWritable key, Text value, Context context)
			throws InterruptedException, IOException {
		String line = value.toString();
		
		context.write(new Text(line), null);
		LOG.info("Map processing finished");
	
	}
}
