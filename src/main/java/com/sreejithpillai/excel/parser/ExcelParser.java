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
package com.sreejithpillai.excel.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelParser {

	private static final Log LOG = LogFactory.getLog(ExcelParser.class);
	private StringBuilder currentString = null;
	private long bytesRead = 0;

	public String parseExcelData(InputStream is) {
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(is);

			// Taking first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			currentString = new StringBuilder();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						bytesRead++;
						currentString.append(cell.getBooleanCellValue() + "\t");
						break;

					case Cell.CELL_TYPE_NUMERIC:
						bytesRead++;
						currentString.append(cell.getNumericCellValue() + "\t");
						break;

					case Cell.CELL_TYPE_STRING:
						bytesRead++;
						currentString.append(cell.getStringCellValue() + "\t");
						break;

					}
				}
				currentString.append("\n");
			}
			is.close();
		} catch (IOException e) {
			LOG.error("IO Exception : File not found " + e);
		}
		return currentString.toString();

	}

	public long getBytesRead() {
		return bytesRead;
	}

}
