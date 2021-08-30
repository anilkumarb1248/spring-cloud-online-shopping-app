package com.online.shopping.product.util;

import java.util.ArrayList;
import java.util.List;

import com.online.shopping.product.dto.ProductDTO;
import com.online.shopping.product.enums.ProductType;

public class DummyData {
	
	public static List<ProductDTO> getDummyData() {
		List<ProductDTO> dummyProducts = new ArrayList<>();
		// VEHICLE, MOBILE, TABLET, LAPTOP, TV
		ProductType[] values = ProductType.values();
		for (ProductType pt : values) {
			for (int i = 1; i <= 5; i++) {
				ProductDTO p = new ProductDTO();
				p.setProductName(String.valueOf(pt) + "-" + i);
				p.setType(pt);
				dummyProducts.add(p);
			}
		}

		return dummyProducts;
	}

}
