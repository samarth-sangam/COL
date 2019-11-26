package com.comviva.col.utils.mapper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.comviva.col.entity.UserMaster;
import com.comviva.col.utils.dto.ActivationReportDto;

/**
 * This Class maps CSV data to specified DTO objects. Singleton class.
 * 
 * @author samarth.sangam
 *
 */
@Component
public class CSVToEntity {
	private static CSVToEntity instance = null;

	/**
	 * Reads CSV data into ActivationReportDto object.
	 * 
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @deprecated
	 */
	@Deprecated
	public List<ActivationReportDto> readCSVFileIntoActivationReportObject(String filename) throws IOException {
		Pattern pattern = Pattern.compile(",");
		try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
			return in.lines().skip(1).map(line -> {
				if (line.startsWith(",") || line.contains(",,") || line.endsWith(".")) {
					return null;
				}
				String[] x = pattern.split(line);
				return new ActivationReportDto.ActivationReportBuilder().setTrId(UUID.randomUUID().toString())
						.setMonth(x[0])
						.setActivationDate(
								LocalDateTime.parse(x[1], DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")))
						.setAgentCode(x[2]).setExternalId(x[3]).setMobileNumber(x[4]).setName(x[5]).setScheme(x[6])
						.setIncentive(x[7]).setCategory(x[8]).setActiType(x[9]).setStatus('y').setAmount(x[10]).build();
			}).collect(Collectors.toList()).stream().filter(Objects::nonNull).collect(Collectors.toList());
		}
	}

	/**
	 * Reads CSV data into UserMaster object.
	 * 
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<UserMaster> readCSVintoUserMaster(String filename) throws IOException {
		Pattern pattern = Pattern.compile(",");
		try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
			return in.lines().skip(1).map(line -> {
				if (line.startsWith(",") || line.contains(",,") || line.endsWith(".")) {
					return null;
				}
				String[] x = pattern.split(line);
				UserMaster userMaster = new UserMaster();
				userMaster.setUserId(Integer.parseInt(x[0]));
				userMaster.setEmail(x[1]);
				userMaster.setLocation(x[2]);
				userMaster.setMobileNumber(x[3]);
				if (x[4] == "null" || x[4] == "NULL") {
					userMaster.setParentId(null);
				} else {
					userMaster.setParentId(Integer.parseInt(x[4]));
				}
				userMaster.setPassword(x[5]);
				userMaster.setType(x[6]);
				userMaster.setUsername(x[7]);
				return userMaster;
			}).collect(Collectors.toList()).stream().filter(Objects::nonNull).collect(Collectors.toList());
		}
	}

}
