package com.ap.dataprovider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ap.datamodel.ProductData;

public class DataBuilder {
	@DataProvider(name="ProductData")
	public Iterator<Object[]> loginDataProvider(){
		
		Collection<Object[]>customerData = new ArrayList<Object[]>();
		{
			{
				DataBuilder dataBuilder = new DataBuilder();
				List<ProductData> data = dataBuilder.prepareProductData();
				for (ProductData customerModel:data){
					customerData.add(new Object[] {customerModel});
			}
		}
		
	}
	return customerData.iterator();
}
private List<ProductData> prepareProductData() {
		// TODO Auto-generated method stub
		return null;
	}
@Test(dataProvider="ProductData")
public void testData(ProductData data){
	System.out.println(data.getProductName());
	System.out.println(data.getQuantity());
	System.out.println(data.getSize());
	System.out.println(data.getColor());

}
}