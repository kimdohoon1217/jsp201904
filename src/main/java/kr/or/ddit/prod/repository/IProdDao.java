package kr.or.ddit.prod.repository;

import java.util.List;
import java.util.Map;


public interface IProdDao {
	List<Map> getProd(String id);
}
