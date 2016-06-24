package com.jikexueyuan.caiwen;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.jikexueyuan.caiwen.domain.Goods;
import com.jikexueyuan.caiwen.domain.Order;

public class OrderManager {

	public static void main(String[] args) {
		OrderManager orderManager = new OrderManager();
		orderManager.generateOrder("shopping.xml", "order.xml");
	}

	private void generateOrder(String shoppingXml, String orderXml) {
		List<Goods> goodsList = getGoodsListFromShopping(shoppingXml);
		Order order = getOrderFromGoodsList(goodsList);
		try {
			Document document = DocumentHelper.createDocument();
			Element root = document.addElement("order");
			root.addElement("total").setText(order.getTotal().toString());			
			root.addElement("sums").setText(order.getSums().toString());

			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhh24mmss");
			FileOutputStream outputStream = new FileOutputStream(dateFormat.format(new Date())+ "-" + orderXml);
			XMLWriter writer = new XMLWriter(outputStream, format);
			writer.write(document);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Order getOrderFromGoodsList(List<Goods> goodsList) {
		Order order = new Order();
		Double total = 0.0;
		Integer sums = 0;
		for (Iterator<Goods> iterator = goodsList.iterator(); iterator.hasNext();) {
			Goods goods = iterator.next();
			total += goods.getPrice();
			sums += goods.getCount();
		}
		order.setSums(sums);
		order.setTotal(total);
		return order;
	}

	private List<Goods> getGoodsListFromShopping(String shoppingXml) {
		List<Goods> goodsList = new ArrayList<>();
		try {
			Document document = new SAXReader().read(shoppingXml);
			Element root = document.getRootElement();
			//获取文件中一共有几个货物
			int numberOfGoods = root.elements("goods").size();
			
			for (int i = 1; i <= numberOfGoods; i++) {
				Goods goods = new Goods();
				//根据xpath获取每个货物的信息并设置对象属性，添加到货物列表中
				goods.setName(document.valueOf("//goods[" + i + "]/name"));
				goods.setCount(Integer.parseInt(document.valueOf("//goods[" + i + "]/number")));
				goods.setPrice(Double.parseDouble(document.valueOf("//goods[" + i + "]/price")));
				goodsList.add(goods);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return goodsList;
	}

}
