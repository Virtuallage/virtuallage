package com.vipro.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.constant.InstitutionStatusConst;
import com.vipro.data.Institution;

/**
 * 
 * @author cvl
 *
 */
@SuppressWarnings("unchecked")
@Repository("com.vipro.dao.InstitutionDao")
public class InstitutionDaoImpl extends DaoImpl<Institution> implements InstitutionDao {

	@Override
	public Institution findById(Long id) {
		Institution ins = getHibernateTemplate().get(Institution.class, id);
		return ins;
	}

	
	@Override
	public List<Institution> findAllActive() {
		String query = "select o from Institution o where o.status=?";
		List<Institution> list = getHibernateTemplate().find(query, InstitutionStatusConst.STATUS_ACTIVE);
		return list;
	}

	@Override
	public List<Institution> findAll() {
		String query = "select o from Institution o";
		List<Institution> list = getHibernateTemplate().find(query);
		return list;
	}


	@Override
	public boolean isOffDay(int dayOfWeek, Long instId) {

		String dayName =  "sun_off";
		
		switch (dayOfWeek) {
        case Calendar.SATURDAY:
            dayName = "sat_off";
            break;
        case Calendar.SUNDAY:
        	 dayName = "sun_off";
            break;
        case Calendar.MONDAY:
        	 dayName = "mon_off";
            break;
        case Calendar.TUESDAY:
        	 dayName = "tue_off";
        	 break;
        case Calendar.WEDNESDAY:
       	 dayName = "wed_off";
       	 break;
        case Calendar.THURSDAY:
       	 dayName = "thu_off";
       	 break;
        case Calendar.FRIDAY:
       	 dayName = "fri_off";
       	 break;
        default:
            break;
        }
		
		final String dayField = dayName;
		final Long id = instId;
		
		
		Object obj  = getHibernateTemplate().execute(new HibernateCallback() {

	        public Object doInHibernate(Session s)
	                throws HibernateException, SQLException {
	        	String query = "select o."+dayField+" from Institution o where o.institution_Id=?";	
	            SQLQuery sql=s.createSQLQuery( query);
	                sql.setParameter(0, id);
//	            sql.addScalar("r");
//	            sql.addScalar("c");
	            return sql.uniqueResult();
	        }
	    });
		
		String val = obj != null ? (String)obj: "N";
		return val.equalsIgnoreCase("Y") ? true: false;
	}


	@Override
	public boolean isHoliday(Date date, Long instId) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String query = " from Holiday h  where h.institution.institutionId=? and DATE_FORMAT(h.date , '%Y-%m-%d') = ?";	
		List list = getHibernateTemplate().find(query,instId,formatter.format(date));
		return !list.isEmpty();
	}
	
	
}
