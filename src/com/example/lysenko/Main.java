package com.example.lysenko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


interface Initiate {
    default void initService(String[] listService_id, Cases cases){
        int service_id = Integer.parseInt(listService_id[0]);
        int variation_id = Integer.parseInt(listService_id[1]);
        cases.service_id = service_id;
        cases.variation_id = variation_id;
    }
    default void initQuestionType(String[] listService_id,Cases cases){
        int question_type_id = Integer.parseInt(listService_id[0]);
        int category_id = Integer.parseInt(listService_id[1]);
        int sub_category_id = Integer.parseInt(listService_id[2]);
        cases.question_type_id = question_type_id;
        cases.category_id = category_id;
        cases.sub_category_id = sub_category_id;
    }
    default void initDate(String[] listService_id, Cases cases){
        int day_from = Integer.parseInt(listService_id[0]);
        int month_from = Integer.parseInt(listService_id[1]);
        int year_from = Integer.parseInt(listService_id[2]);
        cases.date_from.set(Calendar.YEAR, year_from);
        cases.date_from.set(Calendar.MONTH, month_from);
        cases.date_from.set(Calendar.DAY_OF_MONTH, day_from);
    }
    default void init(String[] listService_id, Cases cases){
        int question_type_id = Integer.parseInt(listService_id[0]);
        int category_id = Integer.parseInt(listService_id[1]);
        cases.question_type_id = question_type_id;
        cases.category_id = category_id;
    }

}

abstract class Cases implements Initiate{
	
	public static final int SYMBOL_ALL = Integer.parseInt("101");
	
    protected int service_id;
    protected int variation_id;
    protected int question_type_id;
    protected int category_id;
    protected int sub_category_id;
    protected String response_type;
    protected Calendar date_from = new GregorianCalendar();

    protected int search(ArrayList<Query> listQuery,Query query, ArrayList<WaitingTimeline> listWaitingTimeline, LinkedList<String> linkedList,int countEqual){

        listQuery.add(query);
        // countEqual = 0;
        int allValue = 0;
        int avg = 0;
        for (int j = 0; j < listWaitingTimeline.size(); j++) {
            if (query.service_id == listWaitingTimeline.get(j).service_id &&
                    query.question_type_id == listWaitingTimeline.get(j).question_type_id ||
                    query.question_type_id == SYMBOL_ALL && listWaitingTimeline.get(j).response_type.equals(query.response_type) &&
                            listWaitingTimeline.get(j).date_from.getTime().after(query.date_from.getTime()) || query.question_type_id == SYMBOL_ALL &&
                    listWaitingTimeline.get(j).date_from.getTime().before(query.date_to.getTime()) ||
                    query.question_type_id == SYMBOL_ALL && listWaitingTimeline.get(j).date_from.getTime().equals(query.date_from.getTime())
                    || query.question_type_id == SYMBOL_ALL && listWaitingTimeline.get(j).date_from.getTime().equals(query.date_to.getTime())) {
                countEqual++;
                allValue += listWaitingTimeline.get(j).time;
                avg = allValue / countEqual;
            }
            //avg = allValue / countEqual;
        }

        return avg;
    }
}

final class  WaitingTimeline extends Cases{
    int time;
}
final class Query extends Cases {
	
    Calendar date_to = new GregorianCalendar();

    public void initDateTo(String[] listService_id, Query query) {
        int day_to = Integer.parseInt(listService_id[0]);
        int month_to = Integer.parseInt(listService_id[1]);
        int year_to = Integer.parseInt(listService_id[2]);
        query.date_to.set(Calendar.YEAR, year_to);
        query.date_to.set(Calendar.MONTH, month_to);
        query.date_to.set(Calendar.DAY_OF_MONTH, day_to);
    }

    void catchException(String[] listService_id, Query query){
        try {
            int question_type_id = Integer.parseInt(listService_id[0]);
            query.question_type_id = question_type_id;
        } catch (NumberFormatException e) {
            int question_type_id = SYMBOL_ALL;
            query.question_type_id = question_type_id;
        }
    }
}
 // split all data

class EnterAndShowData {
	
	public static final String EMPTY = "";
	public static final String DELIMITER = "-";
	public static final String DELIMITER_DOT = "\\.";
	public static final String DELIMITER_DOT_ONLY = ".";
	public static final String DELIMITER_SPACE = " ";
	public static final String DELIMITER_WORD = "\\s";
	
