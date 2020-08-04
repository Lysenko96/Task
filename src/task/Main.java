package task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class WaitingTimeline{
    int service_id;
    int variation_id;
    int question_type_id;
    int category_id;
    int sub_category_id;
    String response_type;
    Calendar date_from = new GregorianCalendar();
    int time;
}
class Query extends WaitingTimeline {
    Calendar date_to = new GregorianCalendar();
}


public class Main {
    public static void main(String[] args) throws IOException {
        LinkedList<String> linkedList = new LinkedList<>();

        ArrayList<String> delimiter = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("count lines: ");
        int S = Integer.parseInt(reader.readLine());
        String inputString = "";
        ArrayList<String> arrayList = new ArrayList<>(S);
        int count = 1;
        while (!reader.equals("")) {
            inputString = reader.readLine();
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
                            int service_id = Integer.parseInt(listService_id[0]);
                            int variation_id = Integer.parseInt(listService_id[1]);
                            waitingTimeline.service_id = service_id;
                            waitingTimeline.variation_id = variation_id;
                        } else {
                            int service_id = Integer.parseInt(listService_id[0]);
                            waitingTimeline.service_id = service_id;

                        }
                    }
                    if (j == 2) {
                        if (inputWords[j].contains(".")) {
                            if (inputWords[j].split("\\.").length == 2) {
                                int question_type_id = Integer.parseInt(listService_id[0]);
                                int category_id = Integer.parseInt(listService_id[1]);
                                waitingTimeline.question_type_id = question_type_id;
                                waitingTimeline.category_id = category_id;
                            }
                            if (inputWords[j].split("\\.").length == 3) {
                                int question_type_id = Integer.parseInt(listService_id[0]);
                                int category_id = Integer.parseInt(listService_id[1]);
                                int sub_category_id = Integer.parseInt(listService_id[2]);
                                waitingTimeline.question_type_id = question_type_id;
                                waitingTimeline.category_id = category_id;
                                waitingTimeline.sub_category_id = sub_category_id;
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
                                int day_from = Integer.parseInt(listService_id[0]);
                                int month_from = Integer.parseInt(listService_id[1]);
                                int year_from = Integer.parseInt(listService_id[2]);
                                waitingTimeline.date_from.set(Calendar.YEAR, year_from);
                                waitingTimeline.date_from.set(Calendar.MONTH, month_from);
                                waitingTimeline.date_from.set(Calendar.DAY_OF_MONTH, day_from);
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


                for (int j = 0; j < inputWords.length; j++) {
                    String[] listService_id = inputWords[j].split("\\.");
                    ;
                    if (j == 1) {
                        if (inputWords[j].contains(".")) {
                            int service_id = Integer.parseInt(listService_id[0]);
                            int variation_id = Integer.parseInt(listService_id[1]);
                            query.service_id = service_id;
                            query.variation_id = variation_id;
                        } else {
                            int service_id = Integer.parseInt(listService_id[0]);
                            query.service_id = service_id;
                        }
                    }
                    if (j == 2) {
                        if (inputWords[j].contains(".")) {
                            if (inputWords[j].split("\\.").length == 2) {
                                int question_type_id = Integer.parseInt(listService_id[0]);
                                int category_id = Integer.parseInt(listService_id[1]);
                                query.question_type_id = question_type_id;
                                query.category_id = category_id;
                            }
                            if (inputWords[j].split("\\.").length == 3) {
                                int question_type_id = Integer.parseInt(listService_id[0]);
                                int category_id = Integer.parseInt(listService_id[1]);
                                int sub_category_id = Integer.parseInt(listService_id[2]);
                                query.question_type_id = question_type_id;
                                query.category_id = category_id;
                                query.sub_category_id = sub_category_id;
                            }
                        } else {
                            //
                            try {
                                int question_type_id = Integer.parseInt(listService_id[0]);
                                query.question_type_id = question_type_id;
                            } catch (NumberFormatException e) {
                                int question_type_id = Integer.parseInt("101");
                                query.question_type_id = question_type_id;
                            }
                        }
                    }
                    if (j == 3) {
                        String res_type = inputWords[j];
                        query.response_type = res_type;
                    }
                    if (j == 4) {
                        if (inputWords[j].contains(".")) {
                            if (inputWords[j].split("\\.").length == 3) {
                                int day_from = Integer.parseInt(listService_id[0]);
                                int month_from = Integer.parseInt(listService_id[1]);
                                int year_from = Integer.parseInt(listService_id[2]);
                                query.date_from.set(Calendar.DAY_OF_MONTH, day_from);
                                query.date_from.set(Calendar.MONTH, month_from);
                                query.date_from.set(Calendar.YEAR, year_from);
                            }
                        } else {
                            System.out.println("enter correct date");
                        }
                    }
                    if (j == 5) {
                        if (inputWords[j].contains(".")) {
                            if (inputWords[j].split("\\.").length == 3) {
                                int day_to = Integer.parseInt(listService_id[0]);
                                int month_to = Integer.parseInt(listService_id[1]);
                                int year_to = Integer.parseInt(listService_id[2]);
                                query.date_to.set(Calendar.DAY_OF_MONTH, day_to);
                                query.date_to.set(Calendar.MONTH, month_to);
                                query.date_to.set(Calendar.YEAR, year_to);
                            }
                        } else {
                            System.out.println("enter correct date");
                        }
                    }
                }
                listQuery.add(query);
                int countEqual = 0;
                int allValue = 0;
                int avg = 0;
                for (int j = 0; j < listWaitingTimeline.size(); j++) {
                    if (query.service_id == listWaitingTimeline.get(j).service_id &&
                            query.question_type_id == listWaitingTimeline.get(j).question_type_id ||
                            query.question_type_id == 101 &&
                                    listWaitingTimeline.get(j).date_from.getTime().after(query.date_from.getTime()) ||  query.question_type_id == 101
                                    && listWaitingTimeline.get(j).date_from.getTime().before(query.date_to.getTime())||
                            query.question_type_id == 101 &&  listWaitingTimeline.get(j).date_from.getTime().equals(query.date_from.getTime())
                            ||  query.question_type_id == 101 && listWaitingTimeline.get(j).date_from.getTime().equals(query.date_to.getTime())) {
                        countEqual++;
                        allValue += listWaitingTimeline.get(j).time;
                        avg = allValue / countEqual;
                    }
                }
                linkedList.add(String.valueOf(avg));
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



