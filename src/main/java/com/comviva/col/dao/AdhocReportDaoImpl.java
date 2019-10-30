package com.comviva.col.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comviva.col.dao.interfaces.IAdhocReportDao;
import com.comviva.col.entity.AdhocReport;
import com.comviva.col.repository.AdhocReportRepository;

/**
 * AdhocReport Dao implementation.
 * 
 * @author samarth.sangam
 *
 */
@Component
public class AdhocReportDaoImpl extends AbstractDaoImpl<AdhocReport> implements IAdhocReportDao {

	@Autowired
	private AdhocReportRepository adhocReportRepository;

	@PersistenceContext
	private EntityManager entityManager;

	private static final String FROM_TO_DATE_QUERY = "from %s "
			+ "c where external_id = :externalId AND activation_date BETWEEN :fromDate AND :toDate";

	private static final String MONTH_QUERY = "from %s" + " where external_id = :externalId AND month = :month";

	private static final String TABLE_NAME = "COL_ADHOC_REPORT";

	@Override
	public void addAllAdhocReport(List<AdhocReport> list) {
		adhocReportRepository.saveAll(list);

	}

	@Override
	public void addAdhocReport(AdhocReport adhocReport) throws Exception {
		if (exists(adhocReport.getTrId())) {
			throw new Exception("Transaction with " + adhocReport.getTrId() + " exists.");
		}
		adhocReportRepository.save(adhocReport);

	}

	@Override
	public AdhocReport viewAdhocReport(int id) {
		Optional<AdhocReport> adhocReport = adhocReportRepository.findById(id);
		if (adhocReport.isPresent()) {
			return adhocReport.get();
		}
		return null;
	}

	@Override
	public void updateAdhocReport(AdhocReport adhocReport) throws Exception {
		if (exists(adhocReport.getTrId()))
			adhocReportRepository.save(adhocReport);
		throw new Exception("Adhoc Report Not Found");

	}

	@Override
	public boolean deleteAdhocReport(int id) {
		if (exists(id)) {
			adhocReportRepository.deleteById(id);
			return true;
		}
		return false;
	}

	private boolean exists(int id) {
		return adhocReportRepository.existsById(id);
	}

	@Override
	public List<AdhocReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String id) {
		return super.viewByFromAndToDate(fromDate, toDate, id, TABLE_NAME);
	}

	@Override
	public List<AdhocReport> viewByMonth(String month, String id) {
		return super.viewByMonth(month, id, TABLE_NAME);
	}

	@Override
	public void deleteByMonth(String month, String id) {
		super.deleteByMonth(month, id, TABLE_NAME);

	}

}
