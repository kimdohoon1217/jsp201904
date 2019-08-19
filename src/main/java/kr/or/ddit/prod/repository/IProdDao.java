package kr.or.ddit.prod.repository;

import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.model.Prod;

public interface IProdDao {
	List<Map> getProd(String id);
}