    public void enterData(){
        LinkedList<String> linkedList = new LinkedList<>();

        ArrayList<String> delimiter = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("indexRight count: ");
        int countLines = 0;
        try {
            countLines = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inputString = new String();
        ArrayList<String> arrayList = new ArrayList<>(countLines);
        int indexRight = 1;
        while (!reader.toString().equals(EMPTY)) {
            try {
                inputString = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String newInputString = inputString.replace(DELIMITER, DELIMITER_SPACE);
            String[] arrayItemCases = newInputString.split(DELIMITER_WORD);
            if (arrayItemCases[0].equals("C") || arrayItemCases[0].equals("D")) {
                arrayList.add(newInputString);
                indexRight++;
            } else {
                if (newInputString.equals(EMPTY))
                    break;
                System.out.println("enter C or D first item");
            }
        }
        ArrayList<WaitingTimeline> listWaitingTimeline = new ArrayList<>();
        ArrayList<Query> listQuery = new ArrayList<>();
        for (int indexLeft = 0; indexLeft < indexRight - 1; indexLeft++) {
            if (indexLeft >= countLines - 1) {
                delimiter.add(DELIMITER);
            }
            String[] inputWords = arrayList.get(indexLeft).split(DELIMITER_WORD);
            if (inputWords[0].equals("C") && arrayList.size() <= countLines) {
                WaitingTimeline waitingTimeline = new WaitingTimeline();
                for (int indexWordTimeline = 0; indexWordTimeline < inputWords.length; indexWordTimeline++) {
                    String[] listService_id = inputWords[indexWordTimeline].split(DELIMITER_DOT);
                    if (indexWordTimeline == 1) {
                        if (inputWords[indexWordTimeline].contains(DELIMITER_DOT_ONLY)) {
                            waitingTimeline.initService(listService_id,waitingTimeline);
                        } else {
                            int service_id = Integer.parseInt(listService_id[0]);
                            waitingTimeline.service_id = service_id;
                        }
                    }
                    if (indexWordTimeline == 2) {
                        if (inputWords[indexWordTimeline].contains(DELIMITER_DOT_ONLY)) {
                            if (inputWords[indexWordTimeline].split(DELIMITER_DOT).length == 2) {
                                waitingTimeline.init(listService_id,waitingTimeline);
                            }
                            if (inputWords[indexWordTimeline].split(DELIMITER_DOT).length == 3) {
                                waitingTimeline.initQuestionType(listService_id,waitingTimeline);
                            }
                        } else {
                            int question_type_id = Integer.parseInt(listService_id[0]);
                            waitingTimeline.question_type_id = question_type_id;
                        }
                    }
                    if (indexWordTimeline == 3) {
                        String res_type = inputWords[indexWordTimeline];

                        waitingTimeline.response_type = res_type;
                    }
                    if (indexWordTimeline == 4) {
                        if (inputWords[indexWordTimeline].contains(DELIMITER_DOT_ONLY)) {

                            if (inputWords[indexWordTimeline].split(DELIMITER_DOT).length == 3) {
                                waitingTimeline.initDate(listService_id,waitingTimeline);
                            }
                        } else {
                            System.out.println("enter correct date");
                        }
                    }
                    if (indexWordTimeline == 5) {
                        int time = Integer.parseInt(listService_id[0]);
                        waitingTimeline.time = time;
                    }
                }
                listWaitingTimeline.add(waitingTimeline);
            } else if (inputWords[0].equals("D") && arrayList.size() <= countLines) {
                Query query = new Query();
                int countEqual = 0;
                for (int indexWordQuery = 0; indexWordQuery < inputWords.length; indexWordQuery++) {
                    String[] listService_id = inputWords[indexWordQuery].split(DELIMITER_DOT);
                    if (indexWordQuery == 1) {
                        if (inputWords[indexWordQuery].contains(DELIMITER_DOT_ONLY)) {
                            query.initService(listService_id,query);
                        } else {
                            int service_id = Integer.parseInt(listService_id[0]);
                            query.service_id = service_id;
                        }
                    }
                    if (indexWordQuery == 2) {
                        if (inputWords[indexWordQuery].contains(DELIMITER_DOT_ONLY)) {
                            if (inputWords[indexWordQuery].split(DELIMITER_DOT).length == 2) {
                                query.init(listService_id,query);
                            }
                            if (inputWords[indexWordQuery].split(DELIMITER_DOT).length == 3) {
                                query.initQuestionType(listService_id,query);
                            }
                        } else {
                            query.catchException(listService_id,query);
                        }
                    }
                    if (indexWordQuery == 3) {
                        String res_type = inputWords[indexWordQuery];
                        query.response_type = res_type;
                    }
                    if (indexWordQuery == 4) {
                        if (inputWords[indexWordQuery].contains(DELIMITER_DOT_ONLY)) {
                            if (inputWords[indexWordQuery].split(DELIMITER_DOT).length == 3) {
                                query.initDate(listService_id, query);
                            }
                        } else {
                            System.out.println("enter correct date");
                        }
                    }
                    if (indexWordQuery == 5) {
                        if (inputWords[indexWordQuery].contains(DELIMITER_DOT_ONLY)) {
                            if (inputWords[indexWordQuery].split(DELIMITER_DOT).length == 3) {
                                query.initDateTo(listService_id,query);
                            }
                        } else {
                            System.out.println("enter correct date");
                        }
                    }
                }
            
                linkedList.add(String.valueOf(query.search(listQuery, query, listWaitingTimeline, linkedList, countEqual)));
            }
        }
        for (int indexResult = 0; indexResult < linkedList.size(); indexResult++) {
            System.out.println(linkedList.get(indexResult));
        }
        for (String word : delimiter) {
            System.out.println(word);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EnterAndShowData data = new EnterAndShowData();
        data.enterData();
    }
}


