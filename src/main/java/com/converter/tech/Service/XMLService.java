package com.converter.tech.Service;

import com.converter.tech.Model.Currency;
import com.converter.tech.Model.Rate;
import com.converter.tech.Model.XMLData;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class XMLService {
    public static XMLData XMLDataParse() {
        try {
            List<Currency> currencyList = new ArrayList<>();
            List<Rate> rateList = new ArrayList<>();
            String url = "http://www.cbr.ru/scripts/XML_daily.asp";
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url);
            NodeList nodeList = doc.getElementsByTagName("ValCurs");
            Node node = nodeList.item(0);
            LocalDate currentDate = null;
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                currentDate = LocalDate.parse((element.getAttribute("Date")), dateTimeFormatter);
                System.out.println("Сегодняшняя дата " + currentDate);
            }
            nodeList = doc.getElementsByTagName("Valute");
            for(int i = 0; i < nodeList.getLength(); i++)
            {
                Node p = nodeList.item(i);
                if(p.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element currency = (Element) p;

                    //Паршу данные и  добавляю их в конструткор
                    String code = currency.getElementsByTagName("CharCode").item(0).getTextContent();
                    Currency initCurrency = new Currency(currency.getAttribute("ID"), currency.getElementsByTagName("NumCode").item(0).getTextContent(),
                            code, Integer.parseInt(currency.getElementsByTagName("Nominal").item(0).getTextContent()), currency.getElementsByTagName("Name").item(0).getTextContent());
                    //добавляю объект в список Валют
                    currencyList.add(initCurrency);
                    double value = Double.parseDouble(currency.getElementsByTagName("Value").item(0).getTextContent().replace("," , "."));
                    Rate initRate = new Rate(currency.getAttribute("ID"), currentDate, code, value);
                    rateList.add(initRate);

                }
            }
            System.out.print("Вывод данных ВАЛЮТ\n ");
            for(Currency currency : currencyList)
            {
                System.out.println(currency);
            }

            System.out.println("\n_______________________________________________________\n" + "Вывод курса ВАЛЮТЫ ");
            for(Rate rate : rateList)
            {
                System.out.println(rate);
            }
            return new XMLData(currencyList, rateList);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static LocalDate getActualDate()
    {
        try {
            String url = "http://www.cbr.ru/scripts/XML_daily.asp";
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url);
            NodeList nodeList = doc.getElementsByTagName("ValCurs");
            Node node = nodeList.item(0);
            LocalDate currentDate = null;
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                currentDate = LocalDate.parse((element.getAttribute("Date")), dateTimeFormatter);
                System.out.println("Сегодняшняя дата " + currentDate);
                return currentDate;
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }
}
