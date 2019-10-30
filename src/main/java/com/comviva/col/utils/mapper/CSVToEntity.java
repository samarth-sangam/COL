package com.comviva.col.utils.mapper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.comviva.col.utils.dto.ActivationReportDto;
import com.comviva.col.utils.dto.ChequeReportDto;
import com.comviva.col.utils.dto.DeductionReportDto;

/**
 * This Class maps CSV data to specified DTO objects. Singleton class.
 * 
 * @author samarth.sangam
 *
 */
public class CSVToEntity {
	private static CSVToEntity instance = null;

	private CSVToEntity() {
	}

	/**
	 * 
	 * @return
	 */
	public static CSVToEntity getInstance() {
		if (instance == null) {
			instance = new CSVToEntity();
		}
		return instance;
	}

	/**
	 * Reads CSV data into ActivationReportDto object.
	 * 
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<ActivationReportDto> readCSVFileIntoActivationReportObject(String filename)
			throws FileNotFoundException, IOException {
		Pattern pattern = Pattern.compile(",");
		try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
			List<ActivationReportDto> list = in.lines().skip(1).map(line -> {
				String[] x = pattern.split(line);
				return new ActivationReportDto.ActivationReportBuilder().setMonth(x[0])
						.setActivationDate(LocalDate.parse(x[1], DateTimeFormatter.ofPattern("dd-MM-yyyy")))
						.setAgentCode(x[2]).setExternalId(x[3]).setMobileNumber(x[4]).setName(x[5]).setScheme(x[6])
						.setIncentive(x[7]).setCategory(x[8]).setActiType(x[9]).build();
			}).collect(Collectors.toList());
			return list;
		}
	}

	/**
	 * Reads CSV data into DeductionReportDto object.
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public List<DeductionReportDto> readCSVFileIntoDeductionReportObject(String filename) throws IOException {
		Pattern pattern = Pattern.compile(",");
		try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
			List<DeductionReportDto> list = in.lines().skip(1).map(line -> {
				String[] x = pattern.split(line);
				return new DeductionReportDto.DeductionReportBuilder().setMonth(x[0])
						.setActivationDate(LocalDate.parse(x[1], DateTimeFormatter.ofPattern("dd-MM-yyyy")))
						.setAgentCode(x[2]).setExternalId(x[3]).setMobileNumber(x[4]).setName(x[5]).setScheme(x[6])
						.setAmount(x[7]).setCategory(x[8]).setActiType(x[9]).setRemarks1(x[10]).setRemarks2(x[11])
						.build();
			}).collect(Collectors.toList());
			return list;
		}
	}

	/**
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public List<ChequeReportDto> readCSVFileIntoChequeReportObject(String filename) throws IOException {
		Pattern pattern = Pattern.compile(",");
		try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
			List<ChequeReportDto> list = in.lines().skip(1).map(line -> {
				String[] x = pattern.split(line);
				return new ChequeReportDto(x[0], x[1]);
			}).collect(Collectors.toList());
			return list;
		}
	}

}
