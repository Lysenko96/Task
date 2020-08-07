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
    protected int service_id;
    protected int variation_id;
    protected int question_type_id;
    protected int category_id;
    protected int sub_category_id;
    protected String response_type;
    protected Calendar date_from = new GregorianCalendar();

    protected int search(ArrayList<Query> listQuery,Query query, ArrayList<WaitingTimeline> listWaitingTimeline, LinkedList<String> linkedList, int countEqual){

        listQuery.add(query);
        countEqual = 0;
        int allValue = 0;
        int avg = 0;
        for (int j = 0; j < listWaitingTimeline.size(); j++) {
            if (query.service_id == listWaitingTimeline.get(j).service_id &&
                    query.question_type_id == listWaitingTimeline.get(j).question_type_id ||
                    query.question_type_id == 101 && listWaitingTimeline.get(j).response_type.equals(query.response_type) &&
                            listWaitingTimeline.get(j).date_from.getTime().after(query.date_from.getTime()) || query.question_type_id == 101 &&
                    listWaitingTimeline.get(j).date_from.getTime().before(query.date_to.getTime()) ||
                    query.question_type_id == 101 && listWaitingTimeline.get(j).date_from.getTime().equals(query.date_from.getTime())
                    || query.question_type_id == 101 && listWaitingTimeline.get(j).date_from.getTime().equals(query.date_to.getTime())) {
                countEqual++;
                allValue += listWaitingTimeline.get(j).time;
                avg = allValue / countEqual;
            }
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
            int question_type_id = Integer.parseInt("101");
            query.question_type_id = question_type_id;
        }
    }
}
 // split all data

class EnterAndShowData {
    public void enterData(){
        LinkedList<String> linkedList = new LinkedList<>();

        ArrayList<String> delimiter = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("count lines: ");
        int S = 0;
        try {
            S = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inputString = "";
        ArrayList<String> arrayList = new ArrayList<>(S);
        int count = 1;
        while (!reader.equals("")) {
            try {
                inputString = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String newInputString = inputString.replace("-", " ");
            String[] arrayStr = newInputString.split("\\s");
            if (arrayStr[0].equals("C") || arrayStr[0].equals("D")) {
                arrayList.add(newInputString);
                count++;
            } else {
                if (newInputString.equals(""))
                    break;
                System.out.println("enter C || D");
            }
        }
        ArrayList<WaitingTimeline> listWaitingTimeline = new ArrayList<>();
        ArrayList<Query> listQuery = new ArrayList<>();
        for (int i = 0; i < count - 1; i++) {
            if (i >= S - 1) {
                delimiter.add("-");
            }
            String[] inputWords = arrayList.get(i).split("\\s");
            if (inputWords[0].equals("C") && arrayList.size() <= S) {
                WaitingTimeline waitingTimeline = new WaitingTimeline();
                for (int j = 0; j < inputWords.length; j++) {
                    String[] listService_id = inputWords[j].split("\\.");
                    if (j == 1) {
                        if (inputWords[j].contains(".")) {
                            waitingTimeline.initService(listService_id,waitingTimeline);
                        } else {
                            int service_id = Integer.parseInt(listService_id[0]);
                            waitingTimeline.service_id = service_id;
                        }
                    }
                    if (j == 2) {
                        if (inputWords[j].contains(".")) {
                            if (inputWords[j].split("\\.").length == 2) {
                                waitingTimeline.init(listService_id,waitingTimeline);
                            }
                            if (inputWords[j].split("\\.").length == 3) {
                                waitingTimeline.initQuestionType(listService_id,waitingTimeline);
                            }
                        } else {
                            int question_type_id = Integer.parseInt(listService_id[0]);
                            waitingTimeline.question_type_id = question_type_id;
                        }
                    }
                    if (j == 3) {
                        String res_type = inputWords[j];

                        waitingTimeline.response_type = res_type;
                    }
                    if (j == 4) {
                        if (inputWords[j].contains(".")) {

                            if (inputWords[j].split("\\.").length == 3) {
                                waitingTimeline.initDate(listService_id,waitingTimeline);
                            }
                        } else {
                            System.out.println("enter correct date");
                        }
                    }
                    if (j == 5) {
                        int time = Integer.parseInt(listService_id[0]);
                        waitingTimeline.time = time;
                    }
                }
                listWaitingTimeline.add(waitingTimeline);
            } else if (inputWords[0].equals("D") && arrayList.size() <= S) {
                Query query = new Query();
                int countEqual = 0;
                for (int j = 0; j < inputWords.length; j++) {
                    String[] listService_id = inputWords[j].split("\\.");
                    if (j == 1) {
                        if (inputWords[j].contains(".")) {
                            query.initService(listService_id,query);
                        } else {
                            int service_id = Integer.parseInt(listService_id[0]);
                            query.service_id = service_id;
                        }
                    }
                    if (j == 2) {
                        if (inputWords[j].contains(".")) {
                            if (inputWords[j].split("\\.").length == 2) {
                                query.init(listService_id,query);
                            }
                            if (inputWords[j].split("\\.").length == 3) {
                                query.initQuestionType(listService_id,query);
                            }
                        } else {
                            query.catchException(listService_id,query);
                        }
                    }
                    if (j == 3) {
                        String res_type = inputWords[j];
                        query.response_type = res_type;
                    }
                    if (j == 4) {
                        if (inputWords[j].contains(".")) {
                            if (inputWords[j].split("\\.").length == 3) {
                                query.initDate(listService_id, query);
                            }
                        } else {
                            System.out.println("enter correct date");
                        }
                    }
                    if (j == 5) {
                        if (inputWords[j].contains(".")) {
                            if (inputWords[j].split("\\.").length == 3) {
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
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        for (String w : delimiter) {
            System.out.println(w);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EnterAndShowData data = new EnterAndShowData();
        data.enterData();
    }
}


