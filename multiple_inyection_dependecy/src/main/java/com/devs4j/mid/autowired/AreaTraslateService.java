package com.devs4j.mid.autowired;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AreaTraslateService {
	@Autowired
	private List<Figure> figures;
	
	public double calcAreas() {
		double area=0;
		area = figures.stream().mapToDouble(Figure::calcularArea).sum();
		return area;
	}
}
